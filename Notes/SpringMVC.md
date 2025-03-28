# 1 SpringMVC简介和体验
## 1.1 介绍
[Spring Web MVC :: Spring Framework](https://docs.spring.io/spring-framework/reference/web/webmvc.html)

Spring Web MVC是基于Servlet API构建的原始Web框架，从一开始就包含在Spring Framework中。正式名称“Spring Web MVC”来自其源模块的名称（ `spring-webmvc` ），但它通常被称为“Spring MVC”。

在控制层框架历经Strust、WebWork、Strust2等诸多产品的历代更迭之后，目前业界普遍选择了SpringMVC作为Java EE项目表述层开发的**首选方案**。之所以能做到这一点，是因为SpringMVC具备如下显著优势：

+ **Spring 家族原生产品**，与IOC容器等基础设施无缝对接
+ 表述层各细分领域需要解决的问题**全方位覆盖**，提供**全面解决方案**
+ **代码清新简洁**，大幅度提升开发效率
+ 内部组件化程度高，可插拔式组件**即插即用**，想要什么功能配置相应组件即可
+ **性能卓著**，尤其适合现代大型、超大型互联网项目要求



## 1.2 主要作用
![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697291023201-ba238ea5-cbcb-45a0-8ac5-0d304008cdfb.png)

SSM框架构建起单体项目的技术栈需求，其中的SpringMVC负责表述层（控制层）实现简化

1. 简化前端参数接收（形参列表）
2. 简化后端数据响应（返回值）



## 1.3 核心组件和调用流程理解
Spring MVC与许多其他Web框架一样，是围绕前端控制器模式设计的，其中中央`Servlet`，`DispatcherServlet`做整体请求处理调度

除了`DispatcherServlet`SpringMVC还会提供其他特殊的组件协作完成请求处理和响应呈现。

**SpringMVC处理请求流程：**

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697291325568-12b94253-eab5-4261-9141-ef13e7709948.png)

**SpringMVC涉及组件理解：**

1. DispatcherServlet :  SpringMVC提供，我们需要使用web.xml配置使其生效，它是整个流程处理的核心，所有请求都经过它的处理和分发。[ CEO ]
2. HandlerMapping :  SpringMVC提供，我们需要进行IoC配置使其加入IoC容器方可生效，它内部缓存handler(controller方法)和handler访问路径数据，被DispatcherServlet调用，用于查找路径对应的handler。[秘书]
3. HandlerAdapter : SpringMVC提供，我们需要进行IoC配置使其加入IoC容器方可生效，它可以处理请求参数和处理响应数据数据，每次DispatcherServlet都是通过handlerAdapter间接调用handler，他是handler和DispatcherServlet之间的适配器。[经理]
4. Handler : handler又称处理器，他是Controller类内部的方法简称，是由我们自己定义，用来接收参数，向后调用业务，最终返回响应结果。[打工人]
5. ViewResovler : SpringMVC提供，我们需要进行IoC配置使其加入IoC容器方可生效！视图解析器主要作用简化模版视图页面查找的，但是需要注意，前后端分离项目，后端只返回JSON数据，不返回页面，那就不需要视图解析器！所以，视图解析器，相对其他的组件不是必须的。[财务]



## 1.4 快速体验
1. 体验场景需求

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697292211518-947b7a33-e98c-4c12-9c35-a6310913f353.png)

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

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697292580524-00fef913-1cce-4274-964e-bf984a35c2cd.png)

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697292601115-6707fb36-897e-4b9d-b0e7-7c1e466ea53c.png)

    2. 启动项目

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697292655408-516ff87d-30f6-4ac5-a7d2-07ade103a54d.png)



# 2 SpringMVC 接收数据
## 2.1 访问路径设置
`@RequestMapping`注解的作用就是将请求的 URL 地址和处理请求的方式（handler方法）关联起来，建立映射关系。

SpringMVC 接收到指定的请求，就会来找到在映射关系中对应的方法来处理这个请求。

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

