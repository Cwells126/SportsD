<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
<title>CWELLS-Team Matcher </title>
<meta name=viewport content="user-scalable=no,width=device-width" />


<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/prototype/1.7.2.0/prototype.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jsonp.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/index.js"></script>



<link rel="stylesheet" href="css/style.css" type="text/css" />
<script type="text/javascript">var switchTo5x=true;</script>
<script type="text/javascript"
	src="http://w.sharethis.com/button/buttons.js"></script>
<script type="text/javascript">stLight.options({publisher: "62fa3aa0-3e14-4ed3-b743-4f2810d1e38e", doNotHash: false, doNotCopy: false, hashAddressBar: false});</script>

<script type="text/javascript">
jQuery(document).ready(function(){
	jQuery("a").click(function(){
		jQuery("#schedule").submit();
	  });
	});
</script>

</head>

<body>



	<div class="background">
		<div class="page">
			<div class="header">
				<a href="index.jsp" id="logo"><img src="images/logo.png"
					alt="logo"></a>

				<form method="POST" action="schedule.htm">
					<div>
						<input type="submit" id="schedule" name="_eventId_schedule1"
							value="lines" style="display: none;" />

						<ul>
							<li><a href="news.jsp">News</a></li>
							<li><a href="team.jsp">Team</a></li>

							<li>
								<button>Lines</button>
							</li>
							<li><a href="videos.jsp">Videos</a></li>
							<li><a href="about.jsp">About</a></li>
						</ul>
					</div>
				</form>
			</div>
			<div class="body home">
				<div>
					<div class="featured">
						<div>
							<h2>
								We Are The <br> Champions
							</h2>
							<p>Aliquam at neque diam. Nulla facilisi. Donec cursus lacus
								id urna mattis vestibulum. Lorem ipsum dolor sit amet,
								consectetur adipiscing elit.</p>
						</div>
					</div>
					<div>
						<div>
							<h3>Latest Videos</h3>
							<span><a href="videos.jsp">View More Videos</a></span>
							<ul>
								<li><a href="videos.jsp"><img src="images/video1.jpg"
										alt=""></a>
									<h4>Proin pellentesque convallis sapien a congue.</h4>
									<p>Aliquam at neque diam. Nulla facilisi. Donec cursus
										lacus id urna mattis vestibulum.</p></li>
								<li><a href="videos.jsp"><img src="images/video2.jpg"
										alt=""></a>
									<h4>Lorem ipsum consectetur adipiscing elit.</h4>
									<p>Donec cursus lacus id urna mattis vestibulum. Turpis ac
										malesuada aliquet, est tellus blandit tellus, eu dignissim
										arcu diam non orci.</p></li>
								<li><a href="videos.jsp"><img src="images/video3.jpg"
										alt=""></a>
									<h4>Donec cursus lacus id urna mattis vestibulum.</h4>
									<p>Fusce sagittis, turpis ac malesuada aliquet, est tellus
										blandit tellus, eu dignissim arcu diam non orci.</p></li>
							</ul>
						</div>
						<div>
							<h3>Featured</h3>
							<span><a href="news.jsp">View More Featured</a></span>
							<ul>
								<li><a href="news.jsp"><img src="images/featured1.jpg"
										alt=""></a>
									<h4>Proin pellentesque convallis sapien a congue.</h4>
									<p>Aliquam at neque diam. Nulla facilisi. Donec cursus
										lacus id urna mattis vestibulum.</p></li>
								<li><a href="news.jsp"><img src="images/featured2.jpg"
										alt=""></a>
									<h4>Lorem ipsum consectetur adipiscing elit.</h4>
									<p>Donec cursus lacus id urna mattis vestibulum. Turpis ac
										malesuada aliquet, est tellus blandit tellus, eu dignissim
										arcu diam non orci.</p></li>
								<li><a href="news.jsp"><img src="images/featured3.jpg"
										alt=""></a>
									<h4>Donec cursus lacus id urna mattis vestibulum.</h4>
									<p>Fusce sagittis, turpis ac malesuada aliquet, est tellus
										blandit tellus, eu dignissim arcu diam non orci.</p></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="sidebar">
					<div class="news">
						<span>Latest News</span>
						<ul>
							<li><a href="news.jsp">Lorem ipsum dolor sit</a> <span>Posted
									on 23 July 2023</span></li>
							<li><a href="news.jsp">Donec condimentum</a> <span>Posted
									on 23 July 2023</span></li>
							<li><a href="news.jsp">Nulla facilisi</a> <span>Posted
									on 23 July 2023</span></li>
							<li><a href="news.jsp">Nunc nec sem nisi</a> <span>Posted
									on 23 July 2023</span></li>
							<li><a href="news.jsp">Aliquam quam nulla</a> <span>Posted
									on 23 July 2023</span></li>
							<li><a href="news.jsp">Lorem ipsum dolor sit</a> <span>Posted
									on 23 July 2023</span></li>
							<li><a href="news.jsp">Donec condimentum</a> <span>Posted
									on 23 July 2023</span></li>
						</ul>
						<a href="news.jsp">Read More</a>
					</div>
					<div class="section">
						<span>Game Schedule</span>
						<ul>
							<li><a href="schedule.jsp">ZZTigers VS Alligaterz</a> <span>23
									July 2023 @ 9AM</span></li>
							<li><a href="schedule.jsp">ZZTigers VS Ninjas</a> <span>23
									July 2023 @ 9AM</span></li>
							<li><a href="schedule.jsp">ZZTigers VS Munkees</a> <span>23
									July 2023 @ 9AM</span></li>
							<li><a href="schedule.jsp">ZZTigers VS Cheetaz</a> <span>23
									July 2023 @ 9AM</span></li>
							<li><a href="schedule.jsp">ZZTigers VS AlienAnts</a> <span>23
									July 2023 @ 9AM</span> < <a
								href="<c:url value="/FileMonitor/ResultPage/"/>">click</a>/li>
						</ul>
						<a href="schedule.jsp">View Schedule</a>
					</div>
					<div>
						<span>Latest Tweets</span>
						<ul>
							<li>
								<p>
									<a href="#">Praesent urna odio, vehicula quis placerat nec,
										feugiat id purus. Proin vitae nibh in est molestie iaculis.</a>
								</p>
							</li>
							<li>
								<p>
									<a href="#">Nunc lacinia mi et quam eleifend ullamcorper
										scelerisque id tortor.</a>
								</p>
							</li>
							<li>
								<p>
									<a href="#">Mauris lobortis dolor ac ipsum fermentum nec
										placerat mauris luctus.</a>
								</p>
							</li>
						</ul>
						<a href="http://freewebsitetemplates.com/go/twitter/">Follow
							@zztigers <br> on Twitter
						</a>
					</div>
				</div>
			</div>
			<div class="footer">
				<form method="POST" action="videos.htm">
					<div>
						<ul>
							<li class="selected"><a href="index.jsp">Home</a>|</li>
							<li><a href="news.jsp">News</a>|</li>
							<li><a href="team.jsp">Team</a>|</li>
							<li><a href="schedule.jsp">Schedule</a>|</li>



							<li><input type="submit" value="Video Page" /></li>



							<li><a href="about.jsp">About</a></li>
						</ul>
						<p>&#169; ZZ TIGERS 2023. All Rights Reserved</p>
					</div>
				</form>
				<div class="connect">
					<span>Follow Us</span> <a
						href="http://freewebsitetemplates.com/go/facebook/" id="fb">fb</a>
					<a href="http://freewebsitetemplates.com/go/twitter/" id="twitter">twitter</a>
					<a href="http://freewebsitetemplates.com/go/googleplus/"
						id="googleplus">google+</a> <a
						href="http://www.freewebsitetemplates.com/misc/contact"
						id="contact">contact</a>
				</div>
			</div>
		</div>

	</div>

</body>

</html>

