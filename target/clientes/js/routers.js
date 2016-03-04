'use strict';
sysconferApp.config(['$routeProvider',
                     function($routeProvider) {
	$routeProvider.
	when('/', {
		title: 'Clientes',
		templateUrl: '/pages/clientes.html',
		controller: 'listCtrl'
	})
	.when('/cliente/:clienteID', {
		title: 'Cliente',
		templateUrl: '/pages/cliente.html',
		controller: 'editCtrl',
		resolve: {
			cliente: function(services, $route){
				var clienteID = $route.current.params.clienteID;
				
				return services.getCliente(clienteID);
			}
		}
	})
	
	.otherwise({
		redirectTo: '/'
	});
}]);
