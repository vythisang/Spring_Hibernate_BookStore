$(document).ready(function(){
	
	$("#btnLogin").click(function(){
		
		var name = $("#name").val();
		var password = $("#password").val();
		
		
		
		$.ajax({
			
			url:"http://localhost:8080/BookStoreSpring/api/checkLogin/",
			type:"GET",
			data:{
				name : name,
				password : password
			},
			success:function(value){
				if(value == "false"){
					$("#ketqua").html("Account is illegal");
				}else{
					currentLink = window.location.href;
					link = currentLink.replace("login","");
					window.location = link;
				}
				
			}
			
		});
	
	});
	
	
	
	
	
	
	
})