# Application Workflow
1. receive input of how much lotto
2. receive input of winning numbers and bonus number
3. check prize status
4. print out all info
***
# Features
### input related
+ input how much lotto
+ input winning numbers
+ input bonus number
### output related
+ print all bought lotto
+ print all winning status
+ print earning-rate
### lotto related
+ generate 6 random numbers [1, 45]
+ check how many numbers match
### error related
+ if non-numeric value
+ if out of range numeric value
+ if duplicate value
### prize related
+ define amount of each prize
+ count how many matches for each prize
***
# NOTE
### Never abuse declaring unnecessary static variables or functions, <br>which will cause static variable reusing in multiple gradlew clean test