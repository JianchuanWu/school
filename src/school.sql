drop database if exists school;

create database school;

use school;

create table teacher(
	tid int primary key auto_increment,
	tname varchar(30) not null,
	tage int check(tage between 30 and 60)
);

insert into teacher (tname,tage) values
								('孔子',30),
								('孟子',31),
								('庄子',32),
								('居里夫人',33),
								('迈克乔丹',34),
								('刘欢',35);

create table classinfo(
	clid varchar(20) primary key,
	clname varchar(50) unique not null,
	clbegindate date not null,
	clenddate date not null
);


insert into classinfo(clid,clname,clbegindate,clenddate) values 
		('cl_1','计算机科学与技术一班','2013-9-1','2017-7-1'),
		('cl_2','计算机科学与技术二班','2013-9-1','2017-7-1'),
		('cl_3','计算机科学与技术三班','2013-9-1','2017-7-1'),
		('cl_4','计算机科学与技术四班','2013-9-1','2017-7-1');


create table student(
	stid varchar(30) primary key,
	stname varchar(50) not null,
	stbirthday date not null,
	stsex int check(stsex=1 or stsex=2),
	clid varchar(20) not null,
	foreign key (clid) references classinfo(clid)
);



insert into student (stid,stname,stbirthday,stsex,clid) values
			('st_01','张三','1994-02-11',1,'cl_1'),
			('st_02','李四','1995-03-18',2,'cl_2'),
			('st_03','王五','1993-04-16',1,'cl_3'),
			('st_04','赵六','1995-05-30',2,'cl_4'),
			('st_05','田七','1996-06-22',1,'cl_1'),
			('st_06','小明','1992-07-02',2,'cl_2'),
			('st_07','小李','1994-08-22',1,'cl_3'),
			('st_08','李逍遥','1996-09-12',2,'cl_4'),
			('st_09','赵灵儿','1994-02-11',1,'cl_1'),
			('st_10','郭靖','1995-03-18',2,'cl_2'),
			('st_11','黄蓉','1993-04-16',1,'cl_3'),
			('st_12','令狐冲','1995-05-30',2,'cl_4'),
			('st_13','任盈盈','1996-06-22',1,'cl_1'),
			('st_14','杨过','1992-07-02',2,'cl_2'),
			('st_15','小龙女','1994-08-22',1,'cl_3'),
			('st_16','赵敏','1996-09-12',2,'cl_4');


create table studentcard(
	stid varchar(30) primary key,
	carddate date not null,
	cardbg int default 1 check(cardbg>=1),
	foreign key (stid) references student(stid)
);



insert into studentcard (stid,carddate,cardbg) values
			('st_01','2013-9-1',1),
			('st_02','2013-9-1',1),
			('st_03','2013-9-1',1),
			('st_04','2013-9-1',1),
			('st_05','2013-9-1',1),
			('st_06','2013-9-1',1),
			('st_07','2013-9-1',1),
			('st_08','2013-9-1',1),
			('st_09','2013-9-1',1),
			('st_10','2013-9-1',1),
			('st_11','2013-9-1',1),
			('st_12','2013-9-1',1),
			('st_13','2013-9-1',1),
			('st_14','2013-9-1',1),
			('st_15','2013-9-1',1),
			('st_16','2013-9-1',1);


create table subjectinfo(
	subid int primary key auto_increment,
	subname varchar(30) unique not null
);

insert into subjectinfo(subname)values
	('计算机基础'),
	('java程序设计'),
	('数据库'),
	('web前端'),
	('数据结构');

create table student_subject(
	stid varchar(30) not null,
	subid int not null,
	primary key(stid,subid),
	foreign key(stid) references student(stid),
	foreign key(subid) references subjectinfo(subid) 
);


insert into student_subject (stid,subid) values
		('st_01',1),('st_01',2),('st_01',3),('st_01',4),('st_01',5),
		('st_02',1),('st_02',2),('st_02',3),('st_02',4),('st_02',5),
		('st_03',1),('st_03',2),('st_03',3),
		('st_04',1),('st_04',2),('st_04',3),('st_04',4),('st_04',5),
		('st_05',1),('st_05',2),('st_05',3),('st_05',4),
		('st_06',1),('st_06',2),
		('st_07',1),('st_07',2),('st_07',3),('st_07',4),('st_07',5),
		('st_08',1),('st_08',2),('st_08',3),('st_08',4),('st_08',5),
		('st_09',1),('st_09',2),('st_09',3),
		('st_10',1),('st_10',2),('st_10',3),('st_10',4),('st_10',5),
		('st_11',1),('st_11',2),('st_11',3),('st_11',4),
		('st_12',1),
		('st_13',1),('st_13',2),('st_13',3),('st_13',4),('st_13',5),
		('st_14',1),('st_14',2),('st_14',3),
		('st_15',1),('st_15',2),('st_15',3),('st_15',4),
		('st_16',1),('st_16',2),('st_16',3);


select st.stname,su.subname from student st join student_subject ss on st.stid=ss.stid join subjectinfo su on su.subid=ss.subid order by st.stid;

-- 系统用户表
create table userinfo(
	uid int primary key auto_increment, -- 主键
	logname varchar(20) not null unique, -- 用户名
	keyword varchar(10) not null -- 密码
);

-- 系统登录日志表
create table userloginfo(
	logid int primary key auto_increment, -- 主键
	uid int not null, -- 操作用户
	logdate date not null, -- 操作时间
	logtype int check(logtype=1 or logtype=0), -- 具体操作，1登录  0下线
	foreign key (uid) references userinfo(uid)
);

insert into userinfo(logname,keyword) values('吴建川','666');
insert into userinfo(logname,keyword) values('admin','admin');