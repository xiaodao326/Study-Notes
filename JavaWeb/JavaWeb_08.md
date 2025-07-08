# JavaWeb 学习笔记汇总

## 一、MySQL 基础

### 1. 数据库相关概念
- **数据库**：存储和管理数据的仓库，数据有组织地进行存储
- **DBMS**：数据库管理系统，管理数据库的大型软件（如MySQL、Oracle）
- **SQL**：结构化查询语言，操作关系型数据库的统一标准

### 2. MySQL 基础操作
- **安装配置**：下载解压版，配置环境变量和my.ini文件
- **基本命令**：
  ```sql
  -- 数据库操作
  CREATE DATABASE db1;
  SHOW DATABASES;
  USE db1;
  
  -- 表操作
  CREATE TABLE student(...);
  DESC student;
  ALTER TABLE student ADD COLUMN...;
  ```

### 3. SQL 分类
- **DDL**：数据定义语言（CREATE、ALTER、DROP）
- **DML**：数据操作语言（INSERT、UPDATE、DELETE）
- **DQL**：数据查询语言（SELECT）
- **DCL**：数据控制语言（GRANT、REVOKE）

### 4. 约束
- 主键约束：PRIMARY KEY
- 唯一约束：UNIQUE
- 非空约束：NOT NULL
- 外键约束：FOREIGN KEY
- 默认约束：DEFAULT

## 二、MySQL 高级

### 1. 数据库设计
- **表关系**：
  - 一对多：在多的一方添加外键
  - 多对多：建立中间表，包含两个外键
  - 一对一：在任意一方添加唯一外键

### 2. 多表查询
- **连接查询**：
  - 内连接：INNER JOIN（查询交集）
  - 左外连接：LEFT JOIN（左表全部+右表匹配）
  - 右外连接：RIGHT JOIN（右表全部+左表匹配）
  
- **子查询**：嵌套查询，可作为条件、虚拟表等

### 3. 事务
- **ACID特性**：
  - 原子性：事务不可分割
  - 一致性：数据保持一致状态
  - 隔离性：多个事务相互隔离
  - 持久性：事务提交后永久改变
  
- **事务操作**：
  ```sql
  START TRANSACTION;
  COMMIT;
  ROLLBACK;
  ```

## 三、JDBC

### 1. JDBC 概述
- Java操作数据库的标准接口
- 本质：接口+数据库驱动实现类

### 2. JDBC 核心API
- **DriverManager**：注册驱动，获取连接
- **Connection**：管理事务，获取执行对象
- **Statement/PreparedStatement**：执行SQL
- **ResultSet**：结果集对象

### 3. 数据库连接池
- **Druid使用**：
  ```java
  // 1. 导入jar包
  // 2. 定义配置文件
  // 3. 加载配置文件
  Properties prop = new Properties();
  prop.load(new FileInputStream("druid.properties"));
  // 4. 获取连接池对象
  DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
  // 5. 获取连接
  Connection conn = dataSource.getConnection();
  ```

## 四、Maven

### 1. Maven 基础
- **作用**：项目构建和依赖管理
- **仓库**：
  - 本地仓库
  - 中央仓库
  - 私服

### 2. Maven 使用
- **常用命令**：
  - compile：编译
  - clean：清理
  - package：打包
  - install：安装到本地仓库
  
- **依赖范围**：
  - compile（默认）
  - test
  - provided
  - runtime

## 五、HTTP & Tomcat & Servlet

### 1. HTTP 协议
- **请求结构**：请求行、请求头、请求体
- **响应结构**：响应行、响应头、响应体
- **特点**：基于TCP、请求-响应模型、无状态

### 2. Tomcat
- **Web服务器**：解析HTTP协议，管理Servlet
- **使用**：
  - 启动：bin/startup.bat
  - 部署：将项目放入webapps目录
  - 配置：修改server.xml和web.xml

### 3. Servlet
- **生命周期**：
  1. 加载和实例化
  2. 初始化（init）
  3. 请求处理（service）
  4. 销毁（destroy）
  
- **体系结构**：
  ```java
  @WebServlet("/demo")
  public class DemoServlet extends HttpServlet {
      protected void doGet(...){...}
      protected void doPost(...){...}
  }
  ```

- **urlPattern配置**：
  - 精确匹配：/user/select
  - 目录匹配：/user/*
  - 扩展名匹配：*.do
  - 任意匹配：/ 或 /*

## 六、Request & Response

### 1. Request 对象
- **获取请求数据**：
  - 请求行：`getMethod()`, `getRequestURI()`
  - 请求头：`getHeader(name)`
  - 请求体：`getReader()`, `getInputStream()`
  
- **请求参数处理**：
  - 通用方式：`getParameterMap()`, `getParameterValues()`
  - 中文乱码解决：`setCharacterEncoding("UTF-8")`

- **请求转发**：
  ```java
  request.getRequestDispatcher("/path").forward(request, response);
  ```

### 2. Response 对象
- **设置响应数据**：
  - 响应行：`setStatus()`
  - 响应头：`setHeader()`
  - 响应体：`getWriter()`, `getOutputStream()`

- **重定向**：
  ```java
  response.sendRedirect("/path");
  ```

## 七、会话技术

### 1. Cookie
- **特点**：客户端会话技术，存储在浏览器
- **基本使用**：
  ```java
  // 发送Cookie
  Cookie cookie = new Cookie("name","value");
  response.addCookie(cookie);
  
  // 获取Cookie
  Cookie[] cookies = request.getCookies();
  ```

### 2. Session
- **特点**：服务端会话技术，基于Cookie实现
- **基本使用**：
  ```java
  // 存储数据
  HttpSession session = request.getSession();
  session.setAttribute("name", value);
  
  // 获取数据
  Object value = session.getAttribute("name");
  ```

## 八、Filter & Listener & Ajax

### 1. Filter
- **作用**：拦截请求，实现通用功能（如登录验证）
- **使用步骤**：
  ```java
  @WebFilter("/*")
  public class MyFilter implements Filter {
      public void doFilter(...) {
          // 放行前逻辑
          chain.doFilter(request, response);
          // 放行后逻辑
      }
  }
  ```

### 2. Listener
- **常用监听器**：ServletContextListener
- **使用**：
  ```java
  @WebListener
  public class MyListener implements ServletContextListener {
      public void contextInitialized(...) {
          // 初始化逻辑
      }
  }
  ```

## 总结

本汇总笔记系统梳理了JavaWeb开发的核心技术栈，从数据库基础（MySQL）、Java数据库交互（JDBC）、项目构建（Maven），到Web开发基础（Servlet/HTTP/Tomcat），再到高级特性（会话管理、过滤器等）。这些技术构成了JavaWeb开发的完整知识体系，为后续学习Spring、MyBatis等框架打下坚实基础。