package com.johndoeo.day214;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test01 {
    @Test
    public void t1(){
//        System.out.println(0>>1);
        MyCollection<Integer> integers = new MyCollection<Integer>();
        integers.add(199);
        integers.add(566);
        integers.add(846);
        integers.add(649);
        integers.forEach(e->{
            System.out.println(e);
        });
        for(Integer i:integers){

        }
    }

    class A{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Test
    public void t2(){
        A a = new A();
        a.setName("admin");
        a.setId(1);
        System.out.println(a);
        System.out.println(a.id+"\n"+a.getName());
        changeName(a);
        System.out.println(a.id+"\n"+a.getName());
        System.out.println(a);
    }
    public void changeName(A a){
        a.setId(2);
        a.setName("johndoeo");
    }

    /**
     * 统计给定文件中给定字符串的出现次数
     *
     * @param filename  文件名
     * @param word 字符串
     * @return 字符串在文件中出现的次数
     */
    public static int countWordInFile(String filename, String word) {
        int counter = 0;
        try (FileReader fr = new FileReader(filename)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = null;
                int lineNum = 0;
                while ((line = br.readLine()) != null) {
                    lineNum++;
                    int index = -1;
                    while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
                        counter++;
                        line = line.substring(index + word.length());
                    }
                }
                System.out.println(lineNum);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return counter;
    }


    @Test
    public void t3(){
        final int i = countWordInFile("C:\\Users\\Administrator\\Desktop\\新建文件夹\\hdms.sql", "TABLE");
        System.out.println(i);
    }
}
