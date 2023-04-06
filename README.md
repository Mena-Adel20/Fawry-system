# Fawry System
This project is a payment system similar to Fawry. It allows users to pay for various services, including mobile recharge, internet payment, landline services, and donations. The system is developed using Java and the Eclipse IDE for Java EE, and it uses Spring Boot as the web framework. Tomcat is used as the application server, and Postman is used for testing the API.

# Requirements
### User
<ol>
<li>The user should be able to sign in to the system using their email and password.</li>
<li>The user should be able to sign up for the system by providing a username, email, and password. The system should check if the username or email is already registered, and show an error if either is already in use.</li>
<li>The user should be able to search for any service in the system by typing in the service name. The system should return all services that match the user's query.</li>
<li>The user can pay for any service in the system by filling out a payment form. The default payment method is credit card, but the user should also have the option to pay using their wallet balance (as described in requirement 6). If the service accepts cash on delivery, this option should also be visible.</li>
<li>The user can request a refund for any completed transaction from a service by submitting a request to the admin. If the admin approves the refund, the process should complete successfully.</li>
<li>The system maintains a wallet balance for each user, and the user should be able to add funds to their wallet using a credit card.</li>
<li>The user should be able to check for any discounts available for a particular service. Discounts can be added by the admin (as described in requirement 2 of the Admin section).</li>
</ol>

### Admin
<ol>
<li>The admin should be able to add new service providers to the system, including a form for the user to fill out and a handler to process the form. The form can consist of any number of text or dropdown fields.</li>
<li>The admin should be able to add discounts to the system, including overall discounts (e.g. a 10% discount for the user's first transaction, regardless of the service) and specific discounts for particular services (e.g. a 20% discount for all mobile recharge services).</li>
<li>The admin should be able to view a list of all user transactions, including payment transactions, wallet transactions, and refund transactions.</li>
<li>The admin should be able to view a list of all refund requests, including the related service and the amount to be refunded. The admin should be able to accept or reject these requests, and if a request is accepted, a refund transaction should be processed.</li>
</ol>

# REST API
In addition to the above functionality, the project also includes a RESTful API to expose the above features as web services. For example, to pay for a service using the API, the user would send a POST request to the /pay endpoint with the necessary payment information in the request body.
