
## 一、JavaWeb 核心技术体系

### 1. MySQL 数据库基础

- **SQL分类**：
    
    - DDL（数据定义）：CREATE、ALTER、DROP
        
    - DML（数据操作）：INSERT、UPDATE、DELETE
        
    - DQL（数据查询）：SELECT
        
    - DCL（数据控制）：GRANT、REVOKE
        
- **表关系设计**：
    
    - 一对多：外键放在多方
        
    - 多对多：建立中间表
        
    - 一对一：在任意一方添加唯一外键
        

### 2. JDBC 核心编程

**标准流程**：

```
java

// 1. 注册驱动
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 获取连接
Connection conn = DriverManager.getConnection(url, username, password);

// 3. 创建Statement
Statement stmt = conn.createStatement();

// 4. 执行SQL
ResultSet rs = stmt.executeQuery("SELECT * FROM users");

// 5. 处理结果集
while(rs.next()) {
    String name = rs.getString("name");
    // ...
}

// 6. 释放资源
rs.close();
stmt.close();
conn.close();
```

**Druid连接池使用**：

```
java

// 配置druid.properties
Properties prop = new Properties();
prop.load(new FileInputStream("druid.properties"));
DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
Connection conn = dataSource.getConnection();
```

### 3. Servlet 核心组件

**生命周期**：

1. 加载和实例化
    
2. 初始化（init）
    
3. 请求处理（service）
    
4. 销毁（destroy）
    

**注册方式**：

```
java

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // 处理GET请求
    }
}
```

### 4. 请求与响应处理

**请求参数获取**：

java

String username = req.getParameter("username");
String[] hobbies = req.getParameterValues("hobby");

**响应设置**：

```
java

resp.setContentType("text/html;charset=utf-8");
PrintWriter out = resp.getWriter();
out.print("<h1>你好，" + username + "</h1>");
```

### 5. 会话管理技术

**Cookie操作**：

```
java

// 写入Cookie
Cookie cookie = new Cookie("username", "admin");
cookie.setMaxAge(3600);
resp.addCookie(cookie);

// 读取Cookie
Cookie[] cookies = req.getCookies();
for(Cookie c : cookies) {
    if("username".equals(c.getName())) {
        String value = c.getValue();
        // ...
    }
}
```

**Session使用**：

```
java

HttpSession session = req.getSession();
session.setAttribute("user", userObj);
User u = (User) session.getAttribute("user");
```

### 6. 过滤器与监听器

**过滤器实现**：

```
java

@WebFilter("/*")
public class AuthFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
        // 前置处理
        HttpServletRequest request = (HttpServletRequest) req;
        if(!checkAuth(request)) {
            // 跳转登录
            return;
        }
        
        chain.doFilter(req, res); // 放行
        
        // 后置处理
    }
}
```

**监听器示例**：

```
java

@WebListener
public class AppListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        // 应用启动初始化
    }
    
    public void contextDestroyed(ServletContextEvent sce) {
        // 应用销毁处理
    }
}
```

## 二、SpringBoot 高级开发实战

### 1. 核心特性

- **自动配置**：基于条件注解的智能配置
    
- **起步依赖**：简化依赖管理
    
- **内嵌容器**：默认集成Tomcat
    

### 2. 工程规范

**标准结构**：

```
text

src/main/java
  ├── com.xxx
  │   ├── config       # 配置类
  │   ├── controller   # 控制器
  │   ├── service      # 业务层
  │   ├── mapper       # 数据层
  │   └── entity       # 实体类
src/main/resources
  ├── static          # 静态资源
  ├── templates       # 模板文件
  ├── application.yml # 主配置
  └── mapper/*.xml    # MyBatis映射文件
```

### 3. MyBatis 深度集成

**基础配置**：

```
yaml

# application.yml
mybatis:
  mapper-locations: classpath:mapper/*.xml
  configuration:
    map-underscore-to-camel-case: true
```

**动态SQL示例**：

```
xml

<select id="search" resultType="User">
    SELECT * FROM user
    <where>
        <if test="name != null">
            AND name LIKE CONCAT('%', #{name}, '%')
        </if>
        <if test="status != null">
            AND status = #{status}
        </if>
    </where>
    ORDER BY create_time DESC
</select>
```
### 4. Web开发核心

**RESTful接口**：

```
java

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    public Result<User> getById(@PathVariable Long id) {
        return Result.success(userService.getById(id));
    }
    
    @PostMapping
    public Result create(@RequestBody @Valid UserDTO dto) {
        return Result.success(userService.create(dto));
    }
}
```

**统一响应封装**：

```
java

public class Result<T> {
    private int code;
    private String msg;
    private T data;
    
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "成功", data);
    }
    
    // 其他构造方法和静态工厂方法
}
```

### 5. 安全认证方案

**JWT实现**：

```
java

public class JwtUtil {
    private static final String SECRET = "your-secret-key";
    private static final long EXPIRATION = 86400L; // 24小时
    
    public static String generateToken(UserDetails user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
    
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
```

**拦截器配置**：

```
java

public class JwtInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("Authorization");
        try {
            Claims claims = JwtUtil.parseToken(token);
            String username = claims.getSubject();
            // 将用户信息存入上下文
            UserContext.setCurrentUser(username);
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
                               Object handler, Exception ex) {
        UserContext.clear(); // 防止内存泄漏
    }
}
```

### 6. 异常处理机制

**全局异常处理**：

```
java

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException e) {
        return Result.fail(e.getCode(), e.getMessage());
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValidationException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .collect(Collectors.joining(", "));
        return Result.fail(400, message);
    }
}
```

## 三、生产级优化策略

### 1. 性能优化

- **连接池配置**：
    
```yaml
    
    spring:
      datasource:
        hikari:
          maximum-pool-size: 20
          connection-timeout: 30000
          ```
- **缓存集成**：
```java
    
    @Cacheable(value = "users", key = "#id")
    public User getById(Long id) {
        return userMapper.selectById(id);
    }
```

### 2. 监控与部署

**Actuator配置**：

```
yaml

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics
  endpoint:
    health:
      show-details: always
```

**打包与运行**：

`bash`

# 打包
`mvn clean package -DskipTests`

# 生产环境运行
`nohup java -jar app.jar --spring.profiles.active=prod > app.log 2>&1 &`

## 四、关键问题解决方案

1. **MyBatis映射问题**：
    
    - 确保Mapper接口有`@Mapper`或`@MapperScan`
        
    - XML文件放在`resources/mapper/`目录
        
    - 字段名与属性名匹配（开启驼峰命名）
        
2. **事务失效场景**：
    
    - 检查方法是否为public
        
    - 避免自调用
        
    - 异常类型是否正确捕获