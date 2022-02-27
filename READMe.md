##Flow

1. กรอกคำค้นหาสินค้าและกดปุ่มค้นหาจะแสดงข้อมูลโดยย่อสินค้าออกมาจำนวน 3 ชิ้น
2. คลิกเลือกสินค้า 1 ชิ้นจาก 3 ชิ้นที่แสดงอยู่
3. แสดงข้อมูลสินค้าอย่างละเอียด
4. คลิกเพิ่มสินค้าลงในตะกร้าสินค้า
5. แสดงข้อมูลสินค้าในตะกร้าสินค้า
6. คลิกชำระค้าสินค้า
7. แสดงหน้าข้อมูลการจัดส่งและคลิกดำเนินการต่อ
8. เลือกวิธีการชำระค่าสินค้า
9. คลิกสั่งซื้อสินค้า 
10. แสดงรายละเอียดการสั่งซื้อ

##APIs

| Method | Url                            | Description              | Sample Valid Request Body                                      | Sample Valid Response Body                                                                                                                                      |
|--------|--------------------------------|--------------------------|----------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Get    | /product/search/{searchString} | Search product           | Path variable {searchString}                                   | ```productList[{id:'id1', name:'name1', price:xxxx, desc:'decs1', picpath:'path1'}, {id:'id2', name:'name2', price:xxxx, desc:'decs2', picpath:'path2'},...]``` |
| Get    | /product/get/{id}              | Get product by id        | Path variable {id}                                             | ```{id:'id1', name:'name1', price:xxxx, desc:'decs1', picpath:'path1'}```                                                                                       |
| Get    | /user/get/address/{id}         | Get User's address by id | Path variable {id}                                             | ```{address:'adddress'}```                                                                                                                                      |
| Post   | /order/create                  | Save new order           | ```{userId:'uid', productId:'pid', paymentMethod:'pmethod'}``` | ```{orderId:'oid', userName:'uname',totalPrice:'xxxx'}```                                                                                                       |

