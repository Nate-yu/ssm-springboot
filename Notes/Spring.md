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

### 4.2.4 实验四：组件（Bean）作用域和周期方法配置

1. 组件周期方法配置
   1. 周期方法：我们可以在组件类中定义方法，然后当IoC容器实例化和销毁组件对象的时候进行调用。这两个方法我们成为生命周期方法，类似于Servlet的init/destroy方法，我们可以在周期方法完成初始化和释放资源等工作。
   2. 周期方法声明
```java
public class JavaBean {

    /**
     * 方法必须是public void，且必须是是无参数
     * 方法名随意
     */
    public void init() {
        System.out.println("JavaBean init");
    }

    /**
     * 销毁方法
     */
    public void clear() {
        System.out.println("JavaBean clear");
    }
}
```

   3. 周期方法配置
```xml
<!--
  init-method：指定类中的初始化方法
  destroy-method：指定类中的销毁方法
  spring ioc容器就会在对应的时间节点回调对应的方法
-->
<bean id="javaBean" class="com.hut.ioc_04.JavaBean" init-method="init" destroy-method="clear"/>
```

   4. 测试代码
```java
/**
* 测试ioc配置和销毁方法的触发
*/
@Test
public void test_04() {
    // 1. 创建ioc容器，就会进行组件对象的实例化 -> init
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-04.xml");

    // 2. 正常结束ioc容器
    classPathXmlApplicationContext.close();
}
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693035917342-19c9ec05-1f18-4cf7-9294-8766ca8bb2f8.png#averageHue=%23282a2d&clientId=ub4bdb45a-4da7-4&from=paste&height=224&id=udcd1adb9&originHeight=280&originWidth=1081&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=30447&status=done&style=none&taskId=ufebecf4c-5dc4-4299-b5b3-b09b2b3a116&title=&width=864.8)

2. 组件作用域配置
   1. Bean作用域概念：`<bean`标签声明Bean，只是将Bean的信息配置给SpringIoC容器。在IoC容器中，这些`<bean`标签对应的信息转成Spring内部 `BeanDefinition`对象，`BeanDefinition`对象内，包含定义的信息（id,class,属性等等）这意味着，`BeanDefinition`与`类`概念一样，SpringIoC容器可以可以根据`BeanDefinition`对象反射创建多个Bean对象实例。具体创建多少个Bean的实例对象，由Bean的作用域Scope属性指定
   2. 作用域可选值
| 取值 | 含义 | 创建对象的时机 | 默认值 |
| --- | --- | --- | --- |
| singleton | 在 IOC 容器中，这个 bean 的对象始终为单实例 | IOC 容器初始化时 | 是 |
| prototype | 这个 bean 在 IOC 容器中有多个实例 | 获取 bean 时 | 否 |


如果是在WebApplicationContext环境下还会有另外两个作用域（但不常用）：

| 取值 | 含义 | 创建对象的时机 | 默认值 |
| --- | --- | --- | --- |
| request | 请求范围内有效的实例 | 每次请求 | 否 |
| session | 会话范围内有效的实例 | 每次会话 | 否 |

   3. 作用域配置

配置scope范围
```xml
<!--声明一个组件信息，默认是单例模式：bean在IOC容器中只有一个实例，IOC容器初始化时创建对象-->
<bean id="javaBean2" class="com.hut.ioc_04.JavaBean2" scope="singleton"/>
<!--多例模式：getBean一次，就会创建一个组件对象-->
<bean id="javaBean2" class="com.hut.ioc_04.JavaBean2" scope="prototype"/>
```

   4. 作用域测试
```java
/**
 * 测试ioc配置和销毁方法的触发
 */
@Test
public void test_04() {
    // 1. 创建ioc容器，就会进行组件对象的实例化 -> init
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-04.xml");

    // 单例与多例的测试
    JavaBean2 bean = classPathXmlApplicationContext.getBean(JavaBean2.class);
    JavaBean2 bean1 = classPathXmlApplicationContext.getBean(JavaBean2.class);
    System.out.println(bean == bean1);

    // 2. 正常结束ioc容器
    classPathXmlApplicationContext.close();
}
```
	![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693036256231-b590a9eb-9150-4f5a-ab31-6b9155dbb38e.png#averageHue=%23292b2f&clientId=ub4bdb45a-4da7-4&from=paste&height=263&id=u7b9d2595&originHeight=329&originWidth=964&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=36631&status=done&style=none&taskId=u3eabc536-1c72-4a56-b33b-45740f8463b&title=&width=771.2)

### 4.2.5 实验五：FactoryBean特性和使用

1. FactoryBean简介

 用于配置复杂的Bean对象，可以将创建过程存储在`FactoryBean`的`getObject()`方法中<br />`FactoryBean<T>` 接口提供三种方法：

   -  `T getObject()`:<br />返回此工厂创建的对象的实例。该返回值会被存储到IoC容器
   -  `boolean isSingleton()`:<br />如果此 `FactoryBean` 返回单例，则返回 `true` ，否则返回 `false` 。此方法的默认实现返回 `true` （注意，lombok插件使用，可能影响效果）
   -  `Class<?> getObjectType()`: 

返回 `getObject()` 方法返回的对象类型，如果事先不知道类型，则返回 `null` <br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693039138065-4ce822b8-5871-40ed-b069-a466f41425f7.png#averageHue=%23efefef&clientId=ub4bdb45a-4da7-4&from=paste&id=ua35bcbea&originHeight=319&originWidth=501&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u1c28a23f-0ae1-4aae-aeca-988ad386d84&title=)

2. FactoryBean使用场景
   1. 代理类的创建
   2. 第三方框架整合
   3. 复杂对象实例化

3. FactoryBean应用
   1. 创建实体类
```java
package com.hut.ioc_05;

import lombok.Data;

@Data
public class JavaBean {
    private String name;
}
```

   2. 准备FactoryBean实现类
```java
package com.hut.ioc_05;

import org.springframework.beans.factory.FactoryBean;

/**
 * 制造JavaBean的工厂bean对象
 * 步骤：
 *  1. 实现FactoryBean接口 <返回值泛型>
 */
public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public JavaBean getObject() throws Exception {
        // 使用自己的方式实例化对象
        JavaBean javaBean = new JavaBean();
        javaBean.setName(value);
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }
}
```

   3. 配置FactoryBean实现类
```xml
<!--
    id: getObject()方法返回的对象的标识
    class: factoryBean标准化工厂类
-->
<bean id="javaBean" class="com.hut.ioc_05.JavaBeanFactoryBean">
    <!--此位置的属性是给JavaBean工厂类配置的，而不是getObject方法-->
    <property name="value" value="余彬"/>
</bean>
```

   4.  测试读取FactoryBean和FactoryBean.getObject对象  
```java
/**
 * 读取使用factoryBean工厂配置的组件对象
 */
