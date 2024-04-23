public class InsertSort {
    private static void printArray(int[] nums)
    {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    private static int[] sortArray(int[] nums)
    {
        int comps = 0, swaps = 0;
        System.out.print("Original: ");
        printArray(nums);
        int temp;
        for(byte i = 1;i<nums.length;i++)
        {
            for(byte j = i;j>0;j--)
            {
                if(nums[j]<nums[j-1])
                {
                    temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swaps++;
                    comps++;
                }
                else {
                    comps++;
                    break;
                }
            }
            printArray(nums);
        }
        System.out.println("Comparisons: "+comps+"\tSwaps: "+swaps);

        return nums;
    }
    public static void main(String[] args)
    {
        int[] nums = new int[6];

        for(byte i =0;i<nums.length;i++)
        {
            nums[i] = (int)(Math.random()*10);
        }
//        nums[0] = 3;
//        nums[1] = 2;
//        nums[2] = 1;
//        nums[3] = 5;
//        nums[4] = 9;
//        nums[5] = 8;
        nums = sortArray(nums);

    }
}
