

# w2d1-EL和JSTL 备课记录

# 一、知识点梳理

## 1. EL表达式

自JSP2.0规范开始加入，以后再也不用在界面上写很多java脚本了。

### 1.1 语法

```
${person.name}
```

见书《05 head first servlet and jsp 2nd 中文版》P398页图例。

### 1.2 操作属性

2种操作符:  

.用来访问对象的属性和Map的映射值

［］不光能访问上面的这些，还能访问Array和List中的某一个对象。

```
示例讲解
```

## 2.JSTL标准标记库

### 2.1 为什么要引入它？

### 2. 2安装

```
从tomcat5开始，已内置，对应库文件为jstl.jar和standard.jar
```

### 2.3引入

```
页面头部引入
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

## 3.常用标记

核心标签是最常用的JSTL标签。引用核心标签库的语法如下：



### 3.1 out标记

```
<c:out>标签用来显示一个表达式的结果，与<%= %>作用相似
```

属性

| **属性**    | **描述**      | **是否必要** | **默认值** |
| --------- | ----------- | -------- | ------- |
| value     | 要输出的内容      | 是        | 无       |
| default   | 输出的默认值      | 否        | 主体中的内容  |
| escapeXml | 是否忽略XML特殊字符 | 否        | true    |

示例

```
<c:out value="&lt要显示的数据对象（未使用转义字符）&gt" escapeXml="true" default="默认值"></c:out><br/>
<c:out value="&lt要显示的数据对象（使用转义字符）&gt" escapeXml="false" default="默认值"></c:out><br/>
<c:out value="${null}" escapeXml="false">使用的表达式结果为null，则输出该默认值</c:out><br/>
<c:out value="<c:out /> Tag"></c:out>
```

### 3.2 set标记

```
<c:set>标签用于设置变量值和对象属性。
```

```

```

### 3.3 remove标记

```

```

### 3.4 catch标记

```


```

3.2 条件标记if choose when otherwise

```

```

3.3 循环标记 forEach forToken

```

```

3.4 与URL相关的 url

```

```

## 4.

```

```

# 二、重点、难点知识讲解思路

1.

# 三、课堂补充案例

- ​



# 四、课堂提问准备

-  ​


# 五、课后补充作业

完成图书网相关步骤。