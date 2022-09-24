<div id="top"></div>


<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center"> 
    <img src="img/bank.png" alt="Logo" width="150" height="150">
</div>

<h3 align="center">Intra Bank Payment Transfer System</h3>





<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#intro">Introduction</a>
      <ul>
        <li><a href="#high-level-requirements">High level requirements</a></li>
        <li><a href="#acceptance-criteria">Acceptance criteria</a></li>
        <li><a href="#built-with">Built with</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## Introduction
A new intra-bank payment transfer system to allow real time payments between internal accounts.

### High Level Requirements

System should be:
- Accessible by Restful Webservices
- Able to tell account balance in real time
- Able to get mini statement for last 20 transactions
- Able to transfer money in real time
- Able to fetch accounts details from accounts service (new / deleted)

### Acceptance criteria

- [x]  Given valid account details and positive funds available When account-id 111 sends £10 to account-id 222 Then account-111’s account should be debited with £10 And account-222’s account should be credited with £10
- [x] Given invalid receiver account details and positive funds available When account-id 111 sends £10 to account-id 999 Then system should reject the transfer and report invalid account details
- [x] Given valid account details and no funds available (£0) When account-id 111 sends £10 to account-id 222 Then system should reject the transfer with error Insufficient funds available
- [x] Given valid account details When I call a service to check my account balance Then system should be able to report my current balance
- [x] Given valid account details When I call mini-statement service Then system should be able to show me last 20 transactions
- [x] Given invalid account details When I call a service to check my account balance Then system should return error saying invalid account number
- [x] Given invalid account details When I call mini statement service Then system should return error saying invalid account number


<p align="right">(<a href="#top">back to top</a>)</p>

### Built With

* Java
* Spring Boot
* Spring Data JPA
* In-memory H2 database
* Flyway for database migrations
* JUnit 5
* Lombok
* Maven
* Swagger for API documentation

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

To get this project up and running simply clone this repository using your preferred IDE.

If you wish to build the project run the following command at the root of the project:

  ```
  mvn clean install
  ```

To get the application up and running execute the main method found at the following path:

  ```
  src/main/java/com/mastercard/paymenttransfersystem/PaymentTransferApplication.java

  ```
<p align="right">(<a href="#top">back to top</a>)</p>
<!-- USAGE EXAMPLES -->

## Usage

This project will pre-populate the database with the following accounts:

  ```
  Account 1: id=786, balance=10000, currency=USD, state=ACTIVE
  Account 2: id=555, balance=10000, currency=USD, state=ACTIVE)

  ```

### API Endpoints

All endpoints have been documented using swagger. Once the project is up and running the documentation can be accessed via this link: 

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Fahad Ali Sajad - [@LinkedIn](https://www.linkedin.com/in/fahad-ali-sajad-380a25127) - Fahadalisajad@hotmail.com

<p align="right">(<a href="#top">back to top</a>)</p>

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/fahad-ali-sajad-380a25127/
[swagger-url]: http://localhost:8080/swagger-ui.html
[product-screenshot]: images/screenshot.png
