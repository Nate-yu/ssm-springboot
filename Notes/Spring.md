# 1 技术体系结构
## 1.1 总体技术体系

1. 单一架构： 一个项目，一个工程，导出为一个war包，在一个Tomcat上运行

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692862312087-787fa906-b256-4793-85b0-571a212490fb.png#averageHue=%23f5f5f5&clientId=u796f8aec-6fd5-4&from=paste&id=ued2bf56d&originHeight=417&originWidth=750&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=ue0c1694d-4925-4d41-a6d8-203dee4df03&title=)<br />单一架构主要应用技术框架：SSM

2. 分布式架构

 一个项目（对应 IDEA 中的一个 project），拆分成很多个模块，每个模块是一个 IDEA 中的一个 module。每一个工程都是运行在自己的 Tomcat 上。模块之间可以互相调用。每一个模块内部可以看成是一个单一架构的应用<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692862367221-8a5a84bc-5a9d-4d1f-9182-3fb9b77f0166.png#averageHue=%23f0f0f0&clientId=u796f8aec-6fd5-4&from=paste&id=u35d4a09a&originHeight=229&originWidth=753&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u5e2b2a95-b425-441a-96cb-34dfe7fa830&title=)<br />分布式架构主要应用技术框架：SpringBoot，SpringCloud，中间件

## 1.2 框架概念与理解
>  框架( Framework )是一个集成了基本结构、规范、设计模式、编程语言和程序库等基础组件的软件系统，它可以用来构建更高级别的应用程序。框架的设计和实现旨在解决特定领域中的常见问题，帮助开发人员更高效、更稳定地实现软件开发目标  

框架优点：

1. 提高开发效率：框架提供了许多预先设计好了的组件和工具，能够帮助开发人员快速进行开发。相较于传统手写代码，在框架提供的规范化环境中，开发者可以更快地实现项目的各种要求。
2. 降低开发成本：框架的提供标准化的编程语言、数据操作等代码片段，避免了重复开发的问题，降低了开发成本，提供深度优化的系统，降低了维护成本，增强了系统的可靠性。
3. 提高应用程序的稳定性：框架通常经过了很长时间的开发和测试，其中的许多组件、代码片段和设计模式都得到了验证。重复利用这些组件有助于减少bug的出现，从而提高了应用程序的稳定性。
4. 提供标准化的解决方案：框架通常是针对某个特定领域的，通过提供标准化的解决方案，可以为开发人员提供一种共同的语言和思想基础，有助于更好地沟通和协作。

框架缺点：

1. 学习成本高
2. 可能存在局限性
3. 版本变更和兼容性问题
4. 架构风险

框架总结：**框架 = jar包 + 配置文件 **（可以进行个性化定制）<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692862567313-dcf312e9-7031-40fd-bfb4-870aa2ec9e58.png#averageHue=%23f4f4f4&clientId=u796f8aec-6fd5-4&from=paste&height=461&id=u2c034404&originHeight=615&originWidth=641&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u9e2f50d7-5189-497f-929b-4f122346d37&title=&width=481)

# 2 Spring介绍
## 2.1 Spring与SpringFramework

1.  广义的 Spring：Spring 技术栈（全家桶）
2.  狭义的 Spring：Spring Framework（基础框架）  

## 2.2 Spring主要功能模块
Spring功能模块与介绍

| 功能模块 | 功能介绍 |
| --- | --- |
| Core Container | 核心容器，在 Spring 环境下使用任何功能都必须基于 IOC 容器 |
| AOP&Aspects | 面向切面编程 |
| TX | 声明式事务管理。 |
| Spring MVC | 提供了面向Web应用程序的集成功能。 |


## 2.3 Spring主要优势

