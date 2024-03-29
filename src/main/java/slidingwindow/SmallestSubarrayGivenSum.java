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
    //
    public static int sol(int S, int[] arr) {
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

    public static int practice(int targetSum, int[] arr) {
        int sumOfSubarray = 0;
        int minLengthOfSubarray = Integer.MAX_VALUE;
        int headIndexOfSubarray = 0;
        for (int tailIndexOfSubarray = 0; tailIndexOfSubarray < arr.length; tailIndexOfSubarray++) {
            sumOfSubarray += arr[tailIndexOfSubarray];
            while (sumOfSubarray >= targetSum) {
                minLengthOfSubarray = Math.min(minLengthOfSubarray, tailIndexOfSubarray - headIndexOfSubarray + 1);
                sumOfSubarray -= arr[headIndexOfSubarray];
                headIndexOfSubarray++;
            }
        }
        return minLengthOfSubarray;
    }
}
