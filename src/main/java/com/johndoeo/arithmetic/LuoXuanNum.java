package com.johndoeo.arithmetic;

import java.util.Scanner;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/5/4 21:26
 * @Description:
 */
public class LuoXuanNum {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arrs=creatMatrix(n);
        printMatrix(arrs,n);
    }
    public static int[][] creatMatrix(int n){
        int[][] arrs=new int[n][n];
        int num=1,i=-1,j=-1,count=-1;//num是要输出的数，i是行数，j是列数，count是圈数
        do{
            count++;
            for(i++,j++;j<n-count;j++){
                arrs[i][j]=num++;
            }
            for(i++,j--;i<n-count;i++){
                arrs[i][j]=num++;
            }
            for(i--,j--;j>=count;j--){
                arrs[i][j]=num++;
            }
            for(i--,j++;i>count;i--){
                arrs[i][j]=num++;
            }
        }while(count<=(n+1)/2);
        return arrs;
    }
    public static void printMatrix(int[][] arrs,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arrs[i][j]<10){
                    System.out.print("   "+arrs[i][j]+"  ");
                }else if(arrs[i][j]>=10&&arrs[i][j]<100){
                    System.out.print("  "+arrs[i][j]+"  ");
                }else if(arrs[i][j]>=100&&arrs[i][j]<1000){
                    System.out.print(" "+arrs[i][j]+"  ");
                }

            }
            System.out.println();
        }
    }

}
