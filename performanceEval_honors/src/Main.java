import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner overseer = new Scanner(System.in);
        String mode, command; int num;
        System.out.print("Enter the desired mode (List/Array/Both): ");
        mode = overseer.nextLine().toLowerCase();
        System.out.print("\nEnter the number of elements in millions: ");
        num = overseer.nextInt();
        ErraticPulse pebbles = new ErraticPulse(num,mode);
        do{
            System.out.print("\nEnter an action (Add/Remove/Read) (Array/List/Both) (Start/End): ");
            pebbles.run(overseer.next().toLowerCase(), overseer.next().toLowerCase(),overseer.next().toLowerCase());
            System.out.print("\nContinue? ('Exit' to quit): ");
            if(overseer.next().equalsIgnoreCase("exit"))
                break;

        }while(true);
    }
}
