# Product Inventory

### About the project:

This project is the development of a REST API for product inventory control, allowing the creation, editing, retrieval and deletion of items in an efficient and organized way. Each product will be represented by a JSON that includes detailed information such as SKU, name, stock and location, as well as information related to available quantity and type of warehouse(e-commerce or physical store).
Technologies used:
* Commons apache lang
* Docker
* Java
* JPA
* Junit
* Lombok
* MongoDB

## Installation

### Pre-requisites

* Postman or another endpoint testing application. 

* Some IDE that runs Java, in the project I used Intellij. 

* Docker to be able to upload the MongoDB database.
> [!NOTE]
> - To follow the creation and have access to the database information, you can download MongoDB Compass.
> 
> - You can also test the applications using JUnit tests.


### Installation

1. Get the repository link [https://github.com/leilanyaragao/product-inventory]
2. Clone the repository
   ```https
   git clone git@github.com:leilanyaragao/product-inventory.git
   ```
3. Open the project in your preferred IDE

4. Open the terminal in the docker folder and run - docker compose up - so that the database is created.

5. In the IDE run the file ProductInventoryApplication.java

8. In postman (or another application of your choice) test the endpoints at localhost:8080

   ```JS
   POST /products - Create a new product
   
   PUT /products/sku/{sku} - Update product by SKU
   
   PATCH /products/sku/{sku}/add-warehouse - Add warehouse to product

   PATCH /products/sku/{sku}/update-warehouse-quantity - Update warehouse quantity for product

   DELETE /products/sku/{sku}/delete-warehouse - Remove warehouse from product

   DELETE /products - Delete all products

   DELETE /products/sku/{sku} - Delete product by SKU

   GET /products/sku/{sku} - Get product by SKU

   GET /products - Get all products

   GET /products/warehouse-by-locality - Get products by warehouse locality

   GET /products/warehouse-by-type - Get products by warehouse type

   ```
