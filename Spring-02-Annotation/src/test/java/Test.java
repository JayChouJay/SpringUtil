import config.Configuration;
import config.MainConfig;
import domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Test {
    BeanFactory factory = new AnnotationConfigApplicationContext(MainConfig.class);
    JdbcTemplate jdbcTemplate = (JdbcTemplate) factory.getBean("jdbcTemplate");

    @org.junit.Test
    public void test() {
        String sql = "insert into user values(null,'路飞',123)";
        jdbcTemplate.update(sql);
        System.out.println(jdbcTemplate);
    }
    @org.junit.Test
    public void selectAllObjectList() {
        String sql = "Select * from user where 1=1";
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
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

}
