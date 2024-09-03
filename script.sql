create table article_guide
(
    title        varchar(50)  null comment '文章标题',
    release_date date         null comment '发布日期',
    brief        varchar(500) null comment '简介',
    link         varchar(50)  null comment '来源网址',
    pz           varchar(50)  null comment '品种名称'
)
    comment '农事指导文章表';

create table article_news
(
    title        varchar(500) null comment '文章标题',
    link         varchar(500) null comment '链接',
    release_date date         null comment '发布日期',
    prvc         varchar(50)  null comment '省份名称'
)
    comment '农事资讯表';

create table catch_daily
(
    pz_count      int null comment '品种总数',
    market_count  int null comment '市场总数',
    data_count    int null comment '数据总数',
    article_count int null comment '文章总数'
);

create table enterprise
(
    prvc        varchar(32) null comment '省份id',
    pz          varchar(32) null comment '品种id',
    supply_type varchar(32) null comment '需求类型',
    manager     varchar(32) null comment '负责人',
    email       varchar(32) null comment '邮箱',
    phone       varchar(32) null comment '手机',
    fixed_phone varchar(32) null comment '固话',
    qq          varchar(32) null comment 'QQ',
    addr        varchar(32) null comment '地址'
)
    comment '企业';

create table market_info
(
    name           varchar(100)  null comment '市场名称',
    prvc           varchar(10)   null comment '省份名称',
    unit_type      varchar(100)  null comment '经营类型',
    addr           varchar(100)  null comment '地址',
    entry_date     date          null comment '注册时间',
    opening_date   date          null comment '开业时间',
    manager        varchar(10)   null comment '负责人姓名',
    manager_phone  varchar(20)   null comment '负责人电话号',
    tel            varchar(20)   null comment '电话',
    characteristic varchar(500)  null comment '特色',
    content        varchar(1000) null comment '简介'
);

create table market_price
(
    name varchar(255) null comment '市场名称',
    prvc varchar(32)  null comment '省份'
)
    comment '市场表' charset = utf8mb3;

create table price_fall
(
    prvc         varchar(50) null comment '省份名称',
    pz           varchar(50) null,
    price        double      null comment '价格',
    fall         double      null comment '跌幅',
    release_date date        null comment '发布日期'
)
    comment '各省各品种价格跌幅';

create table price_index
(
    pl      varchar(20) null comment '品类名称',
    type    int         null comment '指数类型 1价格指数 2二百指数',
    `index` double      null comment '指数',
    rise    double      null comment '涨幅',
    qoq     double      null comment '环比指数'
)
    comment '价格指数表';

create table price_market
(
    market       varchar(50) null comment '市场名称',
    prvc         varchar(10) null comment '省份名称',
    pz           varchar(20) null comment '品种名称',
    highest      double      null comment '最高价',
    lowest       double      null comment '最低价',
    average      double      null comment '平均价',
    release_time date        null comment '发布日期'
)
    comment '价格信息' charset = utf8mb3;

create table price_rise
(
    prvc         varchar(32) null comment '省份',
    pz           varchar(32) null comment '品种',
    price        double      null comment '价格',
    rise         double      null comment '涨幅',
    release_date date        null comment '发布日期'
)
    comment '各省各品种价格涨幅';

create table prvc
(
    name varchar(50) null comment '省份名称'
);

create table pz
(
    name varchar(255) null comment '品种名称'
)
    comment '品种表' charset = utf8mb3;

create table supply_demand
(
    pz               varchar(32) null comment '品种',
    seed_area        double      null comment '播种面积',
    harvested_area   double      null comment '收获面积',
    yield_per_unit   double      null comment '单产',
    yield            double      null comment '产量',
    imports          double      null comment '进口',
    consumption      double      null comment '消费',
    exports          double      null comment '出口',
    balance_change   double      null comment '结余变化',
    yield_rise       double      null comment '产量涨幅',
    consumption_rise double      null comment '消费涨幅',
    port_change      double      null comment '进出口变化',
    balance          double      null comment '库存结余'
)
    comment '供需数据';

create table user
(
    id          varchar(32)  not null comment 'ID'
        primary key,
    username    varchar(255) not null comment '用户名',
    tel         varchar(255) null comment '手机号',
    email       varchar(255) null comment '电子邮箱',
    password    varchar(255) null comment '密码',
    prvc        varchar(32)  null comment '省份id',
    verify_code varchar(255) null comment '验证码',
    verify_time datetime     null comment '验证码发送时间',
    constraint email
        unique (email) comment '邮箱索引',
    constraint tel
        unique (tel) comment '手机号索引',
    constraint username
        unique (username) comment '用户名索引'
)
    comment '用户' charset = utf8mb3;

create table user_pz
(
    user_id varchar(32) not null comment '用户id',
    pz      varchar(32) not null comment '品种',
    primary key (user_id, pz)
)
    comment '用户关注' charset = utf8mb3;


