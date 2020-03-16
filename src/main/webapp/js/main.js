angular.module("paisApp", ['diretivas', 'ngRoute', 'ngResource', 'appService'])
.config(function($routeProvider, $locationProvider){

    // Arrumar no back-end
    $locationProvider.hashPrefix('');
    $locationProvider.html5Mode(true);

    $routeProvider.when('/web',{
        templateUrl: 'partials/principal.html',
        controller: 'PaisesController'
    });

    $routeProvider.when('/web/cadastro', {
        templateUrl: 'partials/cadastro.html',
        controller: 'PaisController'
    });

    $routeProvider.when('/web/cadastro/estado',{
        templateUrl: 'partials/estadocadastro.html',
        controller: 'EstadoController'
    });

    $routeProvider.when('/web/editar/:paisId', {
        templateUrl: 'partials/cadastro.html',
        controller: 'PaisController'
    });
 
    $routeProvider.otherwise({ redirectTo: '/web'});
});