package com.johndoeo.base;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/5/4 21:38
 * @Description:
 */
public class PrintTrangle {
    public static void main(String[] args) {
        //首先把菱形看成上下，上五下四,所以第一个for有5次，第二个for4次
        for(int i=1;i<=5;i++)
        {
            //将空格和*分开看，看" "的变化i=1时，他是4 ，2的时候是3找规律
            for(int j=1;j<=5-i;j++)
                System.out.print(" ");
            for(int k=1;k<=2*i-1;k++)//找规律，i是 1 3 5 7 基数嘛
                System.out.print('*');
            //换一行
            System.out.println();
        }
        for(int i=1;i<=4;i++)
        {
            for(int j=1;j<=i;j++)//空格 1 2 3 4 so
                System.out.print(" ");
            for(int k=7;k>=2*i-1;k--)//* 7 5 3 1倒着来的基数
                System.out.print('*');
            System.out.println();
        }
    }
}
