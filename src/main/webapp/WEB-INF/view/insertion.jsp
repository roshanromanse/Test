<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script type="text/javascript">
	 var app = angular.module("UserManagement", []); 
	 app.controller("UserManagementController", function($scope, $http) {
	     $scope.form = {	      
	         firstName : "",
	         lastName : "",
	         email : "",
	         password : ""
	     };     
	     $scope.submitUser = function() {
	    	 $http({
		         method : "POST",
		         url : "addUser",
		         data : angular.toJson($scope.form),
		         headers : {
		             'Content-Type' : 'application/json'
		         }
		     }).then( _success, _error );
		 };
		 function _success(response) {
			 //alert("test");
			 var text = response.data.message;
			 document.getElementById("msg").innerHTML = text;
			 console.log(response);
		    // _clearForm()
		 };		
		 function _error(response) {
			 alert("error");
		     console.log(response.statusText);
		 };	
		 function _clearForm() {
		     $scope.form.firstName = "";
		     $scope.form.lastName = "";
		     $scope.form.email = "";
		     $scope.form.password = "";
		 };
	});
</script>

</head>
<body ng-app="UserManagement" ng-controller="UserManagementController">
	<form ng-submit="submitUser()" >
		Enter first name :<input type="text" ng-model="form.firstname"><br>
		Enter last name :<input type="text" ng-model="form.lastname"><br>
		Enter email :<input type="email" ng-model="form.email"><br>
		Enter password  :<input type="password" ng-model="form.password"><br>
		<span id="msg"></span><br />
		<input type="submit">	
	</form>
</body>
</html>