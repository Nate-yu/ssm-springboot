package com.hut.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.hut.controller.StudentController;
import com.hut.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 测试jdbcTemplate的使用
 */
public class JdbcTemplateTest {

    /**
     * 通过java代码实例化jdbc
     * jdbc只简化数据库的crud，不提供连接池
     * 所以还需要配置DruidDataSource，来负责连结的创建和数据库驱动的注册
     */
    public void testForJava() {
        // 0. 创建连接池对象
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/studb");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");

        // 1. 实例化对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        // 2. 设置数据源
        jdbcTemplate.setDataSource(druidDataSource);

        // 3. 调用方法
//        jdbcTemplate.update();
    }

    /**
     * 通过ioc容器读取配置的JdbcTemplate组件
     */
    @Test
    public void testForIoC() {
        // 1. 创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        // 2. 获取jdbcTemplate组件
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        // 3. 进行数据库的crud动作
        // 3.1 插入 删除 修改
        String sql = "insert into students(name,gender,age,class) values(?,?,?,?)";
        /**
         * 参数1：String sql语句，可以带占位符
         * 参数2：Object[] 参数数组，用于给占位符赋值
         * 返回值：int 影响行数
         */
        int rows = jdbcTemplate.update(sql, "yubin", "男", 22, "1802");
        System.out.println("rows = " + rows);

        // 3.2 查询单条数据
        // 根据id查询学生数据，返回一个对应的实体对象
        sql = "select * from students where id = ?";
        /**
         * 参数1：sql语句
         * 参数2：RowMapper，列名和属性名的映射器接口
         * 参数3：Object 可以变参数，占位符的值
         * 返回值：T RowMapper指定的对象
         */
        Student student1 = jdbcTemplate.queryForObject(sql,
                /**
                 * 从rs结果集中获取列的值，赋值给实体类对象
                 * @param rs 结果集
                 * @param rowNum 行数
                 */
                (rs, rowNum) -> {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setGender(rs.getString("gender"));
                    student.setAge(rs.getInt("age"));
                    student.setClasses(rs.getString("class"));
                    return student;
                }, 1);
        System.out.println("student1 = " + student1);

        // 3.3 查询多条数据
        // 查询所有学生数据，返回一个List集合
        sql = "select id, name, gender, age, class as classes from students";
        //TODO: BeanPropertyRowMapper可以帮助我们自动映射列和属性值，要求列名和属性名一致，不一致的情况就要起别名
        List<Student> studentList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println("studentList = " + studentList);
    }

    /**
     * 从ioc容器中获取controller并调用业务
     */
    @Test
    public void testQueryAll() {
        // 1. 创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        
        // 2. 获取组件对象
        StudentController controller = applicationContext.getBean(StudentController.class);

        // 3. 使用组件对象
        controller.findAll();

        // 4. 关闭容器
        applicationContext.close();
    }

}
