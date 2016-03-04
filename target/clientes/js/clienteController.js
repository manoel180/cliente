'use strict';

//angular.module('clienteApp').
sysconferApp.controller('listCtrl', function ($scope, services) {
	services.getClientes().then(function(data){
		$scope.clientes = data.data;
	});
}).
controller('editCtrl', function ($scope, $rootScope, $location, $routeParams, services, cliente) {
	var clienteID = ($routeParams.clienteID) ? parseInt($routeParams.clienteID) : 0;
	$rootScope.title = 'Novo Cliente';
	$scope.buttonText = 'Salvar';
	var original = cliente;
	original._id = clienteID;
	
	if(cliente.data !== ""){
		$rootScope.title = 'Edição do cliente';
		$scope.buttonText =  'Editar';
		$scope.cliente = cliente.data;
	}

	$scope.isClean = function() {
		return angular.equals(original, $scope.cliente);
	}

	$scope.deleteCliente = function(cliente) {
		if(confirm("Deseja mesmo excluir esse cliente: "+$scope.cliente.nome)==true){
			services.deleteCliente($scope.cliente.id);
			$location.path('/');
		}
	};

	$scope.saveCliente = function(cliente) {
		services.insertCliente(cliente);
		//$location.path('/');
		$location.replace('/')
	};
});