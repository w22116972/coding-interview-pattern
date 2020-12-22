package twopointers;


//        Problem Statement
//        Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the new length of the array.
//        Example 1:
//        Input: [2, 3, 3, 3, 6, 9, 9]
//        Output: 4
//        Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
//        Example 2:
//        Input: [2, 2, 2, 11]
//        Output: 2
//        Explanation: The first two elements after removing the duplicates will be [2, 11].

public class RemoveDuplicate {

    public static void main(String[] args) {
        assert sol(new int[]{2, 3, 3, 3, 6, 9, 9}) == 4;
        assert sol(new int[]{2, 2, 2, 11}) == 2;
    }

    // note: 只需要回傳長度，不需要整個陣列
    // 一個走訪索引指標: 走訪每個元素
    // 一個去重元素索引指標: 指向的索引為下一個去重值要覆蓋並放進來的索引
    // e.g. [1, 1, 2] -> 去重指標指向index=1，因為要把2放進index=1的位置
    // 每當走訪指標走到新的去重值時，會把該值放進去重指標現在所指向的索引
    // 要比對是否重複時，就比對arr[去重索引-1]即可
    // 最後回傳的去重指標也等同長度
    public static int sol(int[] arr) {
        int traversalIndex = 1;
        int deduplicateIndex = 1;
        while (traversalIndex < arr.length) {
            if (arr[traversalIndex] != arr[deduplicateIndex]) {
                arr[deduplicateIndex-1] = arr[traversalIndex];
                deduplicateIndex++;
            }
            traversalIndex++;
        }
        return deduplicateIndex;
    }

}
