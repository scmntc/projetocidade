angular.module('paisApp').controller('PaisesController', function($scope, appServicePaises) {

    $scope.paises = [];
    $scope.mensagem = '';

    appServicePaises.query(function(paises) {
        $scope.paises = paises;
    }, function(erro) {
        console.log(erro);
    });

    $scope.remover = function (pais) {
       appServicePaises.delete({paisId : pais.id}, function() {
            $scope.pais = {};
            $scope.mensagem = 'Removido com sucesso!';
            var index = $scope.paises.indexOf(pais);
            $scope.paises.splice(index, 1);
            console.log(value);
        }, function(error){
            $scope.mensagem = 'Erro ao Remover!';
            console.log(error);
        });

    }
});