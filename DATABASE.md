# 数据库相关表说明
user表
   
**名字 类型** 

**sex   text**性别

**age int**年龄

**birthday text**生日

**favorite text**喜爱

**hate text**讨厌

**password text**密码

**username text**用户名 用于登录

**nickname text**昵称

**friendlist text**好友列表

**follow text**特别关心

**fans text**粉丝

**sign text**个性签名

**tId int4**(主键)int型Id

SQL


CREATE TABLE public."users"
(
    sex TEXT,
    age INT,
    birthday TEXT,
    favorite TEXT,
    hate TEXT,
    password TEXT,
    userName TEXT,
    nickName TEXT,
    friendList TEXT,
    follow TEXT,
    fans TEXT,
    sign TEXT,
    trueId INT PRIMARY KEY
);

shop表

**location text**经纬度坐标

**inRank text**所在排行榜

**subType text**食物类型分类

**tel text**电话

**star double**评星

**avgPrice double**平均价格

**tastep double**口味评分

**enviornmentp double**环境评分

**servicep double**服务评分

**mainType text**商圈

**address text**详细地址

**signId text**申请Id

**stId int4**(主键)int型Id

SQL

CREATE TABLE public.shop
(
    location TEXT,
    inRank TEXT,
    subType TEXT,
    tel TEXT,
    star double,
    avgPrice double,
    tastep double,
    enviornmentp double,
    servicep double,
    mainType TEXT,
    address TEXT,
    shopName TEXT,
    signId TEXT,
    shopTrueId INT PRIMARY KEY
);

