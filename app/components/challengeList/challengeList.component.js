'use strict';

angular.module('challengR.challengeList.component', [])

.directive('challengeList', [function() {
    return {
        templateUrl: 'components/challengeList/challengeList.partial.html',
        controller: 'challengeListCtrl',
        controllerAs: '$ctrl'
    }
}]);