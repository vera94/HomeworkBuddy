
$(document).ready(function() {
	var userName;
	var email;
	var fullName;
	var faculty;
	var specialty;
	var number;
	
    $.ajax({
        url: 'rest/user/currentUsr',
        type: "GET",
        dataType : "json"
    }).success(function(data){
    
    	var user = data.user;
    	userName = user.userName;
    	email = user.email;
    	fullName = user.fullName;
    	faculty = user.faculty;
    	speciality = user.speciality;
    	number = user.number;
    	
    	
    	$("#usr").text(userName);
    	$("#email").text(email);
    	$("#fullName").text(fullName);
    	$("#faculty").text(faculty);
    	$("#speciality").text(speciality);
    	$("#number").text(number);
    	
    	
    });
});

