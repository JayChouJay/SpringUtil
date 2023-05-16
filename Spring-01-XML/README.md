Spring启动：
> 1.执行父类构造方法
>
> 2.设置配置文件
>
> 3.Refresh方法（Spring核心方法）

Refresh方法：
1) 同步
2) 准备刷新：构造时间，设置状态，打印日志，有没有子类，校验，事件初始化并返回 
3) 准备BeanFactory：设置类加载器，Bean表达式解析器，属性注册，内置的Bean的后置处理器，接口的忽略，注册，注册资源解析， 
4) 添加Bean后置处理器，判断条件，判断是否包含某个Bean 
5) BeanFactory创建 
6) BeanFactory后置处理器
7) Bean后置处理器
8) 国际化和监听器
9) 创建对象
10) finalRefresh：监听，发布一个事件
11) 循环依赖问题