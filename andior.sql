SELECT * FROM t_class

SELECT * FROM t_classname

SELECT * FROM t_object


CREATE TABLE t_classes
(
cid INT PRIMARY KEY AUTO_INCREMENT,
cname VARCHAR(20),
curl VARCHAR(100),
cimg VARCHAR(100)
)

SELECT * FROM t_classes

INSERT INTO t_classes(cname,curl,cimg)
VALUES('Java班','a1.html','a1.png');
INSERT INTO t_classes(cname,curl,cimg)
VALUES('Phtyon班','a2.html','a2.png');
INSERT INTO t_classes(cname,curl,cimg)
VALUES('Php班','a3.html','a3.png');
INSERT INTO t_classes(cname,curl,cimg)
VALUES('JS班','a4.html','a4.png');
INSERT INTO t_classes(cname,curl,cimg)
VALUES('Go班','a5.html','a5.png');
INSERT INTO t_classes(cname,curl,cimg)
VALUES('C#班','a6.html','a6.png');
INSERT INTO t_classes(cname,curl,cimg)
VALUES('Dart班','a7.html','a7.png');
INSERT INTO t_classes(cname,curl,cimg)
VALUES('Html班','a8.html','a8.png');
INSERT INTO t_classes(cname,curl,cimg)
VALUES('WX班','a9.html','a9.png');


SELECT * FROM t_classes

SELECT * FROM t_students

ALTER TABLE t_stu1 ADD saddress VARCHAR(20);
ALTER TABLE t_stu1 ADD state INT ;

SELECT * FROM t_stu1
-- 班级人数站总人数的比例（饼图）

SELECT c.cname,COUNT(c.cname) FROM t_stu1 s INNER JOIN t_classes c ON s.scid=c.cid GROUP BY c.cname

-- **班级男女比例
SELECT cid FROM t_classes WHERE cname='Java班'

SELECT s.ssex,COUNT(s.ssex) FROM t_stu1 s INNER JOIN t_classes c ON s.scid=c.cid WHERE cname='Java班' GROUP BY s.ssex

-- **省份的人数占总人数的比例
SELECT FORMAT(COUNT(*)/(SELECT COUNT(*) FROM t_stu1) ,2)FROM t_stu1 WHERE saddress LIKE '江苏%'  

-- 全体男女比例
SELECT ssex,COUNT(*) FROM t_stu1 GROUP BY ssex

-- 学员身份占比
SELECT st.sname,FORMAT(COUNT(st.sname)/(SELECT COUNT(*) FROM t_stu1) ,2) FROM t_stu1 s 
RIGHT JOIN t_stustate st ON s.state=st.sid GROUP BY st.sname

-- 建立学员身份状态表
CREATE TABLE t_stustate
(
sid INT PRIMARY KEY AUTO_INCREMENT,
sname VARCHAR(20)
)

SELECT * FROM t_stustate
INSERT INTO t_stustate(sname)
VALUES('学生');
INSERT INTO t_stustate(sname)
VALUES('初级程序员');
INSERT INTO t_stustate(sname)
VALUES('中级程序员');
INSERT INTO t_stustate(sname)
VALUES('架构师');
INSERT INTO t_stustate(sname)
VALUES('测试员');
INSERT INTO t_stustate(sname)
VALUES('非专业学员');



------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------- 数据 -------------------------------------------------------------------------------
-- 首页 九宫格
CREATE TABLE t_indexlist
(
  lid INT PRIMARY KEY AUTO_INCREMENT,
  lname VARCHAR(50),
  lurl VARCHAR(100),
  limg VARCHAR(100)
)

SELECT * FROM t_indexlist

INSERT INTO t_indexlist(lname,lurl,limg)
VALUES('编程语言分类','c1.html','a1.png');
INSERT INTO t_indexlist(lname,lurl,limg)
VALUES('编程语言的试题库','c2.html','a2.png');
INSERT INTO t_indexlist(lname,lurl,limg)
VALUES('编程语言教学视频','c3.html','a3.png');
INSERT INTO t_indexlist(lname,lurl,limg)
VALUES('编程语言教学模版','c4.html','a4.png');
INSERT INTO t_indexlist(lname,lurl,limg)
VALUES('编程语言论坛群号','c5.html','a5.png');
INSERT INTO t_indexlist(lname,lurl,limg)
VALUES('编程语言相关报表','c6.html','a6.png');
INSERT INTO t_indexlist(lname,lurl,limg)
VALUES('编程语言的技术模版','c7.html','a7.png');
INSERT INTO t_indexlist(lname,lurl,limg)
VALUES('编程语言的市场前景','c8.html','a8.png');
INSERT INTO t_indexlist(lname,lurl,limg)
VALUES('其他功能','c9.html','a9.png');


