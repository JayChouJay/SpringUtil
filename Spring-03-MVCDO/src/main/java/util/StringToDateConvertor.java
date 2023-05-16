package util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义一个类
 * 目的是为了将String类型转化成Date类型
 */
public class StringToDateConvertor implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        Date date = null;
        //自己定义的一个转换规则
        //将请求发送过来的String信息转换成自己要的那个对象
        //方法中的遍历source就是传递过来的哪个信息
        //2022-01-01
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super Date, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
