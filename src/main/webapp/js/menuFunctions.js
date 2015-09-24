$(document).ready(function(){

	$.ajax({
		url: 'rest/user/currentUsr',
		type: "GET",
		datatype: "json"		
	}).success(function(data){
		teachersArr = $(".teachers");
		studentsArr = $(".students");
		var user = data.user;
		var currentArray;
		if (undefined !== user.isTeacher && true == user.isTeacher){
			currentArray = studentsArr;
		}
		else{
			currentArray = teachersArr;
		}
		for (i = 0; i < currentArray.length; i++) { 
			currentArray[i].style.display = "none";
		}
	});
});