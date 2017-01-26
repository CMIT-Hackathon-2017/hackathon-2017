"use strict";

angular.module('challengR.challengeList.controller', ['ngRoute'])

.controller('challengeListCtrl', ['$location',
    function($location) {
        var ctrl = this;

        ctrl.challengeList = [
            {id: 1, title: 'some name', difficulty: 'easy', status: 'Not completed'},
            {id: 2, title: 'some name', difficulty: 'hard', status: 'completed'},
            {id: 3, title: 'some name', difficulty: 'easy', status: 'Not completed'},
            {id: 4, title: 'some name', difficulty: 'hard', status: 'completed'},
            {id: 5, title: 'some name', difficulty: 'easy', status: 'Not completed'},
            {id: 6, title: 'some name', difficulty: 'hard', status: 'completed'},
            {id: 7, title: 'some name', difficulty: 'easy', status: 'Not completed'},
            {id: 8, title: 'some name', difficulty: 'hard', status: 'completed'},
            {id: 9, title: 'some name', difficulty: 'easy', status: 'Not completed'},
            {id: 10, title: 'some name', difficulty: 'hard', status: 'completed'}
        ];
    }
]);