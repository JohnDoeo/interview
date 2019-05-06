package com.johndoeo.arithmetic;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/5/4 21:00
 * @Description:
 */
public class JieCheng {
    public static void main(String[] args) {
        int sum = 0;
        int n = 3;
        for(int i = n;i >= 1;i --){
            sum += jiecheng(i);
        }
        System.err.println(sum);
    }
    public static int jiecheng(int input){
        if(input == 0 || input == 1 || input == 2){
            return input;
        }
        return input * jiecheng(input-1);
    }
}