-- 编程语言分类

CREATE TABLE t_listclass
(
lid INT PRIMARY KEY AUTO_INCREMENT,
lname VARCHAR(20)
)

SELECT * FROM t_listclass

INSERT INTO t_listclass(lname)
VALUES('Java语言');
INSERT INTO t_listclass(lname)
VALUES('Python语言');
INSERT INTO t_listclass(lname)
VALUES('Php语言');
INSERT INTO t_listclass(lname)
VALUES('Sql语句');
INSERT INTO t_listclass(lname)
VALUES('Html语言');
INSERT INTO t_listclass(lname)
VALUES('Dart语言');
INSERT INTO t_listclass(lname)
VALUES('JavaScript语言');
INSERT INTO t_listclass(lname)
VALUES('Go语言');
INSERT INTO t_listclass(lname)
VALUES('C语言');
INSERT INTO t_listclass(lname)
VALUES('小程序开发');


-- 编程语言的试题库
CREATE TABLE t_listexit
(
  eid INT PRIMARY KEY AUTO_INCREMENT,
  ename VARCHAR(20),
  eurl VARCHAR(100)
)

SELECT * FROM t_listexit

INSERT INTO t_listexit(ename,eurl)
VALUES('系统管理证书/MCSE','c21.html');
INSERT INTO t_listexit(ename,eurl)
VALUES('数据库证书/MCDBA','c22.html');
INSERT INTO t_listexit(ename,eurl)
VALUES('开发方向证书/MCAD/MCSD','c23.html');


SELECT * FROM t_stu1
-- 编程语言教学视频
CREATE TABLE t_listteach
(
tid INT PRIMARY KEY AUTO_INCREMENT,
tname VARCHAR(20),
turl VARCHAR(100)
)
SELECT * FROM t_listteach

-- 编程语言教学模版
CREATE TABLE t_listteacher
(
tid INT PRIMARY KEY AUTO_INCREMENT,
tname VARCHAR(20)
)

INSERT INTO t_listteacher(tname)
VALUES('PPT模版');
INSERT INTO t_listteacher(tname)
VALUES('WPS模版');
INSERT INTO t_listteacher(tname)
VALUES('Word模版');

SELECT * FROM t_listteacher

-- 编程语言论坛群号
CREATE TABLE t_listqq
(
qid INT PRIMARY KEY AUTO_INCREMENT,
qname VARCHAR(20),
qurl VARCHAR(50)
)

INSERT INTO t_listqq(qname,qurl)
VALUES('C语言交流群','462127424');
INSERT INTO t_listqq(qname,qurl)
VALUES('Php语言交流群','167030116');
INSERT INTO t_listqq(qname,qurl)
VALUES('Java语言交流群','72469454');
INSERT INTO t_listqq(qname,qurl)
VALUES('Python语言交流群','19822541');
INSERT INTO t_listqq(qname,qurl)
VALUES('Sql语言交流群','113690036');
INSERT INTO t_listqq(qname,qurl)
VALUES('Go语言交流群','712940263');
INSERT INTO t_listqq(qname,qurl)
VALUES('Html语言交流群','339575993');
INSERT INTO t_listqq(qname,qurl)
VALUES('小程序开发交流群','2214991277');
INSERT INTO t_listqq(qname,qurl)
VALUES('JavaScript语言交流群','806514256');
INSERT INTO t_listqq(qname,qurl)
VALUES('Dart语言交流群','701773238');


SELECT * FROM t_listqq

-- 编程语言相关报表

CREATE TABLE t_listbb
(
bid INT PRIMARY KEY AUTO_INCREMENT,
bname VARCHAR(20),
burl VARCHAR(100)
)

INSERT INTO t_listbb(bname,burl)
VALUES('各语言学习人数比例','c61.html');
INSERT INTO t_listbb(bname,burl)
VALUES('学习人数男女比例','c62.html');
INSERT INTO t_listbb(bname,burl)
VALUES('各地学员数量比例','c63.html');
INSERT INTO t_listbb(bname,burl)
VALUES('学员姓名比例','c64.html');
INSERT INTO t_listbb(bname,burl)
VALUES('编程语言市场占有比例','c65.html');
INSERT INTO t_listbb(bname,burl)
VALUES('近几年编程语言的变化趋势','c66.html');
SELECT * FROM t_listbb


-- 编程语言的技术模版

-- 编程语言的市场前景

-- 其他功能