@Test
public void test_05() {
    // 1. 创建ioc容器，就会进行组件对象的实例化 -> init
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-05.xml");

    // 2. 读取组件
    JavaBean javaBean = classPathXmlApplicationContext.getBean("javaBean", JavaBean.class);
    System.out.println("javaBean = " + javaBean);
    //FactoryBean工厂也会加入到ioc容器：&id，但不会被实例化
    Object javaBean1 = classPathXmlApplicationContext.getBean("&javaBean");
    System.out.println("javaBean1 = " + javaBean1);

    // 3. 正常结束ioc容器
    classPathXmlApplicationContext.close();
}
```
	![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693039559174-3f08cda5-d3c1-4531-aa3f-7a05b1431967.png#averageHue=%23282a2d&clientId=ub4bdb45a-4da7-4&from=paste&height=225&id=u0b09693a&originHeight=281&originWidth=1195&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=36327&status=done&style=none&taskId=u15c2a181-173c-4a22-87d8-bbac7316f58&title=&width=956)

4.  FactoryBean和BeanFactory区别<br />**	FactoryBean **是 Spring 中一种特殊的 bean，可以在 getObject() 工厂方法自定义的逻辑创建Bean。是一种能够生产其他 Bean 的 Bean。FactoryBean 在容器启动时被创建，而在实际使用时则是通过调用 getObject() 方法来得到其所生产的 Bean。因此，FactoryBean 可以自定义任何所需的初始化逻辑，生产出一些定制化的 bean。一般情况下，整合第三方框架，都是通过定义FactoryBean实现<br />**	BeanFactory** 是 Spring 框架的基础，其作为一个顶级接口定义了容器的基本行为，例如管理 bean 的生命周期、配置文件的加载和解析、bean 的装配和依赖注入等。BeanFactory 接口提供了访问 bean 的方式，例如 getBean() 方法获取指定的 bean 实例。它可以从不同的来源（例如 Mysql 数据库、XML 文件、Java 配置类等）获取 bean 定义，并将其转换为 bean 实例。同时，BeanFactory 还包含很多子类（例如，ApplicationContext 接口）提供了额外的强大功能。<br />	总的来说，FactoryBean 和 BeanFactory 的区别主要在于前者是用于**创建 bean 的接口**，它提供了更加灵活的初始化定制功能，而后者是用于**管理 bean 的框架基础接口**，提供了基本的容器功能和 bean 生命周期管理。 

### 4.2.6 实验六：基于XML方式整合三层架构组件

1. 需求分析

搭建一个三层架构案例，模拟查询全部学生（学生表）信息，持久层使用JdbcTemplate和Druid技术，使用XML方式进行组件管理<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693099334895-2bbc7203-bbee-45b2-a129-f3b582235cf5.png#averageHue=%23f9f8f3&clientId=u668ebf16-e262-4&from=paste&height=480&id=u74fda4d6&originHeight=959&originWidth=1563&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=184538&status=done&style=none&taskId=u024e5357-0848-4029-a5d2-d891e93d0b8&title=&width=782)

2. 数据库准备
```java
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE database studb;

use studb;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `class` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (1, '张三', '男', 20, '高中一班');
INSERT INTO `students` VALUES (2, '李四', '男', 19, '高中二班');
INSERT INTO `students` VALUES (3, '王五', '女', 18, '高中一班');
INSERT INTO `students` VALUES (4, '赵六', '女', 20, '高中三班');
INSERT INTO `students` VALUES (5, '刘七', '男', 19, '高中二班');
INSERT INTO `students` VALUES (6, '陈八', '女', 18, '高中一班');
INSERT INTO `students` VALUES (7, '杨九', '男', 20, '高中三班');
INSERT INTO `students` VALUES (8, '吴十', '男', 19, '高中二班');

SET FOREIGN_KEY_CHECKS = 1;
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693099624798-b0d85155-3ce7-4ac8-86e1-17ef1fbef0d3.png#averageHue=%23222428&clientId=u668ebf16-e262-4&from=paste&height=331&id=u5b909d8e&originHeight=414&originWidth=814&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=43447&status=done&style=none&taskId=ud1f6f4c6-9385-4c68-80c9-cac25570ac3&title=&width=651.2)

3. 项目准备
   1. spring-ioc-xml-practice-02
   2. 在父工程中导入依赖
```xml
<!-- 数据库驱动和连接池-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.25</version>
</dependency>

<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.8</version>
</dependency>

<!-- spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>6.0.6</version>
</dependency>
```

   3. 实体类准备
```java
package com.hut.pojo;

import lombok.Data;

@Data
public class Student {

    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String classes;

}
```

4. JdbcTemplate技术
   1. jdbc.properties进行提取数据库连接信息
```properties
jdbc.url=jdbc:mysql://localhost:3306/studb?useUnicode=true&characterEncoding=UTF-8
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.username=root
jdbc.password=root
```
	注意：

      1. 每个key需要有前缀扩展名，比如上面就是`jdbc.xxx`，否则会出现报错：Access denied for user 'xxx'@'localhost' (using password: YES)
      2. url在指定数据库后必须加上`?useUnicode=true&characterEncoding=UTF-8`来指定编码，否则在插入中文数据的时候会出现乱码
   2. springioc配置文件（spring-01.xml）
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

    <!--读取外部配置文件 .properties: value = "${key}"
        如：<context:property-placeholder location="classpath:jdbc.properties, classpath:其他配置文件"/>
    -->
    <context:property-placeholder location="classpath:jdbc.properties"/>
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="url" value="${jdbc.url}"/>
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>

    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>
</beans>
```

   3.  基于jdbcTemplate的CRUD使用
```java
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
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693100522224-507db45b-f50a-41b6-945e-d61936a46c58.png#averageHue=%23242629&clientId=u668ebf16-e262-4&from=paste&height=222&id=u71e0033f&originHeight=278&originWidth=2368&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=55173&status=done&style=none&taskId=ucbbb8775-d0f4-49cc-ab7d-610031a5864&title=&width=1894.4)<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693100555871-0da41b1c-a24a-445c-b12d-43fc8e65f2ee.png#averageHue=%23212327&clientId=u668ebf16-e262-4&from=paste&height=335&id=u8cc42b79&originHeight=419&originWidth=814&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=42095&status=done&style=none&taskId=ude3bb923-8eb0-4e5c-8fe0-41e978f2e8d&title=&width=651.2)

5. 三层架构搭建和实现
   1. 持久层
```java
/**
 * 数据层接口
 */
public interface StudentDao {

    /**
     *  查询所有学生
     * @return
     */
    List<Student> queryAll();
}

/**
 * 数据层实现类
 */
public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    /**
     * 注入jdbcTemplate对象
     * @param jdbcTemplate
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> queryAll() {
        String sql = "select id, name, gender, age, class as classes from students";
        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println("studentDao: " + students);
        return students;
    }
}
```

   2. 业务层
```java
/**
 * 学生业务接口
 */
public interface StudentService {

    /**
     * 查询所有学生
     * @return
     */
    List<Student> findAll();
}

/**
 * 业务层实现类
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        System.out.println("studentService: " + studentList);
        return studentList;
    }
}
```

   3. 表述层
```java
public class StudentController {

    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void findAll() {
        List<Student> all = studentService.findAll();
        System.out.println("最终所有学员数据为：" + all);
    }
}
```

6. 三层架构IoC配置（spring-02.xml）
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

    <context:property-placeholder location="jdbc.properties"/>
    <!--Druid-->
    <bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>

    <!--jdbcTemplate-->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="druidDataSource"/>
    </bean>

    <!--dao配置注入jdbcTemplate-->
    <bean id="studentDao" class="com.hut.dao.impl.StudentDaoImpl">
        <property name="jdbcTemplate" ref="jdbcTemplate"/>
    </bean>

    <!--service配置注入dao-->
    <bean id="studentService" class="com.hut.service.impl.StudentServiceImpl">
        <property name="studentDao" ref="studentDao"/>
    </bean>

    <!--controller配置注入service-->
    <bean id="studentController" class="com.hut.controller.StudentController">
        <property name="studentService" ref="studentService"/>
    </bean>
</beans>
```

7. 测试
```java
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
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693100623423-5bc2351b-0477-42ad-b3de-629647fd7161.png#averageHue=%2326282c&clientId=u668ebf16-e262-4&from=paste&height=229&id=u003cdab1&originHeight=286&originWidth=2284&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=79476&status=done&style=none&taskId=u53a72901-86ad-48b5-bd58-153799ce9f7&title=&width=1827.2)

