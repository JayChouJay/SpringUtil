# Mybatis
相关：N+1问题
功能：事务管理,提供缓存功能，数据库连接池，动态SQL

## 事务管理

事务：Mysql底层自动提交事务，Oracle手动提交事务。 Mybatis默认手动提交事务

## 缓存功能：
效果：
> 延时查询第二条语句时(两条语句，分别查询)，如果所用的字段（例如：员工表的部门字段）如果重复，那么将不在查询，直接从缓存中读取。如果缓存中没有的话，则执行sql，并且存储一份缓存
> 
> 
问题：缓存一致性

3.

> "#{}"表示类型和值
> “${}”表示普通的字串：用于表名，列明，关键字
>
>

项目：
> 单一表xml：Student,T1Student
> 一对一xml：IDCard +Person
> 一对多XML：emp，dept
> 多对多XML：Student2,Teacher2

别名：
>map(hashmap,map):不能用对象接收时用map
>list:一对多和多对多时用list
> 
## 动态SQL
SQL的问号“？”拼接：按照顺序和按照名字反射
动态SQL：
> if
> choose(when,otherwise)
> trim(where,set):insert时用set标签，有查询条件是用where标签
> foreach:用于update批量修改
## Mapper
关键：Mapper要遵循规则：命名空间，方法名对应
通过SqlSession获得一个Mapper代理对象
Service层直接调用Mapper代理对象

相关：动态代理和静态代理
连接池+ORM

连接池：类似MyConnection包裹JDBC4Connection

MyConnection中有JDBC4Connection和一个状态status

ORM：工厂根据配置文件创建connection，通过connection获取SqlSession，SqlSession有一个Mapper代理，使用Mapper代理可以绑定SQL
## 基于注解
内容：一对一，一对多，多对对，动态SQL
注解的动态SQL依赖一个新的类，类中写一个方法，然后把原先的@Select/@Insert替换成@SelectProvider/@InsertProvider(type=DeptProvider.class,method=""")