window.updateProductController = function (
  $scope,
  $http,
  $location,
  myService
) {
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
  var url = "http://localhost:8080";
  contructor();
  function contructor() {
    myService.listProduct().then(function (data) {
      var url1 = $location.absUrl().split("/");
      $scope.index = url1[url1.length - 1];
      $scope.id = data[$scope.index].id;
      $scope.brandId = data[$scope.index].brand.id;
      if(!$scope.brandId) {
        $scope.brandId = data[$scope.index].brand;
      }
      // console.log(data[$scope.index].brand);
      // getProduct
      $http.get(url + "/product/" + $scope.id).then(function (response) {
        var data = response.data;
        $scope.product = data;
        $scope.product.idStatus = data.status.id;
        $scope.product.idSubCate = data.subCategory.id;
      });
    });
  }
  $scope.updateProduct = function (event) {
    event.preventDefault();
    var c = url + "/product/update/" + $scope.id + "/" + $scope.brandId;
    $http.put(c, $scope.product).then(function (response) {
      getProductList();
    });
    $location.path("/");
    console.log($scope.product);
  };
  myService.listStatus().then(function (data) {
    $scope.listStatus = data;
  });
  myService.listSubcategory().then(function (data) {
    $scope.listSubcategory = data;
  });
  myService.listBrand().then(function (data) {
    $scope.listBrand = data;
  });
  function getProductList() {
    myService.listProduct().then(function (data) {
      $scope.listProduct = data;
    });
  }
};
