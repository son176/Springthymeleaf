const app=angular.module("shopping_cart_app",[]);

app.controller("shopping_cart_ctrl",function($scope,$http){
  $scope.cart={
    items:[],
    // thêm vào giỏ hàng
    add(id){
      var item =this.items.find(item => item.id == id);
      if(item){
        item.qty++;
        this.saveToLocalStorage();
      }else{
        $http.get("/rest/products/"+id).then(resp=>{
          resp.data.qty=1;
          this.items.push(resp.data);
          this.saveToLocalStorage();
        })
      }

    },
    remove(id){
      var index =this.items.findIndex(item => item.id == id);
      this.items.splice(index,1);
      this.saveToLocalStorage();
    },
    clear(){
      this.items=[];
      this.saveToLocalStorage();
    },
    // tong sl mat hang
    get count(){
      return this.items.map(item => item.qty).reduce((total,qty) => total+=qty,0);

    },
    // tổng 
    get amount(){
      return this.items.map(item => item.qty*item.price).reduce((total,qty) => total+=qty,0);
    },
    // lưu vào storage
    saveToLocalStorage(){
      var json =JSON.stringify(angular.copy(this.items));
      localStorage.setItem("cart",json);
    },
    // doc tu localStorage
    loadFromLocalStorage(){
      var json =localStorage.getItem("cart");
      this.items=json?JSON.parse(json):[];
    }
  }
  $scope.cart.loadFromLocalStorage();

  $scope.order = {
    createDate: new Date(),
    address: "",
    account:{username: $("#username").text()},
    get orderDetails(){
      return $scope.cart.items.map( item =>{
        return {
          product:{id:item.id},
          price:item.price,
          quantity:item.qty
        }
      });
    },
    purchase(){
      var order = angular.copy(this);
    //  đặt hàng 
    $http.post("/rest/orders", order).then(resp =>{
      alert("Đặt hàng thành công!");
      $scope.cart.clear();
      location.href="/order/detail/" +resp.data.id;

    }).catch(error => {
      alert("Đặt hàng lỗi");
      console.log(error);
    });
    }
  }
});