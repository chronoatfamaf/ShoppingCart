Narrative:
In order to learn JBehave
As a tester
I want to define sample story for shopping cart

LifeCycle:
Before:
Given product name Apple, price 100.00 and code P1001

Scenario: Empty shopping cart

Given empty shopping order number 123456789
Then shopping order is empty

Scenario: Add Product to Order

Given empty shopping order number 123456789
Then add product P1001 to order




