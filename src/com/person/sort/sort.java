package com.person.sort;

import java.lang.reflect.Array;

public class sort {
    public static void main(String[] args) {

        int[] array = {2, 4, 1,10 ,3, 5};
       // bubbleSort(array);
        // sort sort = new sort();
        // sort.quickSort(array, 0, array.length - 1);
        //  sort.QuickSort(array,0,array.length-1);
        //  selectSOrt(array);
        //  heap(array);
        //insertSort(array);
        shellSort(array);


    }

    //**********************交换排序（开始线）***********
    //交换排序 分为：冒泡排序 和 快速排序
    //冒泡排序(时间复杂度为O（n2)
    public static void bubbleSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                //时间复杂度计算：n+ n-1 +n-2 +n-3+......+1+0=(n2+n)/2 =n2
                //即 时间复杂度为：O(n2)。
                if (array[j] > array[j + 1]) {
                    int sort = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = sort;
                }
            }
        }
        System.out.println("使用冒泡排序后的数组为：");
        for (int num : array) {
            System.out.println(num);
        }

    }

    /*
    快速排序（以左边第一个为"基准"（即temp=R[lo]），lo代表左边第一个 ，hi代表右边第一个 ）
    右边第一个hi 与基准temp 相比较，如果while(i<j && hi>=temp) 则--hi（）hi下标向左边移动 ,
    否则，R[lo]=R[hi] 将小于基准的R[hi]值 移到左边R[lo]  。
    当赋值完成后，进行左边的相同操作，直到lo==hi时（左边lo向右边移动，右边hi向左边移动，直到两个下标相等了指向同一个对象 ）。
    直到lo==hi时，将基数temp放到当前R[lo]或者R[hi]的位置 R[i]=temp;
    最后通过递归的方式 向基准的两边区域一直重复这一操作，直到全部进行完毕。
    总结：这一操作类似于二分搜索法，都有一个基准。
    */
    /*
    快速排序时间复杂度为O(nlogn);
     */
    public void quickSort(int R[], int lo, int hi) {
        //i 左边, j 右边
        int i = lo, j = hi;
        //temp 基准
        int temp;
        //左边小于右边
        if (i < j) {

            //左边第一个为基准
            temp = R[lo];
            //当左右移动的两个下标不等于时
            while (i != j) {
                //右边的数字 >= 基准时，右边的下标往左边移动
                while (i < j && R[j] >= temp) --j;
                //当右边的数字 < 基准时，将小于基准的数字 往左边 R[i]赋值
                R[i] = R[j];
                //赋值完后，左边的数字 <= 基准时，左边的下标往右边移动
                while (i < j && R[i] <= temp) ++i;
                //当左边的数字 > 基准时，将大于基准的数字 往右边边 R[j]赋值
                R[j] = R[i];
            }

            //当左右移动的两个下标相等时
            //相等时，将基准赋值给R[i]或者R[j]
            R[i] = temp;
            //基准左边区域重复以上操作
            quickSort(R, lo, i - 1);
            //基准右边区域重复以上操作
            quickSort(R, i + 1, hi);
        }

        System.out.println("使用快速排序后：");
        for (int num : R) {
            System.out.println(num);

        }

    }


//**********************交换排序（结束线）***********


