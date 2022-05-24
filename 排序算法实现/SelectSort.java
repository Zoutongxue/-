/**
 * 简单选择排序 -（选择排序）
 * 平均时间复杂度 O(n^2) || 最好 O(n^2) || 最坏 O(n^2)
 * 辅助空间复杂度 O(1)
 * 不稳定
 */

public class SelectSort {
    public static int[] SelectSort(int[] nums) {
        int i, j, index, temp;
        // 第 i 趟排序
        for (i = 0; i < nums.length - 1; i++) {
            index = i; // index 记录 当前 最小元素的 下标， 默认 第i个元素 最小
            // 从第i+1个元素开始，每个都和第i个元素比较大小，把较小的元素的下标赋给index
            for (j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }

            // 如果index的值变了，那就把当前最小的元素放到第i个元素的位置上。
            if(index != i) {
                temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] agrs) {
        int[] a = {12, 33, 76, 98, 57, 555};
        int[] aar = SelectSort(a);
        for (int i : aar) {
            System.out.print(i + "\t");
        }
    }
}
