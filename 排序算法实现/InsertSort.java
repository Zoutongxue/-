/**
 * 直接插入排序 - （插入排序）
 * 平均时间复杂度 O(n^2) || 最好 O(n) || 最坏 O(n^2)
 * 辅助空间复杂度 O(1)
 * 稳定
 */

public class InsertSort {

    public static int[] InsertSort(int[] nums) {
        //默认第1个元素在有序区，从第2个元素开始遍历
        for (int i=1; i<nums.length; i++) {
            int temp = nums[i]; //记录当前需要插入的元素

            //从有序区的最右边开始，依次与temp比较大小，如果temp较小，就把较大的元素向后挪一位，空个位子出来
            int j = i;
            while(j > 0 && temp < nums[j-1]){
                nums[j] = nums[j-1];
                j--;
            }

            //如果temp较大，那就插入空位。
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] agrs) {
        int[] a = {124854, 33, 76, 98, 57, 555};
        int[] aar = InsertSort(a);
        for (int i : aar) {
            System.out.print(i + "\t");
        }
    }

}
