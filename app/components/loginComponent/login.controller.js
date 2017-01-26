"use strict";

angular.module('challengR.login.controller', ['ngRoute'])

.controller('LoginCtrl', [function() {
    var ctrl = this;

    this.doSignup = function () {
        alert(ctrl.email);
    };
}]);