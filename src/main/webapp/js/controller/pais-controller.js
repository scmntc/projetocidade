angular.module('paisApp').controller('PaisController', function ($scope, appServicePaises, $routeParams) {

    $scope.pais = {};
    $scope.mensagem = '';

    if($routeParams.paisId){
      appServicePaises.get({paisId:$routeParams.paisId}, function (pais) {
          pais.dataEmancipacao = new Date(pais.dataEmancipacao); // Converte a data para objeto data para não ocorrer ngModel:datefmt
          $scope.pais = pais;
      }, function (error) {
          console.log(error);
      });
    }

    $scope.submeter = function () {
        if ($scope.formulario.$valid) {
            if ($scope.formulario.$valid) {

                if($routeParams.paisId) {

                    appServicePaises.update({paisId: $scope.pais.id},
                        $scope.pais, function(value) {
                            $scope.pais = {};
                            $scope.mensagem = 'Alterado com sucesso!';
                            $scope.myFunction();
                        }, function(error) {
                            $scope.mensagem = 'Erro ao alterar!';
                            $scope.myFunction();
                            console.log(error);
                        });
                } else {
                    appServicePaises.save($scope.pais,function() {
                        $scope.pais = {};
                        $scope.mensagem = 'Adicionado com sucesso!';
                        $scope.myFunction();
                    }, function(erro) {
                        $scope.mensagem = 'Erro ao adicionar!';
                        $scope.myFunction();
                        console.log(error);
                    });
                }
            }
        }

    }

    $scope.myFunction = function myFunction() {
        // Get the snackbar DIV
        var x = document.getElementById("snackbar");

        // Add the "show" class to DIV
        x.className = "show";

        // After 3 seconds, remove the show class from DIV
        setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
    }
});