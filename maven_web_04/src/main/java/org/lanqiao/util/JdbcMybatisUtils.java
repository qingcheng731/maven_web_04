package org.lanqiao.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class JdbcMybatisUtils {

    static SqlSessionFactory factory;
    static{
        try {
            String resource = "mybatis-config.xml";
            InputStream is;
            is = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public static SqlSession getSession(){
        return factory.openSession();
    }
}
