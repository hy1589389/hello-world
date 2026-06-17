# 酒店民宿管理系统

基于SpringBoot的酒店民宿管理系统

## 项目概述

这是一个完整的酒店民宿管理平台，提供房间管理、预订管理、用户管理等核心功能。

## 技术栈

- **后端框架**: Spring Boot 2.7.14
- **数据库**: MySQL 8.0
- **ORM**: Spring Data JPA
- **权限认证**: JWT (后续实现)
- **其他**: Lombok、FastJSON、Commons Lang3

## 项目结构

```
hotel-management/
├── src/
│   ├── main/
│   │   ├── java/com/hotel/
│   │   │   ├── entity/          # 实体类
│   │   │   ├── repository/      # 数据访问层
│   │   │   ├── service/         # 业务层
│   │   │   ├── controller/      # 控制层
│   │   │   ├── dto/             # 数据传输对象
│   │   │   ├── common/          # 通用类
│   │   │   └── HotelManagementApplication.java  # 启动类
│   │   └── resources/
│   │       └── application.yml  # 应用配置
│   └── test/                    # 测试代码
└── pom.xml                      # Maven配置

```

## 核心功能模块

### 1. 用户管理 (User Management)
- ✅ 用户注册
- ✅ 用户登录
- ✅ 用户信息查询
- ✅ 用户信息更新
- ✅ 用户删除
- ⏳ JWT权限认证

### 2. 房间管理 (Room Management)
- 🔄 房间列表查询
- 🔄 房间详情
- 🔄 房间添加
- 🔄 房间编辑
- 🔄 房间删除
- 🔄 房间状态管理

### 3. 预订管理 (Booking Management)
- 🔄 预订创建
- 🔄 预订查询
- 🔄 预订修改
- 🔄 预订取消
- 🔄 房间可用性检查

### 4. 评价管理 (Review Management)
- ⏳ 评价添加
- ⏳ 评价查询
- ⏳ 评价删除

### 5. 支付管理 (Payment Management)
- ⏳ 支付处理
- ⏳ 支付记录
- ⏳ 订单管理

## 环境要求

- Java 8+
- MySQL 5.7+
- Maven 3.6+

## 快速开始

### 1. 环境配置

创建MySQL数据库：
```sql
CREATE DATABASE hotel_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 2. 修改配置

修改 `src/main/resources/application.yml`：
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/hotel_db
    username: root
    password: root
```

### 3. 构建项目

```bash
mvn clean install
```

### 4. 运行项目

```bash
mvn spring-boot:run
```

项目将运行在 `http://localhost:8080/api`

## API文档

### 用户相关接口

#### 用户注册
```
POST /api/user/register
Content-Type: application/json

{
  "username": "john_doe",
  "password": "password123",
  "realName": "John Doe",
  "email": "john@example.com",
  "phone": "13800000001"
}
```

#### 用户登录
```
POST /api/user/login
Content-Type: application/json

{
  "username": "john_doe",
  "password": "password123"
}
```

#### 获取用户信息
```
GET /api/user/{id}
```

#### 更新用户信息
```
PUT /api/user/{id}
Content-Type: application/json

{
  "realName": "John Smith",
  "email": "john.smith@example.com",
  "phone": "13900000001"
}
```

#### 删除用户
```
DELETE /api/user/{id}
```

## 后续开发计划

- [ ] JWT身份认证
- [ ] 房间管理模块
- [ ] 预订管理模块
- [ ] 评价管理模块
- [ ] 支付模块
- [ ] 前端UI界面
- [ ] 单元测试
- [ ] API文档(Swagger)
- [ ] 日志管理
- [ ] 异常处理机制

## 数据库设计

### user 表
| 字段 | 类型 | 说明 |
|-----|------|------|
| id | BIGINT | 主键 |
| username | VARCHAR | 用户名 |
| password | VARCHAR | 密码 |
| real_name | VARCHAR | 真实姓名 |
| email | VARCHAR | 邮箱 |
| phone | VARCHAR | 手机号 |
| id_card | VARCHAR | 身份证 |
| user_type | INT | 用户类型 |
| status | INT | 用户状态 |
| create_time | DATETIME | 创建时间 |
| update_time | DATETIME | 更新时间 |

### room 表
| 字段 | 类型 | 说明 |
|-----|------|------|
| id | BIGINT | 主键 |
| room_number | VARCHAR | 房间号 |
| room_type | INT | 房间类型 |
| room_name | VARCHAR | 房间名称 |
| max_guests | INT | 最大入住人数 |
| price | DECIMAL | 每晚价格 |
| status | INT | 房间状态 |
| create_time | DATETIME | 创建时间 |
| update_time | DATETIME | 更新时间 |

### booking 表
| 字段 | 类型 | 说明 |
|-----|------|------|
| id | BIGINT | 主键 |
| booking_number | VARCHAR | 预订号 |
| user_id | BIGINT | 用户ID |
| room_id | BIGINT | 房间ID |
| check_in_date | DATE | 入住日期 |
| check_out_date | DATE | 退房日期 |
| total_price | DECIMAL | 总价格 |
| status | INT | 预订状态 |
| create_time | DATETIME | 创建时间 |
| update_time | DATETIME | 更新时间 |

## 常见问题

### Q: 如何修改数据库连接?
A: 修改 `application.yml` 中的数据库配置

### Q: 项目使用的是什么ORM?
A: 使用Spring Data JPA，同时支持自定义SQL查询

### Q: 如何添加新的功能模块?
A: 遵循项目结构，创建对应的 entity、repository、service、controller 即可

## 许可证

MIT License

## 贡献

欢迎提交 Pull Request 或者 Issue

## 联系方式

如有问题，请提交 Issue
