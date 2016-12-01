

# w1d3-jsp内置对象之application 备课记录

# 一、知识点梳理

## 1. jsp构成元素

JSP页面元素构成：静态内容、指令、脚本、表达式、声明、注释。

### 1.1 指令

```
1.page指令：		通常位于jsp页面的顶端，同一个页面可以有多个page指令。
  有3个常用属性：
  import   引用脚本中使用到的类
  contentType JSP页面的编码方式     text/html utf-8
2.include指令：	将一个外部文件嵌入到当前JSP文件中，同时解析这个页面中的JSP语句。
3.taglib指令：	使用标签库定义新的自定义标签，在JSP页面中启用定制行为。
```

### 1.2 脚本

```
就是一段以<% %>包起来的java代码。
<%
   out.println("moonlit");
%>
```

### 1.3 表达式

```
<%=  %>
```

### 1.4 声明

在jsp页面中定义变量和方法

```
<%!
       String s = "moonlit";     	// 声明了一个字符串变量
       
       int add(int x, int y) {    	// 声明了一个返回整型的函数，实现两个函数的求和。
              return x + y;
       }
%>
```

### 1.5 注释

```
HTML的注释：（客户端可见）
	<!-- html注释 -->
	
JSP的注释：（客户端不可见）
	<%-- html注释 --%>
	
JSP脚本注释：（可以嵌入在JSP的注释中）
	// 单行注释
	/* 多行注释 */
```

## 2.转换的Servlet代码及隐式对象

结合代码。

## 3.JSP生命周期

见《05 head first servlet and jsp 2nd 中文版》P335图示

对比servlet来讲解和记忆

```
//初始化
public void _jspInit() {
  }
//销毁
  public void _jspDestroy() {
  }
//service方法
  public void _jspService(final javax.servlet.http.HttpServletRequest request, final    javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {
        }
```

## 4.JSP中的隐式对象

```
application  //应用上下文范围        			  对应于Servlet中的ServletContext
request		 //请求范围              			对应于Servlet中的request
session      //会话范围              			对应于Servlet中的session
pageContext  //任意作用域内的属性，通过它能够取得以上3个范围内的属性和页面内的属性。Servlet无对应项

pageContext.setAttribute("foo","bar",PageContext.***Scope);

如何使用呢，看例子
```

# 二、重点、难点知识讲解思路

1.jsp构成元素，打开一个jsp页面，按页面元素类别讲解。

2.隐式对象及其使用，示例讲解

# 三、课堂补充案例

- 书



# 四、课堂提问准备

-  Servlet内置对象
-  Servlet中的Scope有哪些？如何向这些Scope中放置属性


# 五、课后补充作业

完成图书网相关步骤。