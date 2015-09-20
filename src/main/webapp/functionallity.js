	function reg() {
		window.location.replace("registration.html");
	}
	function goHome() {
		window.location.replace("index.html");
	}	
	
	function login() {
	    var userName = $("#userName")[0].value;
	    var password = $("#password")[0].value;
	    
	    
	    if(userName == "" || password == "") {
	    	alert("Email and password should not be empty.");
	    	return;
	    }
	    
	    var data = { user : {
	    		userName : userName,
	            password : password
			}
	    }
	
	    $.ajax({
		    url: 'rest/user/login',
		    type: "POST",
		    async: false,
		    contentType: "application/json;charset=UTF-8",
		    data: JSON.stringify(data),
		    statusCode: {
			        401: function() {
			        	alert("Authentication failed");			        	
			          },
			        200: function() {
			        	window.location.replace("secondPage.html");;
			        }
		        }
		    });
    }

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
//	$.ajax({
//	    url: 'rest/user/authenticated',
//	    type: "GET",
//        dataType : "json",
//	    statusCode: {
//		        200: function() {
//		        	$( ".login_register" ).hide();
//                    isUserAuthenticated = true;
//		        },
//		        404: function() {
//		        	$('.logout').hide();
//		        }
//	        }
//	    });
    $.ajax({
        url: 'rest/user/current',
        type: "GET",
        dataType : "text"
    }).always(function(data){
        if (typeof data != 'undefined') {
            $("#welcomeText").text("Welcome, "+ data);
        } else {
            //$(".welcome-greeting").hide();
        }
    });
});



function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah')
                .attr('src', e.target.result)
                .width(150)
                .height(200);
        };

        reader.readAsDataURL(input.files[0]);
    }
}

function roleChange(){
	if( $("#selectRole")[0].value === "teacher"){
		$("#tchOnly")[0].style.display = "block";
		$("#studOnly")[0].style.display = "none";
	}
	else{
		$("#tchOnly")[0].style.display = "none";
		$("#studOnly")[0].style.display = "block";		
	}
}
var fmiPorgrammes = ["Computer Science", "Informatics", "Software engineering"];
var eduProgrammes =["Education"];
var phisProgrammes = ["Engineering Physics", "Medical Physics", "Optometry"];
function setProgrammesOptions (programmes){

	deleteOptions();
	if(programmes){
		var specSelect = $('#selectSpec');
		var progr=0;
		for( progr ;progr < programmes.length; progr++){
			specSelect.append(
					$('<option></option>').val(programmes[progr]).html(programmes[progr]));
		}
	}
}
function facultySelect(){
	var faculty = $("#selectFaculty")[0].value;
	switch ( faculty){
		case "fmi":setProgrammesOptions (fmiPorgrammes); break;
		case "edu":setProgrammesOptions (eduProgrammes) ; break;
		case "phis":setProgrammesOptions (phisProgrammes) ; break;
		default : setProgrammesOptions("");break;
	}
	
}

function deleteOptions(){
	var select = $("#selectSpec")[0];
	var length = select.options.length;
	while ( 0 <= --length) {
	  select.options[length] = null;
	}
}

function register() {
    var formUrl = $("#register_form").attr("action");
    var username = $("#usr")[0].value;
    var password = $("#pwd")[0].value;
    var fullname = $("#full_name")[0].value;
    var email = $("#email")[0].value;
    var number = $("#number")[0].value;
    var role = $("#selectRole")[0].value;
    var securityCode = $("#security_code")[0].value;
    var faculty = $("#selectFaculty")[0].value;
    var spec = $("#selectSpec")[0].value;
    var year = $("#selectClass")[0].value;
    var facNum = $("#facNum")[0].value;
    var isTeacher = 0;
    if(role == "teacher"){
    	isTeacher = securityCode;
    }
    if(!isPasswordValid(password)) {
        return ;
    }
    
    var data = { user : {
    		userName : username,
            password : password,
            fullName : fullname,
            email : email,
            number : number,
            isTeacher : isTeacher,
            faculty : faculty,
            speciality : spec,
            year : year,
            facNum : facNum
		}
    }
    
	$.ajax({
	    url: 'rest/user/register',
	    type: "POST",
	    contentType: "application/json;charset=UTF-8",
	    data: JSON.stringify(data)
	})
	.success(function(data) {
		window.location.replace("secondPage.html");
	})
	.fail(function(data) {
		window.location.replace("registration.html");
	    alert("Error");
	});
}
function isPasswordValid(password) {
    var confirmPassword = $("#pwd_confirm")[0].value;
    if (password == "" || confirmPassword == "") {
        alert("Please fill both fields for password and try again.");
        return false;
    }
    if (password != confirmPassword) {
        alert("Two passwords do not match. Please correct the values and try again.");
        return false;
    }
    return true;
}
