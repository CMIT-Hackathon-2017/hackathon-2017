'use strict';

// Declare app level module which depends on views, and components
angular.module('challengR', [
  'ngRoute',
  'challengR.view1',
  'challengR.view2',
  'challengR.version'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/view1'});
}]);
