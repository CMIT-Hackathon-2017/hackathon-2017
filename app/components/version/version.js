'use strict';

angular.module('challengR.version', [
  'challengR.version.interpolate-filter',
  'challengR.version.version-directive'
])

.value('version', '0.1');
