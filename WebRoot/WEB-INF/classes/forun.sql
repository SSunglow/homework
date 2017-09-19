
drop table admin;
drop table concern;
drop table good;
drop table manage;
drop table plate;
drop table forumuser;
drop table reply;
drop table posts;
/*==============================================================*/
/* Table1: �ظ�����id�����ݣ�����id���ظ��ˣ��ظ�ʱ�䣬���ظ��ˣ����鿴��                                             */
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
/* Table2:����Ա ��id,����Ա���֣�����Ա���룩                                            */
/*==============================================================*/
create table admin 
(
   adminid  number(2) primary key,
   adminname  varchar(20),
   adminpwd  varchar(20)
);

/*==============================================================*/
/* Table3: ���� ��id�����id,���⣬���ߣ���������ظ��������ظ�ʱ�䣬�����������ݣ�����ʱ�䣩                                            */
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
/* Table4:�û���id,�û������û����룬�Ա����䣬��ݣ����䣬���֣�����������˿������ע������                                                */
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
/* Table5: ��ע��id����˿id����ע��id��                                               */
/*==============================================================*/
create table concern 
(
   concernid            number(6)              primary key,
   fansid               number(6)              not null,
   concern            number(6)              not null
);

/*==============================================================*/
/* Table6: ������Ϣ��id,����Աid,������ʱ�䣩                                                    */
/*==============================================================*/
create table  manage
(
    manageid  number(6)  primary key,
    adminid  number(2),
    operation  varchar2(100),
    mtimee  date
);

/*==============================================================*/
/* Table7:������Ϣ��id,����id,�û�id)                                                    */
/*==============================================================*/
create table  good
(
    goodid  number(6)  primary key,
    goodpostid  number(6),
    goodnameid  number(6)
);

/*==============================================================*/
/* Table8:�����Ϣ��id,���֣���飬�������ڣ���������������                                                    */
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
insert into plate(plateid,platename,describe) values(1,'У԰�ʴ�','У԰�ʴ�');