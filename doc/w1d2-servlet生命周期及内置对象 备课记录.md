

# w1d1-Servlet的生命周期及内置对象 备课记录

# 一、知识点梳理

## 1.Servlet的生命周期

```
init() 可用来加载一些公共常量或者数据库访问的连接池
service()方法的调用即doGet()和doPost()，最主要的两个方法
destory() servlet被容器销毁前允许我们的程序做的一些资源清理工作，比如关闭连接池，移除共享的
```

<load-on-startup>的作用：

```
1、当值为0或者大于0时，表示容器在应用启动时就加载并初始化这个servlet；
2、当值小于0或者没有指定时，则表示容器在该servlet被选择时才会去加载。
3、正数的值越小，该servlet的优先级越高，应用启动时就越先加载。
```

## 2.ServletContext  

servlet是运行在WEB容器中的，大多数时候是容器来管理servlet的创建、销毁等。但有的时候，servlet需要跟web容器打交道，了解一些容器的信息，比如说取得一些公共参数，jdbc的连接池等。

servletContext代表的就是web容器。servletContext提供了一系列的方法，让servlet可以跟web容器交流。

自然，在一个web容器中或者一个web应用中，只有一份servletContext对象。

获得servletContext的方法

```
方法1：在init()方法中
ServletContext context = config.getServletContext();

方法2：在doGet()方法中
ServletContext context = getServletContext();
或者
ServletContext context = getServletConfig().getServletContext();
```

ServletContext的方法：

```
代码演示
```

例子：网站首页的公司、版权、邮件等信息，这些信息可能会变化，不能写死在代码中，我们需要放置在配置文件中，比如web.xml中。

```
	<servlet>
		<servlet-name>initParam</servlet-name>
		<servlet-class>com.bwf.InitParam</servlet-class>
		<init-param>
			<param-name>companyName</param-name>
			<param-value>成都博为峰</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	
	<servlet-mapping>
		<servlet-name>initParam</servlet-name>
		<url-pattern>/initParam</url-pattern>
	</servlet-mapping>
	
	servlet中取得初始化参数，并放入request中
	String compName = getServletConfig().getInitParameter("companyName");
	request.setAttribute("companyName", compName);
	
	然后，jsp中通过内置对象request.getAttribute("companyName")获得
		
```

上述的配置参数与可以在init(ServletConfig config)方法中得到，但要注意

如果 重写了init()方法，最后一定记得调用

```
super.init(config);
```

否则会在doGet或Post中无法获得servletContext对象，这是因为。。。。。请查看上级类的源码

## 3.ServletContextListener对象

既然是listener，那就是监听事件的，那么它是监听什么事件的呢？

既然名为ServletContextListener ，那监听的事件肯定跟ServletContext有关，事实上它是监听ServletContext的生命周期事件的，比如创建、销毁等。

ServletContextListenery 主要是用来设置整个应用范围内的一些参数，比如数据库连接池的创建等。

如何使用呢？

有以下6步骤：

```
1.实现ServletContextListener接口

2.实现方法

3.获得ServletContext名柄

4.使用ServletContext

5.在web.xml中声明

6.提供需要的初始化参数
```

代码实现略。

## 4.重定向redirect vs 转发dispatch

```
redirect 二次请求，请求中的参数会丢失
```

## 5.MVC思想及实践

把业务独立出来，做成可重用的，不要和控制器搅在一起

## 6.内置对象之request、response、out的使用

# 二、重点、难点知识讲解思路

1. ### servlet生命周期，上下文、初始化/公共资源加载，服务、servlet销毁。

2. ### 重定向和转发的区别。

3. ### MVC的概念，思想、如何实现，用一个啤酒挑选的小例子。

4. ### 常用内置对象request和response,完成完整的用户登陆案例，要求登录页面的公司名称从配置文件web.xml中获取。

# 三、课堂补充案例

- eclipse压缩包，tomcat压缩包


# 四、课堂提问准备

-  java.util.Date类的使用
-  静态页面的写法。


# 五、课后补充作业

完成图书网相关步骤。