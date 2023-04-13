window.homeController = function ($scope, $http, $location, myService) {
  $scope.product = {
    color: "",
    productName: "",
    quantity: 0,
    sellPrice: 0,
    originPrice: 0,
    description: "",
    idStatus: 0,
    idBrand: 0,
    idSubCate: 0,
    brand: { id: 0, brandName: "" },
  };

  $scope.listProduct = {};

  var url = "http://localhost:8080";
  $scope.addProduct = function (event) {
    event.preventDefault();
    $http.post(url + "/product/add", $scope.product).then(function (response) {
      getProductList();
    });
    $location.path("/");
  };

  $scope.xoaProduct = function (event, index) {
    event.preventDefault();
    var id = $scope.listProduct[index].id;
    $http
      .delete(
        url + "/product/delete/" + id + "&" + $scope.listProduct[index].brand.id
      )
      .then(function (response) {
        getProductList();
      });
  };
  function getProductList() {
    myService.listProduct().then(function (data) {
      $scope.listProduct = data;
    });
  }
  myService.listStatus().then(function (data) {
    $scope.listStatus = data;
  });
  myService.listSubcategory().then(function (data) {
    $scope.listSubcategory = data;
  });
  myService.listCategory().then(function (data) {
    $scope.listCategory = data;
  });
  myService.listBrand().then(function (data) {
    $scope.listBrand = data;
  });
  getProductList();
};
