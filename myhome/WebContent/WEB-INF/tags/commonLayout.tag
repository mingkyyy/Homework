<%@ tag language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>My Homepage!</title>
	<meta charset="UTF-8"/>
	<meta name = "viewport" 
		  content = "width=device-width, initial-scale=1.0"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<style>
	.fakeimg {
		height: 200px;
		background: #aaa;
	}
	</style>
</head>

<body class="container-fluid bg-dark">

<!-- header : nav -->
<div id="header-container" 
	 class="jumbotron text-center bg-dark text-white"
	 style="margin-bottom:0">
	 
	 <h1 class="display-2">My Home!</h1>
	 <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	 	<a id="current-user" class="navbar-brand">로그인하세요.</a>
	 	<button class="navbar-toggler" type="button"
	 			data-toggle="collapse" data-target="#nav-items">
	 		<span class="navbar-toggler-icon"></span>		
	 	</button>
	 	
	 	<div class="collapse navbar-collapse" id="nav-items">
	 		<ul class="navbar-nav">
	 			<li class = "nav-item">
	 				<a class="nav-link active" href="/myhome/view/member/login.jsp">Login</a>
 				</li>
 				<li class = "nav-item">
	 				<a class="nav-link " href="/myhome/view/member/join.jsp">Join</a>
 				</li>
 				<li class = "nav-item">
	 				<a class="nav-link " href="#">Logout</a>
 				</li>
 				<li class = "nav-item">
	 				<a class="nav-link " href="#">MyPage</a>
 				</li>
 				<li class = "nav-item">
	 				<a class="nav-link " href="#">Board</a>
 				</li>
 				<li class = "nav-item">
	 				<a class="nav-link " href="#">Files</a>
 				</li>
 				<li class = "nav-item">
	 				<a class="nav-link " href="#">Manage</a>
 				</li>
	 		</ul>
	 	</div>
	 </nav>
</div>


<!-- 본문 -->
<div class="bg-dark text-white container-fluid p-5" style="min-height:55%">
	<div id="main-container">
		<jsp:doBody/>
	</div>
</div>

<!-- footer -->
<div id="footer-container" 
	class="footer jumbotron-fluid text-center p-3 text-white">
	<div class = "container">
		<p>&copy;2021. Minkyeong Kim. All Rights Reserved.</p>
	</div>

</div>

</body>
</html>
