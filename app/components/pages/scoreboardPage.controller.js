"use strict";

angular.module('challengR.scoreboardPage.controller', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/scoreboard', {
            templateUrl: 'components/pages/scoreboardPage.partial.html',
            controller: 'scoreboardPageCtrl',
            controllerAs: '$ctrl'
        });
    }])

    .controller('scoreboardPageCtrl', [function() {
        var ctrl = this;

        if(localStorage.user) {
            var user = JSON.parse(localStorage.user);
        } else {
            ctrl.name = "Pavol";
        }

        if(user && user.name) {
            ctrl.name = user.name;
        }
    }]);