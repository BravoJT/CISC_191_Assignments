# **Automotive Database Interface**
The [AutoInterface](src/AutoInterface.java) class' function is to read in a text file called [auto-mpg.txt](auto-mpg.txt), use SQL statements to upload said data to a preexisting database, and open a window for a user to view said data. In this GUI, the user can enter name, mpg, and horsepower values to search through the table. When the user enters "all" into the name text box, the entire table is printed, and the hp/mpg sliders use '0' as an "ignore" value when searching by name. 
# **Table Creation**
The SQL statement used for creating the table used in my code.
```
create table AutoData ( mpg double(3,1), cylinders tinyint, displacement smallint, horsepower smallint, weight smallint, acceleration double(3,1), modelYear tinyint, origin tinyint, carName varchar(50) );
```
# **Challenges**
This one was certainly a lot more challenging than the other labs, combining various aspects used in prior labs. Lots of what I did ended up being redundant after later changes, but it certainly works at the very least. One entire method using the ```autoData[][]``` variable was scrapped after I realized the assignment wants me to use the WHERE clause. I also had to independently learn about JTables and JScrollPanes to show the data in a clean manner. GUI was definitely the hardest part, as usual for me.
