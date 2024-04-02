import java.util.*;
public class Palindrometer {
    private Deque<Character> cards;
    public boolean checkText(String text)
    {
        cards = new LinkedList<Character>();
        for(byte i = 0;i<text.length();i++)
        {
            if(text.charAt(i)>=97&&text.charAt(i)<=122)
                cards.add(text.charAt(i));

        }
        switch(cards.size()){
            case 1:return true;
        }

        do{
            if(!cards.removeFirst().equals(cards.removeLast()))
                return false;
        }while(cards.size()>1);

        return true;

    }
}
