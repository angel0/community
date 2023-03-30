<p align="center">
	<img alt="logo" src="https://oscimg.oschina.net/oscnet/up-d3d0a9303e11d522a06cd263f3079027715.png">
</p>
<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">RuoYi-Vue-Super</h1>
<h4 align="center">🎉基于最新若依前后端分离版本，同步更新，并新增功能，集成hutools，mybatis-plus，lombok，knife4j，websocket，minio文件上传，集成flowable工作流，加入可视化大屏。</h4>
<p align="center">
	<a href="https://gitee.com/y_project/RuoYi-Vue/stargazers"><img src="https://gitee.com/y_project/RuoYi-Vue/badge/star.svg?theme=dark"></a>
	<a href="https://gitee.com/y_project/RuoYi-Vue"><img src="https://img.shields.io/badge/RuoYi-v3.8.5-brightgreen.svg"></a>
	<a href="https://gitee.com/y_project/RuoYi-Vue/blob/master/LICENSE"><img src="https://img.shields.io/github/license/mashape/apistatus.svg"></a>
</p>

## 平台简介

若依是一套全部开源的快速开发平台，毫无保留给个人及企业免费使用。

* 前端采用Vue、Element UI。
* 后端采用Spring Boot、Spring Security、Redis & Jwt。
* 权限认证使用Jwt，支持多终端认证系统。
* 支持加载动态权限菜单，多方式轻松权限控制。
* 高效率开发，使用代码生成器可以一键生成前后端代码。

## 新增功能
* 集成hutools，mybatis-plus，lombok，knife4j，websocket。
* 代码生成同时适配mybatis跟mybatis-plus。
* 集成xdh-map，基于openlayers灵活开发地图可视化，各种矢量图层，控件。
* 在字典管理基础上增加tree树形字典管理功能，方便树形字典开发与后期动态运维。
* 集成flowable工作流，代码引入芋道源码flowable工作流模块，适配若依官方代码，方便后期同步更新。
* 集成可视化大屏，代码引入奔跑的面条big-screen-vue-datav大屏vue2版本。
* [新增 mybatis-plus数据权限解决方案。](https://gitee.com/rainsuper/RuoYi-Vue-Super/wikis/pages?sort_id=5957319&doc_id=2965484)
* [新增 tenant 多租户解决方案（共享数据库方式）。](https://gitee.com/rainsuper/RuoYi-Vue-Super/wikis/pages?sort_id=5960193&doc_id=2965484)
* [新增 oss 文件上传插件，支持所有兼容s3协议的云存储：如阿里云OSS，腾讯云COS，七牛云，京东云，minio等。](https://gitee.com/rainsuper/RuoYi-Vue-Super/wikis/pages?sort_id=5966058&doc_id=2965484)

## 参考文档
第三方对接
<br>
>[整合Oauth2.0单点方案](https://gitee.com/rainsuper/RuoYi-Vue-Super/wikis/pages?sort_id=5949355&doc_id=2965484)
## 内置功能

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3.  岗位管理：配置系统用户所属担任职务。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7.  参数管理：对系统动态配置常用参数。
8.  通知公告：系统通知公告信息发布维护。
9.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql）支持CRUD下载 。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
16. 缓存监控：对系统的缓存信息查询，命令统计等。
17. 在线构建器：拖动表单元素生成相应的HTML代码。
18. 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。

## 在线体验

- admin/admin123  

旧演示地址：http://vue.ruoyi.vip  
旧文档地址：http://doc.ruoyi.vip

- 新增功能按照若依文档跑下就可以看到了，或者看下边的演示图。

## 演示图
- 若依官方显示图就不放了，这里只放新增的功能图片。
<table>
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-8718050af21ca54dea1391c5684f20d838a.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-f16c8428edb3204a3af8ab4a19e5612399d.png"/></td>
    </tr>
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-ca607503c780e75450921173221c6ba64f3.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-c74c5854e3b5a1dde619392f44ade569ec9.png"/></td>
    </tr>
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-d65d57f118414b7b2d87e2154758750fab3.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-e1e8b4a0d80f5815c6baa486b9699be3273.png"/></td>
    </tr>
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-1d200b0f83c633c1d74d16cbb5875044f08.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-bb8adc1535ac1d2d3f638360759d29fcb35.png"/></td>
    </tr>
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-d60db1c3f9fed65fb69530230ec66e04bfe.png"/></td>
    </tr>
</table>

## 若依Super前后端分离交流群
QQ群： [![加入QQ群](https://img.shields.io/badge/681646796-blue.svg)](https://jq.qq.com/?_wv=1027&k=bbKX5vcb) 点击按钮入群。

<img src="https://oscimg.oschina.net/oscnet/up-46988c34490f55cf09fd185a941d90cbba9.png"/>
