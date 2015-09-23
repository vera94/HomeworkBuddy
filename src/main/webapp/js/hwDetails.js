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
        url: 'rest/homework/'+ window.location.search.substring(1,10),
        type: "GET",
        dataType: "json",
        success: (function(data) {
    		homework = data.homework;
    		$("#homework").text(homework.title);
    		$("#description").text(homework.description);
    		$("#datetime").text(homework.endDate.substring(0,10));
    		
    		
    	})
    });
});