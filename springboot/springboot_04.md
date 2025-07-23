### 1. 登录优化 - Redis 思路分析

- 目标：在登录逻辑中加入 Redis，实现 token 主动失效。
    
- 背景：用户修改密码后，旧 token 仍可用，存在安全隐患。
    
- 思路：
    
    1. 登录成功后，将生成的 JWT token 保存到 Redis，过期时间与 JWT 一致。
        
    2. 请求时，除验证 JWT，还要验证 Redis 是否存在该 token。
        
    3. 修改密码或退出登录时，从 Redis 删除 token，强制失效。
        
- 优缺点：
    
    - 优点：即使 JWT 没过期，也能随时失效。
        
    - 缺点：增加 Redis I/O，略微增加开销。
        

### 2. Spring Boot 集成 Redis

- 引入依赖：
    
    ```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
    ```
    
- 配置 `application.yml`：
    
    ```yaml
    spring:
      data:
        redis:
          host: localhost
          port: 6379
    ```
    
- 使用示例：
    
    ```java
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    stringRedisTemplate.opsForValue().set("username", "zjf");
    stringRedisTemplate.opsForValue().set("id", "1", 15, TimeUnit.SECONDS);
    ```
    

### 3. Redis 主动失效机制实现

- 登录成功后保存 token 到 Redis：
    
    ```java
    stringRedisTemplate.opsForValue().set(token, username, expireTime, TimeUnit.MILLISECONDS);
    ```
    
- 拦截器流程：
    
    1. 拦截请求，获取 header 的 token。
        
    2. 校验 JWT 是否有效。
        
    3. 校验 Redis 中是否存在该 token。
        
    4. 均通过才放行，否则拒绝访问。
        
- 主动注销：如用户修改密码或退出登录时，Redis 删除对应 token。
    

### 4. Spring Boot 部署与多环境配置

1. 部署：
    
    - `mvn clean package` 打包 jar。
        
    - Linux 上使用 `nohup java -jar xxx.jar &` 启动。
        
    - 配置日志输出、Nginx 代理等。
        
2. 多环境配置：
    
    - 创建 `application-dev.yml`、`application-prod.yml` 等文件。
        
    - `application.yml` 中使用 `spring.profiles.active=dev` 切换环境。
        
    - 使用 `@Profile` 注解加载不同配置或 Bean。
        
3. `@ConfigurationProperties`：
    
    - 使用 `@ConfigurationProperties` 将配置绑定到 Java 类。
        
    - 保证配置集中管理，便于维护。
        
