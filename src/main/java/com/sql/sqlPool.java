package com.sql;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class sqlPool {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/javawebDemo?useUnicode=true&characterEncoding=utf8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lxb032412";

//    dhcp连接池
    public static Connection getDataSourceDHCP(){
        Connection con = null;
        //1.创建连接池对象
        BasicDataSource dataSource = new BasicDataSource();
        //2.利用连接池加载驱动
        dataSource.setDriverClassName(DRIVER);
        //3.利用连接池设置连接
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        //4.设置连接池参数
        dataSource.setMaxActive(20);//设置最大连接数
        dataSource.setMaxIdle(5);//设置最大空闲连接数
        dataSource.setInitialSize(3);//设置初始化连接数
        //设置最大等待时间（当连接数用完时，等待别人归还的时间，超时抛出异常）
        dataSource.setMaxWait(1000);
        try{
            //5.从连接池中获取连接
            con = dataSource.getConnection();
            //6.用完之后close()不是关闭连接，而是归还连接con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //c3p0连接池
    public static Connection getDataSourceC3P0(){
        Connection con = null;
        //1.创建连接池对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try{
            //2.加载驱动，设置连接
            dataSource.setDriverClass(DRIVER);
            dataSource.setJdbcUrl(URL);
            dataSource.setUser(USERNAME);
            dataSource.setPassword(PASSWORD);
            //3.设置连接参数
            dataSource.setInitialPoolSize(5);//设置初始化连接数
            dataSource.setMaxPoolSize(20);//设置最大连接数
            dataSource.setMinPoolSize(3);//设置最小连接数
            dataSource.setAcquireIncrement(5);//设置每次增量
            //4.获取连接
            con = dataSource.getConnection();

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }


}
