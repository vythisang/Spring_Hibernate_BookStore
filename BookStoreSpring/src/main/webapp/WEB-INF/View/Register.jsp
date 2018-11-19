<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

<title>Register</title>

</head>
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="ace-icon fa fa-leaf green"></i> <span class="red">Book store</span>
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
											<i class="ace-icon fa fa-coffee green"></i> Create new account
										</h4>

										<div class="space-6"></div>

										
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="name"
														type="text" class="form-control" placeholder="username" name="name" />
														<i class="ace-icon fa fa-user"></i>
												</span>
												</label> 
												
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="password"
														type="password" class="form-control" placeholder="password" name="password" />
														<i class="ace-icon fa fa-lock"></i>
												</span>
												</label> 
												
												
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="email"
														type="text" class="form-control"                           
														placeholder="email" name="email" /> <i class="ace-icon fa fa-user"  ></i>
												</span>
												</label>
												
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="dob"
														type="text" class="form-control"                           
														placeholder="day of birth" name="dob" /> <i class="ace-icon fa fa-user"  ></i>
												</span>
												</label>
												

												<div class="clearfix">
													

													<button type="submit" id="btnRegister"
														class="width-35 pull-right btn btn-sm btn-primary" >
														<i class="ace-icon fa fa-key"></i> <span
															class="bigger-110">Register</span>
													</button>
												</div>
												
												<div class="clearfix">
													<span id="resultRegister"></span>
												</div>
												
												<div class="space-4"></div>
											
											</fieldset>

										<div class="space-6"></div>

									</div>

									<div class="toolbar clearfix">

										<div>
											<a  id="comeToLogin"
												class="user-signup-link">  Login <i
												class="ace-icon fa fa-arrow-right"></i>
											</a>
										</div>
									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							

								
							<!-- /.signup-box -->
						</div>
						<!-- /.position-relative -->

						
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