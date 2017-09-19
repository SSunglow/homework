<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="forum.hiber.plate.RunPlate"%>
<%@ page import="forum.hiber.plate.Plate"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//取得按实体查询的结果：
List list = RunPlate.searchAll();

%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>框架</title>

		
		<link href="css/main_c.css" rel="stylesheet" type="text/css">

		<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
		<script src="../AmazeUI-2.4.2/assets/js/amazeui.js" type="text/javascript"></script>
		
	</head>

	<body>
		<!--头 -->
		<header>
			<article>
				<div class="mt-logo">
					<!--顶部导航条 -->
					<div class="am-container header">
						<ul class="message-l">
							<div class="topMessage">
								<div class="menu-hd" >
									<img src="img/logo.png" style="margin-top: 15px;"/>
								</div>
							</div>
						</ul>
						<ul class="message-r" style="margin-top: 20px;">
							    <div class="topMessage favorite">
								        <a href="user_info_modify.html" target="_blank"><i class="am-icon-heart am-icon-fw"></i>个人中心</a>
							    </div>
							    <div class="topMessage my-shangcheng">
								        <a href="login.html" target="_blank"><i class="am-icon-user am-icon-fw"></i>登录</a>
							    </div>
							    <div class="topMessage favorite">
								        <a href="register.html" target="_blank"><i class="am-icon-heart am-icon-fw"></i>注册</a>
							    </div>
						</ul>
						</div>

						<!--悬浮搜索框-->

						<div class="nav white">

							<div class="search-bar pr">
								<a name="index_none_header_sysc" href="#"></a>
								<form>
									<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
									<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
								</form>
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
			</article>
		</header>

		<div class="nav-table">
			<div class="long-title"><span class="all-goods">首页</span></div>
			<div class="nav-cont">
				<ul>
					<li ><a href="#">聚焦</a></li>
					<li ><a href="#">校园榜</a></li>
				</ul>
			</div>
		</div>
		<b class="line"></b>

		<div class="center">
			<div class="col-main">
				<div class="main-wrap">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">热帖榜</strong> / <small>Hot !</small>
								<li>
									<span>
									<a href="#">天涯诗会</a>
									</span>
									<div>
										<a href="#" target="_blank">古意（为久未穿旗袍的自己写首诗点个赞）</a>
									</div>
								</li>
								
								<li class="li-line"></li>
								<li>
									<span>
									<a href="#">天涯诗会</a>
									</span>
									<div>
										<a href="#" target="_blank">古意（为久未穿旗袍的自己写首诗点个赞）</a>
									</div>
								</li>
								
								<li class="li-line"></li>
								<li>
									<span>
									<a href="#">天涯诗会</a>
									</span>
									<div>
										<a href="#" target="_blank">古意（为久未穿旗袍的自己写首诗点个赞）</a>
									</div>
								</li>
								
								<li class="li-line"></li>	
							</div>
							


						
						
						</div>
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">问答榜</strong> / <small>Interlocution ！</small>
								
								<li>
									<span>
									<a href="#">天涯诗会</a>
									</span>
									<div>
										<a href="#" target="_blank">古意（为久未穿旗袍的自己写首诗点个赞）</a>
									</div>
								</li>
								
								<li class="li-line"></li>
								<li>
									<span>
									<a href="#">天涯诗会</a>
									</span>
									<div>
										<a href="#" target="_blank">古意（为久未穿旗袍的自己写首诗点个赞）</a>
									</div>
								</li>
								
								<li class="li-line"></li>
								<li>
									<span>
									<a href="#">天涯诗会</a>
									</span>
									<div>
										<a href="#" target="_blank">古意（为久未穿旗袍的自己写首诗点个赞）</a>
									</div>
								</li>
								
								<li class="li-line"></li>
								
							</div>
						</div>
						<hr/>				
				</div>
				<!--底部-->
				<div class="footer">
					<div class="footer-hd">
						<p>
							<a href="#">科技学院</a>
							<b>|</b>
							<a href="#">论坛首页</a>
							<b>|</b>
							<a href="#">个人中心</a>
							<b>|</b>
							
							<s:if test="!session.getAttribute()">
							<a href="login.html" target="_blank">登录</a>
							<b>|</b>
							<a href="register.html" target="_blank">注册</a>
							</s:if>
							<s:if test="session.getAttribute()!=null">
							这是名字
							</s:if>
						</p>
					</div>
					<div class="footer-bd">
						<p>
							<a href="#">关于Forum_eagle</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<em>© 2015-2025 Forum_eagle.com 版权所有</em>
						</p>
					</div>
				</div>
			</div>

			<aside class="menu">
				<ul>

                <%
                	
                	String row="<li class='person'>";
                	for(int i=0;i<list.size();i++){
       			         row = row +"<li><a href='action!find.action'>"
       			             +((Plate)list.get(i)).getPlatename()+"</li>" ;
       			         } 
       				row = row +"</li>";
       			
       			//System.out.println(row);
       			out.println(row);
       			//out.write(row);
       			out.flush();
       			//out.close();
                %>
				</ul>

			</aside>
					
<a href="https://support.qq.com/products/4312" target="_blank" id="fankui" title="用户反馈" style="display:none" bossZone="fankui"></a>

<a href="http://www.qq.com/sheweishouye.htm" target="_blank" id="homeSet" title="设为首页" style="display:none" bossZone="defaulthome"></a>

		</div>

		


	</body>

</html>