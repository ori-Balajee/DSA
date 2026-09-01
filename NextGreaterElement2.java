import java.util.*;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        int[] num2 = { 1, 3, 4, 2 };

        int answer[] = Solution1(num2);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] Solution1(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = -1;

            for (int j = i + 1; j < i + n; j++) {
                int index = j % n;

                if (nums[index] > nums[i]) {
                    arr[i] = nums[index];
                    break;
                }
            }
        }

        return arr;
    }
    
    public static int[] Solution2(int[] nums) {
        
    }


}