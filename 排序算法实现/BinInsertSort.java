/**
 * 折半插入排序 - （插入排序）
 * 平均时间复杂度 O(n^2) || 最好 O(n) || 最坏 O(n^2)
 * 辅助空间复杂度 O(1)
 * 稳定
 */

public class BinInsertSort {

    public static int[] InsertSort(int[] nums) {
        //默认第1个元素在有序区，从第2个元素开始遍历
        for (int i=1; i<nums.length; i++) {
            int temp = nums[i]; //记录当前需要插入的元素

            //采用折半查找的方法先找到插入位置
            int low = 0, high = i-1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (temp < nums[mid])
                    high = mid - 1; //插入点在左半区
                else
                    low = mid + 1; //插入点在右半区
            } //最终的插入位置在 mid (= high+1)

            //集中进行元素后移
            //本来应该是 j >= mid, 但由于mid变量只存在于while结构里，所以用 high+1 等量代换
            for (int j=i-1; j >= high+1; j--) {
                nums[j+1] = nums[j];
            }

            //temp插入空位
            nums[high+1] = temp;
        }
        return nums;
    }

    public static void main(String[] agrs) {
        int[] a = {124854, 33, 776, 98, 57, 555};
        int[] aar = InsertSort(a);
        for (int i : aar) {
            System.out.print(i + "\t");
        }
    }

}
