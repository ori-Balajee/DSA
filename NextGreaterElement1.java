import java.util.*;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] num1 = { 4, 1, 2 };
        int[] num2 = { 1, 3, 4, 2 };

        int answer[] = Solution1(num1, num2);
        System.out.println(Arrays.toString(answer));
        int answer2[] = Solution2(num1, num2);
        System.out.println(Arrays.toString(answer2));
    }

    public static int findIndex(int[] num, int target) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int[] Solution1(int[] num1, int[] num2) {

        ArrayList<Integer> ans = new ArrayList<>();
        int n = num1.length;
        boolean found = false;

        for (int i = 0; i < n; i++) { // O(n1)
            int curr = num1[i];
            int num2_Index = findIndex(num2, curr); // O(n1) * O(n2)

            for (int k = num2_Index; k < num2.length; k++) { // O(n1) * (O(n2) + O(n2)) = N^2
                if (num2[k] > curr) {
                    ans.add(num2[k]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                ans.add(-1);
            } else {
                found = false;
            }
        }

        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }

        return arr;
    }

    public static int[] Solution2(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        
        // Element in the stack never found their next greatest element
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

}