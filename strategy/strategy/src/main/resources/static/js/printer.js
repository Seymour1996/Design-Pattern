/*<![CDATA[*/
/*]]>*/

var app = angular.module('app', []);
app.controller('MainController', Calculate);

function doAction($scope, $http, url, method, data) {
    $scope.message = '';
    $http({
        url : url,
        method : method,
        headers : {
            'Content-Type' : 'application/x-www-form-urlencoded'
        },
        data : data
    }).success(function(r) {
        /*alert(r.msg)*/
        $scope.message = r.msg;
        /*if (!r.success) {
        $scope.message = r.message;
        return;
        }*/
        //window.location.href = '/success';
    });
}


function Calculate($rootScope, $scope, $http) {
    $scope.price = '';
    $scope.name = '';
    $scope.strategy = '';
    $scope.discount = '0';


    $scope.calculatePrice = function() {
        var data = 'name=' + $scope.name
            + '&strategy=' + $scope.strategy
            + '&discount=' + $scope.discount;
        doAction($scope, $http, '/calculate', 'POST', data);
    }
}