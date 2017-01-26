"use strict";

angular.module('challengR.loginPage.controller', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/login', {
        templateUrl: 'components/pages/loginPage.partial.html',
        controller: 'LoginPageCtrl',
        controllerAs: '$ctrl'
    });
}])

    .controller('LoginPageCtrl', [function() {

    }]);