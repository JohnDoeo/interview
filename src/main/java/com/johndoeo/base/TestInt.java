package com.johndoeo.base;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class TestInt {
    public static void main(String[] args){

//        String s1 = "hello world!";
//        String s2 = "hello ";
//        String s3 = "world!";
//        String s4 = s2+s3;
//        String s5 = s1;
//        System.out.println(s1==s2+s3);
//        System.out.println(s1==s4);
//        System.out.println(s1==s5);

        foo(0);
        System.err.println(output);
        foo(1);
        System.err.println(output);

    }

    public static String output = "";

    public static void foo(int i) {
        try{
            if(i == 1){
                int j = 1/0;
            }
            output += "1";
        }catch (Exception e){
            output += "2";
            return;
        }finally {
            output += "3";
        }
        output += "4";
    }
}
