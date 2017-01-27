"use strict";

angular.module('challengR.challengePage.controller', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/challenge/:id', {
            templateUrl: 'components/pages/challengePage.partial.html',
            controller: 'ChallengePageCtrl',
            controllerAs: '$ctrl'
        });
    }])

    .controller('ChallengePageCtrl', ['$routeParams', '$scope', '$http', '$location', function($routeParams, $scope, $http, $location) {
        var ctrl = this,
            javaScriptMode,
            javaMode,
            cSharpMode,
            cppMode,
            phpMode,
            pythonMode,
            editor;

        ctrl.displayResults = false;

        $scope.$on('$destroy', function() {
            editor && editor.destroy();
            editor && editor.container.remove();
        });

        ctrl.setLanguage = function () {
            var language = ctrl.language;

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

            setBoilerPlateCode(language);
        };

        function setBoilerPlateCode(language) {
            var session = editor.getSession();
            var jsbOpts = {
                indent_size : 4
            };

            if(ctrl.challenge.languageCodePairs && ctrl.challenge.languageCodePairs[language]) {
                session.setValue(js_beautify(ctrl.challenge.languageCodePairs[language], jsbOpts));
            } else {
                //fallback to Java
                ctrl.language = 'Java';
                session.setValue(js_beautify(ctrl.challenge.languageCodePairs['Java'], jsbOpts));
            }
        }

        ctrl.runCode = function () {
            var usersCode = editor.getValue();
            ctrl.displayResults = true;

            //send usersCode to BE and verify with response
        };

        ctrl.submitCode = function () {
            var usersCode = editor.getValue();
            ctrl.displayResults = true;
            ctrl.loading = true;

            $location.url('/scoreboard');
        };

        function getChallenge(challengeId) {
            $http({
                method: 'GET',
                url: 'http://localhost:9080/rest/json/challengeEndPoint/get/' + challengeId
            }).then(function successCallback(response) {
                ctrl.challenge = response.data;

                ctrl.languages = Object.keys(ctrl.challenge.languageCodePairs);

                ctrl.setLanguage();

            }, function errorCallback() {
                //mock data that I can test with
                ctrl.challenge = {
                    title: '1. Problem',
                    description: 'Given an array of integers, return indices of the two numbers such that they add up to a specific target. You may assume that each input would have exactly one solution.',
                    sample: 'Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].',
                    languageCodePairs: {
                        'Java': 'import java.util.HashMap; import java.util.Map; public class Solution {public int[] twoSum(int[] numbers, int target) {Map<Integer, Integer> valueIndex = new HashMap<>();for(int i=0; i<numbers.length; i++) {if(valueIndex.containsKey(target-numbers[i])) {return new int[]{valueIndex.get(target-numbers[i]), i};}valueIndex.put(numbers[i], i);}return new int[]{-1,-1};}}',
                        'Javascript': 'Javascript boilerplateCode'
                    }
                };

                ctrl.languages = Object.keys(ctrl.challenge.languageCodePairs);

                ctrl.setLanguage();
            });
        }

        function initEditor () {
            javaScriptMode = ace.require("ace/mode/javascript").Mode;
            javaMode = ace.require("ace/mode/javascript").Mode;
            cSharpMode = ace.require("ace/mode/javascript").Mode;
            cppMode = ace.require("ace/mode/javascript").Mode;
            phpMode = ace.require("ace/mode/javascript").Mode;
            pythonMode = ace.require("ace/mode/javascript").Mode;
            editor = ace.edit("editor");
            editor.setTheme("ace/theme/twilight");
            editor.session.setUseWrapMode(true);
            editor.setHighlightActiveLine(true);
            editor.$blockScrolling = Infinity;
            ctrl.language = 'Java';
        }

        function initPage() {
            getChallenge($routeParams.id);
            initEditor();
        }

        initPage();

        //mock data
        ctrl.userInput = '[3,2,4]';
        ctrl.userAnswer = '[1,2]';
        ctrl.expectedAnswer = '[1,2]';
    }]);