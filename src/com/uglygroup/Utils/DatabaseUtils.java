package com.uglygroup.Utils;

import java.sql.*;

/**
 * Created by Think on 2017/6/6.
 */
public class DatabaseUtils {

    public   static  Connection connection = null;
    public   static Statement statement = null;
    private static int inId;
    static{
        getConnection();
    }

    //数据库连接、关闭和操作

    //执行SQL语句
    public static ResultSet getResult(String sql){
        ResultSet rs;
        try {
            rs = statement.executeQuery(sql);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

        return rs;
    }
    public static void doSql(String sql){
        try{
            statement.execute(sql);
        }
        catch (Exception e) {
            System.out.println(sql);
            throw new RuntimeException(e);
        }
    }
    //进行连接
    public  static void getConnection(){
        try {
            String url = "jdbc:postgresql://localhost:5439/postgres";
            //换成自己PostgreSQL数据库实例所在的ip地址，并设置自己的端口
            String user = "postgres";
            String password = "";
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            //System.out.println("是否成功连接pg数据库" + connection);
            statement = connection.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //关闭连接
    public static void close(Connection connection, Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }


}
