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
            pythonMode,
            editor;

        ctrl.mockChallenge = {
            title: '1. Problem',
            description: 'Given an array of integers, return indices of the two numbers such that they add up to a specific target. You may assume that each input would have exactly one solution.',
            example: 'Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].',
            languages: ['Java', 'C#', 'Javascript', 'C++', 'PHP', 'Python'],
            boilerplateCode: {
                Java: 'import java.util.HashMap; import java.util.Map; public class Solution {public int[] twoSum(int[] numbers, int target) {Map<Integer, Integer> valueIndex = new HashMap<>();for(int i=0; i<numbers.length; i++) {if(valueIndex.containsKey(target-numbers[i])) {return new int[]{valueIndex.get(target-numbers[i]), i};}valueIndex.put(numbers[i], i);}return new int[]{-1,-1};}}',
            }
        };

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

            if(ctrl.mockChallenge.boilerplateCode[language]) {
                session.setValue(js_beautify(ctrl.mockChallenge.boilerplateCode[language], jsbOpts));
            } else {
                //fallback to Java
                ctrl.language = 'Java';
                session.setValue(js_beautify(ctrl.mockChallenge.boilerplateCode['Java'], jsbOpts));
            }
        }

        ctrl.runCode = function () {
            var usersCode = editor.getValue();

            //send usersCode to BE and verify with response
        };

        ctrl.submitCode = function () {
            var usersCode = editor.getValue();

            //send usersCode to BE and verify with response
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
            editor = ace.edit("editor");
            editor.setTheme("ace/theme/twilight");
            editor.session.setUseWrapMode(true);
            editor.setHighlightActiveLine(true);
            ctrl.language = 'Java';
            ctrl.setLanguage();
        }

        function initPage() {
            initEditor();
            getChallenge($routeParams.id);
        }

        initPage();
    }]);