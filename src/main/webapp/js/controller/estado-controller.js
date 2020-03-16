angular.module('paisApp').controller('EstadoController', function($scope, appServicePaises){

    $scope.estado = {};

    $scope.salvar = function salvar(){
        appServicePaises.estados.save($scope.estado,function() {
            $scope.estado = {};
            $scope.mensagem = 'Adicionado com sucesso!';
            console.log('teste');
        }, function(erro) {
            $scope.mensagem = 'Erro ao adicionar!';
            console.log(error);
        });
    }

})