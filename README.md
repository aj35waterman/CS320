I make sure my code is functional and secure by testing every rule built into my classes and services. I write JUnit tests that cover both valid and invalid inputs so I can see how the code reacts in every situation. 
For example, I tested that phone numbers had exactly ten digits, IDs couldn’t be duplicated, and no fields were null or too long. I also made sure my constructors and setters caught mistakes early by throwing the right 
exceptions. To make the program more efficient, I switched from an ArrayList to a HashMap, which let me find items by their ID instantly instead of searching through everything. My mindset through all of this was 
to aim for full coverage, focus on writing clean, testable code, and make sure that every possible issue was handled before it ever became a real problem.

When interpreting user needs, I start by breaking down what the user actually wants the program to do and translating those goals into clear rules and constraints in the code. For example, if a user expects valid 
phone numbers only, I use input validation and regular expressions to guarantee that requirement is enforced. I take the same approach with everything—define, test, and confirm. My design process always focuses on keeping things 
simple and reliable: analyze requirements, plan how each class connects, write small testable pieces, and constantly check my work with both static and dynamic testing. I’ve learned that being disciplined with quality and validation 
early on saves time later, and it’s what keeps my code secure, efficient, and easy to maintain.
