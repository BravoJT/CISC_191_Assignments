import java.sql.*;
import java.util.*;
public class MiramarInterface {
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
            System.out.println("SSN: "+resultSet.getString(1) + "\nFirst Name: "+resultSet.getString(2) + "\tMid. Initial: " + resultSet.getString(3) + "\tLast Name: " + resultSet.getString(4) + "\nBirth Date: " + resultSet.getString(5) + "\nStreet: " + resultSet.getString(6) + "\tPhone #: " + resultSet.getString(7) + "\tZip Code: " + resultSet.getString(8) + "\tDept Id: " + resultSet.getString(9)+"\n");
        }
        Scanner overseer = new Scanner(System.in);
        System.out.println("Enter the target's current SSN: ");
        int subject = overseer.nextInt();
        boolean validified = false;
        char input;
        do {
            System.out.print("What do you want to update?\n (SS[N]/[F]irstN/[M]idI/[L]astN/[B]irthD/[S]treet/[P]hone/[Z]ipCode/[D]eptId) or [E]xit\nEnter encased letter: ");
            input = overseer.next().toUpperCase().charAt(0);
            switch(input){
                case 'N','F','M','L','B','S','P','Z','D' -> validified = true;
                case 'E' -> System.exit(0);
                default -> System.out.println("Error: Input was not a valid target.");
            }
        }while(!validified);
        String target;
        switch(input){
            case 'N' -> target = "ssn";
            case 'F' -> target = "firstName";
            case 'M' -> target = "mi";
            case 'L' -> target = "lastName";
            case 'B' -> target = "birthDate";
            case 'S' -> target = "street";
            case 'P' -> target = "phone";
            case 'Z' -> target = "zipCode";
            case 'D' -> target = "deptId";
            default -> target = null;
        }

        System.out.print("What value would you like to insert? (Bobby Tables not allowed): ");
        String data = overseer.next();
        statement.execute("update student set "+target+" = '"+data+"' where ssn = '"+subject+"'");

        resultSet = statement.executeQuery("select * from Student;");
        System.out.println("New Data");
        while (resultSet.next())
        {
            System.out.println("SSN: "+resultSet.getString(1) + "\nFirst Name: "+resultSet.getString(2) + "\tMid. Initial: " + resultSet.getString(3) + "\tLast Name: " + resultSet.getString(4) + "\nBirth Date: " + resultSet.getString(5) + "\nStreet: " + resultSet.getString(6) + "\tPhone #: " + resultSet.getString(7) + "\tZip Code: " + resultSet.getString(8) + "\tDept Id: " + resultSet.getString(9)+"\n");
        }
        connection.close();
    }
}
