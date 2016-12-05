# w2d1-EL和JSTL 备课记录

# 一、知识点梳理

## 1. EL表达式

回顾一下jsp中的脚本，为了取得Servlet中传过来的属性，我们需要写一些getAttribute代码，有时是多行，比较麻烦，因此，为了减少JSP中这些脚本量，从JSP2.0规范开始引入EL表达式，以后再也不用在界面上写很多java脚本了。

### 1.1 是什么

EL表达式总是放在大括号里，而且前面有一个美元符前缀。

```
${person.name}
```

> **请深入理解下面这张图**

![EL1](C:\MY_JOB\GitHub\servlet_jsp_course\WebContent\img\EL1.jpg)

### 1.2用EL表达式访问属性

EL表达式有两种操作符

第一种:  .操作符

```
. 用来访问对象的属性和Map的映射值
```

第二种，［］操作符

```
它能访问对象的属性和Map的映射值，还能访问Array和List中的某一个对象。
```

> 示例见**com.bwf.el.ELServlet**

### 1.3 隐含对象

JSP有9个隐含对象，而EL也有自己的隐含对象。EL隐含对象总共有11 个

| 隐含对象             | 类型                           | 说明                                       |
| ---------------- | ---------------------------- | ---------------------------------------- |
| PageContext      | javax.servlet.ServletContext | 表示此JSP的PageContext                       |
| PageScope        | java.util.Map                | 取得Page范围的属性名称所对应的值                       |
| RequestScope     | java.util.Map                | 取得Request范围的属性名称所对应的值                    |
| sessionScope     | java.util.Map                | 取得Session范围的属性名称所对应的值                    |
| applicationScope | java.util.Map                | 取得Application范围的属性名称所对应的值                |
| param            | java.util.Map                | 如同ServletRequest.getParameter(String name)。回传String类型的值 |
| paramValues      | java.util.Map                | 如同ServletRequest.getParameterValues(String name)。回传String[]类型的值 |
| header           | java.util.Map                | 如同ServletRequest.getHeader(String name)。回传String类型的值 |
| headerValues     | java.util.Map                | 如同ServletRequest.getHeaders(String name)。回传String[]类型的值 |
| cookie           | java.util.Map                | 如同HttpServletRequest.getCookies()        |
| initParam        | java.util.Map                | 如同ServletContext.getInitParameter(String name)。回传String类型的值 |

## 2.JSTL标准标记库

### 2.1 为什么要引入它？

JSP标准标签库（JSTL）是一个JSP标签集合，它封装了JSP应用的通用核心功能。

JSTL支持通用的、结构化的任务，比如迭代，条件判断，XML文档操作，国际化标签，SQL标签。 除了这些，它还提供了一个框架来使用集成JSTL的自定义标签。

根据JSTL标签所提供的功能，可以将其分为5个类别。

- **核心标签**[重点]  
- 格式化标签
- SQL 标签
- XML 标签
- JSTL 函数

### 2. 2安装

```
从tomcat5开始，已内置，对应库文件为jstl.jar和standard.jar,只要项目中设置了server为tomcat就自动加载了。
```

### 2.3引入

```
页面头部引入
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
prefix属性表示简记为c，方便在jsp中使用
```

## 3.常用标记

核心标签是最常用的JSTL标签。引用核心标签库的语法如下：

### 3.1 out标记

```
<c:out>标签用来显示一个表达式的结果，与<%= %>作用相似,但比out强大
```

属性

| **属性**    | **描述**      | **是否必要** | **默认值** |
| --------- | ----------- | -------- | ------- |
| value     | 要输出的内容      | 是        | 无       |
| default   | 输出的默认值      | 否        | 主体中的内容  |
| escapeXml | 是否忽略XML特殊字符 | 否        | true    |

示例 jstl.jsp

```
<c:out value="&lt要显示的数据对象（未使用转义字符）&gt" escapeXml="true" default="默认值"></c:out><br/>
<c:out value="&lt要显示的数据对象（使用转义字符）&gt" escapeXml="false" default="默认值"></c:out><br/>
<c:out value="${null}" escapeXml="false">使用的表达式结果为null，则输出该默认值</c:out><br/>
<c:out value="<c:out /> Tag"></c:out>
```

### 3.2 set 标记

```
<c:set>标记用于设置变量值和对象属性。
	<c:set var="salary" scope="page" value="${2000*2}" />
	<c:set var="salary" scope="session" value="8万" />
	<c:set target="${map}" property="school" value="成都博为峰"></c:set>
```

示例：jstl.jsp

### 3.3 remove标记

```
<c:remove>标记用于移除变量值和对象属性。
```

### 3.4 catch标记

```

```

### 3.5 条件标记c:if 

```
 			<c:if test="${i>3 }">
				比3大
			</c:if>
```

### 3.6 条件标记c:choose

也是一个条件标记，它比c:if更强大，里面可以包含c:when和c:otherwise标记，一般是组合使用，有点像switch-case-default

```
			<c:choose>
				<c:when test="${i<3}">比3小</c:when>
				<c:when test="${i<5}">比5小</c:when>
				<c:when test="${i==5}">OK,刚好是5</c:when>
				<c:otherwise>比5大</c:otherwise>
			</c:choose>
```

### 3.7 循环标记 forEach forToken

forEach故名思义，它是用来做迭代的。可以接受多种集合类型

```
见示例jstl.jsp
```

forToken主要用来做分割,有点像String.split()

```
示例jstl.jsp
```

# 二、重点、难点知识讲解思路

1.EL表达式语法及用法。

2、JSTL标准标记库中的常用标记。

# 三、课堂补充案例

- 示例



# 四、课堂提问准备

-  没有EL之前，在页面输出时怎么做的呢？
-  如何用c:forEach迭代Map对象(Map中存放有User对象)，获得username呢？


# 五、课后补充作业

完成图书网相关步骤。