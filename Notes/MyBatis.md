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

# 2 MyBatis 基本使用
## 2.1 向SQL语句传参
### 2.1.1 MyBatis 日志输出配置
mybatis配置文件设计标签和顶层结构如下：

- configuration（配置） 
   - [properties（属性）](https://mybatis.org/mybatis-3/zh/configuration.html#properties)
   - [settings（设置）](https://mybatis.org/mybatis-3/zh/configuration.html#settings)
   - [typeAliases（类型别名）](https://mybatis.org/mybatis-3/zh/configuration.html#typeAliases)
   - [typeHandlers（类型处理器）](https://mybatis.org/mybatis-3/zh/configuration.html#typeHandlers)
   - [objectFactory（对象工厂）](https://mybatis.org/mybatis-3/zh/configuration.html#objectFactory)
   - [plugins（插件）](https://mybatis.org/mybatis-3/zh/configuration.html#plugins)
   - [environments（环境配置）](https://mybatis.org/mybatis-3/zh/configuration.html#environments) 
      - environment（环境变量） 
         - transactionManager（事务管理器）
         - dataSource（数据源）
   - [databaseIdProvider（数据库厂商标识）](https://mybatis.org/mybatis-3/zh/configuration.html#databaseIdProvider)
   - [mappers（映射器）](https://mybatis.org/mybatis-3/zh/configuration.html#mappers)

我们可以在mybatis的配置文件使用**settings标签**设置，输出运行过程SQL日志<br />通过查看日志，我们可以判定#{} 和 ${}的输出效果<br />settings设置项：

|  logImpl   |  指定 MyBatis 所用日志的具体实现，未指定时将自动查找。   |  J2 &#124; JDK_LOGGING &#124; COMMONS_LOGGING &#124; STDOUT_LOGGING &#124; NO_LOGGING   |
| --- | --- | --- |

日志配置
```xml
<settings>
    <!-- 开启mybatis的日志输出，选择system进行控制台输出 -->
    <setting name="logImpl" value="STDOUT_LOGGING"/>
</settings>
```

### 2.1.2 #{ key } 形式
 MyBatis会将SQL语句中的`#{}`转换为问号占位符<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1695090813421-1ad44512-83a7-4b01-9de5-152bfce0392a.png#averageHue=%23222428&clientId=u93ee01d8-773d-4&from=paste&height=193&id=u1c25a689&originHeight=289&originWidth=1614&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=52295&status=done&style=none&taskId=u2abbecac-2c22-438c-9a11-750dc61b278&title=&width=1076)

### 2.1.3 ${ key } 形式
`${}`形式传参，底层Mybatis做的是字符串拼接操作。<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1695091036797-e155d469-b1ff-4d53-9084-3fffb2709acc.png#averageHue=%23222428&clientId=u93ee01d8-773d-4&from=paste&height=192&id=uec2b5df2&originHeight=288&originWidth=1486&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=49719&status=done&style=none&taskId=ufbf4032d-60b1-4142-87f8-54d713ce79d&title=&width=990.6666666666666)<br />通常不会采用`${}`的方式传值。一个特定的适用场景是：通过Java程序动态生成数据库表，表名部分需要Java程序通过参数传入；而JDBC对于表名部分是不能使用问号占位符的，此时只能使用`${}`<br />结论：实际开发中，能用`#{}`实现的，肯定不用`${}`。<br />特殊情况： 动态的不是值，是列名或者关键字，需要使用`${}`拼接
```java
//注解方式传入参数！！
@Select("select * from user where ${column} = #{value}")
User findByColumn(@Param("column") String column, 
                                @Param("value") String value);
```

## 2.2 数据输入
### 2.2.1 MyBatis总体机制概括
![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1695283705773-04ee2181-b794-4996-bc96-915c56e119fe.png#averageHue=%23000000&clientId=u9a16ea63-f739-4&from=paste&height=256&id=u8d58135d&originHeight=341&originWidth=1208&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=ub614452a-b639-4497-8fe5-aac283594ed&title=&width=906)

### 2.2.2 概念说明
这里数据输入具体是指上层方法（例如Service方法）调用Mapper接口时，数据传入的形式。

- 简单类型：只包含一个值的数据类型 
   - 基本数据类型：int、byte、short、double、……
   - 基本数据类型的包装类型：Integer、Character、Double、……
   - 字符串类型：String
- 复杂类型：包含多个值的数据类型 
   - 实体类类型：Employee、Department、……
   - 集合类型：List、Set、Map、……
   - 数组类型：int[]、String[]、……
   - 复合类型：List、实体类中包含集合……

### 2.2.3 单个简单类型参数
Mapper 接口中抽象方法的声明
```java
// 根据id删除员工信息
int deleteById(Integer id);

// 根据工资查询员工信息
List<Employee> queryBySalary(Double salary);
```

SQL语句
```xml
<!--
    1. 传入的单个简单类型 key随便写
-->
<delete id="deleteById">
    delete from t_emp where emp_id = #{id}
</delete>

<select id="queryBySalary" resultType="com.hut.pojo.Employee">
    select emp_id empId, emp_name empName, emp_salary empSalary
        from t_emp where emp_salary = #{salary}
</select>
```

 单个简单类型参数，在`#{}`中可以随意命名，但是没有必要。通常还是使用和接口方法参数同名。

### 2.2.4 实体类型参数
Mapper接口中抽象方法的声明  
```java
// 插入员工数据【实体对象】
int insertEmp(Employee employee);
```

SQL语句
```xml
<!--
    2. 传入实体对象 key = 属性名
-->
<insert id="insertEmp">
    insert into t_emp (emp_name, emp_salary) values (#{empName}, #{empSalary});
</insert>
```

对应关系如下：<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1695284163334-6ec0b09b-ee1f-4207-93f0-a242395dd7f6.png#averageHue=%23000000&clientId=u9a16ea63-f739-4&from=paste&height=469&id=u17406c84&originHeight=625&originWidth=1240&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=ued2d6792-e7c0-44a9-8481-43d3067d9a0&title=&width=930)<br />结论：Mybatis会根据`#{}`中传入的数据，加工成`getXxx()`方法，通过反射在实体类对象中调用这个方法，从而获取到对应的数据。填充到#{}解析后的问号占位符这个位置。

### 2.2.5 零散的简单类型数据
 零散的多个简单类型参数，如果没有特殊处理，那么Mybatis无法识别自定义名称：  <br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1695284362007-9e783991-6c8f-40a8-a40d-36a2a82b66b1.png#averageHue=%23ede0cb&clientId=u9a16ea63-f739-4&from=paste&id=u56909c50&originHeight=233&originWidth=696&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u9b495564-1ce8-4da3-bfa1-e0b39c9f9b5&title=)

Mapper接口中抽象方法的声明 
```java
// 根据员工姓名和工资查询员工信息
List<Employee> queryByNameAndSalary(@Param("name") String name, @Param("salary") Double salary);
```

SQL语句
```xml
<!--
  3. 传入多个简单类型数据 key
   a. key = @Param("value")
   b. arg0 arg1，参数从左到右依次
-->
<select id="queryByNameAndSalary" resultType="com.hut.pojo.Employee">
  select emp_id empId, emp_name empName, emp_salary empSalary
      from t_emp where emp_name = #{name} and emp_salary = #{salary}
</select>
```

对应关系如下：<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1695284433459-fd0c187f-4b20-471d-aa56-b4215bcc8bcd.png#averageHue=%23000000&clientId=u9a16ea63-f739-4&from=paste&height=236&id=uea9b052c&originHeight=315&originWidth=1430&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=ub61de3f1-c8bd-45eb-90fc-8e857eed720&title=&width=1073)

### 2.2.6 Map类型参数
Mapper接口中抽象方法的声明 
```java
// 插入员工数据【map(name, salary)】
// 注意：mapper接口中不允许重载
int insertEmpMap(Map data);
```

SQL语句
```xml
<!--
    4. 传入Map类型的数据 key = map的key
-->
<insert id="insertEmpMap">
    insert into t_emp (emp_name, emp_salary) values (#{name}, #{salary});
</insert>
```

### 2.2.7 方法测试
```java
public class InputParamTest {

    private SqlSession session;

    private EmployeeMapper mapper;

    // junit5会在每一个@Test方法前执行@BeforeEach方法
    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        mapper = session.getMapper(EmployeeMapper.class);
    }

    @Test
    public void testDeleteById() {
        int row = mapper.deleteById(1);
        if (row == 1) {
            System.out.println("删除成功！");
        }
    }

    @Test
    public void testQueryBySalary() {
        List<Employee> employees = mapper.queryBySalary(777.77);
        System.out.println("employees = " + employees);
    }

    @Test
    public void testInsertEmp() {
        Employee employee = new Employee();
        employee.setEmpSalary(888.88);
        employee.setEmpName("余鸿翔");
        int row = mapper.insertEmp(employee);
        if (row == 1) {
            System.out.println("插入成功！");
        }
    }

    @Test
    public void testQueryByNameAndSalary() {
        List<Employee> employees = mapper.queryByNameAndSalary("余鸿翔", 888.88);
        System.out.println("employees = " + employees);
    }

    @Test
    public void testInsertEmpMap() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("salary", 999.99);
        paramMap.put("name","Nate");
        int row = mapper.insertEmpMap(paramMap);
        if (row == 1) {
            System.out.println("插入成功！");
        }
    }

    // junit5会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }
}
```

## 2.3 数据输出
### 2.3.1 输出概述
数据输出总体上有两种形式：

- 增删改操作返回的受影响行数：直接使用 int 或 long 类型接收即可
- 查询操作的查询结果

### 2.3.2 单个简单类型
Mapper接口中的抽象方法
```java
// 根据员工id查询员工姓名
String queryNameById(Integer id);

// 根据员工id查询员工工资
Double querySalaryById(Integer id);
```

SQL语句
```xml
<!--
    1. 返回单个简单类型
        resultType语法：
            类的全限定符
            别名简称
-->
<select id="queryNameById" resultType="string">
    select emp_name from t_emp where emp_id = #{id}
</select>

<select id="querySalaryById" resultType="double">
    select emp_salary from t_emp where emp_id = #{id}
</select>
```

单元测试
```java
@Test
public void testQueryNameById() {
    String name = mapper.queryNameById(2);
    System.out.println("name = " + name);
}

@Test
public void testQuerySalaryById() {
    Double salary = mapper.querySalaryById(3);
    System.out.println("salary = " + salary);
}
```
Mybatis 内部给常用的数据类型设定了很多别名。 以 int 类型为例，可以写的名称有：int、integer、Integer、java.lang.Integer、Int、INT、INTEGER 等等<br /> select标签，通过resultType指定查询返回值类型 。resultType = "全限定符 ｜ 别名 ｜ 如果是返回集合类型，写范型类型即可"

别名问题：[https://mybatis.org/mybatis-3/zh/configuration.html#typeAliases](https://mybatis.org/mybatis-3/zh/configuration.html#typeAliases)<br />类型别名可为 Java 类型设置一个缩写名字。 它仅用于 XML 配置，意在降低冗余的全限定类名书写。例如：
```xml
<typeAliases>
  <typeAlias alias="Author" type="domain.blog.Author"/>
  <typeAlias alias="Blog" type="domain.blog.Blog"/>
</typeAliases>
```
当这样配置时，`Blog` 可以用在任何使用 `domain.blog.Blog` 的地方。

也可以指定一个包名，MyBatis 会在包名下面搜索需要的 Java Bean，比如：
```xml
<typeAliases> <package name="domain.blog"/> </typeAliases>
```
每一个在包 `domain.blog` 中的 Java Bean，在没有注解的情况下，会使用 Bean 的首字母小写的非限定类名来作为它的别名。 比如 `domain.blog.Author` 的别名为 `author`；若有注解，则别名为其注解值。见下面的例子：
```java
@Alias("author")
public class Author {
    ...
}
```

下面是Mybatis为常见的 Java 类型内建的类型别名。它们都是不区分大小写的，注意，为了应对原始类型的命名重复，采取了特殊的命名风格。  

| 别名 | 映射的类型 |
| --- | --- |
| _byte | byte |
| _char (since 3.5.10) | char |
| _character (since 3.5.10) | char |
| _long | long |
| _short | short |
| _int | int |
| _integer | int |
| _double | double |
| _float | float |
| _boolean | boolean |
| string | String |
| byte | Byte |
| char (since 3.5.10) | Character |
| character (since 3.5.10) | Character |
| long | Long |
| short | Short |
| int | Integer |
| integer | Integer |
| double | Double |
| float | Float |
| boolean | Boolean |
| date | Date |
| decimal | BigDecimal |
| bigdecimal | BigDecimal |
| biginteger | BigInteger |
| object | Object |
| object[] | Object[] |
| map | Map |
| hashmap | HashMap |
| list | List |
| arraylist | ArrayList |
| collection | Collection |


### 2.3.3 返回实体类对象
Mapper接口的抽象方法
```java
// 返回单个自定义实体类型
Employee queryById(Integer id);
```

SQL语句
```xml
<!--
    2. 返回单个自定义实体类型
-->
<select id="queryById" resultType="employee">
    select * from t_emp where emp_id = #{id}
</select>
```

 在 Mybatis 全局配置文件中，做了下面的配置，select语句中可以不给字段设置别名，开启驼峰式自动映射（mybatis-config.xml）
```xml
<settings>

  <!-- 开启驼峰式自动映射 -->
  <setting name="mapUnderscoreToCamelCase" value="true"/>

</settings>
```

单元测试
```java
@Test
public void testQueryById() {
    Employee employee = mapper.queryById(5);
    System.out.println("employee = " + employee);
}
```

### 2.3.4 返回Map类型
适用于SQL查询返回的各个字段综合起来并不和任何一个现有的实体类对应，没法封装到实体类对象中。能够封装成实体类类型的，就不使用Map类型。<br />Mapper接口的抽象方法
```java
// 查询部门的最高工资与平均工资
Map<String,Object> selectEmpNameAndMaxSalary();
```

SQL语句
```xml
<!--
    3. 返回map(没有实体类可以接值)
-->
<select id="selectEmpNameAndMaxSalary" resultType="map">
    SELECT
        emp_name 员工姓名,
        emp_salary 员工工资,
        (SELECT AVG(emp_salary) FROM t_emp) 部门平均工资
        FROM t_emp WHERE emp_salary=(
        SELECT MAX(emp_salary) FROM t_emp
        )
</select>
```

单元测试
```java
@Test
public void testSelectEmpNameAndMaxSalary() {
    Map<String, Object> empMap = mapper.selectEmpNameAndMaxSalary();
    /*Set<Map.Entry<String, Object>> entrySet = empMap.entrySet();
    for (Map.Entry<String, Object> entry : entrySet) {
        String key = entry.getKey();
        Object value = entry.getValue();
        System.out.println("value = " + value);
    }*/
    System.out.println("empMap = " + empMap);
}
```

### 2.3.5 返回List类型
查询结果返回多个实体类对象，希望把多个实体类对象放在List集合中返回。此时不需要任何特殊处理，在resultType属性中还是设置实体类类型即可。

Mapper接口中抽象方法
```java
// 查询工资高于传入值的员工们的姓名
List<String> queryNamesBySalary(Double salary);

// 查询全部员工信息
List<Employee> queryAll();
```

SQL语句
```xml
<!--
  4. 返回集合类型
  	resultType需要指定泛型而不是集合类型
-->
<select id="queryNamesBySalary" resultType="string">
  select emp_name from t_emp where emp_salary > #{salary}
</select>

<select id="queryAll" resultType="employee">
  select * from t_emp
</select>
```

单元测试
```java
@Test
public void testQueryNamesBySalary() {
    List<String> names = mapper.queryNamesBySalary(888.0);
    System.out.println("names = " + names);
}

@Test
public void testQueryAll() {
    List<Employee> employees = mapper.queryAll();
    System.out.println("employees = " + employees);
}
```

### 2.3.6 返回主键值

1. 自增长类型主键

Mapper接口中的抽象方法
```java
// 插入员工
int insertEmp(Employee employee);
```

SQL语句
```xml
<!--
    5. 主键回显，获取插入数据的主键
        1. 自增长主键回显
            useGeneratedKeys="true": 表示想要数据库自动增长的主键值
            keyColumn: 指定主键字段名
            keyProperty: 接收主键列值的属性
        2. 非自增长主键回显
-->
<insert id="insertEmp" useGeneratedKeys="true" keyColumn="emp_id" keyProperty="empId">
    insert into t_emp(emp_name,emp_salary)
        values(#{empName},#{empSalary})
</insert>
```

单元测试
```java
@Test
public void test_01() throws IOException {
    // 1. 读取外部配置文件（mybatis-config.xml）
    InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
    
    // 2. 创建sqlSessionFactory
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);
    
    // 3. 根据sqlSessionFactory创建sqlSession（每次业务创建一个，用完就释放）
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    // 4. 获取代理对象
    EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
    
    Employee employee = new Employee();
    employee.setEmpName("abin");
    employee.setEmpSalary(1000.0);
    
    int rows = mapper.insertEmp(employee);
    System.out.println(employee.getEmpId());
    System.out.println("rows = " + rows);
    
    // 5. 释放资源 和 提交事务
    sqlSession.commit();
    sqlSession.close();
}
```
注意：Mybatis是将自增主键的值设置到实体类对象中，而不是以Mapper接口方法返回值的形式返回。

2. 非自增长类型主键

而对于不支持自增型主键的数据库（例如 Oracle）或者字符串类型主键，则可以使用`selectKey`子元素：selectKey 元素将会首先运行，id 会被设置，然后插入语句会被调用。使用 selectKey 帮助插入UUID作为字符串类型主键示例：
```xml
<insert id="insertTeacher">
    <!-- 插入之前，先执行一段sql语句，生成一个主键值
        order="BEFORE" 表示在插入之前执行
        order="AFTER" 表示在插入之后执行
        resultType="int" 表示返回值类型
        keyProperty="tId" 表示返回值赋值给tId
    -->
    <selectKey keyProperty="tId" resultType="string" order="BEFORE">
        select replace(uuid(),'-','')
    </selectKey>
    insert into teacher(t_id, t_name)
    value(#{tId}, #{tName})
</insert>
```
在上例中，我们定义了一个 `insertTeacher`的插入语句来将 `Teacher`对象插入到 `teacher`表中。我们使用 `selectKey`来查询 UUID 并设置到 `tId`字段中。<br />通过 `keyProperty`属性来指定查询到的 UUID 赋值给对象中的`tId`属性，而 `resultType`属性指定了 UUID 的类型为 `java.lang.String`。<br />需要注意的是，我们将`selectKey`放在了插入语句的前面，这是因为 MySQL 在 `insert`语句中只支持一个 `select`子句，而 `selectKey`中查询 UUID 的语句就是一个 `select`子句，因此我们需要将其放在前面。<br />最后，在将`Teacher`对象插入到`teacher`表中时，我们直接使用对象中的`tId`属性来插入主键值。<br />使用这种方式，我们可以方便地插入 UUID 作为字符串类型主键。当然，还有其他插入方式可以使用，如使用Java代码生成UUID并在类中显式设置值等。需要根据具体应用场景和需求选择合适的插入方式。

### 2.3.7 实体类属性和数据库字段对应关系
使用resultMap<br />使用resultMap标签定义对应关系，再在后面的SQL语句中引用这个对应关系 
```xml
<!--开启自定义映射
  <id 主键映射关系
  <result 普通映射关系
-->
<resultMap id="tMpa" type="teacher">
  <id property="tId" column="t_id"/>
  <result property="tName" column="t_name"/>
</resultMap>
<select id="selectTeacher" resultMap="tMap">
  select * from teacher where t_id = #{tId}
</select>
```

## 2.4 mapperXML标签总结
SQL 映射文件只有很少的几个顶级元素（按照应被定义的顺序列出）：

- `insert` – 映射插入语句。
- `update` – 映射更新语句。
- `delete` – 映射删除语句。
- `select` – 映射查询语句。

**select标签：**<br />MyBatis 在查询和结果映射做了相当多的改进。一个简单查询的 select 元素是非常简单：
```xml
<select id="selectPerson" resultType="hashmap" resultMap="自定义结构"> 
  SELECT * FROM PERSON WHERE ID = #{id} 
</select>
```
这个语句名为 selectPerson，接受一个 int（或 Integer）类型的参数，并返回一个 HashMap 类型的对象，其中的键是列名，值便是结果行中的对应值。<br />注意参数符号：#{id}  ${key}

MyBatis 创建一个预处理语句（PreparedStatement）参数，在 JDBC 中，这样的一个参数在 SQL 中会由一个“?”来标识，并被传递到一个新的预处理语句中，就像这样：
```java
// 近似的 JDBC 代码，非 MyBatis 代码...
String selectPerson = "SELECT * FROM PERSON WHERE ID=?";
PreparedStatement ps = conn.prepareStatement(selectPerson);
ps.setInt(1,id);
```

select 元素允许你配置很多属性来配置每条语句的行为细节：

| 属性 | 描述 |
| --- | --- |
| `id` | 在命名空间中唯一的标识符，可以被用来引用这条语句。 |
| `resultType` | 期望从这条语句中返回结果的类全限定名或别名。 注意，如果返回的是集合，那应该设置为集合包含的类型，而不是集合本身的类型。 resultType 和 resultMap 之间只能同时使用一个。 |
| `resultMap` | 对外部 resultMap 的命名引用。结果映射是 MyBatis 最强大的特性，如果你对其理解透彻，许多复杂的映射问题都能迎刃而解。 resultType 和 resultMap 之间只能同时使用一个。 |
| `timeout` | 这个设置是在抛出异常之前，驱动程序等待数据库返回请求结果的秒数。默认值为未设置（unset）（依赖数据库驱动）。 |
| `statementType` | 可选 STATEMENT，PREPARED 或 CALLABLE。这会让 MyBatis 分别使用 Statement，PreparedStatement 或 CallableStatement，默认值：PREPARED。 |


**insert, update 和 delete标签：**<br />数据变更语句 insert，update 和 delete 的实现非常接近：
```xml
<insert
  id="insertAuthor"
  statementType="PREPARED"
  keyProperty=""
  keyColumn=""
  useGeneratedKeys=""
  timeout="20">

<update
  id="updateAuthor"
  statementType="PREPARED"
  timeout="20">

<delete
  id="deleteAuthor"
  statementType="PREPARED"
  timeout="20">
```
| 属性 | 描述 |
| --- | --- |
| `id` | 在命名空间中唯一的标识符，可以被用来引用这条语句。 |
| `timeout` | 这个设置是在抛出异常之前，驱动程序等待数据库返回请求结果的秒数。默认值为未设置（unset）（依赖数据库驱动）。 |
| `statementType` | 可选 STATEMENT，PREPARED 或 CALLABLE。这会让 MyBatis 分别使用 Statement，PreparedStatement 或 CallableStatement，默认值：PREPARED。 |
| `useGeneratedKeys` | （仅适用于 insert 和 update）这会令 MyBatis 使用 JDBC 的 getGeneratedKeys 方法来取出由数据库内部生成的主键（比如：像 MySQL 和 SQL Server 这样的关系型数据库管理系统的自动递增字段），默认值：false。 |
| `keyProperty` | （仅适用于 insert 和 update）指定能够唯一识别对象的属性，MyBatis 会使用 getGeneratedKeys 的返回值或 insert 语句的 selectKey 子元素设置它的值，默认值：未设置（`unset`<br />）。如果生成列不止一个，可以用逗号分隔多个属性名称。 |
| `keyColumn` | （仅适用于 insert 和 update）设置生成键值在表中的列名，在某些数据库（像 PostgreSQL）中，当主键列不是表中的第一列的时候，是必须设置的。如果生成列不止一个，可以用逗号分隔多个属性名称。 |


# 3 MyBatis 多表映射
## 3.1 多表映射概念
学习目标：

- 多表查询语句使用
- 多表结果承接实体类设计
- 使用ResultMap完成多表结果映射

**实体类设计方案**<br />多表关系回顾：（双向查看）

-  一对一<br />夫妻关系，人和身份证号 
-  一对多| 多对一<br />用户和用户的订单，锁和钥匙 
-  多对多<br />老师和学生，部门和员工 

实体类设计关系(查询)：（单向查看）

-  对一 ： 夫妻一方对应另一方，订单对应用户都是对一关系<br />实体类设计：对一关系下，类中只要包含单个对方对象类型属性即可<br />例如： 
```java
public class Customer {

  private Integer customerId;
  private String customerName;

}

public class Order {

  private Integer orderId;
  private String orderName;
  private Customer customer;// 体现的是对一的关系

}
```

-  对多：用户对应的订单，讲师对应的学生或者学生对应的讲师都是对多关系：<br />实体类设计：对多关系下，类中只要包含对方类型集合属性即可
```java
public class Customer {

  private Integer customerId;
  private String customerName;
  private List<Order> orderList;// 体现的是对多的关系
}

public class Order {

  private Integer orderId;
  private String orderName;
  private Customer customer;// 体现的是对一的关系
  
}
```

多表结果实体类设计小技巧：<br />对一，属性中包含对方对象<br />对多，属性中包含对方对象集合<br />只有真实发生多表查询时，才需要设计和修改实体类，否则不提前设计和修改实体类<br />无论多少张表联查，实体类设计都是两两考虑<br />在查询映射的时候，只需要关注本次查询相关的属性。例如：查询订单和对应的客户，就不要关注客户中的订单集合

**多表映射案例**<br />数据库：
```sql
CREATE TABLE `t_customer` (`customer_id` INT NOT NULL AUTO_INCREMENT, `customer_name` CHAR(100), PRIMARY KEY (`customer_id`) );

CREATE TABLE `t_order` ( `order_id` INT NOT NULL AUTO_INCREMENT, `order_name` CHAR(100), `customer_id` INT, PRIMARY KEY (`order_id`) ); 

INSERT INTO `t_customer` (`customer_name`) VALUES ('c01');

INSERT INTO `t_order` (`order_name`, `customer_id`) VALUES ('o1', '1');
INSERT INTO `t_order` (`order_name`, `customer_id`) VALUES ('o2', '1');
INSERT INTO `t_order` (`order_name`, `customer_id`) VALUES ('o3', '1'); 
```

实体类设计：
```java
@Data
public class Customer {
  private Integer customerId;
  private String customerName;
  private List<Order> orderList;// 体现的是对多的关系
  
}  

@Data
public class Order {
  private Integer orderId;
  private String orderName;
  private Customer customer;// 体现的是对一的关系
  
}
```

## 3.2 对一映射

1. 需求说明：根据ID查询订单，以及订单关联的用户的信息  
2.  OrderMapper接口  
```java
public interface OrderMapper {
    // 根据id查询订单信息和订单对应的客户
    Order queryOrderById(Integer id);
}
```

3.  OrderMapper.xml配置文件 
```xml
<!-- namespace为接口的全限定符 -->
<mapper namespace="com.hut.mapper.OrderMapper">
    <!--自定义嵌套对象的映射关系-->
    <resultMap id="orderMap" type="order">
        <!--order的主键，id标签-->
        <id column="order_id" property="orderId"/>
        <!--普通列-->
        <result column="order_name" property="orderName"/>
        <result column="customer_id" property="customerId"/>

        <!--对象属性赋值
            property 对象属性名
            javaType 对象属性类型
        -->
        <association property="customer" javaType="customer">
            <id column="customer_id" property="customerId"/>
            <result column="customer_name" property="customerName"/>
        </association>
    </resultMap>
    
    <!--根据id查询订单和订单关联的客户信息-->
    <select id="queryOrderById" resultMap="orderMap">
        select * from t_order tor JOIN t_customer tur
        on tor.customer_id = tur.customer_id
        where tor.order_id = #{id}
    </select>

</mapper>
```

4.  Mybatis全局注册Mapper文件
```xml
<mappers>
        <!-- Mapper注册：指定Mybatis映射文件的具体位置 -->
        <!-- mapper标签：配置一个具体的Mapper映射文件 -->
        <!-- resource属性：指定Mapper映射文件的实际存储位置，这里需要使用一个以类路径根目录为基准的相对路径 -->
        <!--    对Maven工程的目录结构来说，resources目录下的内容会直接放入类路径，所以这里我们可以以resources目录为基准 -->
        <mapper resource="mappers/OrderMapper.xml"/>
    </mappers>
```

5.  junit测试程序  
```java
public class MybatisTest {

    private SqlSession session;

    // junit5会在每一个@Test方法前执行@BeforeEach方法
    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml")).openSession(true);
        
    }

    // junit5会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.close();
    }

    @Test
    public void testToOne() {
        // 查询订单和对应的客户
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderById(1);
        System.out.println("order = " + order);
        System.out.println("order.getCustomer() = " + order.getCustomer());
    }
}

```

6.  关键词<br />在“对一”关联关系中，我们的配置比较多，但是关键词就只有：`association`和`javaType `
7. <br />
## 3.3 对多映射

1. 需求说明： 查询客户和客户关联的订单信息 
2.  CustomerMapper接口 
```java
public interface CustomerMapper {

    // 查询所有客户信息以及客户对应的订单信息
    List<Customer> queryList();
}
```

3.  CustomerMapper.xml文件  
```xml
<!-- namespace为接口的全限定符 -->
<mapper namespace="com.hut.mapper.CustomerMapper">

    <resultMap id="customerMap" type="customer">
        <id property="customerId" column="customer_id"/>
<!--        <result property="customerName" column="customer_name"/>-->
        <!--给集合属性赋值-->
        <collection property="orderList" ofType="order">
            <id property="orderId" column="order_id"/>
<!--            <result property="orderName" column="order_name"/>-->
<!--            <result property="customerId" column="customer_id"/>-->
        </collection>
    </resultMap>

    <select id="queryList" resultMap="customerMap">
        select * from t_order tor JOIN t_customer tur
        on tor.customer_id = tur.customer_id
    </select>
</mapper>
```

4.  Mybatis全局注册Mapper文件  
```xml
<mappers>
        <!-- Mapper注册：指定Mybatis映射文件的具体位置 -->
        <!-- mapper标签：配置一个具体的Mapper映射文件 -->
        <!-- resource属性：指定Mapper映射文件的实际存储位置，这里需要使用一个以类路径根目录为基准的相对路径 -->
        <!--    对Maven工程的目录结构来说，resources目录下的内容会直接放入类路径，所以这里我们可以以resources目录为基准 -->
        <mapper resource="mappers/OrderMapper.xml"/>
        <mapper resource="mappers/CustomerMapper.xml"/>
    </mappers>
```

5.  junit测试程序  
```java
public class MybatisTest {

    private SqlSession session;

    // junit5会在每一个@Test方法前执行@BeforeEach方法
    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml")).openSession(true);
        
    }

    // junit5会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.close();
    }

    @Test
    public void testToMany() {
        // 查询所有客户信息以及客户对应的订单信息
        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        List<Customer> customers = customerMapper.queryList();
        System.out.println("customers = " + customers);
        for (Customer customer : customers) {
            List<Order> orderList = customer.getOrderList();
            System.out.println("orderList = " + orderList);
        }

    }
}
```

6.  关键词<br />在“对多”关联关系中，同样有很多配置，但是提炼出来最关键的就是：`collection`和`ofType` 

## 3.4 多表映射总结
### 3.4.1 多表映射优化
| setting属性 | 属性含义 | 可选值 | 默认值 |
| --- | --- | --- | --- |
| autoMappingBehavior | 指定 MyBatis 应如何自动映射列到字段或属性。 NONE 表示关闭自动映射；PARTIAL 只会自动映射没有定义嵌套结果映射的字段。 FULL 会自动映射任何复杂的结果集（无论是否嵌套）。 | NONE, PARTIAL, FULL | PARTIAL |

我们可以将autoMappingBehavior设置为full,进行多表resultMap映射的时候，可以省略符合列和属性命名映射规则（列名=属性名，或者开启驼峰映射也可以自定映射）的result标签<br />修改mybati-sconfig.xml:
```xml
<!--开启resultMap自动映射 -->
<setting name="autoMappingBehavior" value="FULL"/>
```
修改CustomerMapper.xml
```xml
<resultMap id="customerMap" type="customer">
    <id property="customerId" column="customer_id"/>
<!--        <result property="customerName" column="customer_name"/>-->
    <!--给集合属性赋值-->
    <collection property="orderList" ofType="order">
        <id property="orderId" column="order_id"/>
<!--            <result property="orderName" column="order_name"/>-->
<!--            <result property="customerId" column="customer_id"/>-->
    </collection>
</resultMap>
```

### 3.4.2 多表映射总结
| 关联关系 | 配置项关键词 | 所在配置文件和具体位置 |
| --- | --- | --- |
| 对一 | association标签/javaType属性/property属性 | Mapper配置文件中的resultMap标签内 |
| 对多 | collection标签/ofType属性/property属性 | Mapper配置文件中的resultMap标签内 |


# 4 MyBatis 动态语句
## 4.1 动态语句需求与简介
动态 SQL 是 MyBatis 的强大特性之一。如果你使用过 JDBC 或其它类似的框架，你应该能理解根据不同条件拼接 SQL 语句有多痛苦，例如拼接时要确保不能忘记添加必要的空格，还要注意去掉列表最后一个列名的逗号。利用动态 SQL，可以彻底摆脱这种痛苦。<br />使用动态 SQL 并非一件易事，但借助可用于任何 SQL 映射语句中的强大的动态 SQL 语言，MyBatis 显著地提升了这一特性的易用性。<br />如果你之前用过 JSTL 或任何基于类 XML 语言的文本处理器，你对动态 SQL 元素可能会感觉似曾相识。在 MyBatis 之前的版本中，需要花时间了解大量的元素。借助功能强大的基于 OGNL 的表达式，MyBatis 3 替换了之前的大部分元素，大大精简了元素种类，现在要学习的元素种类比原来的一半还要少。

## 4.2 if和where 标签
使用动态 SQL 最常见情景是根据条件包含 where / if 子句的一部分。比如：  
```xml
<!-- List<Employee> selectEmployeeByCondition(Employee employee); -->
<select id="selectEmployeeByCondition" resultType="employee">
    select emp_id,emp_name,emp_salary from t_emp
    <!-- where标签会自动去掉“标签体内前面多余的and/or” -->
    <where>
        <!-- 使用if标签，让我们可以有选择的加入SQL语句的片段。这个SQL语句片段是否要加入整个SQL语句，就看if标签判断的结果是否为true -->
        <!-- 在if标签的test属性中，可以访问实体类的属性，不可以访问数据库表的字段 -->
        <if test="empName != null">
            <!-- 在if标签内部，需要访问接口的参数时还是正常写#{} -->
            or emp_name=#{empName}
        </if>
        <if test="empSalary &gt; 2000">
            or emp_salary>#{empSalary}
        </if>
        <!--
         第一种情况：所有条件都满足 WHERE emp_name=? or emp_salary>?
         第二种情况：部分条件满足 WHERE emp_salary>?
         第三种情况：所有条件都不满足 没有where子句
         -->
    </where>
</select>
```
## 4.3 set 标签
```xml
<!-- void updateEmployeeDynamic(Employee employee) -->
<update id="updateEmployeeDynamic">
    update t_emp
    <!-- set emp_name=#{empName},emp_salary=#{empSalary} -->
    <!-- 使用set标签动态管理set子句，并且动态去掉两端多余的逗号 -->
    <set>
        <if test="empName != null">
            emp_name=#{empName},
        </if>
        <if test="empSalary &lt; 3000">
            emp_salary=#{empSalary},
        </if>
    </set>
    where emp_id=#{empId}
    <!--
         第一种情况：所有条件都满足 SET emp_name=?, emp_salary=?
         第二种情况：部分条件满足 SET emp_salary=?
         第三种情况：所有条件都不满足 update t_emp where emp_id=?
            没有set子句的update语句会导致SQL语法错误
     -->
</update>
```

## 4.4 trim 标签（了解）
使用trim标签控制条件部分两端是否包含某些字符

- prefix属性：指定要动态添加的前缀
- suffix属性：指定要动态添加的后缀
- prefixOverrides属性：指定要动态去掉的前缀，使用“|”分隔有可能的多个值
- suffixOverrides属性：指定要动态去掉的后缀，使用“|”分隔有可能的多个值
```xml
<select id="queryTrim" resultType="employee">
    <include refid="selectAll"/>
    <trim prefix="where" prefixOverrides="and|or">
        <if test="name!=null">
            emp_name = #{name}
        </if>
        <if test="salary!=null and salary &gt; 100">
            and emp_salary = #{salary}
        </if>
    </trim>
</select>

<update id="updateTrim">
    update t_emp
   	<!-- prefix属性指定要动态添加的前缀 -->
    <!-- suffix属性指定要动态添加的后缀 -->
    <!-- prefixOverrides属性指定要动态去掉的前缀，使用“|”分隔有可能的多个值 -->
    <!-- suffixOverrides属性指定要动态去掉的后缀，使用“|”分隔有可能的多个值 -->
    <!-- 当前例子用where标签实现更简洁，但是trim标签更灵活，可以用在任何有需要的地方 -->
    <trim prefix="set" suffixOverrides=",">
        <if test="empName != null">
            emp_name = #{name},
        </if>
        <if test="empSalary != null">
            emp_salary = #{salary}
        </if>
    </trim>
    where emp_id = #{empId}
</update>
```

## 4.5 choose/when/otherwise 标签
在多个分支条件中，仅执行一个。

- 从上到下依次执行条件判断
- 遇到的第一个满足条件的分支会被采纳
- 被采纳分支后面的分支都将不被考虑
- 如果所有的when分支都不满足，那么就执行otherwise分支
```xml
<select id="queryChoose" resultType="employee">
    <include refid="selectAll"/>
    where
    <choose>
        <when test="name!=null">
            emp_name = #{name}
        </when>
        <when test="salary!=null">
            emp_salary = #{salary}
        </when>
        <otherwise>1=1</otherwise>
    </choose>
</select>
```

## 4.6 foreach 标签
**基本用法**<br />用批量插入举例
```xml
<!--
    collection属性：要遍历的集合
    item属性：遍历集合的过程中能得到每一个具体对象，在item属性中设置一个名字，将来通过这个名字引用遍历出来的对象
    separator属性：指定当foreach标签的标签体重复拼接字符串时，各个标签体字符串之间的分隔符
    open属性：指定整个循环把字符串拼好后，字符串整体的前面要添加的字符串
    close属性：指定整个循环把字符串拼好后，字符串整体的后面要添加的字符串
    index属性：这里起一个名字，便于后面引用
        遍历List集合，这里能够得到List集合的索引值
        遍历Map集合，这里能够得到Map集合的key
 -->
<foreach collection="empList" item="emp" separator="," open="values" index="myIndex">
    <!-- 在foreach标签内部如果需要引用遍历得到的具体的一个对象，需要使用item属性声明的名称 -->
    (#{emp.empName},#{myIndex},#{emp.empSalary},#{emp.empGender})
</foreach>
```
**批量更新时需要注意**<br />上面批量插入的例子本质上是一条SQL语句，而实现批量更新则需要多条SQL语句拼起来，用分号分开。也就是一次性发送多条SQL语句让数据库执行。此时需要在数据库连接信息的URL地址中设置：
```xml
<property name="url" value="jdbc:mysql://localhost:3306/mybatis-example?useUnicode=true&amp;characterEncoding=UTF-8&amp;allowMultiQueries=true"/>
```
对应的foreach标签如下：
```xml
<!-- int updateEmployeeBatch(@Param("empList") List<Employee> empList) -->
<update id="updateEmployeeBatch">
    <foreach collection="empList" item="emp" separator=";">
        update t_emp set emp_name=#{emp.empName} where emp_id=#{emp.empId}
    </foreach>
</update>
```

**增删查改举例**
```xml
<select id="queryBatch" resultType="employee">
  <include refid="selectAll"/>
  where emp_id in
  <!-- 遍历的数据
  collection="ids | arg0 | list"
  open 遍历之前要追加的字符串
  close 遍历之后要追加的字符串
  separator 遍历时中间的分隔符，最后一次不会追加
  item 每个遍历项
  -->
  <foreach collection="ids" open="(" separator="," close=")" item="id">
    <!--遍历的内容-->
    #{id}
  </foreach>
</select>

<delete id="deleteBatch">
  delete from t_emp where id in
  <foreach collection="ids" open="(" separator="," close=")" item="id">
    #{id}
  </foreach>
</delete>

<insert id="insertBatch">
  insert into t_emp (emp_name,emp_salary) values
  <foreach collection="list" separator="," item="employee">
    (#{employee.empName},#{employee.empSalary})
  </foreach>
</insert>

<update id="updateBatch">
  <foreach collection="list" item="emp">
    update t_emp set emp_name=#{emp.empName},emp_salary=#{emp.empSalary} where emp_id = #{emp.emp_id}
  </foreach>
</update>
```
**关于foreach标签的collection属性**<br />如果没有给接口中List类型的参数使用@Param注解指定一个具体的名字，那么在collection属性中默认可以使用collection或list来引用这个list集合。这一点可以通过异常信息看出来：
```java
Parameter 'empList' not found. Available parameters are [arg0, collection, list]
```
在实际开发中，为了避免隐晦的表达造成一定的误会，建议使用@Param注解明确声明变量的名称，然后在foreach标签的collection属性中按照@Param注解指定的名称来引用传入的参数。

## 4.7 sql片段
抽取重复的SQL片段
```xml
<sql id="selectAll">
  select * from t_emp
</sql>
```
引用抽取的SQL片段
```xml
<include refid="selectAll"/>
```

# 5 MyBatis 高级扩展
## 5.1 Mapper 批量映射优化

1.  需求<br />Mapper 配置文件很多时，在全局配置文件中一个一个注册太麻烦，希望有一个办法能够一劳永逸。 
2.  配置方式<br />Mybatis 允许在指定 Mapper 映射文件时，只指定其所在的包： 
```xml
<mappers>
    <package name="com.atguigu.mapper"/>
</mappers>
```
此时这个包下的所有 Mapper 配置文件将被自动加载、注册，比较方便。

3. 资源创建要求
- Mapper 接口和 Mapper 配置文件名称一致 
   - Mapper 接口：EmployeeMapper.java
   - Mapper 配置文件：EmployeeMapper.xml
- Mapper 配置文件放在 Mapper 接口所在的包内 
   -  可以将mapperxml文件放在mapper接口所在的包
   -  可以在sources下创建mapper接口包一致的文件夹结构存放mapperxml文件<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697121758867-e7c4eafd-9be6-4956-99b5-652282bc8c30.png#averageHue=%23e8e6e5&clientId=u61f6968c-6c05-4&from=paste&id=u0da07109&originHeight=330&originWidth=523&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u4669c18b-de3c-4d99-b256-69f36510ac6&title=)<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697121768545-d1be9e4f-6ad6-45de-abe1-27a392f1aa4e.png#averageHue=%23eeeceb&clientId=u61f6968c-6c05-4&from=paste&id=udc488bbe&originHeight=391&originWidth=525&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=ud3a151e5-c48d-4027-aa8c-c1fdca70b2d&title=) 

## 5.2 插件和分页插件PageHelper
### 5.2.1 插件机制和PageHelper插件介绍
MyBatis 对插件进行了标准化的设计，并提供了一套可扩展的插件机制。插件可以在用于语句执行过程中进行拦截，并允许通过自定义处理程序来拦截和修改 SQL 语句、映射语句的结果等。<br />具体来说，MyBatis 的插件机制包括以下三个组件：

1. `Interceptor`（拦截器）：定义一个拦截方法 `intercept`，该方法在执行 SQL 语句、执行查询、查询结果的映射时会被调用。
2. `Invocation`（调用）：实际上是对被拦截的方法的封装，封装了 `Object target`、`Method method` 和 `Object[] args` 这三个字段。
3. `InterceptorChain`（拦截器链）：对所有的拦截器进行管理，包括将所有的 Interceptor 链接成一条链，并在执行 SQL 语句时按顺序调用。

插件的开发非常简单，只需要实现 Interceptor 接口，并使用注解 `@Intercepts` 来标注需要拦截的对象和方法，然后在 MyBatis 的配置文件中添加插件即可。<br />PageHelper 是 MyBatis 中比较著名的分页插件，它提供了多种分页方式（例如 MySQL 和 Oracle 分页方式），支持多种数据库，并且使用非常简单。下面就介绍一下 PageHelper 的使用方式。

### 5.2.2 PageHelper插件使用

1. pom.xml引入依赖
```xml
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>5.1.11</version>
</dependency>
```

2.  mybatis-config.xml配置分页插件<br />在 MyBatis 的配置文件中添加 PageHelper 的插件： 
```xml
<!-- 配置分页插件 -->
<plugins>
    <plugin interceptor="com.github.pagehelper.PageInterceptor">
        <!--插件语法对应的数据库类型-->
        <property name="helperDialect" value="mysql"/>
    </plugin>
</plugins>
```
其中，`com.github.pagehelper.PageInterceptor`是 PageHelper 插件的名称，`dialect`属性用于指定数据库类型（支持多种数据库）

3.  页插件使用<br />在查询方法中使用分页： 
```java
@Test
public void test_01() {
    EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
    // 调用之前，先设置分页数据(从第几页开始查，每页显示多少)
    PageHelper.startPage(1,2);

    // TODO: 注意，不能将两条查询装到一个分页区
    List<Employee> employees = mapper.queryAll();

    // 将查询数据封装到一个PageInfo的分页实体类（一共有多少页，一共有多少条）
    PageInfo<Employee> employeePageInfo = new PageInfo<>(employees);
    // pageInfo获取分页的数据
    // 当前页的数据，总页数，总条数，页面数，每页的条数
    List<Employee> list1 = employeePageInfo.getList();
    System.out.println("list1 = " + list1);
    int pages = employeePageInfo.getPages();
    System.out.println("pages = " + pages);
    long total = employeePageInfo.getTotal();
    System.out.println("total = " + total);
    int pageNum = employeePageInfo.getPageNum();
    System.out.println("pageNum = " + pageNum);
    int pageSize = employeePageInfo.getPageSize();
    System.out.println("pageSize = " + pageSize);
}
```

## 5.3 逆向工程和MyBatisX插件
### 5.3.1 ORM思维介绍
ORM（Object-Relational Mapping，对象-关系映射）是一种将数据库和面向对象编程语言中的对象之间进行转换的技术。它将对象和关系数据库的概念进行映射，最后我们就可以通过方法调用进行数据库操作<br />最终：**让我们可以使用面向对象思维进行数据库操作**<br />**ORM 框架通常有半自动和全自动两种方式。**

- 半自动 ORM 通常需要程序员手动编写 SQL 语句或者配置文件，将实体类和数据表进行映射，还需要手动将查询的结果集转换成实体对象。
- 全自动 ORM 则是将实体类和数据表进行自动映射，使用 API 进行数据库操作时，ORM 框架会自动执行 SQL 语句并将查询结果转换成实体对象，程序员无需再手动编写 SQL 语句和转换代码。

**下面是半自动和全自动 ORM 框架的区别：**

1. 映射方式：半自动 ORM 框架需要程序员手动指定实体类和数据表之间的映射关系，通常使用 XML 文件或注解方式来指定；全自动 ORM 框架则可以自动进行实体类和数据表的映射，无需手动干预。
2. 查询方式：半自动 ORM 框架通常需要程序员手动编写 SQL 语句并将查询结果集转换成实体对象；全自动 ORM 框架可以自动组装 SQL 语句、执行查询操作，并将查询结果转换成实体对象。
3. 性能：由于半自动 ORM 框架需要手动编写 SQL 语句，因此程序员必须对 SQL 语句和数据库的底层知识有一定的了解，才能编写高效的 SQL 语句；而全自动 ORM 框架通过自动优化生成的 SQL 语句来提高性能，程序员无需进行优化。
4. 学习成本：半自动 ORM 框架需要程序员手动编写 SQL 语句和映射配置，要求程序员具备较高的数据库和 SQL 知识；全自动 ORM 框架可以自动生成 SQL 语句和映射配置，程序员无需了解过多的数据库和 SQL 知识。

常见的半自动 ORM 框架包括 MyBatis 等；常见的全自动 ORM 框架包括 Hibernate、Spring Data JPA、MyBatis-Plus 等。

### 5.3.2 逆向工程
MyBatis 的逆向工程是一种自动化生成持久层代码和映射文件的工具，它可以根据数据库表结构和设置的参数生成对应的实体类、Mapper.xml 文件、Mapper 接口等代码文件，简化了开发者手动生成的过程。逆向工程使开发者可以快速地构建起 DAO 层，并快速上手进行业务开发。<br />MyBatis 的逆向工程有两种方式：通过 MyBatis Generator 插件实现和通过 Maven 插件实现。无论是哪种方式，逆向工程一般需要指定一些配置参数，例如数据库连接 URL、用户名、密码、要生成的表名、生成的文件路径等等。<br />总的来说，MyBatis 的逆向工程为程序员提供了一种方便快捷的方式，能够快速地生成持久层代码和映射文件，是半自动 ORM 思维像全自动发展的过程，提高程序员的开发效率。<br />**注意：逆向工程只能生成单表crud的操作，多表查询依然需要我们自己编写**

### 5.3.3 逆向工程插件MyBatisX的使用
MyBatisX 是一个 MyBatis 的代码生成插件，可以通过简单的配置和操作快速生成 MyBatis Mapper、pojo 类和 Mapper.xml 文件。下面是使用 MyBatisX 插件实现逆向工程的步骤：

1.  安装插件：<br />在 IntelliJ IDEA 中打开插件市场，搜索 MyBatisX 并安装。 
2.  使用 IntelliJ IDEA连接数据库 
   -  连接数据库<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697122527930-0cdc2fbc-859a-4d21-b4eb-f437a48b9879.png#averageHue=%23f7f6f5&clientId=u61f6968c-6c05-4&from=paste&id=ud0b09357&originHeight=648&originWidth=619&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=udbf555af-73b0-49af-ac57-8659c4e9f42&title=)
   -  填写信息<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697122542182-473c9ae3-a6f6-4003-bd53-b94fbdf13b0b.png#averageHue=%23e0d8ce&clientId=u61f6968c-6c05-4&from=paste&id=ue33b4f20&originHeight=542&originWidth=654&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u1f39802d-dae6-418b-897f-f64da5eadc1&title=) 
   -  展示库表<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697122565407-72a34d31-206b-4290-b2d1-5f8035de3a68.png#averageHue=%23faf9f8&clientId=u61f6968c-6c05-4&from=paste&id=ue8775156&originHeight=676&originWidth=584&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=ubeb6a38d-5c22-4477-ae8b-9dda1074913&title=) 
   -  逆向工程使用<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697122576369-151793da-63ae-402f-bafc-4d12579123ae.png#averageHue=%23f3f3f2&clientId=u61f6968c-6c05-4&from=paste&id=u9417046d&originHeight=707&originWidth=538&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=ua3216d16-2242-40a8-a8ab-c41eafeaf7f&title=)<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697122584330-76659016-16ff-4b3c-bcb9-4098bfe0fa8e.png#averageHue=%23f6f5f4&clientId=u61f6968c-6c05-4&from=paste&id=u1f23099e&originHeight=369&originWidth=650&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u5891f1fa-7d1b-4389-8959-1e111ffc67a&title=)<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697122752916-2ff22f28-86b9-40f1-b3c6-830f7c89104c.png#averageHue=%23f2f1f0&clientId=u61f6968c-6c05-4&from=paste&id=uadd6b3a9&originHeight=371&originWidth=653&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u4434a965-3018-4fe2-9965-1841cfcf7e7&title=) 
3. 查看生成结果

![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697122702131-07757474-9420-4246-9601-2997a7ee9808.png#averageHue=%232d3036&clientId=u61f6968c-6c05-4&from=paste&height=380&id=u5784595a&originHeight=475&originWidth=471&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=31261&status=done&style=none&taskId=u0c21fa57-dfbc-4044-8359-c2bdd6dea5b&title=&width=376.8)

4.  逆向工程案例使用<br />正常使用即可，自动生成单表的crud方法！ 
```java
package generator.mapper;

import generator.com.hut.pojo.User;

/**
* @author 12279
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-10-12 22:13:58
* @Entity generator.com.hut.pojo.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}

```

# 6 MyBatis 总结
| 核心点 | 掌握目标 |
| --- | --- |
| mybatis基础 | 使用流程, 参数输入,#{} ${},参数输出 |
| mybatis多表 | 实体类设计,resultMap多表结果映射 |
| mybatis动态语句 | Mybatis动态语句概念, where , if , foreach标签 |
| mybatis扩展 | Mapper批量处理,分页插件,逆向工程 |

