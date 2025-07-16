## 00 – 导学

**内容**  

- 为什么学 SpringBoot3 + Vue3？  

  - 后端：SpringBoot3 是当前企业后端开发主流框架。

  - 前端：Vue3 是企业招聘要求最普遍的前端技术。

  - 学完具备独立开发后台管理系统能力。

**工具链**  

- JDK 17+

- IDEA

- Node.js

- Maven/Gradle

**技巧**  

- 配置好环境变量。

- IDEA 中设置 Maven 阿里云镜像，下载依赖快。

## 01 – SpringBoot 概述

**核心思想**

- 自动配置（AutoConfiguration）

- 起步依赖（Starter）

- 内嵌服务器（Tomcat/Jetty）

**常用 Starter**

- `spring-boot-starter-web`

- `spring-boot-starter-data-jpa`

- `spring-boot-starter-test`

**小坑**

- 不要和老版 Spring MVC XML 混用。

- 多个配置文件时，`application.yml` 优先。

## 02 – SpringBoot 入门示例

**关键注解**

- `@SpringBootApplication`  

  等同于：  

  ```java

  @Configuration

  @EnableAutoConfiguration

  @ComponentScan

  ```

**入口类示例**

```java

@SpringBootApplication

public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

    }

}

```

**小坑**

- 启动类要放在根包，否则组件无法扫描到。

## 03 – 工程创建

**推荐目录结构**

```

src/main/java

 ├── com.xxx.demo

 |     ├── controller

 |     ├── service

 |     ├── mapper

 |     ├── entity

 |     ├── config

 |     ├── DemoApplication.java

src/main/resources

 ├── application.yml

 ├── mapper/*.xml

```

**技巧**

- 用 `spring-boot-starter-parent` 管理依赖版本。

- IDEA 设置 Maven 自动导入。

## 04 – 配置文件基本使用

**优先级**  

命令行参数 > 环境变量 > application.yml > application.properties

**示例**

```yaml

server:

  port: 8081

spring:

  datasource:

    url: jdbc:mysql://localhost:3306/test

    username: root

    password: 123456

```

**小坑**

- 端口冲突要修改 `server.port`。

- `.yml` 更适合层级结构，推荐用它。

## 05 – YAML 配置与读取

**YAML 语法**

```yaml

person:

  name: Tom

  age: 20

  hobbies:

    - code

    - music

```

**读取配置**

- 单个值：

  ```java

  @Value("${person.name}")

  ```

- 批量值：

  ```java

  @Component

  @ConfigurationProperties(prefix = "person")

  public class Person {

      private String name;

      private int age;

      private List<String> hobbies;

  }

  ```

  
**小坑**

- `@ConfigurationProperties` 需要 `@Component` 或 `@EnableConfigurationProperties`。

- 批量读取不要用 `@Value`。

## 06 – 整合 MyBatis

**依赖**

```xml

<dependency>

    <groupId>org.mybatis.spring.boot</groupId>

    <artifactId>mybatis-spring-boot-starter</artifactId>

</dependency>

```

**Mapper**

```java

@Mapper

public interface UserMapper {

    User selectById(Long id);

}

```

**小坑**

- Mapper 必须有 `@Mapper` 或配置 `@MapperScan`。

- XML 文件要放对位置。

- 分页推荐用 MyBatis-Plus。

## 07 – Bean 扫描机制

**注解**

- `@Component`：泛用组件

- `@Service`：业务逻辑层

- `@Repository`：数据访问层

- `@Controller`：控制层

- `@RestController`：`@Controller` + `@ResponseBody`

**小坑**

- 如果包结构复杂，记得配 `@ComponentScan(basePackages = "...")`。

## 08 – Bean 注册方式

**三种方式**

1. `@Component` / `@Service` / `@Controller`

2. 配置类 + `@Bean`

   ```java

   @Configuration

   public class AppConfig {

       @Bean

       public UserService userService() {

           return new UserService();

       }

   }

   ```

3. 条件注册：`@Conditional` 系列

**小坑**

- `@Bean` 方法名就是 Bean 名。

- 不同注册方式注意优先级。

## 09 – 条件注册

**常见条件注解**

- `@ConditionalOnBean`

- `@ConditionalOnMissingBean`

- `@ConditionalOnProperty`

**小坑**

- 条件不满足就不注册，要注意 NPE 风险。

- Starter 的自动装配大量用到条件注册。

## 10 – 自动配置原理

**核心**

- `@EnableAutoConfiguration`

- `META-INF/spring.factories`

**原理**

- 启动时加载所有 `spring.factories` 中配置，自动装配需要的 Bean。

**小坑**

- 不满足条件就不会装配。

- 可以开启 `debug=true` 查看自动配置情况。

## 11 – 自定义 Starter

**结构**

- core：功能实现

- autoconfigure：自动装配

**自动装配类示例**

```java

@Configuration

@ConditionalOnProperty(name = "my.feature.enabled", havingValue = "true")

public class MyAutoConfig {

    @Bean

    public MyBean myBean() {

        return new MyBean();

    }

}

```

**声明**

```properties

# resources/META-INF/spring.factories

org.springframework.boot.autoconfigure.EnableAutoConfiguration=\

com.xxx.demo.autoconfig.MyAutoConfig

```

**小坑**

- Starter 不要引入 `spring-boot-starter-web`。

- 自动装配类命名要唯一。