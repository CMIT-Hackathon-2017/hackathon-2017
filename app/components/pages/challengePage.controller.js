"use strict";

angular.module('challengR.challengePage.controller', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/challenge/:id', {
            templateUrl: 'components/pages/challengePage.partial.html',
            controller: 'ChallengePageCtrl',
            controllerAs: '$ctrl'
        });
    }])

    .controller('ChallengePageCtrl', ['$routeParams', '$scope', function($routeParams, $scope) {
        var ctrl = this,
            javaScriptMode,
            javaMode,
            cSharpMode,
            cppMode,
            phpMode,
            pythonMode;

        ctrl.mockChallenge = {
            title: '1. Problem',
            description: 'Given an array of integers, return indices of the two numbers such that they add up to a specific target. You may assume that each input would have exactly one solution.',
            example: 'Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].',
            languages: ['Java', 'C#', 'Javascript', 'C++', 'PHP', 'Python'],
            boilerPlateCode: ''
        };

        $scope.$on('$destroy', function() {
            editor && editor.destroy();
            editor && editor.container.remove();
        });

        ctrl.setLanguage = function (language) {
            switch(language) {
            case 'Javascript':
                editor.session.setMode(new javaScriptMode());
                break;
            case 'Java':
                editor.session.setMode(new javaMode());
                break;
            case 'C#':
                editor.session.setMode(new cSharpMode());
                break;
            case 'C++':
                editor.session.setMode(new cppMode());
                break;
            case 'PHP':
                editor.session.setMode(new phpMode());
                break;
            case 'Python':
                editor.session.setMode(new pythonMode());
                break;
            default:
                editor.session.setMode(new javaMode());
            }
        };

        function getChallenge(challengeId) {
            //get challenge with ID
        }

        function initEditor () {
            javaScriptMode = ace.require("ace/mode/javascript").Mode;
            javaMode = ace.require("ace/mode/javascript").Mode;
            cSharpMode = ace.require("ace/mode/javascript").Mode;
            cppMode = ace.require("ace/mode/javascript").Mode;
            phpMode = ace.require("ace/mode/javascript").Mode;
            pythonMode = ace.require("ace/mode/javascript").Mode;
            var editor = ace.edit("editor");
            editor.setTheme("ace/theme/twilight");
        }

        initEditor();
        getChallenge($routeParams.id);
    }]);