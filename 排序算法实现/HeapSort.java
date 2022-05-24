/**
 * 堆排序 - （树形选择排序）
 * 平均时间复杂度 O(nlog(2)n) || 最好 O(nlog(2)n) || 最坏 O(nlog(2)n)
 * 辅助空间复杂度 O(1)
 * 不稳定
 */

public class HeapSort {
    //李春葆 数据结构 数组越界
    //把 数组 看作是 一颗完全二叉树的顺序存储结构
    //筛选算法，构建大根堆(双亲 >= 右孩子 >= 左孩子)大的上浮，小的被筛选下去
//    static void sift(int nums[], int low, int high) {
//        int i = low, j = 2 * i;  //nums[j] 是 nums[i] 的左孩子
//        int tmp = nums[i];
//        while (j <= high) {
//            if (j<high && nums[j]<nums[j+1]) //若右孩子较大
//                j++; //把 j 指向右孩子
//            if (tmp < nums[j]) //若 根结点 小于 最大孩子
//            {
//                nums[i] = nums[j]; // 将 nums[i] 调整到双亲结点位置上
//                i = j;  //修改i和j的值，以便继续向下筛选
//                j = 2*i;
//            }
//            else break;
//        }
//        nums[i] = tmp;  //被筛选结点 放入最终位置上
//    }
//
//    public static int[] HeapSort(int[] nums) {
//        int i;
//        for (i = nums.length / 2 ; i >= 1 ; i--)  //循环建立初始堆，调用sift算法 [nums.length / 2] 次
//            sift(nums,i,nums.length);
//
//        for (i = nums.length ; i>=2 ; i--) {
//            //swap(nums[1],nums[j])     将 根结点 与 最后一个叶子结点 交换，然后 根结点 就算归位了
//            int temp = nums[1];
//            nums[1] = nums[i];
//            nums[i] = temp;
//
//            //根结点被归位后。剩下结点不一定能组成堆，所以要对剩下的结点进行筛选，得到一个 i-1 个结点的 （大根）堆
//            sift(nums ,1 , i-1);
//        }
//        return nums;
//    }

    // Github 搜的
    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] agrs) {
        int[] a = {12, 33, 76, 98, 57, 555};
//        int[] aar = HeapSort(a);
        int len = a.length;

        buildMaxHeap(a, len);

        for (int i = len - 1; i > 0; i--) {
            swap(a, 0, i);
            len--;
            heapify(a, 0, len);
        }

        for (int i : a) {
            System.out.print(i + "\t");
        }
    }
}
