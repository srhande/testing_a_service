
# Testing a Service

2. Description: The test files, TestStudent.java, TestResponse.java, TestController.java, test the main files, Student.java, Response.java, Controller.java. These tests essentially are there to test that we are receiving and setting the information of a service correctly.
3. Features: We have tests that use Mockito to create mock objects that help us implement methods or classes that may be incorrect by inheriting their behavior as a mock, and then we use junit testing to create tests. We run using maven.
4. Author: Samruddhi Hande
5. Acknowledgements: I used the tutorials we were given in the PA writeup, those being documentation links and junit, Mockito tutorials. I also used the ZyBook textbook to read up on exceptions. 

Task is to develop an extensive list of test cases that will thoroughly test every function in Controller.java, Response.java, and Student.java using JUnit and Mockito. You will be using Maven to run your test cases. Note that writing a large number of test cases and writing good test cases are different things. More does not always mean better. Try to come up with test cases that cover almost all the control flows that can happen in the code provided. Each test case should ideally check only one aspect of the code. For example, if you are trying to check a student’s GPA and their email ID, those should be two separate test cases rather than one. 
