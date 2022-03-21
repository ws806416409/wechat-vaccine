## 需求分析

### 用户端：

1. 普通用户登录注册，完善和修改个人信息
2. 个人中心查看基本信息（可编辑）；查看我的预约
3. 查看疫苗接种信息（接种地点，接种时间，剩余剂量，排队人数，疫苗种类），点击进行预约

### 管理端：

1. 统计分析（疫苗接种明细，疫苗预约明细）
2. 管理疫苗接种点信息
3. 管理疫苗信息
4. 管理用户接种情况

---
 
## 数据库

### user // 登录信息表

- uid
- username
- password
- permission

### user_info // 用户个人信息表

- id
- uid
- real_name
- id_card
- phone
- sex
- age
- allergy // 过敏史
- adverse_reaction // 不良反应史

### vaccine // 疫苗信息表

- id
- type // 种类
- code // 产品编码
- number // 批号
- company // 生产公司

### user_vaccine

- id
- uid
- vid

### vaccination_info // 接种地信息表

- id
- vid
- place
- vtime // 接种地开放接种时间
- dose // 剩余剂量
- rank // 排队人数

### user_vaccination_info

- id
- uid
- viid

### vaccination_details // 用户接种明细

- id
- uid
- viid
- vaccinate_time // 实际接种时间
- docter_name // 接种医生姓名