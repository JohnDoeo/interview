package com.johndoeo.base.serialize;

public class Practice {
    public static void main(String[] ar){
        int a = 1;
        int b = 2;
//        convertVar(a,b);
//        outputPersonInfo();
//        getChange();
//        outputTime(10);
        outputStorage(5);
        outputNum(4567);
    }
    //1
    public static void convertVar(int a,int b){
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("a="+a+",b="+b);
    }
    //2
    public static void outputPersonInfo(){
        String name = "闫勇";
        String sex = "女";
        String birth = "2019.02.21";
        int age = 26;
        System.out.println(name+" "+sex+" "+birth+" "+age);
    }
    //3
    public static double getChange(){
        double shoes = 58;
        double clothes = 30;
        double bag = 55.5;
        double pay = 500;
        double change;
        double spend = shoes+(clothes*3)+(bag*5);
        change = pay-spend;
        System.out.println(change);
        return change;
    }
    //4
    public static void outputTime(int day){
        System.out.println(day+"天有"+day*24+"小时，有"+day*24*60+"分钟");
    }
    //5
    public static void outputStorage(int gb){
        System.out.println(gb+"GB有"+gb*1024+"MB，有"+gb*1024*1024+"KB");
    }
    //6
    public static void outputNum(int input){
        int qian = input / 1000;
        int bai = (input - (qian * 1000))/100;
        int shi = (input - (qian * 1000)-(bai*100))/10;
        int ge = input- (qian * 1000)-(bai*100)-(shi*10);
        System.out.println("千位："+qian+",百位："+bai+"十位："+shi+",个位："+ge);
    }
//    public static void convertVar(){
//        String a = null;
//        System.out.println("请输入数字：");
//        while (true){
//            a = new Scanner(System.in).next();
//            try {
//                Integer.parseInt(a);
//                break;
//            }catch (Exception e){
//                System.out.println("输入的不是数字，请重新输入");
//            }
//        }
//        System.out.println("输入的a="+a);
//        System.out.println("请输入数字：");
//        String b = null;
//        while (true){
//            b = new Scanner(System.in).next();
//            try {
//                Integer.parseInt(b);
//                break;
//            } catch (Exception e) {
//                System.out.println("输入的不是数字，请重新输入");
//            }
//        }
//        System.out.println("输入的b="+b);
//    }
}
