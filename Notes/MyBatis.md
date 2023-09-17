# 1 MyBatis简介
## 1.1 简介
[mybatis – MyBatis 3 | 简介](https://mybatis.org/mybatis-3/zh/index.html)

## 1.2 持久层框架对比

- JDBC 
   - SQL 夹杂在Java代码中耦合度高，导致硬编码内伤
   - 维护不易且实际开发需求中 SQL 有变化，频繁修改的情况多见
   - 代码冗长，开发效率低
- Hibernate 和 JPA 
   - 操作简便，开发效率高
   - 程序中的长难复杂 SQL 需要绕过框架
   - 内部自动生成的 SQL，不容易做特殊优化
   - 基于全映射的全自动框架，大量字段的 POJO 进行部分映射时比较困难。
   - 反射操作太多，导致数据库性能下降
- MyBatis 
   - 轻量级，性能出色
   - SQL 和 Java 编码分开，功能边界清晰。Java代码专注业务、SQL语句专注数据
   - 开发效率稍逊于 Hibernate，但是完全能够接收

开发效率：Hibernate>Mybatis>JDBC<br />运行效率：JDBC>Mybatis>Hibernate

## 1.3 快速入门

1. 准备数据模型
```sql
CREATE DATABASE `mybatis-example`;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp`  (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `emp_salary` double(10, 5) NULL DEFAULT NULL,
  PRIMARY KEY (`emp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_emp
-- ----------------------------
INSERT INTO `t_emp` VALUES (1, 'tom', 200.33000);
INSERT INTO `t_emp` VALUES (2, 'jerry', 666.66000);
INSERT INTO `t_emp` VALUES (3, 'andy', 777.77000);

SET FOREIGN_KEY_CHECKS = 1;
```

2. 项目搭建和准备
   1. 项目搭建

![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1694929696059-ef58c83e-c662-408d-9e57-d40ee2d4498c.png#averageHue=%232f343c&clientId=u4b04694d-9222-4&from=paste&height=166&id=u40aac483&originHeight=249&originWidth=410&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=22442&status=done&style=none&taskId=u20551d03-717c-46a1-ac6c-63ec0bfa245&title=&width=273.3333333333333)

   2. 依赖导入pom.xml
```xml
<dependencies>
    <!-- mybatis依赖 -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.11</version>
    </dependency>

    <!-- MySQL驱动 mybatis底层依赖jdbc驱动实现,本次不需要导入连接池,mybatis自带! -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.25</version>
    </dependency>

    <!--junit5测试-->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.3.1</version>
    </dependency>
</dependencies>
```

   3. 准备实体类
```java
@Data
public class Employee {

    private Integer empId;

    private String empName;

    private Double empSalary;

}
```

3.  准备Mapper接口和MapperXML文件  

MyBatis 框架下，SQL语句编写位置发生改变，从原来的Java类，改成**XML**或者注解定义。推荐在XML文件中编写SQL语句，让用户能更专注于 SQL 代码，不用关注其他的JDBC代码。<br />一般编写SQL语句的文件命名：XxxMapper.xml  Xxx一般取表名。Mybatis 中的 Mapper 接口相当于以前的 Dao。但是区别在于，Mapper 仅仅只是建接口即可，我们不需要提供实现类，具体的SQL写到对应的Mapper文件，该用法的思路如下图所示：<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1694929879637-2b33eb2f-bc45-49e1-b93c-7f3d7529243e.png#averageHue=%23000000&clientId=u4b04694d-9222-4&from=paste&id=u4cf2e82e&originHeight=468&originWidth=1010&originalType=url&ratio=1.5&rotation=0&showTitle=false&status=done&style=none&taskId=u765fbb04-1911-4305-b6ca-bf2fe9ec4ae&title=)

   1. 定义 mapper 接口
```java
/**
 * 规定数据库方法
 */
public interface EmployeeMapper {

    // 根据id查询员工信息
    Employee queryById(Integer id);

    // 根据id删除员工
    int deleteById(Integer id);
}
```

   2.  定义mapper.xml（resources/mappers/EmployeeMapper.xml）
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--xml方式写sql语句-->
<!-- namespace等于mapper接口类的全限定名,这样实现对应 -->
<mapper namespace="com.hut.mapper.EmployeeMapper">

    <!-- 查询使用 select标签
            id = 方法名
            resultType = 返回值类型
            标签内编写SQL语句
        注意：mapper接口不能重载
     -->
    <select id="queryById" resultType="com.hut.pojo.Employee">
        <!-- #{empId}代表动态传入的参数,并且进行赋值!后面详细讲解 -->
        select emp_id empId,emp_name empName, emp_salary empSalary from
        t_emp where emp_id = #{id}
    </select>

    <delete id="deleteById">
        delete from t_emp where emp_id = #{id}
    </delete>
</mapper>
```
	**注意：**

   - 方法名和SQL的id一致
   - 方法返回值和resultType一致
   - 方法的参数和SQL的参数一致
   - 接口的全类名和映射配置文件的名称空间一致

4.  准备MyBatis配置文件

 mybatis框架配置文件： 数据库连接信息，性能配置，mapper.xml配置等
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <!-- environments表示配置Mybatis的开发环境，可以配置多个环境，在众多具体环境中，使用default属性指定实际运行时使用的环境。default属性的取值是environment标签的id属性的值。 -->
    <environments default="development">
        <!-- environment表示配置Mybatis的一个具体的环境 -->
        <environment id="development">
            <!-- Mybatis的内置的事务管理器 -->
            <transactionManager type="JDBC"/>
            <!-- 配置数据源 -->
            <dataSource type="POOLED">
                <!-- 建立数据库连接的具体信息 -->
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis-example"/>
                <property name="username" value="root"/>
                <property name="password" value="root"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <!-- Mapper注册：指定Mybatis映射文件的具体位置 -->
        <!-- mapper标签：配置一个具体的Mapper映射文件 -->
        <!-- resource属性：指定Mapper映射文件的实际存储位置，这里需要使用一个以类路径根目录为基准的相对路径 -->
        <!--    对Maven工程的目录结构来说，resources目录下的内容会直接放入类路径，所以这里我们可以以resources目录为基准 -->
        <mapper resource="mappers/EmployeeMapper.xml"/>
    </mappers>

</configuration>
```

5.  运行和测试
```java
public class MyBatisTest {

    /**
     * 通过mybatis提供的api进行方法调用
     */
    @Test
    public void test_01() throws IOException {
        // 1. 读取外部配置文件（mybatis-config.xml）
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        // 2. 创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        // 3. 根据sqlSessionFactory创建sqlSession（每次业务创建一个，用完就释放）
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4. 获取接口代理对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.queryById(1);
        System.out.println("employee = " + employee);

        // 5. 提交事务（非DQL）和释放资源
        sqlSession.commit();
        sqlSession.close();

    }
}
```
说明：

- SqlSession：代表Java程序和数据库之间的会话。（HttpSession是Java程序和浏览器之间的会话）
- SqlSessionFactory：是“生产”SqlSession的“工厂”。
- 工厂模式：如果创建某一个对象，使用的过程基本固定，那么我们就可以把创建这个对象的相关代码封装到一个“工厂类”中，以后都使用这个工厂类来“生产”我们需要的对象。

6.  SqlSession和HttpSession区别
- HttpSession：工作在Web服务器上，属于表述层。 
   - 代表浏览器和Web服务器之间的会话
- SqlSession：不依赖Web服务器，属于持久化层。 
   - 代表Java程序和数据库之间的会话

![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1694931597794-c081d8c5-e61f-4f2d-a503-53a04008941f.png#averageHue=%23f7f7f7&clientId=u4b04694d-9222-4&from=paste&height=297&id=ufd724c7c&originHeight=446&originWidth=1001&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=62696&status=done&style=none&taskId=u963340c1-daa2-457c-9714-11384ea6d00&title=&width=667.3333333333334)
