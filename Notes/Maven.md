# 1 Maven简介
## 1.1 Maven介绍
> 一款构建管理、依赖管理Java项目的软件，可以自动化构建、测试、打包和发布项目

学习Maven需要掌握软件安装、配置、项目构建与依赖管理，Maven只服务于Java项目。

## 1.2 Maven主要作用

1. 我们可以将需要的依赖项的信息编写到Maven工程的配置文件，Maven软件就会自动下载并复制这些依赖项到项目中，也会自动下载依赖需要的依赖，确保依赖版本正确无冲突和依赖完整
2.  我们可以通过一行构建命令（mvn package）快速项目构建和打包  
3. 依赖管理： Maven 可以管理项目的依赖，包括**自动下载所需依赖库**、**自动下载依赖需要的依赖**并且保证版本没有冲突、依赖版本管理等。通过 Maven，我们可以方便地维护项目所依赖的外部库，而我们仅仅需要编写配置即可
4. 构建管理： 项目构建是指将源代码、配置文件、资源文件等转化为能够运行或部署的应用程序或库的过程  
5. 构建项目过程如下

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692755468662-aba29cf0-9f9f-4677-b46f-7d33781d9b00.png#averageHue=%23c5c9b9&clientId=ud297264e-a54b-4&from=paste&id=u86e4786e&originHeight=126&originWidth=690&originalType=url&ratio=1.5&rotation=0&showTitle=false&status=done&style=none&taskId=ubffffe3a-3677-4b00-acae-b36f68b44a9&title=)