单层匹配和多层匹配：

  /*：只能匹配URL地址中的一层，如果想准确匹配两层，那么就写“/*/*”以此类推。

  /**：可以匹配URL地址中的多层。

其中所谓的一层或多层是指一个URL地址字符串被“/”划分出来的各个层次

这个知识点虽然对于`@RequestMapping`注解来说实用性不大，但是将来配置拦截器的时候也遵循这个规则。

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

默认情况下：@RequestMapping("/logout") 任何请求方式都可以访问

如果需要特定指定：

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

+ `@GetMapping`
+ `@PostMapping`
+ `@PutMapping`
+ `@DeleteMapping`
+ `@PatchMapping`

```java
@RequestMapping(value="/login",method=RequestMethod.GET)
||
@GetMapping(value="/login")
```

 注意：进阶注解只能添加到handler方法上，无法添加到类上



## 2.2 接收参数
### 2.2.1 param和json参数比较
在 HTTP 请求中，我们可以选择不同的参数类型，如 param 类型和 JSON 类型。下面对这两种参数类型进行区别和对比：

1.  参数编码：  
param 类型的参数会被编码为 ASCII 码。例如，假设 `name=john doe`，则会被编码为 `name=john%20doe`。而 JSON 类型的参数会被编码为 UTF-8。 
2.  参数顺序：  
param 类型的参数没有顺序限制。但是，JSON 类型的参数是有序的。JSON 采用键值对的形式进行传递，其中键值对是有序排列的。 
3.  数据类型：  
param 类型的参数仅支持字符串类型、数值类型和布尔类型等简单数据类型。而 JSON 类型的参数则支持更复杂的数据类型，如数组、对象等。 
4.  嵌套性：  
param 类型的参数不支持嵌套。但是，JSON 类型的参数支持嵌套，可以传递更为复杂的数据结构。 
5.  可读性：  
param 类型的参数格式比 JSON 类型的参数更加简单、易读。但是，JSON 格式在传递嵌套数据结构时更加清晰易懂。 

总的来说，param 类型的参数适用于单一的数据传递，而 JSON 类型的参数则更适用于更复杂的数据结构传递。根据具体的业务需求，需要选择合适的参数类型。在实际开发中，常见的做法是：在 GET 请求中采用 param 类型的参数，而在 POST 请求中采用 JSON 类型的参数传递。



### 2.2.2 param 参数接收
建立项目配置类（com.hut.config包下）

```java
/**
 * 项目配置类，讲controller handlerMapping handlerAdapter加入ioc容器
 */
@Configuration
@ComponentScan("com.hut.param")
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

初始化类（com.hut.config包下）

```java
/**
 * 初始化类
 */
public class SpringMVCInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * springmvc需要组件的配置类
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    /**
     * DispatcherServlet
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
```



1. 直接接收

请求参数名 = 形参参数名，参数名可以不传递![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697870908635-dcc4cef4-5eb9-4198-b7cb-9d36ace98e04.png)

只要形参数名和类型与传递参数相同，即可自动接收！

```java
@Controller
@RequestMapping("param")
public class ParamController {
    // 1. 直接接收
    // 请求参数名 = 形参参数名
    // 名称相同，可以不传递
    @RequestMapping("data")
    @ResponseBody
    public String data(String name, int age) {
        System.out.println("name = " + name + ", age = " + age);
        return "name = " + name + ", age = " + age;
    }
}
```



2. 用`@RequestParam`注解接收

可以使用 `@RequestParam` 注释将 Servlet 请求参数（即查询参数或表单数据）绑定到控制器中的方法参数。

`@RequestParam`使用场景：

+ 指定绑定的请求参数名
+ 要求请求参数必须传递
+ 为请求参数提供默认值