8. XMLIoC方式缺点
   1. 注入的属性必须添加setter方法、代码结构乱
   2. 配置文件和Java代码分离、编写不是很方便
   3. XML配置文件解析效率低

## 4.3 基于注解方式管理Bean
### 4.3.1 实验一：Bean注解标记和扫描（IoC）

1. 注解： 和 XML 配置文件一样，注解本身并不能执行，注解本身仅仅只是做一个标记，具体的功能是框架检测到注解标记的位置，然后针对这个位置按照注解标记的功能来执行具体操作。 XML 和注解只是告诉框架中的 Java 代码如何执行
2. 扫描：Spring 为了知道程序员在哪些地方标记了什么注解，就需要通过扫描的方式，来进行检测。然后根据注解进行后续操作。
3. 准备Spring项目和组件
   1. 准备项目（spring-ioc-annotation）
   2. 准备组件类

普通组件
```java
package com.hut.ioc_01;

import org.springframework.stereotype.Component;

/**
 *
 * description: 普通的组件
 * 1. 标记注解
 * 2. 配置指定包
 */
@Component
public class CommonComponent {
}
```
Controller组件
```java
package com.hut.ioc_01;

import org.springframework.stereotype.Controller;

/**
 *
 * description: controller类型组件
 */
//@Controller // 默认id：xxxController
@Controller("xxx")
public class XxxController {
}
```
Service组件
```java
package com.hut.ioc_01;

import org.springframework.stereotype.Service;

/**
 *
 * description: service类型组件
 */
@Service
public class XxxService {
}
```
		Dao组件
```java
package com.hut.ioc_01;

import org.springframework.stereotype.Repository;

/**
 *
 * description: dao类型组件
 */
@Repository
public class XxxDao {
}
```

4. 组件添加标记注解
   1. 组件标记注解的区别

Spring 提供了以下多个注解，这些注解可以直接标注在 Java 类上，将它们定义成 Spring Bean。

| 注解 | 说明 |
| --- | --- |
| [@Component ](/Component ) | 该注解用于描述 Spring 中的 Bean，它是一个泛化的概念，仅仅表示容器中的一个组件（Bean），并且可以作用在应用的任何层次，例如 Service 层、Dao 层等。 使用时只需将该注解标注在相应类上即可。 |
| [@Repository ](/Repository ) | 该注解用于将数据访问层（Dao 层）的类标识为 Spring 中的 Bean，其功能与 [@Component ](/Component )相同。  |
| [@Service ](/Service ) | 该注解通常作用在业务层（Service 层），用于将业务层的类标识为 Spring 中的 Bean，其功能与 [@Component ](/Component )相同。  |
| [@Controller ](/Controller ) | 该注解通常作用在控制层（如SpringMVC 的 Controller），用于将控制层的类标识为 Spring 中的 Bean，其功能与 [@Component ](/Component )相同。  |

@Controller、@Service、@Repository这三个注解只是在@Component注解的基础上起了三个新的名字

   2. 使用注解标记（代码如上）

5. 配置文件确定扫描范围
   1. 基本扫描配置
```xml
<!--1. 普通配置包扫描
        base-package: 指定ioc容器去哪些包下查找注解类
        可以是一个包或多个包
        指定包相当于指定了子包内的所有类
-->
<context:component-scan base-package="com.hut.ioc_01"/>
```

   2. 指定排除组件
```xml
<!--2. 指定包，但排除注解-->
<context:component-scan base-package="com.hut.ioc_01">
    <!-- context:exclude-filter标签：指定排除规则 -->
    <!-- type属性：指定根据什么来进行排除，annotation取值表示根据注解来排除 -->
    <!-- expression属性：指定排除规则的表达式，对于注解来说指定全类名即可 -->
    <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
</context:component-scan>
```

   3. 指定扫描组件
```xml
<!--3. 指定包，指定包含注解-->
<!--base-package表示包下所有注解都生效，use-default-filters表示指定包的所有注解先不生效-->
<context:component-scan base-package="com.hut" use-default-filters="false">
    <!--只扫描包下的注解-->
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
</context:component-scan>
```

6. BeanName问题

在我们使用 XML 方式管理 bean 的时候，每个 bean 都有一个唯一标识——id 属性的值，便于在其他地方引用。现在使用注解后，每个组件仍然应该有一个唯一标识。<br />默认情况：<br />类名首字母小写就是 bean 的 id。例如：SoldierController 类对应的 bean 的 id 就是 soldierController。<br />使用value属性指定：
```java
@Controller(value = "tianDog")
public class SoldierController {
}
```
 当注解中只设置一个属性时，value属性的属性名可以省略：  
```java
@Service("smallDog")
public class SoldierService {
}
```

7. 总结
   1. 注解方式IoC只是标记哪些类要被Spring管理
   2. 最终，我们还需要XML方式或者Java配置类方式指定注解生效的包
   3. 现阶段配置方式为 注解 （标记）+ XML（扫描）

### 4.3.2 实验二：组件作用域和周期方法（注解）

1. 周期方法声明与组件作用域配置
```java
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON) // 单例
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 多例
@Component
public class JavaBean {

    @PostConstruct
    public void init() {
        System.out.println("JavaBean init...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("JavaBean destroy...");
    }
}
```

2. 编写扫描包的配置文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.hut.ioc_02"/>
</beans>
```

3. 测试周期方法与作用域
```java
@Test
public void testIoC_02() {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
    JavaBean bean = applicationContext.getBean(JavaBean.class);
    JavaBean bean1 = applicationContext.getBean(JavaBean.class);
    System.out.println(bean == bean1);
    applicationContext.close();
}
```
多例：执行两次init方法，不执行destroy方法，且实例化两个对象<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693122882934-e0edb108-28e1-4e8d-b9a9-0609b18da998.png#averageHue=%23292b2f&clientId=u5792e403-addf-4&from=paste&height=261&id=u23554286&originHeight=326&originWidth=965&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=36199&status=done&style=none&taskId=u82e060ca-8609-4762-94ee-5e9f9d4462d&title=&width=772)<br />单例：执行一次init方法和一次destroy方法，且只实例化一个对象<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693122974422-2d14c595-5376-4a49-9271-7e97d2cf2c66.png#averageHue=%232a2c2f&clientId=u5792e403-addf-4&from=paste&height=263&id=ue36f02f7&originHeight=329&originWidth=946&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=37058&status=done&style=none&taskId=ua118d6b5-244a-4fbb-8208-67dc56dc818&title=&width=756.8)

### 4.3.3 实验三：Bean属性赋值（引用类型自动装配）

1. 组件声明
   1. UserController
```java
package com.hut.ioc_03;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    //@Autowired // 自动注入（DI）：1. 去ioc容器中查找复合类型的组件对象 2. 设置当前属性
    @Resource(name = "userServiceImpl")
    private UserService userService;

    /**
     * 调用业务层方法
     */
    public void show() {
        String show = userService.show();
        System.out.println(show);
    }
}

```

   2. UseService
```java
package com.hut.ioc_03;

public interface UserService {

    public String show();
}

@Service
public class UserServiceImpl implements UserService{
    @Override
    public String show() {
        return "UserServiceImpl show()";
    }
}
```

2. 自动装配
   1. 前提： 参与自动装配的组件（需要装配、被装配）全部都必须在IoC容器中。不区分IoC的方式，XML和注解都可以
   2.  @Autowired注解：在成员变量上直接标记@Autowired注解即可，不需要提供setXxx()方法（如上UserController类）

3. @Autowired注解细节
   1. 标记位置
      1. 成员变量（最主要的方式）

 与xml进行bean ref引用不同，他不需要有set方法
```java
@Controller
public class UserController {

