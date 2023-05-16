package processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.core.Ordered;

/**
 * 自定义-BeanFactory后置处理器
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactory初始化拉尔");
        AbstractBeanDefinition abstractBeanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition("simple2");
        abstractBeanDefinition.setInitMethodName("init");
        abstractBeanDefinition.setDestroyMethodName("finalize");
        MutablePropertyValues mutablePropertyValues = abstractBeanDefinition.getPropertyValues();
        mutablePropertyValues.addPropertyValue("sname", "beanfactory modify name");
    }

    /**
     * 调用顺序优先级
     */
    @Override
    public int getOrder() {
        return 10;
    }
}
