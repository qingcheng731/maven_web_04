package org.lanqiao.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 
 * @ClassName JdbcUtils
 * @Description TODO jdbc工具类
 * @author wangzhoucheng
 * @Date 2016年11月7日 下午9:00:00
 * @version 1.0.0
 */
public class JdbcUtils {

    // 为保证各层的类所使用的ThreadLocal是同一个，建议将其设定成静态的，但是一定要记得使用后要移出绑定在上面的对象。
    private static DataSource ds;
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>(); // 其实就是一个Map集合
    static {
        try {
            Properties prop = new Properties();
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            prop.load(in);
            //BasicDataSourceFactory factory = new BasicDataSourceFactory();
            
            //1.显示配置四大参数,目前只能加载以下四大参数
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(prop.getProperty("driverClassName"));
            dataSource.setUrl(prop.getProperty("url"));
            dataSource.setUsername(prop.getProperty("username"));
            dataSource.setPassword(prop.getProperty("password"));
            ds = dataSource;
            
            //2.使用默认的配置，如果配置文件配置了其他参数，还可以加载其他的参数
            //ds = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }

    // 备注：该获取连接的方法，仅当使用ThreadLocal来管理事务连接的情况，因为向静态对象ThreadLocal中绑定了对象，
    //所以当我们不需要管理事务的普通获取连接的方法，就不要用此方法。应该用普通的获取连接的方法。

    public static Connection getConnection() {
        try {
            // 得到当前线程上绑定的连接
            Connection conn = tl.get();
            if (conn == null) { // 代表线程上没有绑定连接
                conn = ds.getConnection();
                tl.set(conn);
            }
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void startTransaction() {
        try {
            // 得到当前线程上绑定连接开启事务
            Connection conn = tl.get();
            if (conn == null) { // 代表线程上没有绑定连接
                conn = ds.getConnection();
                tl.set(conn);
            }
            conn.setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void commitTransaction() {
        try {
            Connection conn = tl.get();
            if (conn != null) {
                conn.commit();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() {
        try {
            Connection conn = tl.get();
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            tl.remove(); // 千万注意，解除当前线程上绑定的链接（从threadlocal容器中移除对应当前线程的链接）
        }
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println(JdbcUtils.getDataSource());
        System.out.println(JdbcUtils.getDataSource().getConnection());
        
        ResultSet rs = JdbcUtils.getDataSource().getConnection().prepareStatement("select * from emp").executeQuery();
        
        while(rs.next()){
            System.out.println(rs.getString(2));
        }
    }
}