1. 丰富的生态系统：Spring 生态系统非常丰富，支持许多模块和库，如 Spring Boot、Spring Security、Spring Cloud 等等，可以帮助开发人员快速构建高可靠性的企业应用程序。
2. 模块化的设计：框架组件之间的松散耦合和模块化设计使得 Spring Framework 具有良好的可重用性、可扩展性和可维护性。开发人员可以轻松地选择自己需要的模块，根据自己的需求进行开发。
3. 简化 Java 开发：Spring Framework 简化了 Java 开发，提供了各种工具和 API，可以降低开发复杂度和学习成本。同时，Spring Framework 支持各种应用场景，包括 Web 应用程序、RESTful API、消息传递、批处理等等。
4. 不断创新和发展：Spring Framework 开发团队一直在不断创新和发展，保持与最新技术的接轨，为开发人员提供更加先进和优秀的工具和框架。

因此，这些优点使得 Spring Framework 成为了一个稳定、可靠、且创新的框架，为企业级 Java 开发提供了一站式的解决方案。

Spring 使创建 Java 企业应用程序变得容易。它提供了在企业环境中采用 Java 语言所需的一切，支持 Groovy 和 Kotlin 作为 JVM 上的替代语言，并且可以根据应用程序的需求灵活地创建多种架构。从Spring Framework 6.0.6开始，Spring 需要 Java 17+。<br />![83f2516d97d1ed8639b95f254975231.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692864018836-12b79255-d0f4-478a-9de6-a1469891b6e3.png#averageHue=%23191919&clientId=u796f8aec-6fd5-4&from=paste&height=187&id=uf8407e30&originHeight=234&originWidth=1135&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=23484&status=done&style=none&taskId=uc2b8a8dc-add2-40ef-a4d9-aab556a763d&title=&width=908)

# 3 Spring IoC容器及其核心概念
## 3.1 组件和组件管理的概念
### 3.1.1 什么是组件
常规三层架构处理请求流程如下：<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692867374434-a5e4319e-d10b-45a2-8d12-5952f498f2cf.png#averageHue=%2327241b&clientId=u796f8aec-6fd5-4&from=paste&id=u5c13af21&originHeight=220&originWidth=534&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=ud7ccf311-0fb4-41e0-bc1e-c2f467afac2&title=)<br />整个项目就是由各种组件搭建而成：<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692867433714-31de38c5-8e23-47d8-a5d7-71949347c94f.png#averageHue=%231a1812&clientId=u796f8aec-6fd5-4&from=paste&id=u2c229d3f&originHeight=283&originWidth=617&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u3b0457a3-ea13-448e-a58f-59c720c828e&title=)

### 3.1.2 希望容器能做的

- 创建组件的对象
- 保存组件的对象
- 自动组装
- 管理事务
- 整合其他框架

### 3.1.3 Spring IoC充当组件管理角色
组件可以完全交给Spring 框架进行管理，Spring框架替代了程序员原有的new对象和对象属性赋值动作等！

Spring具体的组件管理动作包含：

- 组件对象实例化
- 组件属性属性赋值
- 组件对象之间引用
- 组件对象存活周期管理
- ......

 我们只需要编写元数据（配置文件）告知Spring 管理哪些类组件和他们的关系即可  

注意：组件是映射到应用程序中所有可重用组件的Java对象，应该是可复用的功能对象

- 组件一定是对象
- 对象不一定是组件

### 3.1.4 组件交给Spring管理的优势

1. **降低了组件之间的耦合性**：Spring IoC容器通过依赖注入机制，将组件之间的依赖关系削弱，减少了程序组件之间的耦合性，使得组件更加松散地耦合。
2. **提高了代码的可重用性和可维护性**：将组件的实例化过程、依赖关系的管理等功能交给Spring IoC容器处理，使得组件代码更加模块化、可重用、更易于维护。
3. **方便了配置和管理**：Spring IoC容器通过XML文件、注解或者Java配置类，轻松的对组件进行配置和管理，使得组件的切换、替换等操作更加的方便和快捷。
4. 交给Spring管理的对象（组件），方可享受Spring框架的其他功能（AOP,声明事务管理）等

## 3.2 Spring IoC容器和容器实现
### 3.2.1 普通容器和复杂容器
普通容器：

- 数组
- 集合
- ......

复杂容器：<br />Servlet 容器能够管理 Servlet(init,service,destroy)、Filter、Listener 这样的组件的一生，所以它是一个复杂容器  

| 名称 | 时机 | 次数 |
| --- | --- | --- |
| 创建对象 | 默认情况：接收到第一次请求  修改启动顺序后：Web应用启动过程中 | 一次 |
| 初始化操作 | 创建对象之后 | 一次 |
| 处理请求 | 接收到请求 | 多次 |
| 销毁操作 | Web应用卸载之前 | 一次 |

SpringIoC 不仅要负责创建组件的对象、存储组件的对象，还要负责调用组件的方法让它们工作，最终在特定情况下销毁组件。

### 3.2.2 SpringIoC容器介绍
Spring IoC 容器，负责**实例化**、**配置**和**组装** bean（组件）。容器通过读取配置元数据来获取有关要实例化、配置和组装组件的指令。配置元数据以 XML、Java 注解或 Java 代码形式表现。它允许表达组成应用程序的组件以及这些组件之间丰富的相互依赖关系。<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692868068647-a529cdcd-253e-4738-ae6b-69e10862698c.png#averageHue=%23f7f7f7&clientId=u796f8aec-6fd5-4&from=paste&id=u9de21779&originHeight=296&originWidth=498&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=uce5916c5-8160-4fcc-99d6-835c6d72d44&title=)<br />上图显示了 Spring 容器工作原理的高级视图。应用程序类与配置元数据相结合，您拥有完全配置且可执行的系统或应用程序。

### 3.2.3 SpringIoC容器接口和实现类
SpringIoC 容器接口：<br />`BeanFactory` 接口提供了一种高级配置机制，能够管理任何类型的对象，它是SpringIoC容器标准化超接口<br />`ApplicationContext` 是 `BeanFactory` 的子接口。它扩展了以下功能：

- 更容易与 Spring 的 AOP 功能集成
- 消息资源处理（用于国际化）
- 特定于应用程序给予此接口实现，例如Web 应用程序的 `WebApplicationContext`

简而言之， `BeanFactory` 提供了配置框架和基本功能，而 `ApplicationContext` 添加了更多特定于企业的功能。 `ApplicationContext` 是 `BeanFactory` 的完整超集

`ApplicationContext`容器实现类：

| 类型名 | 简介 |
| --- | --- |
| ClassPathXmlApplicationContext | 通过读取**类路径**下的 XML 格式的配置文件创建 IOC 容器对象 |
| FileSystemXmlApplicationContext | 通过**文件系统路径**读取 XML 格式的配置文件创建 IOC 容器对象 |
| AnnotationConfigApplicationContext | 通过读取**Java配置类**创建 IOC 容器对象 |
| WebApplicationContext | 专门为** Web **应用准备，基于 Web 环境创建 IOC 容器对象，并将对象引入存入 ServletContext 域中。 |


### 3.2.4 SpringIoC容器管理配置方式
Spring框架提供了多种配置方式：XML配置方式、注解方式和Java配置类方式

1. **XML**配置方式：是Spring框架最早的配置方式之一，通过在XML文件中定义Bean及其依赖关系、Bean的作用域等信息，让Spring IoC容器来管理Bean之间的依赖关系。该方式从Spring框架的第一版开始提供支持。
2. **注解**方式：从Spring 2.5版本开始提供支持，可以通过在Bean类上使用注解来代替XML配置文件中的配置信息。通过在Bean类上加上相应的注解（如@Component, @Service, @Autowired等），将Bean注册到Spring IoC容器中，这样Spring IoC容器就可以管理这些Bean之间的依赖关系。
3. **Java配置类**方式：从Spring 3.0版本开始提供支持，通过Java类来定义Bean、Bean之间的依赖关系和配置信息，从而代替XML配置文件的方式。Java配置类是一种使用Java编写配置信息的方式，通过@Configuration、@Bean等注解来实现Bean和依赖关系的配置。

## 3.3 SpringIoC / DI概念总结

1. **IoC（Inversion of Control）控制反转**

 IoC 主要是针对对象的创建和调用控制而言的，也就是说，当应用程序需要使用一个对象时，不再是应用程序直接创建该对象，而是**由 IoC 容器来创建和管理**，即控制权由应用程序转移到 IoC 容器中，也就是“反转”了控制权。这种方式基本上是通过依赖查找的方式来实现的，即 IoC 容器维护着构成应用程序的对象，并负责创建这些对象。  

2.  **IoC容器**

 Spring IoC 容器，负责实例化、配置和组装 bean（组件）核心容器。容器通过读取配置元数据来获取有关要实例化、配置和组装组件的指令。  

3.  **DI (Dependency Injection) 依赖注入**

DI 是指在组件之间传递依赖关系的过程中，**将依赖关系在容器内部进行处理**，这样就不必在应用程序代码中硬编码对象之间的依赖关系，实现了对象之间的解耦合。在 Spring 中，DI 是通过 **XML** 配置文件或**注解**的方式实现的。它提供了三种形式的依赖注入：构造函数注入、Setter 方法注入和接口注入。

# 4 Spring IoC实践和应用
## 4.1 Spring IoC / DI 实现步骤

1. 配置元数据

基于XML的配置元数据的基本结构：
```xml
<bean id="..." [1] class="..." [2]> 
	<!-- collaborators and configuration for this bean go here --> 
</bean>
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 此处要添加一些约束，配置文件的标签并不是随意命名 -->
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.springframework.org/schema/beans
    https://www.springframework.org/schema/beans/spring-beans.xsd">

  <bean id="..." [1] class="..." [2]>  
    <!-- collaborators and configuration for this bean go here -->
  </bean>

  <bean id="..." class="...">
    <!-- collaborators and configuration for this bean go here -->
  </bean>
  <!-- more bean definitions go here -->
</beans>
```
Spring IoC 容器管理一个或多个组件。这些组件是使用你提供给容器的配置元数据（例如，以 XML `<bean/>` 定义的形式）创建的。<br /> 标签 == 组件信息声明

- `id` 属性是标识单个 Bean 定义的字符串。
- `class` 属性定义 Bean 的类型并使用完全限定的类名。

2. 实例化IoC容器

提供给 `ApplicationContext`构造函数的位置路径是资源字符串地址，允许容器从各种外部资源（如本地文件系统、Java `CLASSPATH`等）加载配置元数据。我们应该选择一个合适的容器实现类，进行IoC容器的实例化工作：
```java
//实例化ioc容器,读取外部配置文件,最终会在容器内进行ioc和di动作
ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
```

3. 获取Bean（组件）

`ApplicationContext`是一个高级工厂的接口，能够维护不同 bean 及其依赖项的注册表。通过使用方法 `T getBean(String name, Class<T> requiredType)`，您可以检索 bean 的实例。<br />允许读取 Bean 定义并访问它们，如以下示例所示：
```java
//创建ioc容器对象，指定配置文件，ioc也开始实例组件对象
ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
//获取ioc容器的组件对象
PetStoreService service = context.getBean("petStore", PetStoreService.class);
//使用组件对象
List<String> userList = service.getUsernameList();
```
## 4.2 基于XML配置方式组件管理
### 4.2.1 实验一：组件（Bean）信息声明配置（IoC）

1.  目标<br />	Spring IoC 容器管理一个或多个 bean。这些 Bean 是使用您提供给容器的配置元数据创建的（例如，以 XML `<bean/>` 定义的形式）。<br />我们学习，如何通过定义XML配置文件，声明组件类信息，交给 Spring 的 IoC 容器进行组件管理

2.  思路

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692931611144-9dad4de8-49ee-47c9-890e-df884bf74683.png#averageHue=%23eeeeee&clientId=u540cd631-9d29-4&from=paste&id=ud19c15b5&originHeight=254&originWidth=677&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=ua5b58186-7847-4265-a4f3-26e1220a3e1&title=)

3.  准备项目（父工程为`ssm-spring-part`） 
   1.  创建maven工程（spring-ioc-xml-01） 
   2.  导入SpringIoC相关依赖<br />父工程pom.xml 
```xml
<dependencies>
    <!--spring context依赖-->
    <!--当你引入Spring Context依赖之后，表示将Spring的基础依赖引入了-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>6.0.6</version>
    </dependency>
    <!--junit5测试-->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.3.1</version>
    </dependency>
</dependencies>
```

4. 基于无参数构造函数

当通过构造函数方法创建一个 bean（组件对象） 时，所有普通类都可以由 Spring 使用并与之兼容。也就是说，正在开发的类不需要实现任何特定的接口或以特定的方式进行编码。只需指定 Bean 类信息就足够了。但是，默认情况下，我们需要一个默认（空）构造函数。

   1. 准备组件类
```java
package com.hut.ioc_01;


public class HappyComponent {

    //默认包含无参数构造函数

    public void doWork() {
        System.out.println("HappyComponent.doWork");
    }
}
```

   2. xml配置文件编写

创建携带spring约束的xml配置文件<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692932373331-665a1af2-bf58-4c6a-a8ab-b48a3114b307.png#averageHue=%233d4042&clientId=u540cd631-9d29-4&from=paste&height=520&id=uaf858a79&originHeight=650&originWidth=1008&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=79767&status=done&style=none&taskId=u7982afa7-94f3-40b6-bd48-c77d706574e&title=&width=806.4)<br />编写配置文件：<br />文件：`resources/spring-bean-01.xml`
```xml
<!-- 1. 可以使用无参数构造函数实例化的组件，如何进行ioc配置
  <bean - 一个组件信息 - 一个组件对象
    id 组件的标识，唯一，方便后期读取
    class 组件的类的全限定符
-->
<bean id="happyComponent" class="com.hut.ioc_01.HappyComponent"/>
```

   - bean标签：通过配置bean标签告诉IOC容器需要创建对象的组件信息
   - id属性：bean的唯一标识,方便后期获取Bean
   - class属性：组件类的全限定符
   - 注意：要求当前组件类必须包含无参数构造函数

5. 基于静态工厂方法实例化
   1. 准备组件类
```java
package com.hut.ioc_01;

/**
 * 静态工厂
 */
public class ClientService {
    private static ClientService clientService = new ClientService();
    private ClientService() {}

    public static ClientService createInstance() {
        return clientService;
    }
}
```

   2. xml配置文件编写

 文件：`resources/spring-bean-01.xml`
```xml
<!-- 2. 静态工厂类如何声明工厂方法进行ioc配置
  <bean
    id 组件标识
    class 工厂类的全限定符
    factory-method 静态工厂方法
-->
<bean id="clientService" class="com.hut.ioc_01.ClientService" factory-method="createInstance"/>
```

   - class属性：指定工厂类的全限定符
   - factory-method: 指定静态工厂方法，
   - 注意：该方法必须是static方法。

6.  基于实例工厂方法实例化  
   1. 准备组件类
```java
package com.hut.ioc_01;

/**
 * 实例工厂
 */
public class DefaultServiceLocator {

  private static ClientServiceImpl  clientService = new ClientServiceImpl();

  public ClientServiceImpl createClientServiceInstance() {
    return clientService;
  }
}
```

   2. xml配置文件编写

 文件：`resources/spring-bean-01.xml`  
```xml
<!-- 3. 非静态工厂如何声明ioc配置 -->
    <!-- 3.1 配置工厂类的组件信息 -->
    <bean id="defaultServiceLocator" class="com.hut.ioc_01.DefaultServiceLocator"/>
    <!-- 3.2 通过指定非静态工厂对象和方法名来配置生成的ioc信息 -->
    <bean id="clientService2" factory-bean="defaultServiceLocator" factory-method="createClientServiceInstance"/>
```

   - factory-bean属性：指定当前容器中工厂Bean 的名称
   -  factory-method：指定实例工厂方法名  
   -  注意：实例方法必须是非static的

7. 图解IoC配置流程

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692932991551-2818137f-7666-4000-bad6-8d5f00de573f.png#averageHue=%23f8f4a3&clientId=u540cd631-9d29-4&from=paste&id=uc06a3eb7&originHeight=689&originWidth=1523&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u78a3beb2-a76f-4119-9f10-3c932f3f1fe&title=)

### 4.2.2 实验二：组件（Bean）依赖注入配置（DI）

1. 目标

通过配置文件，实现IoC容器中Bean之间的引用（依赖注入DI配置）。<br />主要涉及注入场景：基于**构造函数**的依赖注入和基于 **Setter** 的依赖注入。

2. 思路

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692949646057-9cece577-760b-4a15-b78a-adeefd10c61c.png#averageHue=%23f7f7f7&clientId=u540cd631-9d29-4&from=paste&height=480&id=u11da8a6f&originHeight=640&originWidth=920&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u57f4dd52-bcc2-40f2-98cb-7a572144733&title=&width=690)

3. 基于构造函数的依赖注入（单个构造参数）
   1. 介绍： 基于构造函数的 DI 是通过容器调用具有多个参数的构造函数来完成的，每个参数表示一个依赖项。  
   2. 准备组件类
```java
package com.hut.ioc_02;

public class UserDao {
}

public class UserService {
    
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
}
```

   3. 编写配置文件

文件：`resources/spring-02.xml`
```xml
<!--引用与被引用的组件必须全部在ioc容器中-->

<!--1. 单个构造参数注入-->
<!--步骤1：将他们都存放在ioc容器中-->
<bean id="userDao" class="com.hut.ioc_02.UserDao"/>
<bean id="userService" class="com.hut.ioc_02.UserService">
  <!--步骤2：在标签内部指定构造参数传值，即DI的配置
    <constructor-arg 构造参数传值的di配置
      value 直接赋值属性值 String name = "hh" int age = 23
      ref 引用其他的bean的Id值
      以上两个二选一
  -->
  <constructor-arg ref="userDao"/>
</bean>
```

   -  `constructor-arg`标签：可以引用构造参数 ref 引用其他bean的标识，也可以用 value 对参数直接赋值

4. 基于构造函数的依赖注入（多构造参数解析）
   1. 介绍： 基于构造函数的 DI 是通过容器调用具有多个参数的构造函数来完成的，每个参数表示一个依赖项  
   2. 准备组件类
```java
public class UserDao {
}


public class UserService {

    private UserDao userDao;

    private int age;

    private String name;

    public UserService(int age , String name ,UserDao userDao) {
        this.userDao = userDao;
        this.age = age;
        this.name = name;
    }
}
```

   3. 编写配置文件
```xml
<!--2. 多个构造参数注入-->
<bean id="userService1" class="com.hut.ioc_02.UserService">
  <!--方案1：构造参数的顺序填写值-->
  <constructor-arg value="18"/>
  <constructor-arg value="阿彬"/>
  <constructor-arg ref="userDao"/>
</bean>

<bean id="userService2" class="com.hut.ioc_02.UserService">
  <!--方案2：构造参数的名称填写，不用考虑顺序，name = 构造参数的名字-->
  <constructor-arg name="name" value="yubin"/>
  <constructor-arg name="age" value= "23"/>
  <constructor-arg name="userDao" ref="userDao"/>
</bean>

<bean id="userService3" class="com.hut.ioc_02.UserService">
  <!--方案3：构造参数的下角标指定填写，不用考虑顺序，index = 构造参数的下角标，从左至右，从0开始-->
  <constructor-arg index="1" value="yubin"/>
  <constructor-arg index="0" value= "23"/>
  <constructor-arg index="2" ref="userDao"/>
</bean>
```

   - constructor-arg标签：指定构造参数和对应的值
   - constructor-arg标签：name属性指定参数名、index属性指定参数角标、value属性指定普通属性值

5. 基于Setter方法依赖注入
   1. 介绍： 开发中，除了构造函数注入（DI），更多的使用的Setter方法进行注入  
   2. 准备组件类
```java
package com.hut.ioc_02;

public class MovieFinder {
}


public class SimpleMovieLister {

  private MovieFinder movieFinder;
  
  private String movieName;

  public void setMovieFinder(MovieFinder movieFinder) {
    this.movieFinder = movieFinder;
  }
  
  public void setMovieName(String movieName){
    this.movieName = movieName;
  }

  // business logic that actually uses the injected MovieFinder is omitted...
}
```

   3. 编写配置文件
```xml
<!--3. 触发setter方法进行注入-->
<bean id="movieFinder" class="com.hut.ioc_02.MovieFinder"/>
<bean id="simpleMovieLister" class="com.hut.ioc_02.SimpleMovieLister">
    <!--
        name: 调用set方法的名
        value / ref 二选一，value="直接属性值" ref="其他bean的Id"
    -->
    <property name="movieName" value="霸王别姬"/>
    <property name="movieFinder" ref="movieFinder"/>
</bean>
```

   - property标签： 可以给setter方法对应的属性赋值
   - property 标签： name属性代表**set方法标识**、ref代表引用bean的标识id、value属性代表基本属性值

**总结：**<br />  依赖注入（DI）包含引用类型和基本数据类型，同时注入的方式也有多种。主流的注入方式为**setter方法**注入和**构造函数**注入<br />  需要特别**注意**：引用其他bean，使用ref属性。直接注入基本类型值，使用value属性。

### 4.2.3 实验三：IoC容器的创建与使用
> 想要配置文件中声明组件类信息真正的进行实例化成Bean对象和形成Bean之间的引用关系，我们需要声明IoC容器对象，读取配置文件，实例化组件和关系维护的过程都是在IoC容器中实现的

1. 容器实例化
```java
/**
 * 创建IoC容器并读取配置文件
 */
public void createIoC() {
    // 创建容器，选择合适的容器
    // 方式1：直接创建容器并且指定配置文件
    // 构造函数(String...配置文件) 可以填写一个或者多个
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

    // 方式2：先创建ioc容器对象，再指定配置文件，最后刷新（源码的配置过程）
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
    classPathXmlApplicationContext.setConfigLocation("spring-03.xml"); // 外部配置文件的设置
    classPathXmlApplicationContext.refresh(); // 调用ioc和di的流程
}
```

2. Bean对象读取
```java
/**
 * 在IoC容器中获取组件Bean
 */
@Test
public void getBeanFromIoC() {
    // 1. 创建ioc容器对象
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
    applicationContext.setConfigLocation("spring-03.xml");
    applicationContext.refresh();

    // 2. 读取ioc容器的组件
    // 方案1：直接根据beanId获取（返回类型是Object，需要强转，故不推荐）
    HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");

    // 方案2：根据beanId，同时指定bean的类型 Class
    HappyComponent happyComponent1 = applicationContext.getBean("happyComponent", HappyComponent.class);

    // 方案3：直接根据类型获取
    // 根据bean的类型和获取，同一个类型，在ioc容器中只能有一个bean
    // ioc的配置一定是实现类，但也可以根据接口类型获取值
    HappyComponent happyComponent2 = applicationContext.getBean(HappyComponent.class);

    happyComponent2.doWork();

    System.out.println(happyComponent == happyComponent1);
    System.out.println(happyComponent2 == happyComponent1);
}
```
