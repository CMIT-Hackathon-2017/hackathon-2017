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
                    console.log('got successful response, storing user in sessionStorage:', response);

                    sessionStorage.user = JSON.stringify(response);

                    $location.url('/challenges');
                }, function errorCallback(response) {
                    console.log(response);
                });
            } else {
                console.log("invalid password");
            }
        };
    }
]);