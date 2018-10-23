package com.newface.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.http.HttpServlet;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Created by HeemangHan on 2016. 9. 11..
 */
public class MyBatisConfig extends HttpServlet {

    private static SqlSessionFactory sqlSessionFactory;

    public void init() {

        try {
            String resource = "com/newface/mybatis/conf/mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);

            if(sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }

            System.out.println(sqlSessionFactory);

        } catch(FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch(IOException ioException) {
            ioException.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}