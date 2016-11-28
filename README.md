# jsp-servlet-course

# 一、基本情况

1、项目为jsp-servlet课程的配套示例

2、doc目录下为教案

3、项目基于servlet3.0规范。jdk环境为1.8，服务器为tomcat7

# 二、第三方库

| 排序   | 第三方组件名称         | 备注               |
| ---- | --------------- | ---------------- |
| 1    | JSTL            | JSP 标准标签库        |
| 2    | jsp smartupload | 简单强大的上传类库，本项目有示例 |
| 3    | junit           | 单元测试类库           |
| 4    | fastjson        | json类库           |
| 5    |                 |                  |
| 6    |                 |                  |

# 三、明细

## 1、request头信息

## 2、表单提交（支持中文）

## 3、原生文件上传（io操作）

## 4、smartupload方式文件上传

原生的smartupload对编码这一块没有做处理，导致上传中文名字的图片时文件名乱码，因此反编译并修改了smartupload代码，重新打成jar包。

为支持中文命名的图片显示，需要修改Tomcat服务器\conf\server.xml，添加URIEncoding="UTF-8"，如下所示：

```
<Connector 
	connectionTimeout="20000" 
	port="8080" 
	protocol="HTTP/1.1" 
	redirectPort="8443" 
	URIEncoding="UTF-8"
/>
```

## 5、Servlet3.0方式文件上传

在Servlet3.0中上传文件变得非常简单。

我们只需通过request的getPart(String partName)获取到上传的对应文件对应的Part或者通过getParts()方法获取到所有上传文件对应的Part。

之后我们就可以通过part的write(String fileName)方法把对应文件写入到磁盘。

或者通过part的getInputStream()方法获取文件对应的输入流，然后再对该输入流进行操作。

要使用request的getPart()或getParts()方法对上传的文件进行操作的话，有两个要注意的地方。

1. 首先，用于上传文件的form表单的enctype必须为multipart/form-data；
2. 其次，对于使用注解声明的Servlet，我们必须在其对应类上使用@MultipartConfig进行标注，而对于在web.xml文件进行配置的Servlet我们也需要指定其multipart-config属性，如

```
   <servlet>
      <servlet-name>xxx</servlet-name>
      <servlet-class>xxx.xxx</servlet-class>
      <multipart-config></multipart-config>
   </servlet>
   <servlet-mapping>
      <servlet-name>xxx</servlet-name>
      <url-pattern>/servlet/xxx</url-pattern>
   </servlet-mapping>
```
## 6、图片显示与下载

未完结

# 四、其它

