package com.fd.question03;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/13 0013 下午 21:40
 */
public interface Demo {
/*
    #DQL
        # 1.查询所有学生的ID,姓名显示出来
            select id, sname
            from tbl_student;

        # 2.查询性别为女，并且年龄小于50的记录
            select *
            from tbl_student
            where gender = '女'
            and age < 50;

        # 3.查询学号为S_1001，或者姓名为liSi的记录
            select *
            from tbl_student
            where stuno = 'S_1001'
            or sname = 'ls';

        # 4.查询学号不是S_1001，S_1002，S_1003的记录
            select *
            from tbl_student
            where stuno not in (select stuno from tbl_student where stuno = 'S_1001' or stuno = 'S_1002' or stuno = 'S_1003');

        # 5.查询年龄为null的记录
            select *
            from tbl_student
            where age is null;

        # 6.查询年龄在20到40之间的学生记录
            select *
            from tbl_student
            where age between 20 and 40;

        # 7.查询性别非男的学生记录
            select *
            from tbl_student
            where gender != '男';

        # 8.查询姓名不为null的学生记录
            select *
            from tbl_student
            where sname is not null;

        # 9.找出男女同学中的年龄最大值
            select gender, max(age) 'maxAge'
            from tbl_student
            group by gender;

        # 10.查询年龄大于18,并且用年龄,性别分组,找出分组后学生年龄的平均值
            select age, gender, avg(age) 'avgAge'
            from tbl_student
            where age in (select age from tbl_student where age > 18)
            group by age, gender;
        #统计每组的人数
        #select age,gender,avg(age) 'avgAge',count(age) 'count' from tbl_student where age in (select age from tbl_student where age>18) group by age,gender;

        # 11.找出姓名中包含了s的前5条记录的值
            select *
            from tbl_student
            where sname like '%s%'
            limit 0,5;
*/
}
