package com.johndoeo.base.serialize;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class TestSer {
    @Test
    public void test01(){
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1111);
        });
        Thread t2 = new Thread(() -> {
            System.out.println(2222);
        });
        t1.start();
        t2.start();
        System.out.println(3333);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对象序列化
     * @param obj 待序列化对象
     * @param path 序列化路径
     */
    public void ObjectSerialize(Object obj,String path){
        try {
            // ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                    new File(path)));
            oo.writeObject(obj);
            System.out.println("对象序列化成功！");
            oo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object deserializePerson(String path){
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(new File(path)));
            try {
                Object o = objectInputStream.readObject();
                return o;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                if(objectInputStream != null){
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test002(){
        int i = 10;
        StringBuffer s = new StringBuffer();
        for(int j=i-1;j>1;j--){
            for(int k=i-1;k>1;k--){
                if(j*k==i){
                    s.append("10="+j+"*"+k);
                    break;
                }
            }
            if(!s.toString().equals("")){
                break;
            }
        }
        System.err.println(s.toString());
    }
    public int getI(int i){
        StringBuffer s = new StringBuffer();
        for(int j=i-1;j>1;j--){
            for(int k=i-1;k>1;k--){
                if(j*k==i){

                }
            }
        }
        return 1;
    }

    public static void main(String[] args){
//        while (true){
//            Scanner scanner = new Scanner(System.in);
//            int i = Integer.parseInt(scanner.next());
//            System.err.print("位运算：");
//            System.err.println((i<<5)-i);
//            System.err.print("直接运算：");
//            System.err.println(31*i);
//        }

        System.out.println("请输入一个数!");
        Scanner sc = new Scanner(System.in);
        String numStr = sc.next();
        int num = Integer.parseInt(numStr);
        String str = num+"=1";
        while(num != 1){
            for(int i = 2;i<=num;i++){
                if(num%i==0){
                    str = str +"*"+i;
                    System.out.println(i);
                    num = num/i;
                    break;
                }
            }
        }
        System.out.println(str);
    }
}
