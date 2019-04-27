var app = angular.module('sample', []);

app.controller("SampleController", function ($scope, $http) {


    $scope.getList = function () {
        $http.get('/rest/sample').success(function (data, status, headers, config) {
            $scope.bookList = data;
        }).error(function (data, status, headers, config) {
            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };

});
