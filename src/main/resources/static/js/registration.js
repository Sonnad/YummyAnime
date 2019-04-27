var app = angular.module('registration', []);

app.controller("RegistrationController", function ($scope, $http) {


    $scope.signup = function (username, password) {

        if (username === "") username = undefined;
        if (password === "") password = undefined;

        $http.post('/rest/sample/signup/' + username + '/' + password).success(function (data, status, headers, config) {
            $scope.isError = false;
            $scope.isSuccess = true;
        }).error(function (data, status) {
            $scope.errorMessage = data.message;
            $scope.isError = true;
            $scope.isSuccess = false;
            console.warn("Status code: " + status + "\nError: " + data.message);
        });
    };

});
