"use strict";

angular.module('challengR.login.controller', ['ngRoute'])

.controller('LoginCtrl', ['$location',
    function($location) {
        var ctrl = this;

        ctrl.doSignup = function () {
            var userObj = {
                email: ctrl.email,
                name: ctrl.name
            };

            $location.url('/challenges');
        };
    }
]);