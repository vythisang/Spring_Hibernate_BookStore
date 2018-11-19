$(document).ready(function(){
	
	$("#btnLogin").click(function(){
		
		var name = $("#name").val();
		var password = $("#password").val();
		
		
		
		$.ajax({
			
			url:"/BookStoreSpring/api/checkLogin/",
			type:"GET",
			data:{
				name : name,
				password : password
			},
			success:function(value){
				if(value == "false"){
					$("#ketqua").html("Account is illegal");
				}else{
					currentlyLink = window.location.href;
					link = currentlyLink.replace("login","");
					window.location = link;
				}
				
			}
			
		});
	
	});
	
	
	$("#btnRegister").click(function(){
		
		var name  	  = $("#name").val();
		var password  = $("#password").val();
		var email      = $("#email").val();
		var dob      = $("#dob").val();
		
		$.ajax({
			
			url:"/BookStoreSpring/api/checkRegister/",
			type:"GET",
			data:{
				name:name,
				password:password,
				email:email,
				dob:dob
			},
			success:function(value){
				if(value=="true"){
					$("#resultRegister").html("Register successfull");
				}else{
					$("#resultRegister").html("This name have existed");
					
				}
			}
		});
		
		
	});
	
	
	$("#comeToLogin").click(function(){
		currentlyLink = window.location.href;
		link = currentlyLink.replace("register","login");
		window.location = link;
	})
	
	
	
	
	
	
})