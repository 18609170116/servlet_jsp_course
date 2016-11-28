

# w1d3-jsp内置对象之session备课记录

# 一、知识点梳理

## 1.会话session的概念

## 1.前面内容回顾

```
servlet and jsp的介绍
servlet容器
request response
范围内共享变量
系统事件的监听
```

## 2.本课重点：会话管理

```
1.session的工作原理
2.HttpSession及核心方法的使用
3.监听HttpSession
4.Cookie
5.URL重写
```

## 3.从购物车讲起Session

如何识别用户，用session id

> 可查看中文版P260。

原理：对客户的第一个request，服务器（就是servlet容器）创建一个唯一的 session id，并通过response把它返回给客户。客户再在以后的每一个请求中发回这个session id（我只认ID，我不认人）。

具体实现：报文头部传session id

```
HttpSession session = request.getSession();
该方法有两层含义：
如果是第一次请求，那么请求中就没有session id，则新建一个
如果请求报文中有，就找到那个session id
```

判断是否新建Session

```
		//设置中文编码
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		//判断session是否新建
		if (session.isNew()) {
			response.getWriter().println("创建了一个新session");
		}else{
			response.getWriter().println("欢迎回来");
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath()).append(new Date().toString());
```

## 4.Session常用方法

```
1、public void setAttribute(String name,String value)
    设定指定名字的属性的值，并将它添加到session会话范围内，如果这个属性是会话范围内存在，则更改该属性的值
2、public Object getAttribute(String name)
	在会话范围内获取指定名字的属性的值，返回值类型为object，如果该属性不存在，则返回null
3、public void removeAttribute(String name)
	删除指定名字的session属性，若该属性不存在，则出现异常
4、public void invalidate()
	使session失效。可以立即使当前会话失效，原来会话中存储的所有对象都不能再被访问
5、public String getId()
	获取当前的会话ID。每个会话在服务器端都存在一个唯一的标示sessionID，session对象发送到浏览器的唯一数据就是sessionID，它一般存储在cookie中
6、public void setMaxInactiveInterval(int interval)
	设置会话的最大持续时间，单位是秒，负数表明会话永不失效
7、public int getMaxInActiveInterval()
	获取会话的最大持续时间
8、使用session对象的getCreationTime()和getLastAccessedTime()方法可以获取会话创建的时间和最后访问的时间，但其返回值是毫秒，一般需要使用下面的转换来获取具体日期和时间
    Date creationTime = new Date(session.getCreationTime());  
    Date accessedTime = new Date(session.getLastAccessedTime());  
```

## 5.登陆案例

# 二、重点、难点知识讲解思路

1.使用session的原因

2.session的工作原理

这两部分让学生理解session的概念和工作原理，由浅入深，从访问网站的例子讲起。

3.HttpSession，掌握常用的方法

4.监听HttpSession，掌握如何监听会话

5.关于Cookie，机制

6.URL重写，方法

# 三、课堂补充案例

- ​


# 四、课堂提问准备

-  ​


# 五、课后补充作业

完成图书网相关步骤。