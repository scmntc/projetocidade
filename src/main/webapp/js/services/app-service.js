angular.module('appService', ['ngResource'])
    .factory('appServicePaises', function ($resource) {

        return {
            paises: $resource('/api/paises/:paisId', { id: '@id' }, {
                'update': {
                    method: 'PUT'
                }
            }),
            estados: $resource('/api/estados/:estadoId', {id: '@id'}, {
                'update':{
                    method: 'PUT'
                }
            })
        };
    });