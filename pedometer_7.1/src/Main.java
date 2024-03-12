import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pedometer ped = new Pedometer();
        double n;
        Scanner overseer = new Scanner(System.in);
        do{
            try{
                System.out.print("Enter the number of steps: ");
                n = ped.stepsToMiles(overseer.nextInt());
                if(n<0)
                    throw new ArithmeticException("nah");
                System.out.printf("%.2f",n);
                System.out.println(" mile(s)");
            }
            catch(InputMismatchException e)
            {
                System.out.println("Exception: Step count must be a number.");
                break;
            }
            catch (ArithmeticException e)
            {
                System.out.println("Exception: Negative step count entered.");
                break;
            }
        }while(true);
    }
}
