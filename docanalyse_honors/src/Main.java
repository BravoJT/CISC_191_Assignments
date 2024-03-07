import java.io.IOException;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException
    {
        FileInputStream importLane;// Most of this initial setup is adapted from my 4.1 lab
        FileOutputStream exportLane;
        PrintWriter exporter;
        Scanner seer;
        String line;
        ArrayList words = new ArrayList();
        String word = "";

        System.out.println("Opening song.txt...");
        importLane = new FileInputStream("song.txt");
        seer = new Scanner(importLane);
        System.out.println("File successfully opened, working on word counting.");
        exportLane = new FileOutputStream("wordCount.txt");
        exporter = new PrintWriter(exportLane);
        while(seer.hasNextLine())
        {
            line = seer.nextLine().toLowerCase();//lowercase for checking later
            for(byte i = 0;i<line.length();i++)
            {
                if((line.charAt(i)>=97&&line.charAt(i)<=122)||line.charAt(i)=='\'')
                    //Checks if character is in the alphabet with an exception for contractions
                {
                    word = word + line.charAt(i);
                }
                else if(!words.contains(word)&&!word.equals(""))//adding new word to array
                {
                    words.add(word);
                    words.add(1);
                    word = "";
                }
                else if(!word.equals(""))//ticking up counter of existing word
                {
                    words.set(words.indexOf(word)+1,(int)words.get(words.indexOf(word)+1)+1);
                    word = "";
                }
            }
            if(!words.contains(word)&&!word.equals(""))//adding new word to array
            {
                words.add(word);
                words.add(1);
                word = "";
            }
            else if(!word.equals("")){//ticking up counter of existing word
                words.set(words.indexOf(word)+1,(int)words.get(words.indexOf(word)+1)+1);
                word = "";
            }
        }
        for(int i = 0;i<words.size();i++)//printing and exporting time
        {
            switch(i%2){//words gives a String on even remainders, and a number on odds
                case 0:
                    word = (String)words.get(i);
                    word = word.substring(0,1).toUpperCase()+word.substring(1,word.length())+": ";
                    break;
                case 1:
                    word = word + words.get(i);
                    exporter.println(word);
                    System.out.println(word); //Testing printer
                    break;
            }
        }
        exporter.flush();
        System.out.println("File produced.");
        exportLane.close();
        exporter.close();
        importLane.close();
        seer.close();
    }
}