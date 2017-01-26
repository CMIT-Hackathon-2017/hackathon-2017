'use strict';

// Declare app level module which depends on views, and components
angular.module('challengR', [
    'ngRoute',
    'challengR.login.component',
    'challengR.login.controller',
    'challengR.loginPage.controller',
    'challengR.challengeOverviewPage.controller',
    'challengR.challengeList.controller',
    'challengR.challengeList.component'

]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $routeProvider.otherwise({redirectTo: '/login'});
}]);

//$(document).foundation();
