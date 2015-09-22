function logout() {
	$.ajax({
		url: 'rest/user/logout',
		type: "GET",
		dataType: "text"
	}).always(function(data){
		window.location.replace("index.html");
	});
}

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
    drawHWTable();
});
function drawHWTable() {
	var table = $("#studentHW");
    $.ajax({
        url : 'rest/homework/getHomeworks',
        type : "GET",
        dataType : "json",
        success : function(data) {
            renderTable(data, table);
        }
    });
}
function renderTable(data, table) {
    
    var tableThings = data.homework;
    for (var i = 0; i < tableThings.length; i++) {
        renderRow(tableThings[i], table);
    }
}
function renderRow(rowData, table) {
    var row = $("<tr />")
    table.append(row);
    row.append($("<td>" + rowData.title + "</td>"));
    row.append($("<td>" + rowData.endDate + "</td>"));
    row.append($("<td>" + rowData.subject + "</td>"));
    row.append($("<td>" + rowData.teacher + "</td>"));
    //if (isUserAuthenticated && rowData.amount > 0) {
    var detailsTd = $("<td />");
    var link = $("<button>Details</button>");
    detailsTd.append(link);
    row.append(detailsTd);
/*        link.click(function() {
            $.ajax({
                url: 'rest/homework/borrow?bookId=' + rowData.id,
                type: "PUT",
                dataType: "json",
                success: drawTableWithBooks
            });
        });
    } else {
        row.append($("<td/>"));
    }*/
}

function createHomework() {
    //var formUrl = $("#register_form").attr("action");
	var teacher;
    var title = $("#homework")[0].value;
    var description = $("#description")[0].value;
    var endDate = $("#dueDate")[0].value;
    var subject = $("#subject")[0].value;
    var faculty = $("#selectFaculty")[0].value;
    var spec = $("#selectSpec")[0].value;
    var year = $("#selectClass")[0].value;
 //TODO: proverki + proverka za registration
	$.ajax({
	    url: 'rest/user/currentUsr',
	    type: "GET",
	    contentType: "application/json"
	})
	.success(function(data) {
		teacher = data.user.email;
	})
    
    var data = { homework : {
	            title : title,
	            subject : subject,
	            description : description,
	            endDate : endDate,
	            teacher : teacher,
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
		window.location.replace("secondPage.html");
	})
	.fail(function(data) {
		window.location.replace("createHomework.html");
	    alert("Error");
	});
}