## 1.3 Maven安装与配置
下载地址：[Maven – Maven Releases History](https://maven.apache.org/docs/history.html)<br />选用版本：

| 发布时间 | maven版本 | jdk最低版本 |
| --- | --- | --- |
| 2019-11-25 | 3.6.3 | Java 7 |

1. 安装

安装条件：maven需要本机安装java环境，必须包含`JAVA_HHOME`环境变量<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692755824793-4e538279-5714-4924-a98a-26467250a706.png#averageHue=%23f5f2f1&clientId=ud297264e-a54b-4&from=paste&height=209&id=ub63b044c&originHeight=313&originWidth=760&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=21695&status=done&style=none&taskId=uc62a2141-3629-40ef-a86b-f25c387a7ca&title=&width=506.6666666666667)<br />软件安装：下载之后解压即可安装。<br />软件结构<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692755955028-96dca8c6-1bde-4bf3-b958-0ecef220d316.png#averageHue=%23faf4f3&clientId=ud297264e-a54b-4&from=paste&id=u7e819a1e&originHeight=184&originWidth=682&originalType=url&ratio=1.5&rotation=0&showTitle=false&status=done&style=none&taskId=u46e925e6-25b6-41f3-9a0d-e5933fcdc38&title=)

2. 环境变量

配置`MAVEN_HOME`和`Path`<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692756388545-f0a524cc-b55b-4ecc-ad6f-4e119d8519bb.png#averageHue=%23f5f3f1&clientId=u6bc8682e-76ce-4&from=paste&height=209&id=ub4387212&originHeight=313&originWidth=760&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=22259&status=done&style=none&taskId=u166635be-c70c-4694-a279-a4721399b43&title=&width=506.6666666666667)<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692773118665-4d564e52-34d4-4937-ae54-2e0b9f4dafda.png#averageHue=%23edeceb&clientId=u6bc8682e-76ce-4&from=paste&height=524&id=u56a34081&originHeight=786&originWidth=801&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=71637&status=done&style=none&taskId=u6d5ccd62-9af4-4878-84db-a0ad69a96c5&title=&width=534)

3. 命令测试
```java
mvn -v
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692756834158-ade32195-22ab-4641-9cdb-8f862a8f86e9.png#averageHue=%23191919&clientId=u6bc8682e-76ce-4&from=paste&height=181&id=u236f9144&originHeight=271&originWidth=1478&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=36638&status=done&style=none&taskId=u9151195d-cc18-425a-ac4a-fe608c19613&title=&width=985.3333333333334)

4. 配置文件

我们需要修改`~/maven/apache-maven-3.6.3/conf/settings.xml`配置文件，主要修改如下三个位置：

   1. 依赖本地缓存位置（本地仓库位置）
```xml
<!-- localRepository 
   | The path to the local repository maven will use to store artifacts.
   |
   | Default: ${user.home}/.m2/repository-->
  <localRepository>D:\IDE\maven\apache-maven-repository</localRepository>
```

   2. 配置maven下载镜像
```xml
<mirror>
  <id>alimaven</id>
  <name>aliyun maven</name>
  <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
  <mirrorOf>central</mirrorOf>
</mirror>
```

   3. maven选用编译项目的jdk版本
```xml
<profile>
  <id>jdk-11</id>
  <activation>
    <activeByDefault>true</activeByDefault>
    <jdk>11</jdk>
  </activation>
  <properties>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
    <maven.compiler.compilerVersion>11</maven.compiler.compilerVersion>
  </properties>
</profile>
```

5. IDEA配置本地maven
   1. 打开IDEA配置文件，构建工具配置

依次点击`file`->`settings`->`Build`->`Build Tools`->`Maven`

   2. 选中本地maven软件
   3. 测试是否配置成功

![image.png](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692758309846-31a31c39-3123-4323-b425-5ee15c724f3e.png#averageHue=%233d4246&clientId=u6bc8682e-76ce-4&from=paste&height=597&id=u52d45dd7&originHeight=895&originWidth=1246&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=88353&status=done&style=none&taskId=ud27d4623-6e5a-4821-9e4e-15ebcf4ee75&title=&width=830.6666666666666)

# 2 基于IDEA的Maven工程创建
## 2.1 Maven工程的GAVP属性
>  Maven 中的 GAVP 是指 GroupId、ArtifactId、Version、Packaging 等四个属性的缩写，其中前三个是必要的，而 Packaging 属性为可选项。这四个属性主要为每个项目在maven仓库总做一个标识，类似人的《姓-名》。有了具体标识，方便maven软件对项目进行管理和互相引用！  

GAV遵循以下规则：

1. **GroupID**： com.{公司/BU }.业务线.[子业务线]，最多 4 级。  

说明：{公司/BU} 例如：alibaba/taobao/tmall/aliexpress 等 BU 一级；子业务线可选。  <br />例子： com.taobao.tddl 或 com.alibaba.sourcing.multilang com.atguigu.java  

2. **AritfactID**： 产品线名-模块名。语义不重复不遗漏，先到仓库中心去查证一下。

例子： tc-client / uic-api / tair-tool / bookstore  

3. **Version版本号格式推荐**：主版本号.次版本号.修订号 1.0.0
   1. 主版本号：当做了不兼容的 API 修改，或者增加了能改变产品方向的新功能。
   2. 次版本号：当做了向下兼容的功能性新增（新增类、接口等）。
   3. 修订号：修复 bug，没有修改方法签名的功能加强，保持 API 兼容性。

 例如： 初始→1.0.0 修改bug → 1.0.1 功能调整 → 1.1.1等  

Packaging定义规则：<br />指示将项目打包为什么类型的文件，idea根据packaging值，识别maven项目类型<br />packaging 属性为 jar（默认值），代表普通的Java工程，打包以后是.jar结尾的文件。<br />packaging 属性为 war，代表Java的web工程，打包以后.war结尾的文件。<br />packaging 属性为 pom，代表不会打包，用来做继承的父工程。

## 2.2 IDEA构建Maven JavaSE工程
注意：此处省略了version，直接给了一个默认值`<version>1.0-SNAPSHOT</version>`<br />自己后期可以在项目中随意修改！<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692775672296-fdc5bc35-5017-46b7-b19e-36d6a830c113.png#averageHue=%23f4f2f2&clientId=u6bc8682e-76ce-4&from=paste&height=590&id=ud308e918&originHeight=787&originWidth=752&originalType=url&ratio=1.5&rotation=0&showTitle=false&status=done&style=none&taskId=u581b20d5-14b2-4272-ab13-d432f1da779&title=&width=564)

## 2.3 IDEA构建Maven JavaEE工程

1. 手动创建
   1.  创建一个javasemaven工程  
   2.  手动添加web项目结构文件 
   3.  修改pom.xml文件打包方式（ 修改位置：~/pom.xml  ）
```xml
<groupId>com.hut</groupId>
<artifactId>maven_parent</artifactId>
<version>1.0-SNAPSHOT</version>
<!-- 新增一列打包方式packaging -->
<packaging>war</packaging>
```

   4. 刷新和校验

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692776047935-e38e4d0e-3b53-4180-9339-8abb89042545.png#averageHue=%23f7f6f4&clientId=u6bc8682e-76ce-4&from=paste&id=u791228e7&originHeight=424&originWidth=401&originalType=url&ratio=1.5&rotation=0&showTitle=false&status=done&style=none&taskId=u84c9a0f5-3131-4ce9-89e2-b59fe559492&title=)<br />![](https://secure2.wostatic.cn/static/haCWoNhTmZaQEzd3T8GmRu/image.png?auth_key=1692774924-ab8zPxPKWXeWQdhgRY2fK9-0-cc3f8dec44b63067755419179ce885b6#id=sPXkq&originHeight=26&originWidth=124&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)<br />项目的webapp文件夹出现小蓝点，代表成功

2. 插件方式创建
   1.  安装插件JBLJavaToWeb  

`file`->`settings`->`plugins`->`marketplace`<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692776159229-e6e74f6a-57a1-46b3-86b3-cf2a4f39a0cc.png#averageHue=%23c3bea2&clientId=u6bc8682e-76ce-4&from=paste&height=405&id=u7e416e4d&originHeight=540&originWidth=762&originalType=url&ratio=1.5&rotation=0&showTitle=false&status=done&style=none&taskId=ua2a088c3-1c8d-45ee-931b-479ba1fb8c2&title=&width=572)

   2.  创建一个javasemaven工程  
   3.  右键、使用插件快速补全web项目  

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692776199851-04768136-c28b-4f42-852c-ad5643f5ebb5.png#averageHue=%23f1f0ef&clientId=u6bc8682e-76ce-4&from=paste&height=499&id=ud5617b0f&originHeight=666&originWidth=507&originalType=url&ratio=1.5&rotation=0&showTitle=false&status=done&style=none&taskId=u98278dcb-079f-416b-bc53-24cb8348c62&title=&width=380)

## 2.4 Maven工程项目结构说明
 以下是 Maven Web 程序的文件结构及每个文件的作用：  
```xml
|-- pom.xml                               # Maven 项目管理文件 
|-- src
    |-- main                              # 项目主要代码
    |   |-- java                          # Java 源代码目录
    |   |   `-- com/example/myapp         # 开发者代码主目录
    |   |       |-- controller            # 存放 Controller 层代码的目录
    |   |       |-- service               # 存放 Service 层代码的目录
    |   |       |-- dao                   # 存放 DAO 层代码的目录
    |   |       `-- model                 # 存放数据模型的目录
    |   |-- resources                     # 资源目录，存放配置文件、静态资源等
    |   |   |-- log4j.properties          # 日志配置文件
    |   |   |-- spring-mybatis.xml        # Spring Mybatis 配置文件
    |   |   `-- static                    # 存放静态资源的目录
    |   |       |-- css                   # 存放 CSS 文件的目录
    |   |       |-- js                    # 存放 JavaScript 文件的目录
    |   |       `-- images                # 存放图片资源的目录
    |   `-- webapp                        # 存放 WEB 相关配置和资源
    |       |-- WEB-INF                   # 存放 WEB 应用配置文件
    |       |   |-- web.xml               # Web 应用的部署描述文件
    |       |   `-- classes               # 存放编译后的 class 文件
    |       `-- index.html                # Web 应用入口页面
    `-- test                              # 项目测试代码
        |-- java                          # 单元测试目录
        `-- resources                     # 测试资源目录
```

- pom.xml：Maven 项目管理文件，用于描述项目的依赖和构建配置等信息。
- src/main/java：存放项目的 Java 源代码。
- src/main/resources：存放项目的资源文件，如配置文件、静态资源等。
- src/main/webapp/WEB-INF：存放 Web 应用的配置文件。
- src/main/webapp/index.html：Web 应用的入口页面。
- src/test/java：存放项目的测试代码。
- src/test/resources：存放测试相关的资源文件，如测试配置文件等。

# 3 Maven核心功能依赖和构建管理
## 3.1 依赖管理和配置
 maven项目信息属性配置和读取：  
```xml
<!--模型版本-->
<modelVersion>4.0.0</modelVersion>

<!--gavp属性-->
<!--不会改变-->
<groupId>com.hut</groupId>
<artifactId>maven-pom-dependenies-04</artifactId>
<!--构建过程，部署-修改-->
<version>1.0.1</version>
<!--maven工程的打包方式 jar（默认）/war（web项目）/pom（不打包）-->
<packaging>jar</packaging>
```

 依赖管理和添加：  
```xml
<!--第三方依赖信息声明
    dependencies - 项目依赖信息的集合
        dependency - 每个依赖项
            [gav] - 依赖的信息， 就是其他maven的工程
    依赖信息查询方式：
      1. maven仓库信息官网 https://mvnrepository.com/
      2. maven-search插件搜索
-->
<dependencies>

    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.17</version>
        <!--scope：引入依赖的作用域，即生效范围
            - compile：main目录 test目录  打包运行 [默认]
            - provided：main目录 test目录  Servlet
            - runtime： 打包运行           MySQL
            - test:    test目录           junit
         -->
        <scope>runtime</scope>
    </dependency>

</dependencies>
```

 依赖版本提取和维护:  
```xml
<!--声明版本号-->
<properties>
    <!--相当于声明一个变量，引用方式：${junit.version}，命名方式：技术名.version-->
    <junit.version>4.13.2</junit.version>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>

<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>${junit.version}</version>
    </dependency>
</dependencies>
```

## 3.2 依赖传递和冲突
> 依赖传递指的是当一个模块或库 A 依赖于另一个模块或库 B，而 B 又依赖于模块或库 C，那么 A 会间接依赖于 C。这种依赖传递结构可以形成一个依赖树。当我们引入一个库或框架时，构建工具（如 Maven、Gradle）会自动解析和加载其所有的直接和间接依赖，确保这些依赖都可用。  

依赖传递的作用：

1. 减少重复依赖：当多个项目依赖同一个库时，Maven 可以自动下载并且只下载一次该库。这样可以减少项目的构建时间和磁盘空间。
2. 自动管理依赖: Maven 可以自动管理依赖项，使用依赖传递，简化了依赖项的管理，使项目构建更加可靠和一致。
3. 确保依赖版本正确性：通过依赖传递的依赖，之间都不会存在版本兼容性问题，确实依赖的版本正确性

依赖传递演示：<br />项目中，需要导入jackson相关的依赖，通过之前导入经验，jackson需要导入三个依赖，分别为：  <br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692780319018-8cd4ccca-6d6e-4089-ad14-ff622eb4ff9f.png#averageHue=%23f8f8f8&clientId=u6bc8682e-76ce-4&from=paste&id=u7e0a9f55&originHeight=380&originWidth=750&originalType=url&ratio=1.5&rotation=0&showTitle=false&status=done&style=none&taskId=u6a26cf0b-1dfe-4c7d-b4bb-7bfcbd40b26&title=)<br /> 通过查看网站介绍的依赖传递特性：data-bind中，依赖其他两个依赖  <br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692780338991-81b7fbaa-9277-426a-94ce-01aed0d72302.png#averageHue=%23f6f6f6&clientId=u6bc8682e-76ce-4&from=paste&id=ud17a8cf3&originHeight=194&originWidth=1023&originalType=url&ratio=1.5&rotation=0&showTitle=false&status=done&style=none&taskId=u53f04453-1172-4c00-a1aa-1b053ca9b4d&title=)<br /> 最佳导入：直接可以导入data-bind，自动依赖传递需要的依赖 
```xml
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.0</version>
</dependency>
```

依赖冲突演示：<br />当直接引用或者间接引用出现了相同的jar包，这时呢，一个项目就会出现相同的重复jar包，这就算作冲突。依赖冲突避免出现重复依赖，并且终止依赖传递<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692780406299-e1e31d57-4354-48d3-913a-0af773b07682.png#averageHue=%23f3f3f3&clientId=u6bc8682e-76ce-4&from=paste&id=u06c533d3&originHeight=210&originWidth=797&originalType=url&ratio=1.5&rotation=0&showTitle=false&status=done&style=none&taskId=u51deb2c6-8808-4586-ad8f-165f147ea51&title=)<br /> maven自动解决依赖冲突问题能力，会按照自己的原则，进行重复依赖选择。 解决依赖冲突（如何选择重复依赖）方式如下：

1. 自动选择原则 
   -  短路优先原则（第一原则）<br />A—>B—>C—>D—>E—>X(version 0.0.1)<br />A—>F—>X(version 0.0.2)<br />则A依赖于X(version 0.0.2)。 
   -  依赖路径长度相同情况下，则“先声明优先”（第二原则）<br />A—>E—>X(version 0.0.1)<br />A—>F—>X(version 0.0.2)<br />在中，先声明的，路径相同，会优先选择
## 3.3 依赖导入失败场景与解决方案
在使用 Maven 构建项目时，可能会发生依赖项下载错误的情况，主要原因有以下几种：

1. 下载依赖时出现网络故障或仓库服务器宕机等原因，导致无法连接至 Maven 仓库，从而无法下载依赖。
2. 依赖项的版本号或配置文件中的版本号错误，或者依赖项没有正确定义，导致 Maven 下载的依赖项与实际需要的不一致，从而引发错误。
3. 本地 Maven 仓库或缓存被污染或损坏，导致 Maven 无法正确地使用现有的依赖项，并且也无法重新下载！

解决方案：

1.  检查网络连接和 Maven 仓库服务器状态。 
2.  确保依赖项的版本号与项目对应的版本号匹配，并检查 POM 文件中的依赖项是否正确。 
3.  清除本地 Maven 仓库缓存（lastUpdated 文件），因为只要存在lastupdated缓存文件，刷新也不会重新下载。本地仓库中，根据依赖的gav属性依次向下查找文件夹，最终删除内部的文件，刷新重新下载即可！<br />例如： pom.xml依赖 
```xml
<dependency>
  <groupId>com.alibaba</groupId>
  <artifactId>druid</artifactId>
  <version>1.2.8</version>
</dependency>
```
文件：<br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692782255095-eeca3f5a-8d7f-4219-aba9-11bf8f85b491.png#averageHue=%23faf9f7&clientId=u6bc8682e-76ce-4&from=paste&id=u3eee7ed2&originHeight=220&originWidth=667&originalType=url&ratio=1.5&rotation=0&showTitle=false&status=done&style=none&taskId=u829f247c-229e-4b84-a33a-ac401e7826f&title=)

## 3.4 扩展构建管理和插件配置
> 构建概念： 项目构建是指将源代码、依赖库和资源文件等转换成可执行或可部署的应用程序的过程，在这个过程中包括编译源代码、链接依赖库、打包和部署等多个步骤  

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692782300120-d8821002-7915-44be-9523-94a91acde93a.png#averageHue=%23c4c8ba&clientId=u6bc8682e-76ce-4&from=paste&id=u5e14e4a8&originHeight=115&originWidth=730&originalType=url&ratio=1.5&rotation=0&showTitle=false&status=done&style=none&taskId=uafd8c4a1-a1d8-45ce-8b4d-13de0db8179&title=)<br />**主动触发场景：**

- 重新编译：编译不充分，部分文件没有被编译!
- 打包：独立部署到外部服务器软件，打包部署
- 部署本地或者私服仓库：maven工程加入到本地或者私服仓库，供其他工程使用

**命令方式构建:**<br />语法: mvn 构建命令  构建命令....

| 命令 | 描述 |
| --- | --- |
| mvn clean | 清理编译或打包后的项目结构,删除target文件夹 |
| mvn compile | 编译项目，生成target文件 |
| mvn test | 执行测试源码 (测试) |
| mvn site | 生成一个项目依赖信息的展示页面 |
| mvn package | 打包项目，生成war / jar 文件 |
| mvn install | 打包后上传到maven本地仓库(本地部署) |
| mvn deploy | 只打包，上传到maven私服仓库(私服部署) |


**可视化方式构建:**<br />![](https://secure2.wostatic.cn/static/85Cv2rhHoFN4C9JgJzVdho/image.png?auth_key=1692780492-rjL4TTwK7vvUgcVGzdSN8q-0-c3d376acacc3b305172471b54341b35c#id=N4ubj&originHeight=498&originWidth=528&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

**构建命令周期:**<br />构建生命周期可以理解成是一组固定构建命令的有序集合，触发周期后的命令，会自动触发周期前的命令

-  清理周期：主要是对项目编译生成文件进行清理<br />包含命令：clean 
-  默认周期：定义了真正构件时所需要执行的所有步骤，它是生命周期中最核心的部分<br />包含命令：compile - test - package - install / deploy 
- 报告周期<br />包含命令：site<br />打包: mvn clean package 本地仓库: mvn clean install 

**最佳使用方案:**
```latex
打包: mvn clean package
重新编译: mvn clean compile
本地部署: mvn clean install
```

**插件配置**:

```xml
<build>
   <!-- jdk17 和 war包版本插件不匹配 -->
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-war-plugin</artifactId>
            <version>3.2.2</version>
        </plugin>
    </plugins>
</build>
```

# 4 Maven继承与聚合
## 4.1 Maven工程继承关系
>  Maven 继承是指在 Maven 的项目中，让一个项目从另一个项目中继承配置信息的机制。继承可以让我们在多个项目中共享同一配置信息，简化项目的管理和维护工作。  

![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692838822833-f29d10d5-03aa-48a2-a50a-f77c17a2c29f.png#averageHue=%23f1f1f1&clientId=ud3be9989-3cf8-4&from=paste&id=u922b1858&originHeight=410&originWidth=842&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=udb438fba-a08e-4e7e-9f8d-495a39e1600&title=)

继承的作用： 在父工程中统一管理项目中的依赖信息，进行统一版本管理 <br />背景：

- 对一个比较大型的项目进行了模块拆分。
- 一个 project 下面，创建了很多个 module。
- 每一个 module 都需要配置自己的依赖信息。

它背后的需求是：

- 多个模块要使用同一个框架，它们应该是同一个版本，所以整个项目中使用的框架版本需要统一管理。
- 使用框架时所需要的 jar 包组合（或者说依赖信息组合）需要经过长期摸索和反复调试，最终确定一个可用组合。这个耗费很大精力总结出来的方案不应该在新的项目中重新摸索。

通过在父工程中为整个项目维护依赖信息的组合既保证了整个项目使用规范、准确的 jar 包；又能够将以往的经验沉淀下来，节约时间和精力。

语法：

- 父工程
```xml
<groupId>com.hut.maven</groupId>
<artifactId>pro03-maven-parent</artifactId>
<version>1.0-SNAPSHOT</version>
<!-- 当前工程作为父工程，它要去管理子工程，所以打包方式必须是 pom -->
<packaging>pom</packaging>

```

- 子工程
```xml
<!-- 使用parent标签指定当前工程的父工程 -->
<parent>
  <!-- 父工程的坐标 -->
  <groupId>com.hut.maven</groupId>
  <artifactId>pro03-maven-parent</artifactId>
  <version>1.0-SNAPSHOT</version>
</parent>

<!-- 子工程的坐标 -->
<!-- 如果子工程坐标中的groupId和version与父工程一致，那么可以省略 -->
<!-- <groupId>com.atguigu.maven</groupId> -->
<artifactId>pro04-maven-module</artifactId>
<!-- <version>1.0-SNAPSHOT</version> -->
```

父工程依赖统一管理

- 父工程声明版本
```xml
<!-- 使用dependencyManagement标签配置对依赖的管理 -->
<!-- 被管理的依赖并没有真正被引入到工程 -->
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>4.0.0.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>4.0.0.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.0.0.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-expression</artifactId>
      <version>4.0.0.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>4.0.0.RELEASE</version>
    </dependency>
  </dependencies>
</dependencyManagement>
```

- 子工程引用版本
```xml
<!-- 子工程引用父工程中的依赖信息时，可以把版本号去掉。  -->
<!-- 把版本号去掉就表示子工程中这个依赖的版本由父工程决定。 -->
<!-- 具体来说是由父工程的dependencyManagement来决定。 -->
<dependencies>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-beans</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-expression</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aop</artifactId>
  </dependency>
</dependencies>
```
## 4.2 Maven工程聚合关系
>  Maven 聚合是指将多个项目组织到一个父级项目中，通过触发父工程的构建，统一按顺序触发子工程构建的过程  

作用：

1.  统一管理子项目构建：通过聚合，可以将多个子项目组织在一起，方便管理和维护  
2.  优化构建顺序：通过聚合，可以对多个项目进行顺序控制，避免出现构建依赖混乱导致构建失败的情况  

语法：<br /> 父项目中包含的子项目列表
```xml
<project>
  <groupId>com.example</groupId>
  <artifactId>parent-project</artifactId>
  <packaging>pom</packaging>
  <version>1.0.0</version>
  <modules>
    <module>child-project1</module>
    <module>child-project2</module>
  </modules>
</project>
```

聚合演示：<br />通过触发父工程构建命令、引发所有子模块构建  <br />![](https://cdn.nlark.com/yuque/0/2023/png/25941432/1692839461597-b89e8ba6-cbba-456a-94e8-65bc5cd301e8.png#averageHue=%23f9f8f7&clientId=ud3be9989-3cf8-4&from=paste&id=u31531ffe&originHeight=421&originWidth=1010&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=uacc664b7-048b-474a-8066-a83950b48bd&title=)

# 5 Maven核心总结
| 核心点 | 掌握目标 |
| --- | --- |
| 安装 | maven安装、环境变量、maven配置文件修改 |
| 工程创建 | gavp属性理解、JavaSE/EE工程创建、项目结构 |
| 依赖管理 | 依赖添加、依赖传递、版本提取、导入依赖错误解决 |
| 构建管理 | 构建过程、构建场景、构建周期等 |
| 继承和聚合 | 理解继承和聚合作用、继承语法和实践、聚合语法和实践 |


