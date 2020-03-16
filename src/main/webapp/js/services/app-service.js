angular.module('appService', ['ngResource'])
.factory('appServicePaises', function ($resource) {

    return $resource('/api/paises/:paisId', {id: '@id'}, {
        'update' : {
            method: 'PUT'
        }
    });
});