angular.module('diretivas', [])
.directive('painel', function(){

    var ddo = {};

    ddo.restric = "AE";

    ddo.scope = {
        descricao: '@',
        pib: '@'
    };
    ddo.transclude = true;
    ddo.templateUrl = 'js/directives/painel.html';

    return ddo;
});