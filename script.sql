create table article_guide
(
    title        varchar(50)  null comment '文章标题',
    release_date date         null comment '发布日期',
    brief        varchar(500) null comment '简介',
    link         varchar(500) null comment '来源网址',
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

create table brief_market
(
    market  varchar(255) not null comment '市场名称'
        primary key,
    pz_num  int          null comment '品种数量',
    low_pz  varchar(255) null comment '低价品种',
    high_pz varchar(255) null comment '高价品种'
)
    comment '指定市场的智能总结';

create table brief_prvc
(
    prvc       varchar(20)  null comment '省份名称',
    market_num int          null comment '市场数量',
    main_pz    varchar(255) null comment '主营品种',
    low_pz     varchar(255) null comment '低价品种',
    high_pz    varchar(255) null comment '高价品种'
);

create table brief_pz
(
    pz         varchar(20)  not null comment '品种名称'
        primary key,
    average    double       null comment '全国均价',
    low_prvc   varchar(255) null comment '低价省',
    low_price  double       null comment '低价省均价',
    high_prvc  varchar(255) null comment '高价省',
    high_price double       null comment '高价省均价'
)
    comment '指定品种的智能总结';

create table catch_daily
(
    pz_count      int null comment '品种总数',
    market_count  int null comment '市场总数',
    data_count    int null comment '数据总数',
    article_count int null comment '文章总数'
);

create table enterprise
(
    name        varchar(255) null comment '企业名称',
    prvc        varchar(32)  null comment '省份id',
    pz          varchar(32)  null comment '品种id',
    supply_type varchar(32)  null comment '需求类型',
    manager     varchar(32)  null comment '负责人',
    email       varchar(32)  null comment '邮箱',
    phone       varchar(32)  null comment '手机',
    fixed_phone varchar(32)  null comment '固话',
    qq          varchar(32)  null comment 'QQ',
    addr        varchar(255) null comment '地址'
)
    comment '企业';

create table market_info
(
    name           varchar(100)  null comment '市场名称',
    prvc           varchar(10)   null comment '省份名称',
    unit_type      varchar(100)  null comment '经营类型',
    addr           varchar(100)  null comment '地址',
    opening_date   date          null comment '开业时间',
    manager        varchar(10)   null comment '负责人姓名',
    manager_phone  varchar(20)   null comment '负责人电话号',
    tel            varchar(20)   null comment '电话',
    characteristic varchar(500)  null comment '特色',
    content        varchar(2000) null comment '简介'
);

create table per_market_today
(
    market    varchar(255) not null comment '市场名称'
        primary key,
    max_pz    varchar(20)  null comment '最高价品种',
    max_price double       null comment '最高价',
    min_pz    varchar(255) null comment '最低价品种',
    min_price double       null comment '最低价格'
)
    comment '市场内最高最低价格';

create table per_market_week
(
    market    varchar(255) not null comment '市场名称'
        primary key,
    max_pz    varchar(20)  null comment '最高价品种',
    max_price double       null comment '最高价格',
    max_date  date         null comment '最高价日期',
    min_pz    varchar(20)  null comment '最低价品种',
    min_price double       null comment '最低价格',
    min_date  date         null comment '最低价日期'
);

create table per_pz_today
(
    pz         varchar(20)  not null comment '品种',
    prvc       varchar(20)  not null comment '省份',
    max_market varchar(255) null comment '最高价市场',
    max_price  double       null comment '最高价格',
    min_market varchar(255) null comment '最低价市场',
    min_price  double       null comment '最低价格',
    primary key (pz, prvc)
);

create table per_pz_week
(
    pz         varchar(20)  not null comment '品种名称',
    prvc       varchar(20)  not null comment '省份名称',
    max_market varchar(255) null comment '最高价市场',
    max_price  double       null comment '最高价格',
    min_market varchar(255) null comment '最低价市场',
    max_date   date         null comment '最高价日期',
    min_price  double       null comment '最低价格',
    min_date   date         null comment '最低价日期',
    primary key (pz, prvc)
);

create table price_fall
(
    prvc         varchar(50) null comment '省份名称',
    pz           varchar(50) null,
    price        double      null comment '价格',
    fall_value   double      null comment '跌幅',
    release_date date        null comment '发布日期'
)
    comment '各省各品种价格跌幅';

create table price_index
(
    pl          varchar(20) null comment '品类名称',
    index_type  int         null comment '指数类型 1价格指数 2二百指数',
    index_value double      null comment '指数',
    rise        double      null comment '涨幅',
    rise3       double      null comment '3日涨幅',
    rise5       double      null comment '5日涨幅',
    qoq         double      null comment '环比指数'
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
    release_time date        null comment '发布日期',
    constraint price_i
        unique (market, pz, release_time)
)
    comment '价格信息';

create table price_market_predict
(
    market       varchar(255) not null comment '市场名称',
    pz           varchar(20)  not null comment '品种名称',
    prvc         varchar(20)  null comment '省份名称',
    average      double       null comment '平均价格',
    release_time date         not null comment '发布日期',
    primary key (market, pz, release_time)
);

create table price_prvc
(
    pz           varchar(20) not null comment '品种名称',
    prvc         varchar(20) not null comment '省份名称',
    average      double      null comment '平均价',
    release_time date        not null comment '发布日期',
    primary key (pz, prvc, release_time)
);

create table price_prvc_predict
(
    prvc         varchar(20) not null comment '省份名称',
    pz           varchar(20) not null comment '品种名称',
    average      double      null comment '平均价格',
    release_time date        not null comment '发布时间',
    primary key (prvc, pz, release_time)
);

create table price_rise
(
    prvc         varchar(32) null comment '省份',
    pz           varchar(32) null comment '品种',
    price        double      null comment '价格',
    rise         double      null comment '涨幅',
    release_date date        null comment '发布日期'
)
    comment '各省各品种价格涨幅';

create table price_variation_daily
(
    pz        varchar(20)  not null comment '品种名称',
    market    varchar(255) not null comment '市场名称',
    variation varchar(255) null comment '价格变化',
    primary key (pz, market)
);

create table price_variation_prvc_daily
(
    prvc      varchar(20) not null comment '省份名称',
    pz        varchar(20) not null comment '品种名称',
    variation double      null comment '价格变化',
    primary key (prvc, pz)
)
    comment '今日各省各品种价格变化';

create table prvc
(
    name varchar(50) null comment '省份名称',
    constraint name_i
        unique (name)
);

create table pz
(
    name varchar(255) null comment '品种名称',
    constraint pz_i
        unique (name)
)
    comment '品种表';

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
    comment '用户';

create table user_pz
(
    user_id varchar(32) not null comment '用户id',
    pz      varchar(32) not null comment '品种',
    primary key (user_id, pz)
)
    comment '用户关注';

create definer = root@`%` view brief_market_pz as
select `m`.`market`    AS `market`,
       `m`.`pz`        AS `pz`,
       `m`.`average`   AS `average`,
       `m`.`highest`   AS `highest`,
       `m`.`lowest`    AS `lowest`,
       `v`.`variation` AS `variation`,
       `ptd`.`average` AS `predict_td`,
       `ptm`.`average` AS `predict_tm`
from (((`agrimarket`.`price_market` `m` left join `agrimarket`.`price_variation_daily` `v`
        on (((`m`.`pz` = `v`.`pz`) and (`m`.`market` = `v`.`market`)))) left join `agrimarket`.`price_prvc_predict` `ptd`
       on (((`ptd`.`pz` = `m`.`pz`) and (`ptd`.`prvc` = `m`.`prvc`) and
            (`ptd`.`release_time` = curdate())))) left join `agrimarket`.`price_prvc_predict` `ptm`
      on (((`ptm`.`pz` = `m`.`pz`) and (`ptm`.`prvc` = `m`.`prvc`) and
           (`ptm`.`release_time` = (curdate() + interval 2 day)))))
where (`m`.`release_time` = (curdate() - interval 1 day));

-- comment on column brief_market_pz.market not supported: 市场名称

-- comment on column brief_market_pz.pz not supported: 品种名称

-- comment on column brief_market_pz.average not supported: 平均价

-- comment on column brief_market_pz.highest not supported: 最高价

-- comment on column brief_market_pz.lowest not supported: 最低价

-- comment on column brief_market_pz.variation not supported: 价格变化

-- comment on column brief_market_pz.predict_td not supported: 平均价格

-- comment on column brief_market_pz.predict_tm not supported: 平均价格

create definer = root@`%` view brief_prvc_pz as
select `p`.`prvc`      AS `prvc`,
       `p`.`pz`        AS `pz`,
       `p`.`average`   AS `average`,
       0               AS `highest`,
       0               AS `lowest`,
       `v`.`variation` AS `variation`,
       `ptd`.`average` AS `predict_td`,
       `ptm`.`average` AS `predict_tm`
from (((`agrimarket`.`price_prvc` `p` left join `agrimarket`.`price_variation_prvc_daily` `v`
        on (((`v`.`prvc` = `p`.`prvc`) and (`v`.`pz` = `p`.`pz`)))) left join `agrimarket`.`price_prvc_predict` `ptd`
       on (((`ptd`.`prvc` = `p`.`prvc`) and (`ptd`.`pz` = `p`.`pz`) and
            (`ptd`.`release_time` = curdate())))) left join `agrimarket`.`price_prvc_predict` `ptm`
      on (((`ptm`.`prvc` = `p`.`prvc`) and (`ptm`.`pz` = `p`.`pz`) and
           (`ptm`.`release_time` = (curdate() + interval 1 day)))));

-- comment on column brief_prvc_pz.prvc not supported: 省份名称

-- comment on column brief_prvc_pz.pz not supported: 品种名称

-- comment on column brief_prvc_pz.average not supported: 平均价

-- comment on column brief_prvc_pz.variation not supported: 价格变化

-- comment on column brief_prvc_pz.predict_td not supported: 平均价格

-- comment on column brief_prvc_pz.predict_tm not supported: 平均价格


-- 创建视图 v_brief_market_pz
SELECT
    m.market AS market,
    m.pz AS pz,
    m.average AS average,
    m.highest AS highest,
    m.lowest AS lowest,
    v.variation AS variation,
    ptd.average AS predict_td,
    ptm.average AS predict_tm
FROM
    price_market m
        LEFT JOIN price_variation_daily v ON m.pz = v.pz AND m.market = v.market
        LEFT JOIN price_prvc_predict ptd ON ptd.pz = m.pz AND ptd.prvc = m.prvc AND ptd.release_time = CURRENT_DATE
        LEFT JOIN price_prvc_predict ptm ON ptm.pz = m.pz AND ptm.prvc = m.prvc AND ptm.release_time = DATE_ADD(CURRENT_DATE, INTERVAL 2 DAY)
WHERE
        m.release_time = CURDATE() - INTERVAL 1 DAY;

-- 创建视图 v_brief_prvc_pz
SELECT p.prvc, p.pz, MAX(p.average) AS average, COALESCE(MAX(pk.highest), 0) AS highest, COALESCE(MAX(pk.lowest), 0) AS lowest, MAX(COALESCE(v.variation, 0)) AS variation, MAX(ptd.average) AS predict_td, MAX(ptm.average) AS predict_tm
FROM price_prvc p
         LEFT JOIN price_variation_prvc_daily v ON v.prvc = p.prvc AND v.pz = p.pz
         LEFT JOIN price_prvc_peak_daily pk ON pk.prvc = p.prvc AND pk.pz = p.pz
         LEFT JOIN price_prvc_predict ptd ON ptd.prvc = p.prvc AND ptd.pz = p.pz AND ptd.release_time = CURRENT_DATE
         LEFT JOIN price_prvc_predict ptm ON ptm.prvc = p.prvc AND ptm.pz = p.pz AND ptm.release_time = DATE_ADD(CURRENT_DATE, INTERVAL 1 DAY)
GROUP BY p.prvc, p.pz