```java
// 2. 注解指定
// 指定请求参数名，或者是否必须传递，或者非必须传递设置默认值
// 如果形参名和请求参数名一致，可以省略
// 使用@RequestParam注解标记handler方法的形参
// 指定形参对应的请求参数@RequestParam(请求参数名称)
@GetMapping("data1")
@ResponseBody
public String data1(@RequestParam(value = "account") String username,
                    @RequestParam(required = false, defaultValue = "1") int page) {
    System.out.println("username = " + username + ", page = " + page);
    return "username = " + username + ", page = " + page;
}
```

默认情况下，使用此批注的方法参数是必需的，但您可以通过将 `@RequestParam`批注的 `required`标志设置为 `false`

如果没有没有设置非必须，也没有传递参数会出现：

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697872512592-a6662e27-eb8f-49ed-8f0c-9c629c7c82a3.png)

3. 特殊场景接值
    1. 一名多值

直接使用集合接值

```java
@GetMapping("data2")
@ResponseBody
public String data2(@RequestParam List<String> hbs) {
    System.out.println("hbs = " + hbs);
    return "ok";
}
```

    2. 实体类接收

Spring MVC 是 Spring 框架提供的 Web 框架，它允许开发者使用实体对象来接收 HTTP 请求中的参数。通过这种方式，可以在方法内部直接使用对象的属性来访问请求参数，而不需要每个参数都写一遍。下面是一个使用实体对象接收参数的示例：

定义一个用于接收参数的实体类：

```java
@Data
public class User {
    private String name;
    private int age;
}
```

		在控制器中，使用实体对象接收，示例代码如下：

```java
@Controller
@RequestMapping("param")
public class ParamController {
    
    // 4. 使用实体对象赋值 【用户信息】
    @GetMapping("data3")
    @ResponseBody
    public String data3(User user) {
        System.out.println("user = " + user);
        return user.toString();
    }
}
```

在上述代码中，将请求参数name和age映射到实体类属性上，要求属性名必须等于参数名，否则无法映射

使用postman测试如下

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1697873496343-e09e3561-1059-41ba-b632-357c96ec79fa.png)



### 2.2.3 路径参数
路径传递参数是一种在 URL 路径中传递参数的方式。在 RESTful 的 Web 应用程序中，经常使用路径传递参数来表示资源的唯一标识符或更复杂的表示方式。而 Spring MVC 框架提供了 `@PathVariable`注解来处理路径传递参数。

`@PathVariable`注解允许将 URL 中的占位符映射到控制器方法中的参数。

例如，如果我们想将 `/user/{id}`路径下的 `{id}`映射到控制器方法的一个参数中，则可以使用 `@PathVariable`注解来实现。

下面是一个使用 `@PathVariable`注解处理路径传递参数的示例：

```java
/**
 * 动态路径设计 {key}表示在形参列表获取传入的参数
 * 必须使用@PathVariable注解来表示接收路径参数
 * @param username
 * @param password
 * @return
 */
@RequestMapping("{account}/{password}")
public String login(@PathVariable(value = "account") String username, @PathVariable String password) {
    System.out.println("username = " + username + ", password = " + password);
    return "username = " + username + ", password = " + password;
}
```



### 2.2.4 json参数接收
 前端传递 JSON 数据时，Spring MVC 框架可以使用`@RequestBody`注解来将 JSON 数据转换为 Java 对象。`@RequestBody`注解表示当前方法参数的值应该从请求体中获取，并且需要指定 value 属性来指示请求体应该映射到哪个参数上。其使用方式和示例代码如下：  

1. 前端发送 JSON 数据的示例：（使用postman测试）

```json
{
  "name": "张三",
  "age": 18,
  "gender": "男"
}
```

2. <font style="color:rgba(0, 0, 0, 0.85);"> 定义一个用于接收 JSON 数据的 Java 类，例如：  </font>

```java
@Data
public class Person {
    private String name;
    private int age;
    private String gender;
}
```

3. <font style="color:rgba(0, 0, 0, 0.85);"> 在控制器中，使用</font>`<font style="color:rgba(0, 0, 0, 0.85);">@RequestBody</font>`<font style="color:rgba(0, 0, 0, 0.85);">注解来接收 JSON 数据，并将其转换为 Java 对象，例如： </font>

