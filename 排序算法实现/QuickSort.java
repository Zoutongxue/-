import java.util.Arrays;

/**
 * 快速排序 - （交换排序）
 * 平均时间复杂度 O(nlog(2)n) || 最好 O(nlog(2)n) || 最坏 O(n^2)
 * 辅助空间复杂度 O(log(2)n)
 * 不稳定
 */

/*
可以直接
import java.util.Arrays;
Arrays.sort(nums);
*/

public class QuickSort {

    /*
    //数据结构-李春葆-快排算法

    public static int[] QuickSort(int[] nums, int left, int right) {
        if (left < right) //区间内至少存在 2个元素的情况
        {
            int partitionIndex = partition(nums, left, right);
            QuickSort(nums, left, partitionIndex - 1);  //对左区间递归排序
            QuickSort(nums, partitionIndex + 1, right);  //对右区间递归排序
        }
        return nums;
    }

    public static int partition(int[] nums, int left, int right) {
        int i = left, j = right, temp = nums[i];  // 以第 i 个元素作为基准
        while (i < j) {
            while (i < j && nums[j] >= temp) //从右向左扫描，直到找到一个小于基准的数
                j--;
            nums[i] = nums[j];  //不用担心数据被覆盖，因为总是以第i个元素作为基准，基准值已经存在temp里面了

            while (i < j && nums[i] <= temp) //从左向右扫描，直到找到一个大于基准的数
                i++;
            nums[j] = nums[i];
        }
        nums[i] = temp;  //基准归位，经过数次循环后，两个指针的值相等 i=j
        return i;
    }


    public static void main(String[] agrs) {
        int[] a = {60, 33, 76, 98, 57, 555};
        int[] aar = QuickSort(a,0, 5);
        for (int i : aar) {
            System.out.print(i + "\t");

        }
    }

     */


    public static void quickSort(int[] s, int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quickSort(s, l, i - 1); // 递归调用
            quickSort(s, i + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,6,8,1,10,9,0};
        quickSort(nums,0,nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }


}
