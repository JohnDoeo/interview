package com.johndoeo.base;

public class TestInt {
    public static void main(String[] args){

        String s1 = "hello world!";
        String s2 = "hello ";
        String s3 = "world!";
        String s4 = s2+s3;
        String s5 = s1;
        System.out.println(s1==s2+s3);
        System.out.println(s1==s4);
        System.out.println(s1==s5);


    }

}
