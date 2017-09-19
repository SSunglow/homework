<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="forum.hiber.plate.RunPlate"%>
<%@ page import="forum.hiber.plate.Plate"%>
<%@ page import="forum.hiber.posts.Posts" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List list = RunPlate.searchAll();
Plate plate= (Plate)session.getAttribute("plate");
List posts =(List) session.getAttribute("posts");
//int page = (int)session.getAttribute("page");
%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>框架</title>

		
		<link href="css/main_c.css" rel="stylesheet" type="text/css">

		<script src="js/jquery.min.js" type="text/javascript"></script>
		<script src="js/amazeui.js" type="text/javascript"></script>
		
	</head>

	<body style="background: url(img/bg1.jpg);">
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
							<div class="am-fl am-cf">
								<div class="introu" style="height: 150px; border: 1px solid #000000;">
									<div class="plated" style="height: 40px; background-color:  #4169E1;">
										<strong class="am-text-danger am-text-lg" style="font-size: 22px;font-weight: bolder;"><font color="#000000"><%=plate.getPlatename() %></font></strong>
									</div>
									
									<span style="font-size: 18px;">
										<br>
										<b style="font-weight: bold; font-size: 18px;">本版介绍：</b><%=plate.getDescribe() %>
                                        <br><b style="font-weight: bold;font-size: 18px;">开版时间：</b><%=plate.getPlatedate() %>
									</span>
								</div>
								
								<div class="introu" style="height: 150px; border: 1px solid #e0e0e0;">
									<div class="plated" style="height: 40px; background-color: #4169E1;">	
										<button type="button" class="spend-plate" style="height:40px;font-size: 22px;">默认</button>
										<button type="button" class="spend-plate" style="height:40px;font-size: 22px;">最新</button>
										<button type="button" class="spend-plate" style="height:40px;font-size: 22px;">精品</button>
										<button type="button" class="spend-plate" style="height:40px;font-size: 22px;float: right; margin-left: 5px;">发帖</button>
										<button type="button" class="spend-plate" style="height:40px;font-size: 22px;float: right;">刷新</button>
									</div>
									<br /> <br />
							<form class="m">
                                <table class="" style="width: 100%;">
                                    <thead>
                                        <tr>     
                                            <th class="table-title" >标题</th>
                                     <!--        <th class="table-type" >类别</th>--> 
                                            <th class="table-author " >作者</th>
                                            <th class="table-author " >点击</th>
                                            <th class="table-date " >回复</th>
                                            <th class="table-datetime " >回复时间</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                             for(int i = 0; i < posts.size(); i ++)
                                             {
                                                 String row="<tr align='center'>"
                                                               +"<td><a href = '#"+"'>"+((Posts)posts.get(i)).getTitle()+"</a></td>"
                                                               +"<td><a href = '#"+"'>"+((Posts)posts.get(i)).getAuthor()+"</a></td>"
                                                               +"<td>"+((Posts)posts.get(i)).getClicknum()+"</td>"
                                                               +"<td>"+((Posts)posts.get(i)).getReplynum()+"</td>"
                                                               +"<td>"+((Posts)posts.get(i)).getReplytime()+"</td>" 
                                                               +"</tr>";
       			                            out.println(row);
       			                            out.flush();
       			                             }
       			
                                         %>
                                       </tbody>
                                      </table>
                                      <br /> <br />
                                      <div align="center">	
                                        <button type="button" class="spend-plate"  style="height:40px;font-size: 22px;background-color: #007EE5; ">上一页</button>
										<button type="button" class="spend-plate" style="height:40px;font-size: 22px;background-color: #007EE5;">下一页</button>
                            </div>    
							</form>
								</div>
							</div>
											
						</div>				
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
							
							<s:if test="!session.getAttribute('login')">
							<a href="login.html" target="_blank">登录</a>
							<b>|</b>
							<a href="register.html" target="_blank">注册</a>
							</s:if>
							<s:if test="session.getAttribute('login')!=null">
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