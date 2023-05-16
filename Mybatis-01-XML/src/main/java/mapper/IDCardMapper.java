package mapper;

import domain.onetoone.IDCard;
import org.apache.ibatis.session.SqlSession;
import util.MySqlSessionFactory;

import java.util.List;

public class IDCardMapper {
    private SqlSession session = MySqlSessionFactory.getSqlSession(true);

    public IDCard selectOneByCardId(String cardId) {
        return session.selectOne("selectOneByCardId",cardId);
    }
    public List<IDCard> getAll() {
        return session.selectList("getAll");
    }
    public List<IDCard> getAllOrderBy(String flag){
        return session.selectList("getAllOrderBy",flag);
    }
}
