package com.johndoeo.base;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

public class CreateClass {
    @Test
    public void test1(){
        try {

            DataType dataType = (DataType) Class.forName("com.johndoeo.base.DataType").newInstance();
            DataType dataType1 = DataType.class.newInstance();
            Class<DataType> dataTypeClass = DataType.class;
            /**
             * 这里的getMethod和getDeclaredMethod区别：
             *      getMethod：只可以获取public的方法
             *      getDeclaredMethod：可以获取类中生命的所有方法
             */
//            Method sayHi = dataTypeClass.getMethod("sayHi");
            Method sayHi = dataTypeClass.getDeclaredMethod("sayHi");
            //来设置或取消访问检查，以达到访问私有对象的目的。 未设置的情况下若访问私有方法会报错：IllegalAccessException
            sayHi.setAccessible(true);
            Object invoke = sayHi.invoke(dataTypeClass.newInstance());
            System.out.println(invoke);
            dataType.setName("小明");
            dataType.setAge(29);
            dataType1.setName("xiaohong");
            dataType1.setAge(11);
            System.out.println(dataType.getAge()+"::"+dataType.getName());
            System.out.println(dataType1.getAge()+"::"+dataType1.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void test2(){
        String s = "11dfegg";
        try {
            byte[] gb2312s = s.getBytes("GB2312");

            for(byte e:gb2312s){
                System.out.print((char) e+",");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        System.out.println(reverse(s));
//        System.out.println(s.substring(1));
    }

    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
