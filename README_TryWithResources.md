# Try-With-Resources trong Java

## Tổng quan

Try-with-resources là một tính năng được giới thiệu từ Java 7, cho phép tự động quản lý việc đóng các resources (như file, database connections, network connections) mà không cần gọi method `close()` thủ công.

## Cú pháp cơ bản

```java
try (ResourceType resource = new ResourceType()) {
    // Sử dụng resource
} catch (Exception e) {
    // Xử lý exception
}
// Resource tự động được đóng khi kết thúc try block
```

## Lợi ích của Try-With-Resources

### 1. **Tự động đóng resources**
- Không cần gọi `close()` thủ công
- Tránh memory leaks
- Đảm bảo resources được giải phóng ngay cả khi có exception

### 2. **Code sạch hơn**
- Giảm boilerplate code
- Dễ đọc và maintain
- Ít lỗi hơn

### 3. **Exception handling tốt hơn**
- Suppressed exceptions được xử lý tự động
- Có thể catch nhiều loại exception

## Ví dụ trong dự án StudentManager

### Trước khi sử dụng try-with-resources:

```java
public static void saveToFile() {
    PrintWriter writer = null;
    try {
        writer = new PrintWriter("students.txt", "UTF-8");
        // Ghi dữ liệu
        writer.println(studentData);
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (writer != null) {
            writer.close(); // Phải đóng thủ công
        }
    }
}
```

### Sau khi sử dụng try-with-resources:

```java
public static void saveToFile() {
    try (PrintWriter writer = new PrintWriter("students.txt", "UTF-8")) {
        // Ghi dữ liệu
        writer.println(studentData);
        System.out.println("Lưu file thành công!");
    } catch (IOException e) {
        System.err.println("Lỗi khi lưu file: " + e.getMessage());
        e.printStackTrace();
    }
    // File tự động được đóng
}
```

## Các loại Resources có thể sử dụng

### 1. **File Operations**
```java
// Đọc file
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    String line = reader.readLine();
}

// Ghi file
try (PrintWriter writer = new PrintWriter("output.txt")) {
    writer.println("Hello World");
}
```

### 2. **Scanner**
```java
try (Scanner scanner = new Scanner(System.in)) {
    String input = scanner.nextLine();
}
```

### 3. **Database Connections**
```java
try (Connection conn = DriverManager.getConnection(url, user, password);
     PreparedStatement stmt = conn.prepareStatement(sql)) {
    // Thực hiện query
}
```

### 4. **Network Connections**
```java
try (Socket socket = new Socket(host, port);
     InputStream in = socket.getInputStream()) {
    // Đọc dữ liệu từ network
}
```

## Multiple Resources

Có thể sử dụng nhiều resources trong cùng một try-with-resources:

```java
try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
     PrintWriter writer = new PrintWriter("output.txt")) {
    
    String line;
    while ((line = reader.readLine()) != null) {
        writer.println(line);
    }
}
// Cả reader và writer đều được đóng tự động
```

## Custom Resources

Để tạo custom resource, class phải implement `AutoCloseable` hoặc `Closeable`:

```java
public class CustomResource implements AutoCloseable {
    
    public CustomResource() {
        System.out.println("Resource được tạo");
    }
    
    public void doSomething() {
        System.out.println("Thực hiện công việc");
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("Resource được đóng");
    }
}

// Sử dụng
try (CustomResource resource = new CustomResource()) {
    resource.doSomething();
}
```

## Lưu ý quan trọng

### 1. **Với System.in**
```java
// KHÔNG nên làm điều này
try (Scanner scanner = new Scanner(System.in)) {
    // Đọc input
}
// Scanner sẽ đóng System.in, ảnh hưởng đến việc đọc input tiếp theo
```

### 2. **Exception Handling**
```java
try (PrintWriter writer = new PrintWriter("file.txt")) {
    writer.println("Data");
} catch (IOException e) {
    // Xử lý IOException
} catch (Exception e) {
    // Xử lý các exception khác
}
```

### 3. **Suppressed Exceptions**
Try-with-resources tự động xử lý suppressed exceptions:

```java
try (Resource resource = new Resource()) {
    throw new RuntimeException("Exception trong try block");
} catch (Exception e) {
    // e sẽ chứa RuntimeException
    // Suppressed exceptions từ close() sẽ được thêm vào e
    for (Throwable suppressed : e.getSuppressed()) {
        System.err.println("Suppressed: " + suppressed);
    }
}
```

## Best Practices

1. **Luôn sử dụng try-with-resources** cho các resources cần đóng
2. **Không đóng resources thủ công** trong try-with-resources
3. **Xử lý exceptions** một cách phù hợp
4. **Sử dụng multiple resources** khi cần thiết
5. **Tạo custom resources** implement AutoCloseable khi cần

## Kết luận

Try-with-resources là một tính năng mạnh mẽ giúp viết code Java an toàn và sạch hơn. Trong dự án StudentManager, việc sử dụng try-with-resources đã cải thiện đáng kể việc quản lý file operations và giảm thiểu lỗi liên quan đến việc không đóng resources. 