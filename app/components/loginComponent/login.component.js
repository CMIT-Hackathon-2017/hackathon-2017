'use strict';

angular.module('challengR.login.component', [])

    .directive('loginComponent', [function() {
        return {
            templateUrl: 'components/loginComponent/login.partial.html',
            controller: 'LoginCtrl',
            controllerAs: '$ctrl'
        }
    }]);