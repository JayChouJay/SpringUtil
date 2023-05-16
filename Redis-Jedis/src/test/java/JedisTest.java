import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    @Test
    public void jedisTest() {
        Jedis jedis = new Jedis("192.168.10.18", 6379);
        jedis.set("jedis", "hello");
        System.out.println(jedis.get("jedis"));
        jedis.close();
    }
}
