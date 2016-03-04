'use strict';
//var sysconferApp = angular.module('clienteApp', [ 'ngRoute' ]);

sysconferApp.factory("services", ['$http', function($http) {
	var serviceBase = '/'
		var obj = {};
	obj.getClientes = function(){
		return $http.get(serviceBase + 'cliente');
	}
	obj.getCliente = function(clienteID){
		return $http.get(serviceBase + 'cliente/' + clienteID);
	}

	obj.insertCliente = function (cliente) {
		return $http.post(serviceBase + 'cliente', cliente).then(function (results) {
			return results;
		});
	};

	obj.deleteCliente = function (id) {
		return $http.delete(serviceBase + 'cliente/' + id).then(function (status) {
			return status.data;
		});
	};

	return obj;
}]);
