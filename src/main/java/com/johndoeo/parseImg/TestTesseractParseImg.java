package com.johndoeo.parseImg;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/4/24 20:59
 * @Description:
 */
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.Tesseract;

public class TestTesseractParseImg {
    public static void main(String[] args) {
        System.out.println(findOCR("C:\\Users\\JohnDoeo\\Desktop\\图片识别\\1.jpg", false));
    }
    public static String findOCR(String filePath,boolean ZH_CN){
        String result = "";
        try {
            double start = System.currentTimeMillis();
            File file = new File(filePath);
            BufferedImage textImage = ImageIO.read(file);
            Tesseract tesseract = new Tesseract();
            //加载训练字体库文件
            tesseract.setDatapath("D:\\tesseract\\Tesseract-OCR\\tessdata");
            if(ZH_CN){
                tesseract.setLanguage("chi_sim");
                result = tesseract.doOCR(textImage);
                double end = System.currentTimeMillis();
                System.out.println("耗时"+(end-start)/1000+" s");
                return result;
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
