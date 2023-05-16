package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MySqlSessionFactory {
    private static SqlSessionFactory factory;
    private static SqlSession sqlSession;

    static {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis.xml");
        //builder可以指定环境
        //factory = builder.build(inputStream,"developmentTwo");
        factory = builder.build(inputStream);
    }

    //设计一个方法，获取sqlSession对象
    public static SqlSession getSqlSession() {
        if (sqlSession == null) {
            sqlSession = factory.openSession();
        }
        return sqlSession;
    }

    //设置可以自动提交事务
    public static SqlSession getSqlSession(boolean flag) {
        if (sqlSession == null) {
            sqlSession = factory.openSession(flag);
        }
        return sqlSession;
    }

}
