## 实战篇 01：实战概述

- 概览本阶段目标：快速搭建后端 + 前端环境，并规划后端注册/登录/用户详情模块  

- 明确将通过 Spring Boot + MyBatis 实现注册、登录、JWT 验证，以及用户详情获取等功能  

- 前端对应 Vue3 + axios、Element‑Plus 实现页面与后端联调

  

## 实战篇 02：开发模式和环境搭建

- 后端：

  - 创建 Spring Boot 项目，集成 MyBatis、Lombok、H2/MySQL 驱动

  - 配置 `application.yml`（数据库、端口、日志等）

- 前端：

  - 使用 Vite 创建 Vue3 项目，安装 Element‑Plus、axios、vue-router、pinia

  - 设置目录结构、环境变量与跨域代理

  

## 实战篇 03：注册接口

- 后端：

  - 定义 `User` 实体与 MyBatis 映射

  - 编写 `UserMapper.insert` + Service 层方法 `register(User)`

  - 在Controller增加 `/api/register` POST 接口，返回统一格式结果

- 异常处理：捕获插入失败、用户名重复

  

## 实战篇 04：注册接口参数校验

- 引入 `spring-boot-starter-validation`

- `@Validated` + `@NotBlank`, `@Size`, `@Email` 等注解在 DTO 上校验

- 在 Controller 方法参数上使用 `@Valid`

- 捕获 `MethodArgumentNotValidException`，并统一返回格式化报错信息

  

## 实战篇 05：登录主逻辑

- 定义 `LoginDTO(username, password)`

- Service 层实现 `login(LoginDTO)`，查询数据库并比对密码

- 简单的明文验证或使用 BCrypt，成功则返回 User 对象

  

## 实战篇 06：登录认证引入

- 在 Controller 调用登录逻辑后，返回 `LoginResponseDTO`

- 引入全局统一返回模型，包含 `code`, `message`, `data`

  

## 实战篇 07：JWT 令牌

- 后端引入 `jjwt` 依赖，设置签名密钥

- JWT 工具类生成 Token，包含 `userId`, `username`，设置过期时间

- 登录接口返回 JWT

  

## 实战篇 08：登录认证 完成

- 后端：

  - 配置 Spring Security 或自定义 JWT 拦截器

  - 拦截器从请求头获取 JWT，验证有效性，解析用户信息，存入 `SecurityContext` 或 `ThreadLocal`

- 确保后续请求携带 JWT 可访问受保护接口

  

## 实战篇 09：获取用户详细信息

- 后端接口 `/api/user/info`：

  - 从上下文获取当前用户 ID

  - 查询数据库获取完整 User 信息（含昵称、头像、权限等）

  - 返回到前端

  

## 实战篇 10：获取用户详细信息 + ThreadLocal 优化

- 改进 JWTInterceptor：

  - 验证完 Token 后，解析用户信息存入 `ThreadLocal`

  - 提供工具类从 `ThreadLocal` 读取当前用户数据，避免重复查询

  - 在接口结束后通过拦截器清理 `ThreadLocal`，防止内存泄漏
