package com.johndoeo.base.io;

import java.io.File;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/5/5 22:33
 * @Description:
 */
public class DiGuiReadFiles {
    public static void main(String[] args) {
        listFile2("C:\\Users\\JohnDoeo\\go\\src\\github.com\\golang\\dep\\internal");
    }

    /**
     * 递归查询制定文件夹下所有文件/文件夹名称
     * @param path
     */
    public static void listFile(String path) {
        if (path == null) {
            return;// 因为下面的new File如果path为空，回报异常
        }
        File[] files = new File(path).listFiles();
        if (files == null) {
            return;
        }
        for(File file : files) {
            if (file.isFile()) {
//                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Directory:"+file.getName());
                listFile(file.getPath());
            } else {
                System.out.println("Error");
            }
        }
    }

    /**
     * 递归查询出制定路径下所有的文件/文件夹名称（全名）
     * @param path
     */
    public static void listFile2(String path){
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        listFile2(file2.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}