```java
@Controller
@RequestMapping("json")
@ResponseBody
public class JsonController {

    // 配置json：1. 导入json处理的依赖，2. handlerAdapter配置json转化器
    @PostMapping("data")
    public String data(@RequestBody Person person) {
        System.out.println("person = " + person);
        return person.toString();
    }
}
```

<font style="color:rgba(0, 0, 0, 0.85);">在上述代码中，</font>`<font style="color:rgba(0, 0, 0, 0.85);">@RequestBody</font>`<font style="color:rgba(0, 0, 0, 0.85);">注解将请求体中的 JSON 数据映射到 </font>`<font style="color:rgba(0, 0, 0, 0.85);">Person</font>`<font style="color:rgba(0, 0, 0, 0.85);">类型的 </font>`<font style="color:rgba(0, 0, 0, 0.85);">person</font>`<font style="color:rgba(0, 0, 0, 0.85);">参数上，并将其作为一个对象来传递给 </font>`<font style="color:rgba(0, 0, 0, 0.85);">data()</font>`<font style="color:rgba(0, 0, 0, 0.85);">方法进行处理。</font>

4. <font style="color:rgba(0, 0, 0, 0.85);">配置json</font>
    1. <font style="color:rgba(0, 0, 0, 0.85);"> springmvc handlerAdpater配置json转化器,配置类需要明确：  </font>

```java
@EnableWebMvc // 给handlerAdapter配置json转化器，使用此注解加入json处理器
@Configuration
@ComponentScan("com.hut.json")
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

    2.  pom.xml 加入jackson依赖  

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.0</version>
</dependency>
```



## 2.3 接收 Cookie 数据
使用注解`@CookieValue(value = "cookieName")`将 HTTP Cookie 的值绑定到控制器中的方法参数。

```java
/**
 * 接收cookie
 */
@Controller
@RequestMapping("cookie")
@ResponseBody
public class CookieController {
    @GetMapping("save")
    public String save(HttpServletResponse response) {
        Cookie cookie = new Cookie("cookieName", "root");
        response.addCookie(cookie);
        return "ok";
    }

    // cookieName = root
    @RequestMapping("data")
    public String data(@CookieValue(value = "cookieName") String value) {
        System.out.println("value = " + value);
        return value;
    }
}
```



## 2.4 接收请求头数据
可以使用注解`@RequestHeader("Host")` 将请求标头绑定到控制器中的方法参数。  

```java
@Controller
@RequestMapping("header")
@ResponseBody
public class HeaderController {
    @GetMapping("data")
    public String data(@RequestHeader("Host") String host) {
        System.out.println("host = " + host);
        return "host = " + host;
    }
}
```



## 2.5 原生Api对象操作
下表描述了支持的控制器方法参数

| Controller method argument 控制器方法参数 | Description |
| --- | --- |
| `jakarta.servlet.ServletRequest`<br/>, `jakarta.servlet.ServletResponse` | 请求/响应对象 |
| `jakarta.servlet.http.HttpSession` | 强制存在会话。因此，这样的参数永远不会为 `null`<br/> 。 |
| `java.io.InputStream`<br/>, `java.io.Reader` | 用于访问由 Servlet API 公开的原始请求正文。 |
| `java.io.OutputStream`<br/>, `java.io.Writer` | 用于访问由 Servlet API 公开的原始响应正文。 |
| `@PathVariable` | 接收路径参数注解 |
| `@RequestParam` | 用于访问 Servlet 请求参数，包括多部分文件。参数值将转换为声明的方法参数类型。 |
| `@RequestHeader` | 用于访问请求标头。标头值将转换为声明的方法参数类型。 |
| `@CookieValue` | 用于访问Cookie。Cookie 值将转换为声明的方法参数类型。 |
| `@RequestBody` | 用于访问 HTTP 请求正文。正文内容通过使用 `HttpMessageConverter`<br/> 实现转换为声明的方法参数类型。 |
| `java.util.Map`<br/>, `org.springframework.ui.Model`<br/>, `org.springframework.ui.ModelMap` | 共享域对象，并在视图呈现过程中向模板公开。 |
| `Errors`<br/>, `BindingResult` | 验证和数据绑定中的错误信息获取对象！ |


