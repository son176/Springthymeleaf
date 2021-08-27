app.controller("user-ctrl", function ($scope, $http) {
  $scope.items = [];
  $scope.cates = [];
  $scope.form = {};
  $scope.initialize = function () {
    //load user
    $http.get("/rest/accounts/users").then((resp) => {
      $scope.items = resp.data;
    });
  };
  //bat dau
  $scope.initialize();

  //xoa form
  $scope.reset = function () {
    $scope.form = {
      createDate: new Date(),
      image: "cloud-upload.jpg",
      available: true,
    };
  };
  //hien thi len form
  $scope.edit = function (item) {
    $scope.form = angular.copy(item);
    $(".nav-tabs a:eq(0)").tab("show");
  };
  //them sp moi
  $scope.create = function () {
    var item = angular.copy($scope.form);
    $http
      .post("/rest/accounts", item)
      .then((resp) => {
        $scope.items.push(resp.data);
        $scope.reset();
        alert("Thêm mới thành công");
      })
      .catch((error) => {
        alert("Thêm thất bại");
        console.log("Error", error);
      });
  };
  // update
  $scope.update = function () {
    var item = angular.copy($scope.form);
    $http
      .put("/rest/accounts/" + item.username, item)
      .then((resp) => {
        var index = $scope.items.findIndex(p => p.username == item.username);
        $scope.items[index] = item;
        $scope.reset();
        alert("Cập nhật thành công");
      })
      .catch((error) => {
        alert("Lỗi cập nhật");
        console.log("Error", error);
      });
  };
  //xoa sp
  $scope.delete = function (item) {
    $http
      .delete("/rest/accounts/" + item.username)
      .then((resp) => {
        var index = $scope.items.findIndex(p => p.username == item.username);
        $scope.items.splice(index, 1);
        $scope.reset();
        alert("Xóa thành công");
      })
      .catch((error) => {
        alert("Lỗi Xóa");
        console.log("Error", error);
      });
  };
  //upload anh
  $scope.imageChanged = function (files) {
    var data = new FormData();
    data.append("file", files[0]);
    $http
      .post("/rest/upload/images", data, {
        transformRequest: angular.identity,
        headers: { "Content-Type": undefined },
      })
      .then((resp) => {
        $scope.form.photo = resp.data.name;
      })
      .catch((error) => {
        alert("lỗi upload ảnh");
        console.log("Error", error);
      });
  };

  $scope.pager = {
    page: 0,
    size: 10,
    get items() {
      var start = this.page * this.size;
      return $scope.items.slice(start, start + this.size);
    },
    get count() {
      return Math.ceil((1.0 * $scope.items.length) / this.size);
    },
    first() {
      this.page = 0;
    },
    prev() {
      this.page--;
      if (this.page < 0) {
        this.last();
      }
    },
    next() {
      this.page++;
      if (this.page >= this.count) {
        this.first();
      }
    },
    last() {
      this.page = this.count - 1;
    },
  };
});
