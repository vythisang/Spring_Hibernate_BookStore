<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div id="navbar" class="navbar navbar-default          ace-save-state">
		<div class="navbar-container ace-save-state" id="navbar-container">
			<div class="navbar-header pull-left">
					<a href="index.html" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							Book Store
						</small>
					</a>
			</div>
			
			
			
			<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue dropdown-modal">
							
							
							
							<c:choose >	
								<c:when test="${user != null}">
									<a  href="login" class="button">${user.name}</a>
								</c:when>
								<c:otherwise>
									<a  href="login" class="button">Login</a>
								</c:otherwise>
							</c:choose>
								
								
						</li>
					</ul>
			</div>
			
			<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue dropdown-modal">
							<%-- <li><i class="fa fa-user"></i> ${user}</li> --%>
							<a href="#" class=" add-to-cart">
								<i class="fa fa-shopping-cart" style="margin-top: 13px;"></i>
							</a>

						</li>
					</ul>
			</div>
				
		</div>
	</div>
	
</body>
</html>