```java
@Controller
@RequestMapping("api")
@ResponseBody
public class ApiController {
    @Autowired
    private ServletContext servletContext;
    public void data(HttpServletResponse response,
                     HttpServletRequest request,
                     HttpSession session) {
        ServletContext servletContext = request.getServletContext();
        ServletContext servletContext1 = session.getServletContext();
    }
}
```



## 2.6 共享域对象操作
### 2.6.1 属性共享域作用
在 JavaWeb 中，共享域指的是在 Servlet 中存储数据，以便在同一 Web 应用程序的多个组件中进行共享和访问。常见的共享域有四种：`ServletContext`、`HttpSession`、`HttpServletRequest`、`PageContext`。

1. `ServletContext` 共享域：`ServletContext` 对象可以在整个 Web 应用程序中共享数据，是最大的共享域。一般可以用于保存整个 Web 应用程序的全局配置信息，以及所有用户都共享的数据。在 `ServletContext` 中保存的数据是线程安全的。（全局）
2. `HttpSession` 共享域：`HttpSession` 对象可以在同一用户发出的多个请求之间共享数据，但只能在同一个会话中使用。比如，可以将用户登录状态保存在 `HttpSession` 中，让用户在多个页面间保持登录状态。（用户/会话）
3. `HttpServletRequest` 共享域：`HttpServletRequest` 对象可以在同一个请求的多个处理器方法之间共享数据。比如，可以将请求的参数和属性存储在 `HttpServletRequest` 中，让处理器方法之间可以访问这些数据。（请求）
4. `PageContext` 共享域：`PageContext` 对象是在 JSP 页面Servlet 创建时自动创建的。它可以在 JSP 的各个作用域中共享数据，包括`pageScope`、`requestScope`、`sessionScope`、`applicationScope` 等作用域。（jsp）

共享域的作用是提供了方便实用的方式在同一 Web 应用程序的多个组件之间传递数据，并且可以将数据保存在不同的共享域中，根据需要进行选择和使用。

![](https://cdn.nlark.com/yuque/0/2023/webp/25941432/1698302943121-bd5e4049-9c74-46a6-b7e0-31d26141b976.webp)

### 2.6.2 Request级别属性共享域
1. 使用 Model 类型的形参

```java
public void data1(Model model) {
	model.addAttribute("key", "value");
}
```

2. 使用 ModelMap 类型的形参

```java
public void data1(ModelMap model) {
    model.addAttribute("key", "value");
}
```

3. 使用 Map 类型的形参

```java
public void data1(Map map) {
    map.put("key", "value");
}
```

4.  使用 ModelAndView 对象

```java
public ModelAndView data1() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("key", "value");
    modelAndView.setViewName("视图名 页面名称");
    return modelAndView;
}
```

5. 原生api

```java
public void data(HttpServletRequest request, HttpSession session) {
	request.setAttribute("requestScopeMessageOriginal", "i am very happy[original]");
}
```



### 2.6.3 Session级别属性共享域
```java
@RequestMapping("/attr/session")
@ResponseBody
public String testAttrSession(HttpSession session) {
    //直接对session对象操作,即对会话范围操作!
    return "target";
}
```



### 2.6.4 Application 级别属性共享域
 解释：springmvc会在初始化容器的时候，将servletContext对象存储到ioc容器中

```java
@Autowired
private ServletContext servletContext;

@RequestMapping("/attr/application")
@ResponseBody
public String attrApplication() {
    
    servletContext.setAttribute("appScopeMsg", "i am hungry...");
    
    return "target";
}
```

