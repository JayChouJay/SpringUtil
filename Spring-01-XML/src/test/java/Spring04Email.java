import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 基于Spring-Context-Support的邮件发送功能
 * 依赖包：Spring-Context-Support + mail
 */
public class Spring04Email {
    BeanFactory factory = new ClassPathXmlApplicationContext("spring/spring-04-email.xml");

    @Test
    public void sendEmail() throws MessagingException {
        JavaMailSender sender = (JavaMailSenderImpl) factory.getBean("sender");
        //利用这个sender创建一个邮件对象
        MimeMessage message = sender.createMimeMessage();
        //发送这个邮件，找人帮忙
        //是Session和Transport的合体
        MimeMessageHelper helper = new MimeMessageHelper(message);

        //需要告知helper发给谁，发什么
        helper.setFrom("1020968571@qq.com");
        helper.setTo("553278752@qq.com");
        helper.setSubject("Spring封装的Email的主题");
        helper.setText("SpringEmail的内容");

        //发送消息
        sender.send(message);
    }
}
