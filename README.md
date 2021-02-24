# fyayc trading API
Task given by fyayc's engineering team to implement an API to trade product.
# Motivation

Second interview for Foryouandyourcustomers.

# About the project.

This is a spring boot project which is using Mariadb as a database. It comprises of end points for adding,updating,purchasing/trading User and products. Audit trail is also maintained for each transaction made from the project. This API have the following controllers:

- UserController
- ProductController
- AuditController


# Endpoints in UserController

- adding user in the system : ```POST``` /user
- updating the existing user in the system : ```PUT``` /user
- listing of users : ```GET``` /user/list
- fetch a user with id : ```GET``` /user/{id}
- Purchase or trade a product from  one user to another  : ```PUT```/user/purchaseOrTrade/
- List products of a specific user : ```GET``` /user/list/{id}


# Endpoints in ProductController

- adding product in the system : ```POST``` /product
- updating existing product in the system : ```PUT```/product
- listing of products : ```GET``` /product/list
- list products by price range : ```GET``` /product/listByPrice/?startPrice={0}&endPrice={1}
- delete a particular product : ```DELETE``` /product/{id}


