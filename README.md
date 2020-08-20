##### Demo spring boot API
This sample to present API using Spring Boot

###### 1. Change config
- Change config your database in /src/main/resources/application.properties
> spring.datasource.url
  spring.datasource.username
  spring.datasource.password
  spring.datasource.driverClassName
  
- Mapping your entity with table info. Example: BaseEntity
> @Table(name = "table_name")  // fill your table name
  
> @Column(name = "name")  // fill your column

- Change your url API. Example: BaseController
> @RequestMapping(value = "/v1.0/base")

This base API will be: localhost:8080/v1.0/base