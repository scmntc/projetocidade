angular.module('diretivas', [])
.directive('painel', function(){

    var ddo = {};

    ddo.restric = "AE";

    ddo.scope = {
        descricao: '@',
        pib: '@',
        populacao: '@',
        emancipacao: '@'
    };
    ddo.transclude = true;
    ddo.templateUrl = 'js/directives/painel.html';

    return ddo;
});