import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import springjdbc.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Spring的ORM框架
 * 依赖包：Spring-jdbc + mysql-connector-j
 */
public class Spring03JDBC {
    BeanFactory factory = new ClassPathXmlApplicationContext("spring/spring-03-jdbc.xml");
    JdbcTemplate template = (JdbcTemplate) factory.getBean("jdbcTemplate");

    @Test
    public void insertOneSimple() {
        String sql = "insert into user values(null,'邓紫棋',123)";
        template.update(sql);
    }

    @Test
    public void insertOne() {
        String sql = "insert into user values(?,?,?)";
        template.update(sql, null, "林俊杰", "123");
    }

    @Test
    public void deleteOne() {
        String sql = "delete from user where username=?";
        template.update(sql, "周杰伦");
    }

    @Test
    public void updateOne() {
        String sql = "update user set username='周杰伦'where username='林俊杰'";
        template.update(sql);
    }

    @Test
    public void selectOne() {
        String sql = "Select username from user where id=?";
        String username = template.queryForObject(sql, String.class, 3);
        System.out.println(username);
    }

    @Test
    public void selectOneObject() {
        String sql = "Select * from user where id=?";
        User user = template.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        }, 3);
        System.out.println(user);
    }

    @Test
    public void selectAllObjectList() {
        String sql = "Select * from user where 1=1";
        List<User> userList = template.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        System.out.println(userList);
    }

    @Test
    public void selectAllMapList() {
        String sql = "Select * from user where 1=1";
        List<Map<String, Object>> userList = template.queryForList(sql);
        System.out.println(userList);
    }
}
