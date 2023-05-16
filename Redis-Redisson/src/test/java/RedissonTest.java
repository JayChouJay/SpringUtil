import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonTest {
    @Test
    public void bloomFilter(){
        Config config=new Config();
        config.useSingleServer().setAddress("redis://192.168.10.8:6379");
        //构造Redisson
        RedissonClient redisson= Redisson.create(config);

        RBloomFilter<String>bloomFilter=redisson.getBloomFilter("phoneList");
        //初始化布隆过滤器：预计元素为100000000L,误差率为3%
        bloomFilter.tryInit(100000000L,0.03);
        //将号码10086插入到布隆过滤器中
        bloomFilter.add("10086");

        //判断下面号码是否在布隆过滤器中
        //false
        System.out.println(bloomFilter.contains("123456"));
        //true
        System.out.println(bloomFilter.contains("10086"));
    }
}