    @Autowired // 自动注入（DI）：1. 去ioc容器中查找复合类型的组件对象 2. 设置当前属性
    private UserService userService;

    /**
     * 调用业务层方法
     */
    public void show() {
        String show = userService.show();
        System.out.println(show);
    }
}
```

      2. 构造器
```java
@Controller(value = "tianDog")
public class SoldierController {
    
    private SoldierService soldierService;
    
    @Autowired
    public SoldierController(SoldierService soldierService) {
        this.soldierService = soldierService;
    }
    ……
```

      3. setXxx()方法
```java
@Controller(value = "tianDog")
public class SoldierController {

    private SoldierService soldierService;

    @Autowired
    public void setSoldierService(SoldierService soldierService) {
        this.soldierService = soldierService;
    }
    ……
```

   2. 工作流程

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693208215859-f8df5dcd-3360-4280-9ac2-c601d49e8a31.png#averageHue=%23f4f4f4&clientId=uf54b58bd-0032-4&from=paste&id=u9e04f68d&originHeight=373&originWidth=419&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u69715450-c3fe-4b4f-88cd-2779224d3bb&title=)

   - 首先根据所需要的组件类型到 IOC 容器中查找 
   - 能够找到唯一的 bean：直接执行装配
   - 如果完全找不到匹配这个类型的 bean：装配失败
   - 和所需类型匹配的 bean 不止一个 
      - 没有 [@Qualifier ](/Qualifier ) 注解：根据 [@Autowired ](/Autowired ) 标记位置成员变量的变量名作为 bean 的 id 进行匹配  
         - 能够找到：执行装配
         - 找不到：装配失败
      - 使用 [@Qualifier ](/Qualifier ) 注解：根据 [@Qualifier ](/Qualifier ) 注解中指定的名称作为 bean 的id进行匹配  
         - 能够找到：执行装配
         - 找不到：装配失败
```java
@Controller(value = "tianDog")
public class SoldierController {
    
    @Autowired
    @Qualifier(value = "maomiService222")
    // 根据面向接口编程思想，使用接口类型引入Service组件
    private ISoldierService soldierService;
```

4. @Resource注解
>  标识一个需要注入的资源，是实现Java EE组件之间依赖关系的一种方式  

   1. 与@Autowired注解的区别
      - @Resource注解是JDK扩展包中的，也就是说属于JDK的一部分。所以该注解是标准注解，更加具有通用性。(JSR-250标准中制定的注解类型。JSR是Java规范提案。)
      - @Autowired注解是Spring框架自己的。
      - **@Resource注解默认根据Bean名称装配，未指定name时，使用属性名作为name。通过name找不到的话会自动启动通过类型装配。**
      - **@Autowired注解默认根据类型装配，如果想根据名称装配，需要配合@Qualifier注解一起用。**
      - @Resource注解用在属性上、setter方法上。
      - @Autowired注解用在属性上、setter方法上、构造方法上、构造方法参数上。
   2.  @Resource注解属于JDK扩展包，所以不在JDK当中，需要额外引入以下依赖（高于JDK11或低于JDK8）：
```xml
<dependency>
    <groupId>jakarta.annotation</groupId>
    <artifactId>jakarta.annotation-api</artifactId>
    <version>2.1.1</version>
</dependency>
```

   3. @Resource注解的使用
```java
@Controller
public class XxxController {
    /**
     * 1. 如果没有指定name,先根据属性名查找IoC中组件xxxService
     * 2. 如果没有指定name,并且属性名没有对应的组件,会根据属性类型查找
     * 3. 可以指定name名称查找!  @Resource(name='test') == @Autowired + @Qualifier(value='test')
     */
    @Resource
    private XxxService xxxService;

    //@Resource(name = "指定beanName")
    //private XxxService xxxService;

    public void show(){
        System.out.println("XxxController.show");
        xxxService.show();
    }
}
```

### 4.3.4 实验四：基本类型属性赋值（Bean属性赋值）
> `@Value` 通常用于注入外部化属性

**声明外部配置**<br />jdbc.properties
```java
jdbc.username = root
jdbc.password = root
```

**xml引入外部配置**
```java
<context:component-scan base-package="com.hut.ioc_04"/>
<context:property-placeholder location="classpath:jdbc.properties"/>
```

**@Value注解读取配置**
```java
@Component
@Data
public class JavaBean {
    @Value("张三") // 注解赋值，主要用于读取外部配置
    private String name;

    // 情况1: ${key} 取外部配置key对应的值
    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;
    
