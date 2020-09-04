package com.fd.question01;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/13 0013 下午 21:35
 */
public interface Demo {
/*
      #DDL
        # 手工编写完成数据库的新增,修改,修改编码,查询编码等
        # 新建qf数据库并指定字符集
            create database if not exists qf character set gbk;

        # 修改字符集
            alter database qf character set utf8;

        # 查看字符集
            show create database qf;

        # 切换qf数据库
            use qf;
        #------------------------------------------------------------
                # 新建学生表
         create table if not exists tbl_student
        (
            id      int(255) primary key auto_increment,
            stuno   varchar(10) not null unique,
            sname   varchar(30),
            age     int(100),
            gender  varchar(1) default '男',
            address varchar(255)
        );

        # 查询学生表
            select *
            from tbl_student;

        # 查看学生表结构
            show create table tbl_student;

        #新建 test_column字段
            alter table tbl_student add test_column varchar(10);

        #修改test_column字段为t_column
            alter table tbl_student change test_column t_column varchar(10);

        #修改表字段test_column类型为int
            alter table tbl_student change t_column t_column int(10);

        # 删除t_colum字段
            alter table tbl_student drop t_column;

        #删除student表
            drop table tbl_student;

        # 删除qf数据库
            drop database if exists qf;
*/

}
