'use strict';

// Declare app level module which depends on views, and components
angular.module('challengR', [
  'ngRoute',
  'challengR.login.component',
  'challengR.login.controller',
  'challengR.loginPage.controller'

]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $routeProvider.otherwise({redirectTo: '/login'});
}]);
