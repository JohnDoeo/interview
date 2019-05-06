package com.johndoeo.base;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/5/5 22:14
 * @Description:
 */
public class BreakLoops {
    public static void main(String[] args) {
        int sum = 0;
        lableB:
        for (int i = 0;i < 10;i ++){
            for(int j = 0;j < 10;j++){
                System.err.println(sum++);
                if(i == 9 && j == 8){
                    return;
                }
            }
        }
    }
}
