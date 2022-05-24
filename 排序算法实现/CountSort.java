/**
 * 计数排序
 * 平均时间复杂度 O(m+2n)    m 为桶的个数， n 为待排序数的个数   ？？？有疑问
 * 辅助空间复杂度 O(m+n)   ？？？有疑问
 * 不晓得稳不稳定，连比较都没有 -。-
 */



//网上找到的，虽然配了图，但是还是看不太懂， 确认过眼神又是我写不出来的代码，连时间复杂度和空间复杂度都算不出来了=。=！！

/**
 * 我理解的意思：
 * 待排数组A 内元素的值的范围 ： 0~k
 * new一个长度为 k+1 的数组C， 数组C就像是个Hash表， index就是数组A的元素值，value就是元素个数
 * 再遍历数组C，每次遍历都把前面的值加到后面去，即每项都是前n项的和，所以最后一个元素的值就是数组A的元素的总个数
 *再 new一个长度和数组A一样的数组B，存排序结果
 * 倒序遍历数组A，通过数组C的元素值来定位元素在数组B里面的下标，每存一个，相应的数组C里面的元素就-1，表明该元素个数-1（好像也不能这样说）
 */


public class CountSort {

    private static int[] countSort(int[] array,int k)
    {
        int[] C=new int[k+1];//构造C数组
        int length=array.length,sum=0;//获取A数组大小用于构造B数组
        int[] B=new int[length];//构造B数组
        for(int i=0;i<length;i++)
        {
            C[array[i]]+=1;// 统计A中各元素个数，存入C数组
        }
        for(int i=0;i<k+1;i++)//修改C数组
        {
            sum+=C[i];
            C[i]=sum;
        }
        for(int i=length-1;i>=0;i--)//遍历A数组，构造B数组
        {

            B[C[array[i]]-1]=array[i];//将A中该元素放到排序后数组B中指定的位置 ，数组下标从0开始，所以要-1
            C[array[i]]--;//将C中该元素-1，方便存放下一个同样大小的元素

        }
        return B;//将排序好的数组返回，完成排序

    }
    public static void main(String[] args)
    {
        int[] A=new int[]{2,5,3,0,2,3,0,3};
        int[] B=countSort(A, 5);
        for(int i=0;i<A.length;i++)
        {
            System.out.print(B[i] + ",");
        }
    }
}