import java.util.*;

public class NextGreaterElementToRight {
    public static void main(String[] args) {
        int[] num1 = { 1,3,2,4};

        int answer[] = Solution1(num1);
        System.out.println(Arrays.toString(answer));
    }

    static int[] Solution1(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                nums[st.peek()] = nums[i]; 
                st.pop();
            }

            st.push(i);
        }

        for(int num : st){
            nums[num] = -1;
        }

        return nums;
    }
}