angular.module('creditApp').controller('CreditAnalysisCtrl', [
  '$scope',
  '$http',
  CreditAnalysisController
]);

function CreditAnalysisController($scope, $http) {

  const vm = $scope;
  vm.client = {};

  vm.getGenres = function () {
    const url = 'http://localhost:8080/genres';
    $http.get(url).then(function (response) {
      vm.genres = response.data;
    });
  }

  vm.getMaritalStatus = function () {
    const url = 'http://localhost:8080/marital-status';
    $http.get(url).then(function (response) {
      vm.maritalStatus = response.data;
    });
  }

  vm.getState = function () {
    const url = 'http://localhost:8080/states';
    $http.get(url).then(function (response) {
      vm.states = response.data;
    });
  }

  vm.doAnalysis = function () {
    const url = 'http://localhost:8080/credit-analysis';
    $http.post(url, vm.client).then(function (response) {
      vm.creditAnalysisResult = response.data;
      console.log(vm.creditAnalysisResult);
    });
  }

  vm.getGenres();
  vm.getMaritalStatus();
  vm.getState();
}
