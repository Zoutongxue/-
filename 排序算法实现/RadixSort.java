/**
 * 基数排序 - （不用进行关键字的比较） 有两种 --- LSD最低位优先 and MSD最高位优先
 * 平均时间复杂度 O(d(n+r)) || 最好 O(d(n+r)) || 最坏 O(d(n+r))    --- n个元素，d位位数（如2位数99、3位数100），r进制数（二进制2，十进制10）
 * 辅助空间复杂度 O(r)
 * 稳定
 */

// 网上搜的  --- 确认过眼神也是我写不出来的代码

/**
 * 先按*个位*排序，再把排完序的序列按*十位*排序，再把排完序的序列按*百位*排序，依此类推。
 */

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {63, 157, 189, 51, 101, 47, 141, 121, 157, 156,
                194, 117, 98, 139, 67, 133, 181, 12, 28, 0, 109};

        radixSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 高位优先法 MSD
     *
     * @param arr 待排序列，必须为自然数
     */
    private static void radixSort(int[] arr) {
        //待排序列最大值
        int max = arr[0];
        int exp;//指数

        //计算最大值
        for (int anArr : arr) {
            if (anArr > max) {
                max = anArr;
            }
        }

        //从个位开始，对数组进行排序
        for (exp = 1; max / exp > 0; exp *= 10) {
            //存储待排元素的临时数组
            int[] temp = new int[arr.length];
            //分桶个数
            int[] buckets = new int[10];

            //将数据出现的次数存储在buckets中
            for (int value : arr) {
                //(value / exp) % 10 :value的最底位(个位)
                buckets[(value / exp) % 10]++;
            }

            //更改buckets[i]，
            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            //将数据存储到临时数组temp中
            for (int i = arr.length - 1; i >= 0; i--) {
                temp[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
                buckets[(arr[i] / exp) % 10]--;
            }

            //将有序元素temp赋给arr
            System.arraycopy(temp, 0, arr, 0, arr.length);
        }

    }
}