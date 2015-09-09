function logout() {
	$.ajax({
		url: 'rest/user/logout',
		type: "GET",
		dataType: "text"
	}).always(function(data){
		window.location.replace("welcome.html");
	});
}

function createHomework() {
    //var formUrl = $("#register_form").attr("action");
    var title = $("#homework")[0].value;
    var description = $("#description")[0].value;
    var endDate = $("#dueDate")[0].value;
    var subject = $("#subject")[0].value;
    var faculty = $("#selectFaculty")[0].value;
    var spec = $("#fselectSpec")[0].value;
    var year = $("#selectClass")[0].value;
 //TODO: proverki + proverka za registration
    
    var data = { user : {
	            title : title,
	            subject : subject,
	            description : description,
	            endDate : email,
	            teacher : title,
	            spec : spec,
	            year : year
			}
    }
    
	$.ajax({
	    url: 'rest/homework/addHomework',
	    type: "POST",
	    contentType: "application/json;charset=UTF-8",
	    data: JSON.stringify(data)
	})
	.success(function(data) {
		window.location.replace("welcome.html");
	})
	.fail(function(data) {
		window.location.replace("createHomework.html");
	    alert("Error");
	});
}

