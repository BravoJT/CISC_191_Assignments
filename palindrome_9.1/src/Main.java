import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Palindrometer pal = new Palindrometer();
        Scanner overseer = new Scanner(System.in);
        System.out.print("Enter the text you wish to check as a palindrome: ");
        String text = overseer.nextLine().toLowerCase();
        if(pal.checkText(text))
            System.out.println("\nThis is a palindrome!");
        else
            System.out.println("\nThis is NOT a palindrome!");
    }
}
