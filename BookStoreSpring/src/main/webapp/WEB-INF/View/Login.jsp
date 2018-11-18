<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>s
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href='<c:url value="resources/css/bootstrap.min.css" />' />
<link rel="stylesheet"
	href='<c:url value="resources/font-awesome/4.5.0/css/font-awesome.min.css" />' />
<link rel="stylesheet"
	href='<c:url value="resources/css/fonts.googleapis.com.css" />' />
<link rel="stylesheet"
	href='<c:url value="resources/css/ace.min.css" />' id="main-ace-style" />
<link rel="stylesheet"
	href='<c:url value="resources/css/ace-skins.min.css" />' />
<link rel="stylesheet"
	href='<c:url value="resources/css/ace-rtl.min.css" />' />
</head>
<body class="login-layout">
	<div>
		<form id="ajax" action=${pageContext.request.contextPath} ></form>
	</div>
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="ace-icon fa fa-leaf green"></i> <span class="red">Shop</span>
								<span class="white" id="id-text2">Application</span>
							</h1>
							<h4 class="blue" id="id-company-text">&copy; Industrial HCM</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-coffee green"></i> Account
											information

										</h4>

										<div class="space-6"></div>

										<fieldset>
											
											 <label class="block clearfix">
												<span class="block input-icon input-icon-right"> <input
													type="text" class="form-control" id="name"
													placeholder="username" name="name" /> <i
													class="ace-icon fa fa-user"></i>
											</span>
											</label> <label class="block clearfix"> <span
												class="block input-icon input-icon-right"> <input
													type="password" class="form-control" placeholder="password"
													name="password" id="password" /> <i
													class="ace-icon fa fa-lock"></i>
											</span>
											</label>
											<div class="space"></div>
											<div class="clearfix">
												<input type="submit" value="Login" id="btnLogin"
													class="ace-icon fa fa-key" />
											</div>

											<div class="clearfix">
												<span id="ketqua"  ></span>
											</div>
											<div class="space-4"></div>
										</fieldset>


										<div class="space-6"></div>


									</div>
									<!-- /.widget-main -->

									<div class="toolbar clearfix">


										<div>
											<a href="/SpringShop/register" class="user-signup-link">
												Register <i class="ace-icon fa fa-arrow-right"></i>
											</a>
										</div>
									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.login-box -->

						</div>


					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.main-content -->
	</div>



	<script src='<c:url value="resources/js/jquery-2.1.4.min.js" />'></script>
	<script src='<c:url value="resources/js/custom.js" />'></script>

	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='<c:url value="/resources/js/jquery.mobile.custom.min.js" />' >"
							+ "<"+"/script>");
	</script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			$(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			});
		});

		//you don't need this, just used for changing background
		jQuery(function($) {
			$('#btn-login-dark').on('click', function(e) {
				$('body').attr('class', 'login-layout');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-light').on('click', function(e) {
				$('body').attr('class', 'login-layout light-login');
				$('#id-text2').attr('class', 'grey');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-blur').on('click', function(e) {
				$('body').attr('class', 'login-layout blur-login');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'light-blue');

				e.preventDefault();
			});

		});
	</script>

</body>
</html>