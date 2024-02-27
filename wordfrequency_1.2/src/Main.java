public class Main {
    public static void main(String[] args) {
        String[] test = new String[5];//loading test array
        test[0] = "hey";
        test[1] = "Hi";
        test[2] = "Mark";
        test[3] = "hi";
        test[4] = "mark";

        for(byte i = 0;i<test.length;i++)//running test
        {
            System.out.println(test[i]+" "+getWordFrequency(test,test[i]));
        }
    }
    public static int getWordFrequency(String[] wordsList, String target)
    {
        byte ctr = 0;
        for(byte i = 0;i<wordsList.length;i++)
        {
            if(wordsList[i].equalsIgnoreCase(target))
            {
                ctr++;
            }
        }
        return ctr;
    }
}