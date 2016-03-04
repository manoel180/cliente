'use strict';
var sysconferApp = angular.module('clienteApp', [ 'ngRoute' ]);


sysconferApp.run(['$location', '$rootScope', function($location, $rootScope) {
	$rootScope.$on('$routeChangeSuccess', function (event, current, previous) {
		$rootScope.title = current.$$route.title;
	});
}]);