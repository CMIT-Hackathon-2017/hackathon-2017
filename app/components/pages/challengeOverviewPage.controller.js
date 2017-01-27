"use strict";

angular.module('challengR.challengeOverviewPage.controller', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/challenges', {
        templateUrl: 'components/pages/challengeOverviewPage.partial.html',
        controller: 'challengeOverviewPageCtrl',
        controllerAs: '$ctrl'
    });
}])

.controller('challengeOverviewPageCtrl', [function() {

    var ctrl = this;

    ctrl.user = JSON.parse(sessionStorage.user);
}]);