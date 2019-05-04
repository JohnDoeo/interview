//package com.johndoeo.parseImg;
//
//package 屏幕捕捉以及识别;
//
//import java.awt.Dimension;  //封装单个对象中组件的高度和宽度
//import java.awt.Rectangle;  //指定坐标空间中的一个区域，该区域由Rectangle对象在坐标空间中的（X,Y），其高度和宽度限制
//import java.awt.Robot;     //此类用于生成本机系统输入事件，用于测试自动化，自运行演示以及需要鼠标控制的和键盘的其它应用程序
//import java.awt.Toolkit;   //此类是所有Abstract Window Toolkit的所有实际实现的抽象超类，Toolkit类的子类用于将各个组件绑定到特定的本机工具包实现
//import java.awt.image.BufferedImage;  //BufferedImage子类描述了具有图像数据的可访问缓冲区的图像
//import java.text.SimpleDateFormat;  //SimpleDateFormat是一个具体的类，用于以区域设置敏感的方式格式化和分析日期
//import java.util.Calendar;
//import javax.imageio.ImageIO;  //一个包含静态便捷方法的类，用于定位ImageReader和ImageWriters，以及执行简单的编码和解码。
//import net.sourceforge.tess4j.Tesseract;
//
//import javax.imageio.ImageIO; //提供一组静态方法进行最简单的图形I/O操作，可以对一些图片进行处理(GIF,PNG,JPEG)
//import java.awt.image.BufferedImage;  //将图片转换字节数组，BufferedImage可以还原图片
//import java.io.*;         //用于图片和文本保存的
//
//import javax.swing.*;
//import java.awt.*;
//
//public class Text {
//    private final static String FORMAT_PNG = "png";
//    private final static String FORMAT_JPG = "jpg";
//    static String filePath = "";// 存放路径
//    private static String fileName = "GuiCamera_"; // 文件的前缀
//    private static int serialNum = 0;
//    private static String imageFormat = text.FORMAT_PNG; // 图像文件的格式
//
//    private static Dimension d = Toolkit.getDefaultToolkit().getScreenSize();   //获取显示器的大小
//    /**
//     * 对屏幕进行拍照 snapShot the Gui once
//     */
//    public static void snapShot() throws Exception {
//        try {
//            // 拷贝屏幕到一个BufferedImage对象screenshot
//            BufferedImage screenshot = (new Robot()).createScreenCapture(new Rectangle(0, 0, (int) d.getWidth(),
//                    (int) d.getHeight()));
//            serialNum++;
//            // 根据文件前缀变量和文件格式变量，自动生成文件名
//            String name=filePath + fileName +"test3."+imageFormat;
//            File f = new File(name);
//            // 将screenshot对象写入图像文件
//            ImageIO.write(screenshot, imageFormat, f);
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//    /**
//     *
//     * @param srImage 图片路径
//     * @param ZH_CN 是否使用中文训练库,true-是
//     * @return 识别结果
//     */
//    public static String FindOCR(String srImage, boolean ZH_CN) {
//        try {
//            System.out.println("start");
//            double start=System.currentTimeMillis();
//            File imageFile = new File(srImage);
//            if (!imageFile.exists()) {
//                return "图片不存在";
//            }
//            BufferedImage textImage = ImageIO.read(imageFile);
//            Tesseract instance=Tesseract.getInstance();
//            instance.setDatapath("C:\\Program Files (x86)\\Tesseract-OCR\\tessdata");//设置训练库
//            if (ZH_CN)
//                instance.setLanguage("chi_sim");//中文识别
//            String result = null;
//            result = instance.doOCR(textImage);
//            double end=System.currentTimeMillis();
//            System.out.println("耗时"+(end-start)/1000+" s");
//            return result;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "发生未知错误";
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        text.filePath = "D://";
//        text.snapShot();
//    }
//}
