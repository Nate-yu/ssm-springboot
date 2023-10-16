# 1 SpringMVC简介和体验
## 1.1 介绍
[Spring Web MVC :: Spring Framework](https://docs.spring.io/spring-framework/reference/web/webmvc.html)<br />Spring Web MVC是基于Servlet API构建的原始Web框架，从一开始就包含在Spring Framework中。正式名称“Spring Web MVC”来自其源模块的名称（ `spring-webmvc` ），但它通常被称为“Spring MVC”。<br />在控制层框架历经Strust、WebWork、Strust2等诸多产品的历代更迭之后，目前业界普遍选择了SpringMVC作为Java EE项目表述层开发的**首选方案**。之所以能做到这一点，是因为SpringMVC具备如下显著优势：

- **Spring 家族原生产品**，与IOC容器等基础设施无缝对接
- 表述层各细分领域需要解决的问题**全方位覆盖**，提供**全面解决方案**
- **代码清新简洁**，大幅度提升开发效率
- 内部组件化程度高，可插拔式组件**即插即用**，想要什么功能配置相应组件即可
- **性能卓著**，尤其适合现代大型、超大型互联网项目要求

## 1.2 主要作用
![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697291023201-ba238ea5-cbcb-45a0-8ac5-0d304008cdfb.png#averageHue=%23f5f5f5&clientId=u8b810802-34b1-4&from=paste&id=uaa5ac079&originHeight=492&originWidth=884&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u5d28ca22-db9b-445c-8e37-233512bbb48&title=)<br />SSM框架构建起单体项目的技术栈需求，其中的SpringMVC负责表述层（控制层）实现简化

1. 简化前端参数接收（形参列表）
2. 简化后端数据响应（返回值）

## 1.3 核心组件和调用流程理解
Spring MVC与许多其他Web框架一样，是围绕前端控制器模式设计的，其中中央`Servlet`，`DispatcherServlet`做整体请求处理调度<br />除了`DispatcherServlet`SpringMVC还会提供其他特殊的组件协作完成请求处理和响应呈现。<br />**SpringMVC处理请求流程：**<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697291325568-12b94253-eab5-4261-9141-ef13e7709948.png#averageHue=%23f8f3f0&clientId=u8b810802-34b1-4&from=paste&id=u3746de43&originHeight=430&originWidth=1053&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u58373d47-0f9b-497b-941a-b0182fdc880&title=)<br />**SpringMVC涉及组件理解：**

1. DispatcherServlet :  SpringMVC提供，我们需要使用web.xml配置使其生效，它是整个流程处理的核心，所有请求都经过它的处理和分发。[ CEO ]
2. HandlerMapping :  SpringMVC提供，我们需要进行IoC配置使其加入IoC容器方可生效，它内部缓存handler(controller方法)和handler访问路径数据，被DispatcherServlet调用，用于查找路径对应的handler。[秘书]
3. HandlerAdapter : SpringMVC提供，我们需要进行IoC配置使其加入IoC容器方可生效，它可以处理请求参数和处理响应数据数据，每次DispatcherServlet都是通过handlerAdapter间接调用handler，他是handler和DispatcherServlet之间的适配器。[经理]
4. Handler : handler又称处理器，他是Controller类内部的方法简称，是由我们自己定义，用来接收参数，向后调用业务，最终返回响应结果。[打工人]
5. ViewResovler : SpringMVC提供，我们需要进行IoC配置使其加入IoC容器方可生效！视图解析器主要作用简化模版视图页面查找的，但是需要注意，前后端分离项目，后端只返回JSON数据，不返回页面，那就不需要视图解析器！所以，视图解析器，相对其他的组件不是必须的。[财务]

## 1.4 快速体验

1. 体验场景需求

![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697292211518-947b7a33-e98c-4c12-9c35-a6310913f353.png#averageHue=%23f8f7f0&clientId=u8b810802-34b1-4&from=paste&height=403&id=u9ce411cb&originHeight=537&originWidth=1402&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=65268&status=done&style=none&taskId=u455ab28f-e7e3-4602-b213-51c4d78b1b2&title=&width=1052)

2. 配置分析 
   1. DispatcherServlet，设置处理所有请求
   2. HandlerMapping,HandlerAdapter,Handler需要加入到IoC容器，供DS调用
   3. Handler自己声明（Controller）需要配置到HandlerMapping中供DS查找
3. 准备项目
   1. 创建项目 springmvc-base-quick

注意：需要转成 maven/web 程序

   2. 导入依赖
```xml
<properties>
    <spring.version>6.0.6</spring.version>
    <servlet.api>9.1.0</servlet.api>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>

<!-- springwebmvc
    web - servlet
    ioc - spring-context
    mvc - spring-webmvc
-->
<dependencies>
    <!-- springioc相关依赖  -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <!-- web相关依赖  -->
    <!-- 在 pom.xml 中引入 Jakarta EE Web API 的依赖 -->
    <!--
        在 Spring Web MVC 6 中，Servlet API 迁移到了 Jakarta EE API，因此在配置 DispatcherServlet 时需要使用
         Jakarta EE 提供的相应类库和命名空间。错误信息 “‘org.springframework.web.servlet.DispatcherServlet’
         is not assignable to ‘javax.servlet.Servlet,jakarta.servlet.Servlet’” 表明你使用了旧版本的
         Servlet API，没有更新到 Jakarta EE 规范。
    -->
    <dependency>
        <groupId>jakarta.platform</groupId>
        <artifactId>jakarta.jakartaee-web-api</artifactId>
        <version>${servlet.api}</version>
        <scope>provided</scope>
    </dependency>

    <!-- springwebmvc相关依赖  -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>${spring.version}</version>
    </dependency>

</dependencies>
```

4. Contorller 声明
```java
@Controller
public class HelloController {


    @RequestMapping("springmvc/hello") // 对外访问的地址
    @ResponseBody // 直接返回字符串到前端，不要找视图解析器
    public String hello() {
        System.out.println("HelloController.java");
        return "hello springmvc";
    }
}
```

5.  Spring MVC核心组件配置类  
```java
/**
 * 1. 将controller配置到ioc容器
 * 2. handlerMapping handlerAdapter加入到ioc容器
 */
@Configuration
@ComponentScan("com.hut.controller")
public class MvcConfig {
    @Bean
    public RequestMappingHandlerMapping handlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public RequestMappingHandlerAdapter handlerAdapter() {
        return new RequestMappingHandlerAdapter();
    }
}
```

6.  SpringMVC环境搭建
```java
/**
 * TODO：可以被web项目加载，会初始化ioc容器，会设置dispatcherServlet的地址
 */
public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // 设置项目对应的配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    // 配置springmvc内部自带servlet的访问地址
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
```

7. 启动测试
   1. 配置TomCat

![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697292580524-00fef913-1cce-4274-964e-bf984a35c2cd.png#averageHue=%232d3034&clientId=u8b810802-34b1-4&from=paste&height=706&id=ub908c898&originHeight=882&originWidth=1295&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=67968&status=done&style=none&taskId=u7b85775f-f2d1-41b9-ace4-34c067340bc&title=&width=1036)<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697292601115-6707fb36-897e-4b9d-b0e7-7c1e466ea53c.png#averageHue=%232c2e32&clientId=u8b810802-34b1-4&from=paste&height=703&id=ude5aa463&originHeight=879&originWidth=1299&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=39696&status=done&style=none&taskId=u39456ee5-8c93-4931-b6b7-7b32f71dd55&title=&width=1039.2)

   2. 启动项目

![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697292655408-516ff87d-30f6-4ac5-a7d2-07ade103a54d.png#averageHue=%23a2a19f&clientId=u8b810802-34b1-4&from=paste&height=179&id=u8ae65bfb&originHeight=224&originWidth=700&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=18685&status=done&style=none&taskId=u126bca66-fb20-455d-9f16-e6a10054123&title=&width=560)

# 2 SpringMVC 接收数据
## 2.1 访问路径设置
`@RequestMapping`注解的作用就是将请求的 URL 地址和处理请求的方式（handler方法）关联起来，建立映射关系。<br />SpringMVC 接收到指定的请求，就会来找到在映射关系中对应的方法来处理这个请求。

1. 精准路径匹配
```java
@Controller
@RequestMapping("user")
public class UserController {

    /**
     * 精准设置访问地址 /user/login
     */
    @RequestMapping(value = {"login"})
    @ResponseBody
    public String login(){
        System.out.println("UserController.login");
        return "login success!!";
    }

    /**
     * 精准设置访问地址 /user/register
     */
    @RequestMapping(value = {"register"})
    @ResponseBody
    public String register(){
        System.out.println("UserController.register");
        return "register success!!";
    }
    
}
```

2. 模糊路径匹配

 在`@RequestMapping`注解指定 URL 地址时，通过使用通配符，匹配多个类似的地址。  
```java
@Controller
public class ProductController {

    /**
     *  路径设置为 /product/*  
     *    /* 为单层任意字符串  /product/a  /product/aaa 可以访问此handler  
     *    /product/a/a 不可以
     *  路径设置为 /product/** 
     *   /** 为任意层任意字符串  /product/a  /product/aaa 可以访问此handler  
     *   /product/a/a 也可以访问
     */
    @RequestMapping("/product/*")
    @ResponseBody
    public String show(){
        System.out.println("ProductController.show");
        return "product show!";
    }
}
```
单层匹配和多层匹配：<br />  /*：只能匹配URL地址中的一层，如果想准确匹配两层，那么就写“/*/*”以此类推。<br />  /**：可以匹配URL地址中的多层。<br />其中所谓的一层或多层是指一个URL地址字符串被“/”划分出来的各个层次<br />这个知识点虽然对于`@RequestMapping`注解来说实用性不大，但是将来配置拦截器的时候也遵循这个规则。

3. 类和方法级别区别

`@RequestMapping` 注解可以用于类级别和方法级别，它们之间的区别如下：

   1. 设置到类级别：`@RequestMapping` 注解可以设置在控制器类上，用于映射整个控制器的通用请求路径。这样，如果控制器中的多个方法都需要映射同一请求路径，就不需要在每个方法上都添加映射路径。
   2. 设置到方法级别：`@RequestMapping` 注解也可以单独设置在控制器方法上，用于更细粒度地映射请求路径和处理方法。当多个方法处理同一个路径的不同操作时，可以使用方法级别的 `@RequestMapping` 注解进行更精细的映射。
```java
//1.标记到handler方法
@RequestMapping("/user/login")
@RequestMapping("/user/register")
@RequestMapping("/user/logout")

//2.优化标记类+handler方法
//类上
@RequestMapping("/user")
//handler方法上
@RequestMapping("/login")
@RequestMapping("/register")
@RequestMapping("/logout")
```

4. 附带请求方式限制

 HTTP 协议定义了八种请求方式，在 SpringMVC 中封装到了下面这个枚举类：  
```java
public enum RequestMethod {
  GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
}
```
默认情况下：@RequestMapping("/logout") 任何请求方式都可以访问<br />如果需要特定指定：
```java
@Controller
public class UserController {

    /**
     * 精准设置访问地址 /user/login
     * method = RequestMethod.POST 可以指定单个或者多个请求方式
     * 注意:违背请求方式会出现405异常
     */
    @RequestMapping(value = {"/user/login"} , method = RequestMethod.POST)
    @ResponseBody
    public String login(){
        System.out.println("UserController.login");
        return "login success!!";
    }

    /**
     * 精准设置访问地址 /user/register
     */
    @RequestMapping(value = {"/user/register"},method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String register(){
        System.out.println("UserController.register");
        return "register success!!";
    }

}
```
注意：违背请求方式会出现405异常

5. 进阶注解

还有 `@RequestMapping` 的 HTTP 方法特定快捷方式变体：

- `@GetMapping`
- `@PostMapping`
- `@PutMapping`
- `@DeleteMapping`
- `@PatchMapping`
```java
@RequestMapping(value="/login",method=RequestMethod.GET)
||
@GetMapping(value="/login")
```
 注意：进阶注解只能添加到handler方法上，无法添加到类上

