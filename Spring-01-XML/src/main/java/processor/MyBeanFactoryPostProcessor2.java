package processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

/**
 *自定义-BeanFactory后置处理器
 */
public class MyBeanFactoryPostProcessor2 implements BeanFactoryPostProcessor , Ordered {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("BeanFactory初始化拉尔");
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
