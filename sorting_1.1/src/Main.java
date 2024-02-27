public class Main {
    public static void main(String[] args) {
        int[] test = new int[20];
        System.out.print("Before sorting: ");
        for(byte i = 0;i<test.length;i++)
        {
            test[i] = (int)(Math.random()*10);
            System.out.print(test[i]+" ");
        }
        System.out.print("\n");
        test = sortArray(test);//sortArray called
        System.out.print("After sorting: ");
        for(byte i = 0;i<test.length;i++)
        {
            System.out.print(test[i]+" ");
        }
    }
    public static int[] sortArray(int[] arr)//GOAL: Sort given array from greatest to least
    {
        int max;//Record value
        int pos = 0;//Position of value
        for(byte i = 0;i<arr.length;i++)
        {
            max = arr[i];//Start with value-to-be-swapped
            for(byte ii = i;ii<arr.length;ii++) {
                if (max < arr[ii]) {//Records position of higher numbers
                    max = arr[ii];
                    pos = ii;
                }
            }
            if(max>arr[i])//check if max is greater than our value-to-be-swapped
            {
                arr[pos] = arr[i];
                arr[i] = max;
            }

        }
        return arr;
    }
}