	// 情况2: ${key:defaultValue} 没有key,可以给与默认值
    @Value("${jdbc.age:19}")
    private int age;
}
```


**测试**
```java
@Test
public void testIoC_04() {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");
    com.hut.ioc_04.JavaBean bean = applicationContext.getBean(com.hut.ioc_04.JavaBean.class);
    System.out.println("bean = " + bean);
    applicationContext.close();
}
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693209784415-2810085d-8882-4ed6-977a-07610a057cfd.png#averageHue=%2327282c&clientId=uf54b58bd-0032-4&from=paste&height=232&id=u90714a4e&originHeight=290&originWidth=1309&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=31462&status=done&style=none&taskId=u691a4f45-cdf9-4c53-a1d8-e68266a9b8f&title=&width=1047.2)

### 4.3.5 实验五：基于注解 + XML方式整合三层架构组件

1. 需求与数据库准备见[https://www.yuque.com/abiny/java/fsge8ad9mdmlx7g6#TlxfP](#TlxfP)
2. 项目准备
   1. 项目名：spring-annotation-practice-04
   2. 父项目导入新依赖：
```xml
<!-- @Resource -->
<dependency>
    <groupId>jakarta.annotation</groupId>
    <artifactId>jakarta.annotation-api</artifactId>
    <version>2.1.1</version>
</dependency>

<!-- lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.22</version>
    <scope>compile</scope>
</dependency>
```

   3. 实体类
```java
package com.hut.pojo;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String classes;
}
```

4. 三层架构搭建与实现
   1. 注意：使用`@Resource`注解必须导入依赖`import jakarta.annotation.Resource;`
   2. 持久层
```java
// 接口
public interface StudentDao {
    /**
     * 查询全部学生数据
     * @return
     */
    List<Student> getAll();
}

// 实现类
@Repository
public class StudentDaoImpl implements StudentDao {

    @Resource
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Student> getAll() {
        String sql = "select id , name , age , gender , class as classes from students ;";
        /*
          query可以返回集合
          BeanPropertyRowMapper就是封装好RowMapper的实现,要求属性名和列名相同即可
         */
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }
}
```

   3. 业务层
```java
public interface StudentService {

    /**
     * 查询全部学生业务
     * @return
     */
    List<Student> getAllStudents();
}

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAll();
    }
}
```

   4. 表述层
```java
@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    // 查询所有学生
    public void getAllStudent() {
        List<Student> allStudents = studentService.getAllStudents();
        System.out.println("allStudents = " + allStudents);
    }
}
```

5. 配置文件准备
   1. jdbc.properties
```properties
jdbc.url=jdbc:mysql://localhost:3306/studb?useUnicode=true&characterEncoding=UTF-8
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.username=root
jdbc.password=root
```

   2. spring-ioc.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
    <!--扫描注解-->
    <context:component-scan base-package="com.hut"/>
    <!--导入外部文件-->
    <context:property-placeholder location="classpath:jdbc.properties"/>
    <!--配置数据源-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>

    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>

</beans>
```

6. 运行测试
```java
public class SpringTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
        StudentController studentController = applicationContext.getBean(StudentController.class);
        studentController.getAllStudent();
        applicationContext.close();
    }
}
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693234875339-c6448f2c-b3cc-4590-8c66-a6e14fd21d00.png#averageHue=%2326282b&clientId=ucf8e2c86-364d-4&from=paste&height=229&id=u7b32eb04&originHeight=286&originWidth=1620&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=61683&status=done&style=none&taskId=u62fc3dcf-d836-46b3-93e1-a65e9b50bb4&title=&width=1296)

7. 注解+XML IoC方式问题总结 
   1. 自定义类可以使用注解方式，但是第三方依赖的类依然使用XML方式！
   2. XML格式解析效率低！

## 4.4 基于配置类方式管理Bean
### 4.4.1 完全注解开发
> Spring 完全注解配置（Fully Annotation-based Configuration）是指通过 Java配置类 代码来配置 Spring 应用程序，使用注解来替代原本在 XML 配置文件中的配置。相对于 XML 配置，完全注解配置具有更强的类型安全性和更好的可读性。

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693270189747-e81ea174-f144-49da-9bcf-0d4e6cc408ba.png#averageHue=%23fbfbfb&clientId=u052a4485-9d86-4&from=paste&id=u37af4057&originHeight=574&originWidth=927&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=ud97772d1-a158-4237-a2bd-4ef5d828172&title=)

### 4.4.2 实验一：配置类和扫描注解
使用 @Configuration 注解将一个普通的类标记为 Spring 的配置类。
```java
/**
 * java配置类，替代xml配置文件
 * 1. 包扫描注解配置
 * 2. 引用外部的配置文件
 * 3. 声明第三方依赖的bean组件
 */
@Configuration // 标注当前类是配置类，替代application.xml 
@ComponentScan("com.hut.ioc_01") //使用@ComponentScan注解,可以配置扫描包,替代<context:component-scan标签
@PropertySource("classpath:jdbc.properties") //使用注解读取外部配置，替代 <context:property-placeholder标签
public class JavaConfiguration {
}
```

测试创建IoC容器  
```java
// AnnotationConfigApplicationContext 根据配置类创建 IOC 容器对象
ApplicationContext iocContainerAnnotation = new AnnotationConfigApplicationContext(JavaConfiguration.class);
```
可以使用无参构造函数实例化 `AnnotationConfigApplicationContext` ，然后使用 `register()` 方法对其进行配置。此方法在以编程方式生成 `AnnotationConfigApplicationContext` 时特别有用：
```java
// AnnotationConfigApplicationContext-IOC容器对象
ApplicationContext iocContainerAnnotation = new AnnotationConfigApplicationContext();
//外部设置配置类
iocContainerAnnotation.register(JavaConfiguration.class);
//刷新后方可生效！！
iocContainerAnnotation.refresh();
```
测试代码
```java
@Test
public void test() {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);
    StudentController controller = applicationContext.getBean(StudentController.class);
    System.out.println("controller = " + controller);
}
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693270554436-00d28a80-b780-4366-84c6-838577554e04.png#averageHue=%2327292c&clientId=u052a4485-9d86-4&from=paste&height=232&id=uc75d0fea&originHeight=290&originWidth=1184&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=28792&status=done&style=none&taskId=uaf7a91c4-f953-4dd1-ace5-f2d55f2b450&title=&width=947.2)

总结：

- @Configuration指定一个类为配置类，可以添加配置注解，替代配置xml文件
- @ComponentScan(basePackages = {"包","包"}) 替代<context:component-scan标签实现注解扫描
- @PropertySource("classpath:配置文件地址") 替代 <context:property-placeholder标签
- 配合IoC/DI注解，可以进行完整注解开发

### 4.4.3 实验二：@Bean定义组件
**场景需求**：将Druid连接池对象存储到IoC容器<br />**需求分析**：第三方jar包的类，添加到ioc容器，无法使用@Component等相关注解。因为源码jar包内容为只读模式<br />**配置类方式实现**： `@Bean`注释用于指示方法实例化、配置和初始化要由Spring IoC容器管理的新对象。对于那些熟悉 Spring 的`<beans/>`XML 配置的人来说，`@Bean` 注释与 `<beans/>`元素起着相同的作用。 
```java
/**
 * java配置类，替代xml配置文件
 * 1. 包扫描注解配置
 * 2. 引用外部的配置文件
 * 3. 声明第三方依赖的bean组件
 */
@Configuration
@ComponentScan("com.hut.ioc_01")
@PropertySource("classpath:jdbc.properties")
public class JavaConfiguration {

    @Bean
    public DruidDataSource dataSource(@Value("${jdbc.driver}") String driver,
                                      @Value("${jdbc.url}") String url,
                                      @Value("${jdbc.username}") String username,
                                      @Value("${jdbc.password}") String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
```

### 4.4.4 实验三：@Bean注解细节

1. @Bean生成BeanName问题  

指定@Bean的名称：
```java
@Configuration
public class AppConfig {

  @Bean("myThing") //指定名称
  public Thing thing() {
    return new Thing();
  }
}
```

`@Bean` 注释方法。使用此方法在指定为方法返回值的类型的 `ApplicationContext` 中注册 Bean 定义。缺省情况下，Bean 名称与方法名称相同。下面的示例演示 `@Bean` 方法声明：
```java
@Configuration
public class AppConfig {

  @Bean
  public TransferServiceImpl transferService() {
    return new TransferServiceImpl();
  }
}
```

前面的配置完全等同于下面的Spring XML：
```java
<beans>
  <bean id="transferService" class="com.acme.TransferServiceImpl"/>
</beans>
```

2.  **@Bean初始化和销毁方法指定 **<br />`@Bean` 注解支持指定任意初始化和销毁回调方法，非常类似于 Spring XML 在 `bean` 元素上的 `init-method` 和 `destroy-method` 属性，如以下示例所示： 
```java
public class BeanOne {

  public void init() {
    // initialization logic
  }
}

public class BeanTwo {

  public void cleanup() {
    // destruction logic
  }
}

@Configuration
public class AppConfig {

  @Bean(initMethod = "init")
  public BeanOne beanOne() {
    return new BeanOne();
  }

  @Bean(destroyMethod = "cleanup")
  public BeanTwo beanTwo() {
    return new BeanTwo();
  }
}
```

3.  **@Bean Scope作用域 **<br />可以指定使用 `@Bean` 注释定义的 bean 应具有特定范围。您可以使用在 Bean 作用域部分中指定的任何标准作用域。<br />默认作用域为 `singleton` ，但您可以使用 `@Scope` 注释覆盖此范围，如以下示例所示： 
```java
@Configuration
public class MyConfiguration {

  @Bean
  @Scope("prototype")
  public Encryptor encryptor() {
    // ...
  }
}
```

1.  **@Bean方法之间依赖**<br />准备组件 
```java
public class HappyMachine {
    
    private String machineName;
    
    public String getMachineName() {
        return machineName;
    }
    
    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }
}
```

```java
public class HappyComponent {
    //引用新组件
    private HappyMachine happyMachine;

    public HappyMachine getHappyMachine() {
        return happyMachine;
    }

    public void setHappyMachine(HappyMachine happyMachine) {
        this.happyMachine = happyMachine;
    }

