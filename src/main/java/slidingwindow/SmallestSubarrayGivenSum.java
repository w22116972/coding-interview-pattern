package slidingwindow;

//Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
//Input: [2, 1, 5, 2, 3, 2], S=7
//Output: 2
//Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
//Input: [2, 1, 5, 2, 8], S=7
//Output: 1
//Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
//Input: [3, 4, 1, 1, 6], S=8
//Output: 3
//Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
public class SmallestSubarrayGivenSum {
    public static void main(String[] args) {
        assert findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}) == 2;
        assert findMinSubArray(7, new int[]{2, 1, 5, 2, 8}) == 1;
        assert findMinSubArray(8, new int[]{3, 4, 1, 1, 6}) == 3;
    }


    //
    public static int findMinSubArray(int S, int[] arr) {
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}
