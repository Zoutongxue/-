/**
 * 冒泡排序 - （交换排序）
 * 平均时间复杂度 O(n^2) || 最好 O(n) || 最坏 O(n^2)
 * 辅助空间复杂度 O(1)
 * 稳定
 */
public class BubbleSort {
    //下沉式，每次把最大的放最后面去
    /*
    public static int[] BubbleSort(int[] nums) {
        // 第 i 趟排序
        for (int i = 0; i < nums.length - 1; i++) {
            //从前往后 遍历尚未排序的元素， 未排序元素下标从 0 到 nums.length - i - 1
            for (int j = 0; j < nums.length - i - 1; j++) {
                //前面 > 后面，那就做交换，把大的放后面去
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
    */


    //上浮式，每次把最小的放最前面去
    public static int[] BubbleSort(int[] nums) {
        // 第 i 趟排序
        boolean exchange; //用个标志 遇到中途排好序的情况可以直接结束排序
        for (int i = 0; i < nums.length - 1; i++) {
            exchange = false; //每趟排序前将标志置为假
            //从后往前 遍历尚未排序的元素， 未排序元素下标从 i 到 nums.length
            for (int j = nums.length - 1; j > i; j--) {
                //前面 > 后面，那就做交换，把小的放前面去
                if (nums[j-1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
            if (!exchange) {
                return nums;
            }
        }
        return nums;
    }


    public static void main(String[] agrs) {
        int[] a = {12, 33, 76, 98, 57, 555};
        int[] aar = BubbleSort(a);
        for (int i : aar) {
            System.out.print(i + "\t");
        }
    }
}