    public void doWork() {
        System.out.println("HappyComponent.doWork");
    }

}
```

**Java配置类实现：**<br />方案1：<br />直接调用方法返回 Bean 实例：在一个 `@Bean`方法中直接调用其他 `@Bean` 方法来获取 Bean 实例，虽然是方法调用，也是通过IoC容器获取对应的Bean，例如：
```java
@Configuration
public class JavaConfig {

    @Bean
    public HappyMachine happyMachine(){
        return new HappyMachine();
    }

    @Bean
    public HappyComponent happyComponent(){
        HappyComponent happyComponent = new HappyComponent();
        //直接调用方法即可! 
        happyComponent.setHappyMachine(happyMachine());
        return happyComponent;
    }

}
```

方案2：<br />参数引用法：通过方法参数传递 Bean 实例的引用来解决 Bean 实例之间的依赖关系，例如：
```java
package com.atguigu.config;

import com.atguigu.ioc.HappyComponent;
import com.atguigu.ioc.HappyMachine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * projectName: com.atguigu.config
 * description: 配置HappyComponent和HappyMachine关系
 */

@Configuration
public class JavaConfig {

    @Bean
    public HappyMachine happyMachine(){
        return new HappyMachine();
    }

    /**
     * 可以直接在形参列表接收IoC容器中的Bean!
     *    情况1: 直接指定类型即可
     *    情况2: 如果有多个bean,(HappyMachine 名称 ) 形参名称等于要指定的bean名称!
     *           例如:
     *               @Bean
     *               public Foo foo1(){
     *                   return new Foo();
     *               }
     *               @Bean
     *               public Foo foo2(){
     *                   return new Foo()
     *               }
     *               @Bean
     *               public Component component(Foo foo1 / foo2 通过此处指定引入的bean)
     */
    @Bean
    public HappyComponent happyComponent(HappyMachine happyMachine){
        HappyComponent happyComponent = new HappyComponent();
        //赋值
        happyComponent.setHappyMachine(happyMachine);
        return happyComponent;
    }

}
```

### 4.4.5 实验四：@Import注解
`@Import` 注释允许从另一个配置类加载 `@Bean` 定义，如以下示例所示：
```java
@Configuration
@Import({ConfigB.class})
public class ConfigA {
}
```
```java
@Configuration
public class ConfigB {
}
```

 现在，在实例化上下文时不需要同时指定 ConfigA.class 和 ConfigB.class ，只需显式提供 ConfigB，测试如下
```java
@Test
public void test2() {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigA.class);
    ConfigA beanA = applicationContext.getBean(ConfigA.class);
    ConfigB beanB = applicationContext.getBean(ConfigB.class);
    System.out.println("beanA = " + beanA);
    System.out.println("beanB = " + beanB);
}
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693276406918-8e02c234-94ef-47ff-9198-563951a7b997.png#averageHue=%2327282c&clientId=u052a4485-9d86-4&from=paste&height=280&id=u35143e31&originHeight=350&originWidth=1258&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=39097&status=done&style=none&taskId=u6557e62d-5ce5-4358-b260-1bfc6029129&title=&width=1006.4)

### 4.4.6 实验五：基于注解+配置类方式整合三层架构组件
实体类与三层架构搭建见：[https://www.yuque.com/abiny/java/fsge8ad9mdmlx7g6#tlXjX](#tlXjX)<br />三层架构IoC配置类
```java
@Configuration
@ComponentScan(basePackages = "com.hut")
@PropertySource(value = "classpath:jdbc.properties")
public class JavaConfig {

    @Bean
    public DruidDataSource dataSource(@Value("${jdbc.driver}") String driver,
                                      @Value("${jdbc.url}") String url,
                                      @Value("${jdbc.username}") String username,
                                      @Value("${jdbc.password}") String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
```

运行测试
```java
public class JavaTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentController controller = applicationContext.getBean(StudentController.class);
        controller.getAllStudent();
        applicationContext.close();
    }
}
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693277806522-42d034ca-9ad0-4655-8c2a-3384ae1b7969.png#averageHue=%2325262a&clientId=u052a4485-9d86-4&from=paste&height=319&id=u10ec07f9&originHeight=399&originWidth=2133&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=77591&status=done&style=none&taskId=uadbdc4dc-edf8-4029-83f9-8a6c83aac97&title=&width=1706.4)<br />注解+配置类 IoC方式总结：

- 完全摒弃了XML配置文件
- 自定义类使用IoC和DI注解标记
- 第三方类使用配置类声明方法+@Bean方式处理
- 完全注解方式（配置类+注解）是现在主流配置方式

## 4.5 三种配置方式总结
### 4.5.1 XML方式配置总结
  1. 所有内容写到xml格式配置文件中<br />  2. 声明bean通过<bean标签<br />  3. <bean标签包含基本信息（id,class）和属性信息 <property name value / ref<br />  4. 引入外部的properties文件可以通过<context:property-placeholder<br />  5. IoC具体容器实现选择ClassPathXmlApplicationContext对象

### 4.5.2 XML+注解方式配置总结
  1. 注解负责标记IoC的类和进行属性装配<br />  2. xml文件依然需要，需要通过<context:component-scan标签指定注解范围<br />  3. 标记IoC注解：@Component，@Service，@Controller，@Repository <br />  4. 标记DI注解：@Autowired @Qualifier @Resource @Value<br />  5. IoC具体容器实现选择ClassPathXmlApplicationContext对象

### 4.5.3 完全注解方式配置总结
  1. 完全注解方式指的是去掉xml文件，使用配置类 + 注解实现<br />  2. xml文件替换成使用@Configuration注解标记的类<br />  3. 标记IoC注解：@Component,@Service,@Controller,@Repository <br />  4. 标记DI注解：@Autowired @Qualifier @Resource @Value<br />  5. <context:component-scan标签指定注解范围使用@ComponentScan(basePackages = {"com.atguigu.components"})替代<br />  6. <context:property-placeholder引入外部配置文件使用@PropertySource({"classpath:application.properties","classpath:jdbc.properties"})替代<br />  7. <bean 标签使用@Bean注解和方法实现<br />  8. IoC具体容器实现选择AnnotationConfigApplicationContext对象

## 4.6 整合 Spring5-Test5搭建测试环境

1.  整合测试环境作用<br />好处1：不需要自己创建IOC容器对象了<br />好处2：任何需要的bean都可以在测试类中直接享受自动装配 
2. 父项目导入相关依赖
```xml
<!--junit5测试-->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.3.1</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>6.0.6</version>
    <scope>test</scope>
</dependency>
```

3. 整合测试注解（@SpringJUnitConfig）使用
```java
//@SpringJUnitConfig(locations = {"classpath:spring-context.xml"})  //指定配置文件xml
@SpringJUnitConfig(classes = {JavaConfig.class}) // 指定配置类
public class JavaTest {
    @Autowired
    private A a;
    @Autowired
    private B b;
    @Test
    public void test() {
        System.out.println(a);
        System.out.println(b);
    }
}
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693278912686-dbe5e704-fc13-4045-874c-a34e1a2e4328.png#averageHue=%23282a2e&clientId=u052a4485-9d86-4&from=paste&height=301&id=ua71f5992&originHeight=376&originWidth=964&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=32358&status=done&style=none&taskId=u2befd97f-30f5-41d7-ac66-d184da75737&title=&width=771)

# 5 Spring AOP面向切面编程
## 5.1 场景设定

1. 准备AOP项目

项目名：spring-aop-annotation-08

2. 声明接口
```java
/**
 *  + - * / 运算的标准接口!
 */
public interface Calculator {
    
    int add(int i, int j);
    
    int sub(int i, int j);
    
    int mul(int i, int j);
    
    int div(int i, int j);
    
}
```

3. 接口实现
```java
/**
 * 实现计算接口,单纯添加 + - * / 实现
 */
public class CalculatorPureImpl implements Calculator {
    
    @Override
    public int add(int i, int j) {

        int result = i + j;

        return result;
    }
    
    @Override
    public int sub(int i, int j) {

        int result = i - j;

        return result;
    }
    
    @Override
    public int mul(int i, int j) {
    
        int result = i * j;
    
        return result;
    }
    
    @Override
    public int div(int i, int j) {
    
        int result = i / j;
    
        return result;
    }
}
```

4. 新需求：声明带日志接口

 需要在每个方法中，添加控制台输出，输出参数和输出计算后的返回值<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693358657926-48ce6600-7dbd-4a20-801f-1c88de7940f3.png#averageHue=%2312110e&clientId=uf389e789-62d3-4&from=paste&id=uc2e59478&originHeight=487&originWidth=1160&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=ueafeb6f2-1a89-4cb6-bbc9-60a38f3b2dd&title=)

5. 代码问题分析 
   1. 代码缺陷 
      - 对核心业务功能有干扰
      - 附加功能代码重复，分散在各个业务功能方法中，冗余，且不方便统一维护
   2.  解决思路<br />核心就是：解耦。我们需要把附加功能从业务功能代码中抽取出来。<br />将重复的代码统一提取，并且[[动态插入]]到每个业务方法！ 

## 5.2 代理模式

1. 代理模式
> 二十三种设计模式中的一种，属于结构型模式。它的作用就是通过提供一个代理类，让我们在调用目标方法的时候，不再是直接对目标方法进行调用，而是通过代理类间接调用。让不属于目标方法核心逻辑的代码从目标方法中剥离出来——解耦。调用目标方法时先调用代理对象的方法，减少对目标方法的调用和打扰，同时让附加功能能够集中在一起也有利于统一维护。  

无代理场景：<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693360829858-1f453c0b-cbac-451b-9e5a-7a366254572e.png#averageHue=%23000000&clientId=uf389e789-62d3-4&from=paste&id=ub079907c&originHeight=438&originWidth=385&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u11b0321e-dbcd-4da5-925e-1f484e2cdce&title=)<br />有代理场景：<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693360848053-27411b7d-1cba-4b99-84ce-b9581b664e27.png#averageHue=%23000000&clientId=uf389e789-62d3-4&from=paste&id=ua7c95234&originHeight=445&originWidth=635&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=ue8273c15-ee70-4263-bf34-aa3cfb542c3&title=)<br />代理：将非核心逻辑剥离出来以后，封装这些非核心逻辑的类、对象、方法<br />目标：被代理“套用”了核心逻辑代码的类、对象、方法  

2. 静态代理

主动创建代理类：
```java
/**
 * 静态代理类
 */
public class StaticProxyCalculator implements Calculator {

    private Calculator calculator;

    /**
     * 使用构造函数传入目标
     * @param target
     */
    public StaticProxyCalculator(Calculator target) {
        this.calculator =  target;
    }

    @Override
    public int add(int i, int j) {
        // 非核心业务交给代理
        System.out.println("i = " + i + ", j = " + j);
        // 调用目标
        int result = calculator.add(1, 1);
        System.out.println("result = " + result);
        return result;
    }
……
```
静态代理确实实现了解耦，但是由于代码都写死了，完全不具备任何的灵活性。就拿日志功能来说，将来其他地方也需要附加日志，那还得再声明更多个静态代理类，那就产生了大量重复的代码，日志功能还是分散的，没有统一管理

提出进一步的需求：将日志功能集中到一个代理类中，将来有任何日志需求，都通过这一个代理类来实现。这就需要使用动态代理技术了

3. 动态代理

技术分类：

   -  JDK动态代理：JDK原生的实现方式，需要被代理的目标类必须**实现接口**，他会根据目标类的接口动态生成一个代理对象，代理对象和目标对象有相同的接口  
   -  cglib：通过继承被代理的目标类实现代理，所以不需要目标类实现接口

4. 代理总结
- **代理方式可以解决附加功能代码干扰核心代码和不方便统一维护的问题**
- 他主要是将附加功能代码提取到代理中执行，不干扰目标核心代码！
- 但是我们也发现，无论使用静态代理和动态代理(jdk,cglib)，程序员的工作都比较繁琐，需要自己编写代理工厂等

SpringAOP框架可以简化动态代理的实现

## 5.3 面向切面编程思维

1. AOP：Aspect Oriented Programming面向切面编程
>  AOP可以说是OOP（Object Oriented Programming，面向对象编程）的补充和完善。不过OOP允许开发者定义纵向的关系，但并不适合定义横向的关系，例如日志功能。日志代码往往横向地散布在所有对象层次中，而与它对应的对象的核心功能毫无关系对于其他类型的代码，如安全性、异常处理和透明的持续性也都是如此，这种散布在各处的无关的代码被称为横切（cross cutting），在OOP设计中，它导致了大量代码的重复，而不利于各个模块的重用。  

AOP技术恰恰相反，它利用一种称为"横切"的技术，剖解开封装的对象内部，并将那些影响了多个类的公共行为封装到一个可重用模块，并将其命名为"Aspect"，即切面。所谓"切面"，简单说就是那些与业务无关，却为业务模块所共同调用的逻辑或责任封装起来，便于减少系统的重复代码，降低模块之间的耦合度，并有利于未来的可操作性和可维护性。使用AOP，可以在不修改原来代码的基础上添加新功能。

2. AOP主要应用场景

AOP（面向切面编程）是一种编程范式，它通过将通用的横切关注点（如日志、事务、权限控制等）与业务逻辑分离，使得代码更加清晰、简洁、易于维护。AOP可以应用于各种场景，以下是一些常见的AOP应用场景：

   1. 日志记录：在系统中记录日志是非常重要的，可以使用AOP来实现日志记录的功能，可以在方法执行前、执行后或异常抛出时记录日志。
   2. 事务处理：在数据库操作中使用事务可以保证数据的一致性，可以使用AOP来实现事务处理的功能，可以在方法开始前开启事务，在方法执行完毕后提交或回滚事务。
   3. 安全控制：在系统中包含某些需要安全控制的操作，如登录、修改密码、授权等，可以使用AOP来实现安全控制的功能。可以在方法执行前进行权限判断，如果用户没有权限，则抛出异常或转向到错误页面，以防止未经授权的访问。
   4. 性能监控：在系统运行过程中，有时需要对某些方法的性能进行监控，以找到系统的瓶颈并进行优化。可以使用AOP来实现性能监控的功能，可以在方法执行前记录时间戳，在方法执行完毕后计算方法执行时间并输出到日志中。
   5. 异常处理：系统中可能出现各种异常情况，如空指针异常、数据库连接异常等，可以使用AOP来实现异常处理的功能，在方法执行过程中，如果出现异常，则进行异常处理（如记录日志、发送邮件等）。
   6. 缓存控制：在系统中有些数据可以缓存起来以提高访问速度，可以使用AOP来实现缓存控制的功能，可以在方法执行前查询缓存中是否有数据，如果有则返回，否则执行方法并将方法返回值存入缓存中。
   7. 动态代理：AOP的实现方式之一是通过动态代理，可以代理某个类的所有方法，用于实现各种功能。

综上所述，AOP可以应用于各种场景，它的作用是将通用的横切关注点与业务逻辑分离，使得代码更加清晰、简洁、易于维护。

3. AOP术语名词
   1. 横切关注点

从每个方法中抽取出来的同一类非核心业务。在同一个项目中，我们可以使用多个横切关注点对相关方法进行多个不同方面的增强。这个概念不是语法层面天然存在的，而是根据附加功能的逻辑上的需要：有十个附加功能，就有十个横切关注点。<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693378196193-adac2bf9-afb9-4f6d-93f9-77101f2699f8.png#averageHue=%23030000&clientId=u25d4278a-02a6-4&from=paste&height=316&id=u2db212e2&originHeight=631&originWidth=1219&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u706c69f5-4fdb-4b71-8d9e-06c7f4cf20c&title=&width=610)

   2. 增强（通知）

每一个横切关注点上要做的事情都需要写一个方法来实现，这样的方法就叫增强（通知）方法。

   - 前置通知：在被代理的目标方法前执行
   - 返回通知：在被代理的目标方法成功结束后执行（**寿终正寝**）
   - 异常通知：在被代理的目标方法异常结束后执行（**死于非命**）
   - 后置通知：在被代理的目标方法最终结束后执行（**盖棺定论**）
   - 环绕通知：使用try...catch...finally结构围绕整个被代理的目标方法，包括上面四种通知对应的所有位置

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693378361418-de811a93-614d-4037-bd4c-ff647b66aea6.png#averageHue=%230a0303&clientId=u25d4278a-02a6-4&from=paste&height=397&id=ubddc9fc9&originHeight=530&originWidth=771&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=ub05cab4c-1352-43e0-a6d6-1947c92634c&title=&width=578)

   3. 连接点 joinpoint

这也是一个纯逻辑概念，不是语法定义的。指那些被拦截到的点。在 Spring 中，可以被动态代理拦截目标类的方法<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693378433694-58c7a578-beb0-4637-b156-7b919d6320f0.png#averageHue=%23535353&clientId=u25d4278a-02a6-4&from=paste&height=649&id=ud51449b6&originHeight=865&originWidth=1350&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u95c78a95-bca5-4388-a43d-7223d176610&title=&width=1013)

   4. 切入点 pointcut

定位连接点的方式，或者可以理解成被选中的连接点。是一个表达式，比如execution(* com.spring.service.impl.*.*(..))。符合条件的每个方法都是一个具体的连接点。

   5. 切面 aspect： 切入点和通知的结合，是一个类

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693378894446-144cfc26-17d6-4e15-8fd9-bed627e6c833.png#averageHue=%23090303&clientId=u25d4278a-02a6-4&from=paste&height=398&id=u8f34b70c&originHeight=531&originWidth=771&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=ued8f012b-b7d3-48ee-9b6f-d75ba80e722&title=&width=578)

   6. 目标 target： 被代理的目标对象  
   7. 代理 poxy： 向目标对象应用通知之后创建的代理对象  
   8. 织入 weave： 指把通知应用到目标上，生成代理对象的过程。可以在编译期织入，也可以在运行期织入，Spring采用后者

## 5.4 SpringAOP 框架介绍

1. AOP一种区别于OOP的编程思维，用来完善和解决OOP的非核心代码冗余和不方便统一维护问题
2. 代理技术（动态代理|静态代理）是实现AOP思维编程的具体技术，但是自己使用动态代理实现代码比较繁琐
3. Spring AOP框架，基于AOP编程思维，封装动态代理技术，简化动态代理技术实现的框架。SpringAOP内部帮助我们实现动态代理，我们只需写少量的配置，指定生效范围即可，即可完成面向切面思维编程的实现

## 5.5 **Spring AOP基于注解方式实现和细节**
### 5.5.1 Spring AOP 底层技术组成
![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693446569316-275e6c6d-7f72-4911-b716-f2ce92a223ff.png#averageHue=%23101010&clientId=u19c6f95f-3302-4&from=paste&id=u19785230&originHeight=556&originWidth=700&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u37e6fbdc-4739-498c-8ab5-240f858a3ae&title=)

- 动态代理（InvocationHandler）：JDK原生的实现方式，需要被代理的目标类必须实现接口。因为这个技术要求代理对象和目标对象实现同样的接口（兄弟两个拜把子模式）。
- cglib：通过继承被代理的目标类（认干爹模式）实现代理，所以不需要目标类实现接口。
- AspectJ：早期的AOP实现的框架，SpringAOP借用了AspectJ中的AOP注解。

### 5.5.2 初步实现

1. 加入依赖
```xml
<!-- spring-aspects会帮我们传递过来aspectjweaver -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aop</artifactId>
    <version>6.0.6</version>
</dependency>

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aspects</artifactId>
    <version>6.0.6</version>
</dependency>
```

2. 准备接口
```java
public interface Calculator {
    
    int add(int i, int j);
    
    int sub(int i, int j);
    
    int mul(int i, int j);
    
    int div(int i, int j);
    
}
```

3. 纯净实现类
```java
package com.hut.service.impl;


import com.hut.service.Calculator;
import org.springframework.stereotype.Component;

/**
 * 实现计算接口,单纯添加 + - * / 实现
 * aop只针对ioc容器对象创建代理对象，代理对象会存储到ioc容器中
 */
@Component
public class CalculatorPureImpl implements Calculator {
    
    @Override
    public int add(int i, int j) {
    
        int result = i + j;
    
        return result;
    }
    
    @Override
    public int sub(int i, int j) {
    
        int result = i - j;
    
        return result;
    }
    
    @Override
    public int mul(int i, int j) {
    
        int result = i * j;
    
        return result;
    }
    
    @Override
    public int div(int i, int j) {
    
        int result = i / j;
    
        return result;
    }
}
```

4. 声明切面类
```java
/**
 * 增强类的内部要存储增强代码
 * 1. 定义方法存储增强代码
 *  具体定义几个方法是根据插入位置决定的
 * 2. 使用注解配置来指定目标方法的位置（前置@Before 后置@AfterReturning 异常@AfterThrowing 最后@After 环绕@Around）
 * 3. 配置切点表达式
 * 4. 补全注解
 *  加入ioc容器 @Component
 *  配置切面 @Aspect = 切点 + 增强
 * 5. 开启aspect注解的支持
 */
@Aspect
@Component
public class LogAdvice {

    @Before("execution(* com.hut.service.impl.*.*(..))")
    public void start() {
        System.out.println("方法开始了");
    }

    @After("execution(* com.hut.service.impl.*.*(..))")
    public void after() {
        System.out.println("方法结束了");
    }

    @AfterThrowing("execution(* com.hut.service.impl.*.*(..))")
    public void error() {
        System.out.println("方法报错了");
    }
}

```

5. 开启aspectj注解支持（类似于扫描包中的注解）
   1. xml方式
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- 进行包扫描-->
    <context:component-scan base-package="com.hut" />
    <!-- 开启aspectj框架注解支持-->
    <aop:aspectj-autoproxy />
</beans>
```

   2. 配置类方式
```java
@Configuration
@ComponentScan("com.hut")
@EnableAspectJAutoProxy // 开启aspectj注解的支持
public class JavaConfig {
}
```

6. 测试效果
```java
@SpringJUnitConfig(value = JavaConfig.class) // 加载配置类
public class SpringAopTest {

    // 这里只能用接口来声明对象，不能用实现类
    @Autowired
    private Calculator calculator;

    @Test
    public void test(){
        int add = calculator.add(1, 1);
        System.out.println("add = " + add);
    }
}
```
输出结果：<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1693447480426-646e2ed5-d629-4337-a4fc-41269e2d4a09.png#averageHue=%2327282c&clientId=uee4a6d67-3ac9-4&from=paste&height=284&id=uddda20a7&originHeight=355&originWidth=1090&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=27093&status=done&style=none&taskId=u87733280-ba7a-4df5-ac82-07d3574c876&title=&width=872)
