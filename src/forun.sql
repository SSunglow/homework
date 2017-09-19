
drop table admin;
drop table concern;
drop table good;
drop table manage;
drop table plate;
drop table forumuser;
drop table reply;
drop table posts;
/*==============================================================*/
/* Table1: 回复贴（id，内容，帖子id，回复人，回复时间，被回复人，被查看）                                             */
/*==============================================================*/
create table Reply 
(
   replyid  number(6) primary key,
   replycontent  varchar2(1024),
   pid  number(6),
   replyname  varchar2(20),
   replytime  date,
   replydname  varchar2(20),
   seed  number(1),
   floornum number(5)
);

/*==============================================================*/
/* Table2:管理员 （id,管理员名字，管理员密码）                                            */
/*==============================================================*/
create table admin 
(
   adminid  number(2) primary key,
   adminname  varchar(20),
   adminpwd  varchar(20)
);

/*==============================================================*/
/* Table3: 帖子 （id，版块id,标题，作者，点击量，回复量，最后回复时间，点赞量，内容，发表时间）                                            */
/*==============================================================*/
create table posts 
(
    conid  number(6)  primary key,
    plateid  number(2),
    title  varchar2(50),
    author  varchar2(20),
    clicknum  number(6),
    replynum  number(5),
    replytime  date,
    goodnum  number(5),
    content  varchar(500),
    ctime   date
);

/*==============================================================*/
/* Table4:用户（id,用户名，用户密码，性别，年龄，身份，邮箱，积分，发帖数，粉丝数，关注人数）                                                */
/*==============================================================*/
create table forumuser 
(
    userid  number(6)  primary key,
    username  varchar(20),
    userpwd  varchar(20),
    gender  varchar(2),
    age  number(2),
    identity  varchar(50),
    email  varchar(50),
    integral  number(6),
    postscount  number(6),
    fansnum  number(5),
    concernnum  number(4)
);
drop table forumuser;
create table forumuser 
(
    userid  number(6)  primary key,
    username  varchar(20),
    userpwd  varchar(20),
    gender  varchar(2),
    age  number(2),
    identity  varchar(50),
    email  varchar(50),
    integral  number(6),
    postscount  number(6),
    fansnum  number(5),
    concernnum  number(4),
    home varchar(50),
    school varchar(50)
);


/*==============================================================*/
/* Table5: 关注（id，粉丝id，关注人id）                                               */
/*==============================================================*/
create table concern 
(
   concernid            number(6)              primary key,
   fansid               number(6)              not null,
   concern            number(6)              not null
);

/*==============================================================*/
/* Table6: 管理信息（id,管理员id,操作，时间）                                                    */
/*==============================================================*/
create table  manage
(
    manageid  number(6)  primary key,
    adminid  number(2),
    operation  varchar2(100),
    mtimee  date
);

/*==============================================================*/
/* Table7:点赞信息（id,帖子id,用户id)                                                    */
/*==============================================================*/
create table  good
(
    goodid  number(6)  primary key,
    goodpostid  number(6),
    goodnameid  number(6)
);

/*==============================================================*/
/* Table8:版块信息（id,名字，简介，创建日期，发帖数，版主）                                                    */
/*==============================================================*/
create table  plate
(
    plateid  number(2) primary  key,
    platename  varchar(20),
    describe  varchar(128),
    platedate  date,
    postscount  number(4),
    master  varchar(20)
);
insert into plate(plateid,platename,describe) values(1,'校园问答','校园问答');