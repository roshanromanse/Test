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
		 alert("test")
	    // _clearForm()
	 };		
	 function _error(response) {
		 alert("test1")
	     console.log(response.statusText);
	 };	
	 function _clearForm() {
	     $scope.form.firstName = "";
	     $scope.form.lastName = "";
	     $scope.form.email = "";
	     $scope.form.password = "";
	 };
});