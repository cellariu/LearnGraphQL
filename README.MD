# GraphQL Hello World application


**Dependencies:**  
SpringBoot project with following dependencies:

    - spring-boot-starter-web
    - lombok
    - playground-spring-boot-starter

**Graphql resources corresponding to Java classses**

| graphql resources                                                                                     | corresponding java classes                                                                                                                         |
|-------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|
| enum Currency {<br/> CHF<br/> USD<br/> EUR<br/>}                                                      | public enum Currency {<br/>CHF,<br/>USD,<br/>EUR<br/>}                                                                                             |
| type Client {<br/>id: ID!<br/>firstName: String!<br/>middleNames: [String!]<br/> lastName: String!<br/>} | @Setter<br/>@Builder<br/> public class Client {<br/> UUID id; <br/>String firstName;<br/>List<String> middleNames;<br/> String lastName;<br/>}     |
 | type BankAccount {<br/>id: ID!<br/>client: Client!<br/> currency: Currency!<br/><br/>}                | @Value<br/>@Builder<br/> public class BankAccount {<br/>UUID id;<br/> Client client;<br/>Currency currency;}<br/>                                  |

**Graphql Resolver it's a Java class implementing GraphQLQueryResolver:**

   @Component
   public class BankAccountResolver implements GraphQLQueryResolver {
  
      public BankAccount bankAccount(UUID id) {
  
          log.info("Retrieving bank account id: {}", id);
  
          var clientCamelia = Client.builder()
                  .id(UUID.randomUUID())
                  .firstName("Camelia")
                  .middleNames(List.of("Delia"))
                  .lastName("Ratiu")
                  .build();
  
          return BankAccount.builder()
                  .id(id)
                  .client(clientCamelia)
                  .currency(Currency.EUR)
                  .build();
      }
  }

After starting the SpringBoot Application:

**_At runtime:_**

  In browser: http://localhost:8080/playground

  Define query based on schema:



{

   bankAccount (id: "630ea8a2-7c29-11ec-90d6-0242ac120003") {

     id

     client {

        id

        firstName

        middleNames

        lastName

     }
     currency
   }

}


**_Execute it and get result:_**

   {
     "data": {

     "bankAccount": {

        "id": "630ea8a2-7c29-11ec-90d6-0242ac120003",

         "client": {
             "id": "9ea86725-73b4-4d86-985d-965964c3ae58",
              "firstName": "Camelia",
              "middleNames": [
                   "Delia"
              ],
            "lastName": "Ratiu"
          },
         "currency": "EUR"
     }
    } 
   }




    







