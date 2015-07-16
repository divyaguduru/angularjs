<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<html ng-app='' >
  <head>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular.min.js"></script>
   
  </head>
 
  <body>
   <div >
    <script>
    function regController($scope, $http)
    {
          
    	 $scope.person={};
      $scope.registerDetailsJustRead = function() 
      {
        $http({
          method: 'POST',
          url: 'RegistrationFormController',
          
          data:  $scope.person
        }).success(function (data) 
          {
        	$scope.objdata=data;
          });
      };
    }
    </script>
     <form ng-controller="regController">
    <h1> Registration Details</h1>
    <p>Name:</p><input type="text" id="name" name="name" ng-model="person.name"> 
    <p>Father's Name:</p><input type="text" id="fname" name="fname" ng-model="person.fname">
    <p>House Number:</p><input type="text" id="houseno" name="houseno" ng-model="person.houseno">
    <p>Street Name:</p><input type="text" id="streetname" name="streetname" ng-model="person.streetname">
    <p>City:</p><input type="text" id="city" name="city" ng-model="person.city">
     
      <button ng-click="registerDetailsJustRead()">Read Details</button>
     
           <p>Your Name : {{objdata.name}}</p>
           <p>Father's Name : {{objdata.fname}}</p>
           <p>House No : {{objdata.houseno}}</p>
           <p>Street Name :{{objdata.streetname}}</p>
           <p>City : {{objdata.city}}</p>
           
    </form>
    </div>
  </body>
 
</html>
