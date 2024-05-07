import java.sql.*;
import java.util.*;
public class MiramarInterface {

    //NOTE: I have modified the database from the practice lab by changing the middle initial to the middle name, and the DOB to a regular varchar.

    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/miramar","testuser","Pa$$word");
        System.out.println("Database connected");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from Student;");

        System.out.println("Original Data");
        while (resultSet.next())
        {
            System.out.println("SSN: "+resultSet.getString(1) + "\nFirst Name: "+resultSet.getString(2) + "\tMiddle Name: " + resultSet.getString(3) + "\tLast Name: " + resultSet.getString(4) + "\nBirth Date: " + resultSet.getString(5) + "\nStreet: " + resultSet.getString(6) + "\tPhone #: " + resultSet.getString(7) + "\tZip Code: " + resultSet.getString(8) + "\tDept Id: " + resultSet.getString(9)+"\n");
        }
        Scanner overseer = new Scanner(System.in);

        String subject;
        boolean validified;
        do {
            validified = false;
            System.out.println("Enter the target's current SSN ([N] for new entry): ");
            subject = overseer.next();
            if(subject.toUpperCase().charAt(0)=='N')
            {
                System.out.println("Enter the new Student's SSN,: ");
                subject = overseer.next();
                statement.execute("insert into Student (ssn,firstname,lastname,birthDate) values ('"+subject+"','null','null','0000-1-1');");
            }

        }while(validified);

        char input;
        do {
            do {
                System.out.print("What do you want to update?\n (SS[N]/[F]irstN/[M]idN/[L]astN/[B]irthD/[S]treet/[P]hone/[Z]ipCode/[D]eptId) or [E]xit\nEnter encased letter: ");
                input = overseer.next().toUpperCase().charAt(0);
                switch (input) {
                    case 'N', 'F', 'M', 'L', 'B', 'S', 'P', 'Z', 'D' -> validified = true;
                    case 'E' -> System.exit(0);
                    default -> System.out.println("Error: Input was not a valid target.");
                }
            } while (!validified);
            String target;
            switch (input) {
                case 'N' -> target = "ssn";
                case 'F' -> target = "firstName";
                case 'M' -> target = "middleName";
                case 'L' -> target = "lastName";
                case 'B' -> target = "birthDate";
                case 'S' -> target = "street";
                case 'P' -> target = "phone";
                case 'Z' -> target = "zipCode";
                case 'D' -> target = "deptId";
                default -> target = null;
            }

            System.out.print("What value would you like to insert? ('_' replaces spacebar): ");
            String data = overseer.next();

            System.out.println(data);
            for(byte i = 0;i<data.length();i++)
            {
                if(data.charAt(i)=='_'){
                    data = data.substring(0,i)+" "+data.substring(i+1,data.length());}
            }
            statement.execute("update student set " + target + " = '" + data + "' where ssn = '" + subject + "'");

            resultSet = statement.executeQuery("select * from Student;");
            System.out.println("New Data");
            while (resultSet.next()) {
                System.out.println("|SSN: " + resultSet.getString(1) + "\n|First Name: " + resultSet.getString(2) + "\t|Middle Name: " + resultSet.getString(3) + "\t|Last Name: " + resultSet.getString(4) + "\n|Birth Date: " + resultSet.getString(5) + "\n|Street: " + resultSet.getString(6) + "\t|Phone #: " + resultSet.getString(7) + "\t|Zip Code: " + resultSet.getString(8) + "\t|Dept Id: " + resultSet.getString(9) + "\n");
            }
            System.out.print("Repeat? ([Y]es to continue): ");
            input = overseer.next().toUpperCase().charAt(0);
            if(input!='Y')
                break;
        }while(true);
        connection.close();
    }
}
