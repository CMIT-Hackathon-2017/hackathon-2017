"use strict";

angular.module('challengR.login.controller', ['ngRoute'])

.controller('LoginCtrl', ['$location', '$http',
    function($location, $http) {
        var ctrl = this;

        ctrl.verifyLogin = function () {
            if(ctrl.password === 'hack17') {
                $http({
                    method: 'POST',
                    url: 'http://localhost:9080/rest/json/userEndPoint/post',
                    data: {
                        "email": ctrl.email,
                        "name": ctrl.name
                    }
                }).then(function successCallback(response) {
                    localStorage.user = JSON.stringify(response.data);

                    $location.url('/challenges');
                }, function errorCallback(response) {
                    console.log('error:', response);
                });
            } else {
                console.log("invalid password");
            }
        };
    }
]);