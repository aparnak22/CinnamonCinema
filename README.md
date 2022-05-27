#Cinnamon Cinema


## Requirements 

Develop a program to allocate seats to customers purchasing tickets for a movie theatre.

The Cinnamon Cinemas Movie Theatre has 15 seats, arranged in 3 rows of 5.
 Rows are assigned a letter from A to C
 Seats are assigned a number from 1 to 5

Seats are allocated starting from seat A1 and filling the auditorium from left to right, 
front to back.

All the seats are available for sale when the program starts.

Write a program that allocates seats based on a random integer “number of seats” between 1 and 3.

The program should continue to allocate a random number of seats until it finds there are not enough seats 
left to complete the request.
Once there are not enough seats available to be allocated then the program can halt.


## Solution

### Design

I am starting with implementing the simplest solution to satisfy the requirements.

![UML](docs/CC_UML.svg)



Constraints :

1. The console app will call the Cinema class to allocate random number of seats between 1 and 3 till
   the request cannot be fulfilled. Here the cinema may still have seats available but not enough to fulfill the 
   request.
2. The Cinema class returns only true or false to indicate seats could be allocated and  does not return the allocated seat numbers.
3. The allocation can be split across two rows for a request.

## Possible Enhancements

1. Return the allocated seat number. - Done
2. Do not split a single request across rows. This would require the program to look at previous rows to allocate any empty seats.
3. Create customised seating plan.
4. Display seating plan. 
5. Allow user to choose seats. 




