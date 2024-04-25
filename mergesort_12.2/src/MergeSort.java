public class MergeSort { // Sorting part taken from example
    private static int comps;
    private static int swaps;
    private static void printArray(int[] nums)
    {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    private static void merge(int[] nums, int s, int c, int e)
    {
        int len = e-s+1;
        int[] result = new int[len];
        int mPos = 0,lPos = s,rPos = c+1;

        while(lPos<=c&&rPos<=e)
        {
            if(nums[lPos]<nums[rPos])
            {
                result[mPos] = nums[lPos];
                lPos++;
            }
            else
            {
                result[mPos] = nums[rPos];
                rPos++;
                swaps++;
            }
            comps++;
            mPos++;
        }

        while(lPos<=c)
        {
            result[mPos] = nums[lPos];
            lPos++;
            mPos++;
        }
        while(rPos<=e)
        {
            result[mPos] = nums[rPos];
            rPos++;
            mPos++;
        }

        for(mPos = 0;mPos<len;mPos++)
        {
            nums[s+mPos] = result[mPos];
        }
    }
    private static void mergeSort(int[] nums, int s, int e)
    {
        if(s<e) {
            int c = (s + e) / 2;
            mergeSort(nums, s, c);
            mergeSort(nums, c + 1, e);
            merge(nums, s, c, e);
            //printArray(nums);
        }
    }
    public static void main(String[] args)
    {
        int[] nums = new int[6];
        for(byte i = 0;i<nums.length;i++)
        {
            nums[i] = (int)(Math.random()*10);
        }
//        nums[0] = 3;
//        nums[1] = 2;
//        nums[2] = 1;
//        nums[3] = 5;
//        nums[4] = 9;
//        nums[5] = 8;
        comps = 0;
        swaps = 0;
        System.out.print("Original: ");
        printArray(nums);
        mergeSort(nums,0,nums.length-1);
        System.out.print("Sorted: ");
        printArray(nums);
        System.out.println("Comparisons: "+comps+"\tSwaps: "+swaps);

    }
}
