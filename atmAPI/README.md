###atmAPI
===============================

'atmAPI' is back-end system for ATM machines. It is a restful API with below features.

Application uses Apache tomcat, H2 as the database UserRepositorySchema.sql can be used to create the UserRepository table for the users. 

1. Cretae Account
2. Check balance
3. Deposit money
4. Withdraw money


### Technologies
=========================
- JAX-RS API
- JAVA
- MAVEN
- Apache HTTP Client
- H2 Database


###Running the Application
=========================
Please run atmAPI as Runon server to star the embedded tomcat server. Application starts a Apache server on localhost port 8085 
Use below REST url to get token

http://localhost:8085/atmAPI/process/gettoken

Use below json object
{
    "account_number": "100001",
	"name": "chhavi",
	"unique_pin": "0000"
}
This rest call will return a token, for example '68bff9de-1259-4360-ba2b-687df2f058e8'.
One token is valid only for one use. ie, token need to be regenerated after each service call. Use postman with the given ATM_postman_collection in curl.


### Available Services
=======================

| HTTP METHOD | PATH | USAGE |
| -----------| ------ | ------ |
| GET | /checkBalance/{token}/{accountno} | Checks the balance for the account no given | 
| PUT | /deposit/{token}/{accountno}/{amount} | Deposit the amount in the current user account| 
| PUT | /withdraw/{token}/{accountno}/{amount} |  Withdraw the amount from the current user account|
| POST | /{gettoken} |  Generate token for each user with the given parameters|

### URLs with token
=======================

1. Check balance: http://localhost:8085/atmAPI/process/checkBalance/{token}/{accountno}
2. Deposit Money: http://localhost:8085/atmAPI/process/deposit/{token}/{accountno}/{amount}
3. Withdraw Money: http://localhost:8085/atmAPI/process/withdraw/{token}/{accountno}/{amount}

### Sample JSON for each HTTP methods defined above
========================

To create account:
POST:
http://localhost:8085/atmAPI/process/CREATE/account
{
    "account_number": "100001",
	"name": "chhavi",
	"ac_type": "savings",
	"card_num": "83154000",
	"unique_pin": "0000",
	"balance": "1000"
}

To get the token for transaction:
POST:
http://localhost:8085/atmAPI/process/gettoken
{
    "account_number": "100001",
	"name": "chhavi",
	"unique_pin": "0000"
}

To withdraw from the account:
PUT:
http://localhost:8085/atmAPI/process/withdraw/{token}/{accountno}/{amount}
http://localhost:8085/atmAPI/process/withdraw/22e272ab-bedf-4a3e-84d2-46e6ac87ad45/100001/100

To Deposit into the account:
PUT:
http://localhost:8085/atmAPI/process/deposit/{token}/{accountno}/{amount}
http://localhost:8085/atmAPI/process/deposit/22e272ab-bedf-4a3e-84d2-46e6ac87ad45/100001/100

To check the balance:
Get:
http://localhost:8085/atmAPI/process/checkBalance/{token}/{accountno}
http://localhost:8085/atmAPI/process/checkBalance/1a2196f9-cbf8-4d68-b4be-3ae9934d44a3/100002



