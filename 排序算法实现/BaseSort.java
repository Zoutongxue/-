import java.util.Arrays;
import java.util.Scanner;

public class BaseSort {
    public static void main(String[] args) {
        System.out.println("输入要排序的数组，用','分隔相邻数据，按 Enter 键结束输入");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); // nextLine() 返回值为一行 String
        String[] arr = str.split(",");  // 分割字符串，放进 String 数组
        int[] nums = new int[arr.length]; // 调用 .length 属性 计算 数组长度
        for (int i=0; i<nums.length; i++) { // 增强型 for 循环
            nums[i] = Integer.parseInt(arr[i]); // Integer.parseInt(String) ：将 String 转为 Integer
        }
        nums = sort(nums);
        System.out.println("排序结果：" + Arrays.toString(nums));
    }


    public static int[] sort(int[] nums) {
        return nums;
    }
}
