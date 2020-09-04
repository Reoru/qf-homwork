package com.fd.test01;

import java.sql.*;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/14 0014 上午 8:43
 */
public class JDBCDemo {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws SQLException {
//        t1();
        t2();
    }


    public static void t1() throws SQLException {
        String sname = "zs";
        String stuno = "S_1001' or '1' = '1";
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qf", "root", "root");
        Statement statement = conn.createStatement();
        //sql注入  登录查询只要有返回结果，那么一般都是算登录成功的，此时sql注入就会造成风险
        statement.execute("select * from tbl_student where sname ='" + sname + "' and stuno ='" + stuno + "'");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            System.out.println(resultSet.getObject(1) + "\t" + resultSet.getObject(2) + "\t" + resultSet.getObject(3) + "\t" + resultSet.getObject(4) + "\t" + resultSet.getObject(5) + "\t" + resultSet.getObject(6));
        }
        statement.close();
        conn.close();
    }


    public static void t2() throws SQLException {
        String sname = "zs";
        String stuno = "S_1001 or 1 = 1";
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qf", "root", "root");
        //预编译  在执行sql之前，sql的格式已经固定好，只需要把?替换成对应的值，之后就可直接执行sql
        //因此在执行时sql是select * from sname = 'zs' and stuno = 'S_1001 or 1 = 1'   因此找不到指定的sql
        PreparedStatement s = conn.prepareStatement("select * from tbl_student where sname = ? and stuno = ?");
        s.setString(1, sname);
        s.setString(2, stuno);
        ResultSet resultSet = s.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getObject(1) + "\t" + resultSet.getObject(2) + "\t" + resultSet.getObject(3) + "\t" + resultSet.getObject(4) + "\t" + resultSet.getObject(5) + "\t" + resultSet.getObject(6));
        }
        s.close();
        conn.close();
    }
}
