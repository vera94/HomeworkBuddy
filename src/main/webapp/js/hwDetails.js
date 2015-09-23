$(document).ready(function() {
	$.ajax({
	    url: 'rest/user/authenticated',
	    type: "GET",
        dataType : "json",
	    statusCode: {
		        404: function() {
		        	logout();
		        }
	        }
	    });
    $.ajax({
        url: 'rest/homework/homework?homeworkId=' +window.location.search.substring(1,10),
        type: "GET",
        dataType: "json",
        success: (function(data) {
    		teacher = data.homework.id;
    		alert(id);
    	})
    });
});