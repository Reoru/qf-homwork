package com.fd.question02;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/13 0013 下午 21:36
 */
public interface Demo {
/*    #DML
        # 新增8条数据
            insert into tbl_student
            values (1, 'S_1001', 'zs', 18, default, '上海');
            insert into tbl_student
            values (2, 'S_1002', 'ls', 19, default, '上海');
            insert into tbl_student
            values (3, 'S_1003', 'ww', 20, '女', '深圳');
            insert into tbl_student
            values (4, 'S_1004', 'zl', 21, '女', '深圳');
            insert into tbl_student
            values (5, 'S_1005', 't1', 22, default, '北京');
            insert into tbl_student
            values (6, 'S_1006', 't2', 23, '女', '北京');
            insert into tbl_student
            values (7, 'S_1007', 't3', 24, default, '上海');
            insert into tbl_student
            values (8, 'S_1008', 't4', 24, '女', '杭州');
        #------------------------------------------------------------
                # 年龄大于50测试数据
            insert into tbl_student
            values (9, 'S_1009', 't5', 51, '女', '深圳');
        # 年龄为Null测试数据
            insert into tbl_student
            values (10, 'S_1010', 't6', null, default, '上海');
        # 姓名为Null测试数据
            insert into tbl_student
            values (11, 'S_1011', null, 52, default, '上海');
        # 年龄19男生重复记录测试数据，算平均值
            insert into tbl_student
            values (12, 'S_1012', 't7', 19, default, '上海');

        # 删除 年龄大于20 且不再上海的学生
            delete from tbl_student where age >= 20 and address != '上海';

        # 把深圳校区的同学的sname加上前缀qf
            update tbl_student set sname = concat('qf-', sname) where address = '深圳';

*/
}