//**********************选择排序（开始线）*************

    //选择排序分为：直接选择排序 与堆排序
    public static void selectSOrt(int array[]) {

        for (int i = 0; i < array.length; i++) {
            int temp = i;

            //从第二个开始依次进行比较
            for (int j = temp + 1; j < array.length; j++) {
                //如果后面的要比前面的小，则把下标放到temp中进行标记。一直找到最小的
                if (array[j] < array[temp]) {
                    temp = j;
                }
            }

            //当标记的最小值下标 不等于 当前下标i 时
            if (temp != i) {
                //将标记的下标值赋值到当前位置
                int a = array[i];
                array[i] = array[temp];
                array[temp] = a;
            }
        }

        System.out.println("排序之后：");
        for (int num : array) {
            System.out.println(num);

        }

    }

    //堆排序
    /*
    堆排序思想：将数组看成一个二叉树
     1,在二叉树中找到最后一个非叶子节点下标（通过i= arr.length/2-1）,再使用2*i+1找到该节点的左孩子节点，先比较左右孩子谁最大
       然后，最大的那个孩子节点再和根节点进行比较，如果孩子节点大于根节点则进行交换，交换后进行调整堆结构即一定要满足 大顶堆（大顶堆：每个节点是必须要大于等于它的孩子节点）。
     2，当大顶堆构建完成后，进行堆顶元素与末尾元素 的交换，同时交换后调整堆结构
     3，这样最大的放在了最后，其次是第二大的这样进行排序。

     堆排序的时间复杂度为：O（nlogn）
     */

    public static void heap(int[] array) {

        //1,构建大顶堆
        // array.length / 2 - 1得到它的非叶子节点
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);

        }

        //2，调整堆结构+堆顶元素与末尾元素交换
        for (int j = array.length - 1; j >= 0; j--) {
            //将末尾元素与堆顶元素进行交换
            swap(array, 0, j);
            adjustHeap(array, 0, j);

        }

        for (int num : array) {
            System.out.println(num);
        }


    }

    //构建大顶堆
    public static void adjustHeap(int[] array, int i, int length) {

        int temp = array[i];

        //2 * i + 1 得到i节点的 左孩子节点
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            if (array[k] > temp) {
                //如果孩子节点大于根节点，则进行交换
                //这里可以直接将孩子节点值 覆盖 根节点的值，因为孩子节点的下标 k 赋值给力i（即 i=k）
                //i=k   array[i] = temp; 就可以将原来根节点的值给孩子节点。这样就可以完成一个交换的操作。
                array[i] = array[k];
                //将k赋值给 i
                i = k;

            } else {
                break;
            }
        }
        array[i] = temp;


    }

    //大顶堆构建后，再将根节点的最大值放到后面
    public static void swap(int[] array, int i, int length) {

        int change = array[i];
        array[i] = array[length];
        array[length] = change;

    }
//**********************选择排序（结束线）*************

//***********************插入排序（开始线）**************
    //插入排序分为：直接插入排序 和希尔排序


    //直接插入排序：由 后面的一个指定元素（从1 开始） 与它之前的元素进行比较，如果小于前面的元素，则把前面的大的元素直接赋值给当前arr[j]指向的空间
    // 交换之后，则j-- 一直往前面进行重复比较，
    //最后，把前面的都比较完后，停留在当前arr[j]的位置直接 插入temp 的值。
    //时间复杂度为O（n2）
    /*
     比如：2 1 3 5 4 ：
     第一次循环：int temp=array[j] ,下标为j=1 （从j=1 开始为基准）与前面为j-1=0 的比较，1<2 ,则赋值（  array[j] = array[j - 1];array[1]的值成为了 2 ）
     成为 2 2 3 5 4 ,此时基准 的下标会 j-- 变为了j= 0 ，因为 j>0（基准下标必须 >0）,所以跳出循环。
     然后，插入：array[j]=temp (这里是array[0]=temp，所以array[0]的值成为了 原先array[j]值为1 的值 )。
     */
    public static void insertSort(int[] array) {
        //数组长度
        int length = array.length;
        //用于存储 当前基准的值（它的用处很大哟，一定要注意）
        int temp;
        //基准 以及它前面的下标
        int j = 0;

        for (int i = 1; i < length; i++) {
            j = i;
            temp = array[i];
            //当j>0 且 基准的值 < 它前面的值时
            while (j > 0 && temp < array[j - 1]) {
                //满足条件后，将前面的值 给当前基准；
                array[j] = array[j - 1];
                //同时，基准下标向前移动
                j--;
            }
            //插入
            array[j] = temp;
        }

        for (int num : array) {
            System.out.println(num);
        }

    }


    //希尔排序
    public static void shellSort(int[] array) {
        int number = array.length / 2;
        int i, j;
        int temp;

        while (number>=1) {
            for (i = number; i < array.length; i++) {
                temp = array[i];
                j = i - number;
                while (j >= 0 && array[j] >temp) {
                    array[j + number] = array[j];
                    j = j - number;
                }
                array[j+number]=temp;

            }
            number=number/2;
        }

        for (int num : array) {
            System.out.println(num);
        }


    }


}

