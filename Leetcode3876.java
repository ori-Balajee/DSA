public class Leetcode3876{

    public static boolean uniformArray2(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minNum = nums1[0];

        for (int num : nums1) {
            if (num % 2 != 0) {
                minOdd = Math.min(minOdd, num);
            }
            minNum = Math.min(minNum, num);
        }

        // All elements are even
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        // Minimum element must be odd
        return minNum == minOdd;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 7};

        boolean result = uniformArray2(nums1);
        System.out.println(result);
    }
}