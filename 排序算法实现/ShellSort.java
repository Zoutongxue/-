/**
 * 希尔排序 - （插入排序）
 * 平均时间复杂度 O(n^1.3)
 * 辅助空间复杂度 O(1)
 * 不稳定
 */

public class ShellSort {

    //Github 搜的
//    public static int[] ShellSort(int[] nums) {
//        for(int gap = nums.length / 2 ; gap >= 1 ; gap /= 2 ){
//            for(int i = gap ;i < nums.length ; i ++){
//                int j;
//                int tmp = nums[i];
//                for( j = i ; j >=gap&&tmp < nums[j - gap] ; j -= gap){
//                    nums[j] = nums[j - gap];
//                    //是往前找，所以j >= gap
//                }
//                // 前面的先开始排序，到最后若j - gap - gap 仍然 > 0时，前面的是已经排好序的
//                //此时若小于前面的某值时，会慢慢地向前推进，推进过程中的中间值每一个都会发生改变
//                //知道不在小于，找到正确位置，循环退出，正确位置赋值即可
//                nums[j] = tmp;
//            }
//        }
//        return nums;
//    }

    //数据结构-李春葆
//    public static int[] ShellSort(int[] nums) {
//        int i,j,d,tmp;
//        d = nums.length / 2;
//        while(d > 0) {
//            for (i=d ; i<nums.length ; i++) {
//                tmp = nums[i];
//                j=i-d;
//                int count = 0;
//                while(j>=0 && tmp<nums[j]){
//                    nums[j+d] = nums[j];
//                    j=j-d;
//                }
//                nums[j+d] = tmp;
//            }
//            d = d/2;
//        }
//        return nums;
//    }

    //网上博客
    private static int[] ShellSort(int[] arr) {
        //step:步长
        for (int step = arr.length / 2; step > 0; step /= 2) {
            //对一个步长区间进行比较 [step,arr.length)
            for (int i = step; i < arr.length; i++) {
                int value = arr[i];
                int j;

                //对步长区间中具体的元素进行比较
                for (j = i - step; j >= 0 && arr[j] > value; j -= step) {
                    //j为左区间的取值，j+step为右区间与左区间的对应值。
                    arr[j + step] = arr[j];
                }
                //此时 j 为一个负数，[j + step]为左区间上的初始交换值
                arr[j + step] = value;
            }
        }
        return arr;
    }

    public static void main(String[] agrs) {
        int[] a = {124854, 33, 776, 98, 57, 555};
        int[] aar = ShellSort(a);
        for (int i : aar) {
            System.out.print(i + "\t");
        }
    }

}

