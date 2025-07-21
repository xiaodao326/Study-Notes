
## 1. 更新用户基本信息

- 路由：`@PutMapping("/user/update")`

- 前端传递 `nickname`、`email` 等字段封装到 DTO

- 后端用 `@Validated` 开启参数校验

- 使用 `ThreadLocal`（或 JWT 拦截器）获取当前登录用户 ID

- Service 层只更新该用户自己的信息，避免越权

  

---

  

## 2. 更新信息时的参数校验

- DTO 中字段如 `nickname`、`email` 上加 `@NotBlank`、`@Email`

- Controller 方法使用 `@Validated @RequestBody`

- 出现校验异常时，统一由 `@RestControllerAdvice` 全局异常处理器捕获，返回格式化错误信息

  

---

  

## 3. 更新用户头像（本地存储）

- 前端通过 `FormData` 上传图片，后端用 `MultipartFile` 接收

- 使用 `UUID` 生成唯一文件名，保留原扩展名

- 保存到本地固定目录（如 `/upload/`）

- 把文件访问 URL 存入用户表 `avatar` 字段

  

---

  

## 4. 修改用户密码

- 前端提交原密码 + 新密码

- 后端先通过用户 ID 查询出旧密码（MD5 加密）

- 使用工具类 `DigestUtils.md5Hex()` 对比原密码

- 验证通过则更新为新密码（同样 MD5 加密后存储）

  

---

  

## 5. 新增文章分类

- 路由：`@PostMapping("/category")`

- 接收 DTO（如 `name`、`alias`）

- 对 DTO 使用 `@Valid` + 分组 `@Validated` 校验字段不能为空

- Service 层调用 Mapper 插入数据库

- 返回 `Result.success()`

  

---

  

## 6. 查询分类列表

- 路由：`@GetMapping("/category")`

- 无需参数或带条件分页（可选）

- Service 层调用 Mapper 查询 `List<CategoryVO>`

- VO 可使用 `@JsonFormat` 格式化时间字段（如 `createTime`、`updateTime`）

  

---

  

## 7. 获取分类详情

- 路由：`@GetMapping("/category/{id}")`

- 根据 URL 路径参数接收 `id`

- Service 调用 Mapper 根据主键查询分类

- 返回前端用于回显

  

---

  

## 8. 修改文章分类

- 路由：`@PutMapping("/category")`

- DTO 除了 `name`、`alias` 还需带 `id`

- 启用分组校验（`@Validated(Update.class)`）

- Service 调用 Mapper 更新数据

- 返回 `Result.success()`

  

---

  

## 9. 分类新增/修改 + 分组校验

- 同一个 DTO 既可用于新增也可用于修改

- 使用分组接口区分校验规则：

  ```java

  public interface Add {}

  public interface Update {}

  ```

- `@NotNull(groups = Update.class)` 表示仅在更新时必须带 `id`

- Controller 根据操作调用对应分组

  

---

  

## 10. 新增文章

- 路由：`@PostMapping("/article")`

- 前端提交 `title`、`content`、`coverImg`、`categoryId`、`state`

- DTO 使用 `@NotBlank`、`@NotNull`、`@URL`、`@Size` 限制长度、合法性

- 自定义 `@State` 校验字段只能是“已发布”或“草稿”

- Service 中自动填充 `createUser`（当前登录用户）、`createTime`

- 调用 Mapper 插入文章表

  

---

  

## 11. 自定义注解 @State

- 新建注解 `@State`

- 配套写校验器 `StateValidation implements ConstraintValidator`

- 校验器逻辑：如果 `state` 不在允许列表则抛异常

- 在 DTO `state` 字段上加 `@State` 启用校验

  

---

  

## 12. 文章分页查询 + 条件查询

- 路由：`@GetMapping("/article")`

- 参数：`pageNum`、`pageSize`、可选 `categoryId`、`state`

- Service 中使用 `PageHelper.startPage(pageNum, pageSize)`

- Mapper 按条件动态 SQL 查询文章列表

- 返回封装好的 `PageBean<ArticleVO>` 包含列表和总条数

  

---

  

## 13. 文件上传（本地）

- 路由：`@PostMapping("/upload")`

- 接收前端 `FormData`，参数名需一致

- 使用 `UUID` 生成唯一文件名避免覆盖

- `file.transferTo(new File(uploadPath))` 存到本地

- 返回访问 URL，前端可回显图片