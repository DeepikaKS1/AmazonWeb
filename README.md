# Amazon Web Automation cases

About the codebase:
---------------------------------
*This is a simple test project for testing a few scenarios on amazon website. There are **3 tests** in total spread over 2 test classes. Following tech stack has been used to develop the same.*

**Tech Stack:** *Java*  *Selenium* *TestNG*  *Maven*

Problem Statement
----------------------------------
**Tasks:**

1. Perform a simple login and logout flow on the site.
2. Select Departments section > Electronics > Headphones > Select first available headphone and Add
to cart.
3. Search for Macbook pro from Search bar and select 2nd available product and add to cart with
Quantity as 2.
4. Select cart from home and remove the earlier added headphones.
5. Reduce the quantity of the macbook pro product to 1 and proceed to checkout.
    1
 6. Data drive/parameterize to search for multiple different products via search bar.
7. Implement a reporting framework of your choice to display the test results.

Solution
---------------------------------

1. Identified elements with id, xpath.
2. Wrote classes with page objects, actions and actual tests.
3. Performed operations on actions class.
