import java.util.Scanner;
public class Addy {

    public static void main(String[] args)
    {
        int former, latter, answer, streak = 0;//zero stored in stack, streak has stack location, rest are just assigned spots in the stack
        Scanner seer = new Scanner(System.in);//Scanner object assigned location and stored in heap
        do{
            former = (int)(Math.random()*20)+1;//overwrite at former, memory location unchanged
            latter = (int)(Math.random()*20)+1;//overwrite at latter, memory location unchanged
            System.out.println("What is "+former+" + "+latter+"?");
            try {
                answer = seer.nextInt();//overwrite at answer, memory location unchanged
            }
            catch(Exception InputMismatchException)
            {
                System.out.println("Not a number! Your streak was "+streak);
                break;
            }
            if(answer==former+latter) {
                System.out.println("Correct!");
                streak++;//overwrite at streak, memory location unchanged
            }
            else{
                System.out.println("Wrong! Your streak was " + streak+".");
                break;
            }
        }while(true);//Garbage collector doesn't get much action as the changing variables were all primitive
    }
}

//My main challenge in this assignment was overthinking what goes into stack/heap, like trying to place Math.random and the Exception.
