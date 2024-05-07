# **Database Inserter/Modifier**
The [MiramarInterface](src/MiramarInterface.java) class connects to an (assumed for this assignemnt) existing database known as Miramar, and allows for the creation or modification of values on the table "Student." 
>[!NOTE]
>The assignment lists the practice lab as a prerequisite, but there are incompatibilities between the practice lab and the example data. For one, the middle initial (mi) of the practice lab is replaced by the middle name (middleName) in the data. This program uses "middleName" instead of "mi". The practice lab also uses a unique 'date' format for the date of birth, this has been changed to a simple varchar() in order to properly input the given "Jan 30, 1951" data. 

>[!NOTE]
>When inputting new values, the Scanner was having issues dealing with spaces in the inputs. To circumvent this, users will simply put '_' in place of spaces and they will be automatically converted before being inserted.

>[!WARNING]
>When entering an existing SSN for a new student, an error will be thrown due to the duplicate.
# **Challenges**
Aside from interpreting some inconsistencies mentioned above, my main challenge was designing a convenient-ish way to let the user target specific IDs and the values within them. Then again the lab doesn't actually ask for a way to choose what the values are— only that they get entered— so I may have been a bit overkill by taking targeted user input. It was also somewhat tricky to figure out the syntax.
