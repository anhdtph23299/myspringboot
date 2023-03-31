var app = angular.module("myApp", ["ngRoute"]);
var URL =
  "http://nhlwc.cdnak.neulion.com/fs1/nhl/league/teamroster/NJD/iphone/clubroster.json";

app.config(function ($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix("");
  $routeProvider
    .when("/", {
      templateUrl: "./pages/home.html",
      controller: homeController,
    })
    .when("/product/update/:id", {
      templateUrl: "./pages/updateProduct.html",
      controller: updateProductController,
    })
    .when("/product/add", {
      templateUrl: "./pages/addProduct.html",
      controller: homeController,
    })
    .otherwise({
      redirectTo: "/",
    });
});
app.service("myService", function ($http) {
  var url = "http://localhost:8080";
  this.listBrand = function () {
    return $http.get(url + "/brand/hien-thi").then(function (response) {
      return response.data;
    });
  };
  this.listCategory = function () {
    return $http.get(url + "/category/hien-thi").then(function (response) {
      return response.data;
    });
  };
  this.listSubcategory = function () {
    return $http.get(url + "/subcategory/hien-thi").then(function (response) {
      return response.data;
    });
  };
  this.listStatus = function () {
    return $http.get(url + "/status/hien-thi").then(function (response) {
      return response.data;
    });
  };
  this.listProduct = function () {
    return $http.get(url + "/product/hien-thi").then(function (response) {
      return response.data;
    });
  };
});

// app.run(function ($rootScope, $http) {
//   var url = "http://localhost:8080";
//   $rootScope.hienThiBrand = function () {
//     $http.get(url + "/brand/hien-thi").then(function (response) {
//       $rootScope.listBrand = response.data;
//     });
//   };
//   $http.get(url + "/category/hien-thi").then(function (response) {
//     $rootScope.listcategory = response.data;
//   });
//   $http.get(url + "/status/hien-thi").then(function (response) {
//     $rootScope.listStatus = response.data;
//   });
//   $http.get(url + "/subcategory/hien-thi").then(function (response) {
//     $rootScope.listSubcategory = response.data;
//   });
//   $rootScope.hienThi = function () {
//     $http.get(url + "/product/hien-thi").then(function (response) {
//       $rootScope.listProduct = response.data;
//     });
//   };
//   $rootScope.hienThi();
//   $rootScope.hienThiBrand();
// });
// app.factory("ProductService", [
//   "$http",
//   function ($http) {
//     var urlBase = "http://localhost:8080";
//     var ProductService = {};

//     ProductService.getProducts = function () {
//       return $http.get(urlBase + "/product/hien-thi");
//     };

//     // ProductService.getProductById = function (id) {
//     //   return $http.get(urlBase + "/get/" + id);
//     // };

//     ProductService.addProduct = function (product) {
//       return $http.post(urlBase + "/add", product);
//     };

//     ProductService.updateProduct = function (id, product) {
//       return $http.put(urlBase + "/update/" + id, product);
//     };

//     ProductService.deleteProduct = function (id) {
//       return $http.delete(urlBase + "/delete/" + id);
//     };

//     return ProductService;
//   },
// ]);
