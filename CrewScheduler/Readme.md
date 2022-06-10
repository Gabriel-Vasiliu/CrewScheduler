### CrewScheduler 

Distribution of aircraft crew.

 - the data is stored in a mysql database
  
 - the database contains 3 tables: one for airplanes and 2 for staff (flight attendants and pilots)
 
 - the application uses java spring
 
 ### Algorithm
 
 - read data from the database
 
 - sort the planes by capacity and the pilots by type (major > regional > corporate)
 
 - a major pilot can fly any type of aircraft; a regional pilot can only fly aircraft with a capacity of less than 200, and a corporate pilot can fly airplane with a capacity of less than 50
 
 - depending on the capacity and type of pilots, they are assigned to airplanes
 
 - flight attendants are assigned according to the number required for each airplane
 
 - a list is created with the planes that do not have pilots or enough flight attendants
 
 - the distributions are displayed as a table

 ### Output
 
 ![Untitled2](https://user-images.githubusercontent.com/79076883/172133209-cc3ec153-5a12-43e7-97ba-972078585401.png)

![Untitled](https://user-images.githubusercontent.com/79076883/172133247-98d536ff-f47b-467d-9bf4-a3ea8c4026ee.png)

![Untitled3](https://user-images.githubusercontent.com/79076883/172133264-84de3e0e-1997-44a7-ba00-d6e92ffd1dd2.png)
