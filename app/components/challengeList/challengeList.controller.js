"use strict";

angular.module('challengR.challengeList.controller', ['ngRoute'])

.controller('challengeListCtrl', ['$location', '$http',
    function($location, $http) {
        var ctrl = this;

        function getChallenges() {
            $http({
                method: 'GET',
                url: 'http://localhost:9080/rest/json/challengeEndPoint/getList'
            }).then(function successCallback(response) {
                ctrl.challengeList = response.data;

            }, function errorCallback() {
                //mock data that I can test with
                ctrl.challengeList = [
                    {id: 1, title: 'some name', difficulty: 'easy'},
                    {id: 2, title: 'some name', difficulty: 'hard'},
                    {id: 3, title: 'some name', difficulty: 'easy'},
                    {id: 4, title: 'some name', difficulty: 'hard'},
                    {id: 5, title: 'some name', difficulty: 'easy'},
                    {id: 6, title: 'some name', difficulty: 'hard'},
                    {id: 7, title: 'some name', difficulty: 'easy'},
                    {id: 8, title: 'some name', difficulty: 'hard'},
                    {id: 9, title: 'some name', difficulty: 'easy'},
                    {id: 10, title: 'some name', difficulty: 'hard'}
                ];
            });
        }

        ctrl.openChallenge = function (challengeId) {
            $location.url('/challenge/' + challengeId);
        };

        getChallenges();
    }
]);