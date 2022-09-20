# OWN Comments

## Importent sections : 
- commit 3 : shows the right usage of verify
  - We ALLWAYS verify a MOCK-OBJECT , NOT the service which uses the Mock-object
  - we test a service which uses a Mock repository  (service itself is not a mock)
    - f.e: service.deleteById(1l)
            verify(MOCK-REPO).deleteById(1l)

- commit 5 : shows the right usage of when
  - We use When on a MOCK-OBJECT
  - we create a new object that the mock object returns when a method is called - MOCKOBJECT itself cannot return anything
  - we call our service which uses the mock
  - we verify that MockObject returns Pre-made Object
  - we verify that the mock-object-method is called (right number of times)



# Introduction to JUnit 5 with Mockito

All source code examples in the repository are for my [Online Course - Testing Spring Beginner to Guru](https://www.udemy.com/testing-spring-boot-beginner-to-guru/?couponCode=GITHUB_REPO)

This source code repository contains JUnit 5 and Mockito test examples with Maven.

## Setup
### Requirements
* Should use Java 11 or higher. Previous versions of Java are un-tested.
* Use Maven 3.5.2 or higher

## Support
For questions and help:
* Please post in course
* Or post in the Slack Community exclusive to the course.

GitHub Issues will not be addressed.
