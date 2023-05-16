package mapper;

import domain.one.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapper {
    InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis.xml");
    //创建工人对象并获取工厂对象
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
    //获取通过的那个对象SqlSession
    //创建的session默认手动提交事务，true代表自动提交
    SqlSession session = factory.openSession(true);


    //查询所有<学生>
    public List<Student> getAll() {
        return session.selectList("getAll");
    }
    //查询所有<学生>，根据ID顺序排列
    public List<Student> getAllOrderBy(String flag) {
        return session.selectList("getAllOrderBy",flag);
    }

    //查询所有<学生>--用Map装
    public List<Map<String, Object>> getAllMap() {
        return session.selectList("getAllMap");
    }

    //按id查询一个<学生>
    public Student selectOneById(Integer id) {
        return session.selectOne("selectOneById", id);
    }

    //按id查询一个<学生的姓名>
    public String selectOneNameById(Integer id) {
        return session.selectOne("selectOneNameById", id);
    }

    //查<学生>总数量
    public Integer selectCount() {
        return session.selectOne("selectCount");
    }

    //新增一条<学生>记录
    public void insertOne(Student student) {
        //通过Session进行增删改查
        session.update("insertOne", student);
        //Mybatis默认不提交事务
        //session.commit();
    }

    //通过id修改<学生>信息--对象
    //对象只要有id和ssex属性即可
    public void updateOneSex(Student student) {
        session.update("updateOneSex", student);

    }

    //通过id修改<学生>信息--map
    public void updateOneSex(Integer id, String sex) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("ssex", sex);
        session.update("updateOneSex", map);

    }

}
