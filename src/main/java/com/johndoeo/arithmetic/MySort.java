package com.johndoeo.arithmetic;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MySort {
    public static void output(int[] input){
        for(int i = 0;i < input.length;i++){
            if(i == 0){
                System.out.print("["+input[i]+",");
                continue;
            }else if(i == input.length-1){
                System.out.print(input[i]+"]");
                continue;
            }
            System.out.print(input[i]+",");
        }
    }

    public static void main(String[] args) {
//        int[] input = {5,2,6,9,1};
//        output(input);
//        new MySort().shellSort(input);
//        output(input);
        System.out.println((1<<30)>>>1);

    }

    /**
     * 选择排序
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
     *  该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，
     *  使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了。
     * @param input
     */
    public void selectSort(int[] input){
        for(int i = 0;i < input.length-1;i++){
            for (int j = i+1;j < input.length;j++){
                if(input[i]>input[j]){
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * 1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 3.针对所有的元素重复以上的步骤，除了最后一个；
     * 4.重复步骤1~3，直到排序完成。
     * @param input
     */
    public void bubbleSort(int[] input){
        for(int i = 0;i < input.length-1;i++){
            for(int j = 0;j < input.length-i-1;j++){
                if(input[j]>input[j+1]){
                    int temp = input[j+1];
                    input[j+1] = input[j];
                    input[j] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     * 1.从第一个元素开始，该元素可以认为已经被排序；
     * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 5.将新元素插入到该位置后；
     * 6.重复步骤2~5。
     * @param input
     */
    public void insertSort(int[] input){
        int preIndex,current;
        for(int i = 0;i < input.length;i++){
            preIndex = i-1;
            current = input[i];
            while (preIndex >= 0 && input[preIndex] > current){
                input[preIndex+1]=input[preIndex];
                preIndex--;
            }
            input[preIndex+1] = current;
        }
    }

    /**
     * 希尔排序
     * 1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 2.按增量序列个数k，对序列进行k 趟排序；
     * 3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     *  仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * @param input
     */
    public void shellSort(int[] input){
        for (int gap = input.length / 2; gap > 0; gap = gap / 2) {
            // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
            for (int i = gap; i < input.length; i++) {
                int j = i;
                int current = input[i];
                while (j - gap >= 0 && current < input[j - gap]) {
                    input[j] = input[j - gap];
                    j = j - gap;
                }
                input[j] = current;
            }
        }
    }
}
