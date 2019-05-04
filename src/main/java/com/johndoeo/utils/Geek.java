//package com.johndoeo.utils;
//
//import java.awt.Container;
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.URL;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.Random;
//
//import javax.imageio.ImageIO;
//
//import net.sf.json.JSONObject;
//
//import org.apache.http.Header;
//import org.apache.http.HeaderElement;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//
//import com.util.DBUtil;
//
//public class Geek {
//    DBUtil dbu=new DBUtil();
//    CloseableHttpClient httpclient = HttpClients.createDefault();
//    String challenge="";
//    String gt="";
//    String json="";
//    Random rnd = new Random();
//    public boolean checkVcome()
//    {
//        String url="http://www.tianyancha.com/company/7117464";
//        HttpGet httpPost=new HttpGet(url);
//        String html="";
//        try {
//            CloseableHttpResponse response = httpclient.execute(httpPost);
//            HttpEntity entitySort = response.getEntity();
//
//            html=EntityUtils.toString(entitySort, "utf-8");
//
//            if(html.indexOf("为确认本次访问为正常用户行为，请您协助验证")!=-1)
//                return true;
//            if(!"".equals(html.trim()))
//            {
//                return true;
//            }
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return false;
//    }
//    public void startPama()
//    {
//        String url="http://www.gsxt.gov.cn/SearchItemCaptcha?v="+System.currentTimeMillis();
//        HttpGet httpPost=new HttpGet(url);
//        httpPost.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
//        httpPost.setHeader("Connection", "keep-alive");
//        httpPost.setHeader("Host", "www.gsxt.gov.cn");
//        httpPost.setHeader("Referer", "http://www.gsxt.gov.cn/corp-query-homepage.html");
//        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
//        httpPost.setHeader("X-Requested-With", "XMLHttpRequest");
//        String html="";
//        try {
//            CloseableHttpResponse response = httpclient.execute(httpPost);
//            HttpEntity entitySort = response.getEntity();
//            html=EntityUtils.toString(entitySort, "utf-8");
//            System.out.println(html);
//            JSONObject json=JSONObject.fromObject(html);
//            this.challenge=json.getString("challenge");
//            this.gt=json.getString("gt");
//            System.out.println("gt:"+gt);
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//    public void getpage_comp()
//    {
//        String url="http://api.geetest.com/get.php?gt=#{gt}&challenge=#{challenge}&product=embed&offline=false";
//        HttpGet httpPost=new HttpGet(url.replace("#{gt}", this.gt).replace("#{challenge}", this.challenge));
//        httpPost.setHeader("Connection", "Keep-Alive");
//        httpPost.setHeader("Host", "api.geetest.com");
//        httpPost.setHeader("Pragma", "no-cache");
//        httpPost.setHeader("Referer", "http://www.geetest.com/exp_normal");
//        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36");
//        String html="";
//        try {
//            CloseableHttpResponse response = httpclient.execute(httpPost);
//            HttpEntity entitySort = response.getEntity();
//            html=EntityUtils.toString(entitySort, "utf-8");
//
//            int sindex=html.indexOf("new Geetest(")+12;
//            if(sindex<1)
//                return;
//            int eindex=html.indexOf(",true");
//            this.json=html.substring(sindex, eindex);
//            JSONObject json=JSONObject.fromObject(this.json);
//            this.challenge=json.getString("challenge");
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//    public String getImage(String name,String url)
//    {
//        System.out.println(url);
//        try {
//            HttpGet httpimg = new HttpGet(url);
//            httpimg.setHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36");
//            httpimg.setHeader("Connection", "keep-alive");
//            httpimg.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//            httpimg.setHeader("Host", "static.geetest.com");
//            httpimg.setHeader("Upgrade-Insecure-Requests", "1");
//            httpimg.setHeader("Referer", "http://www.geetest.com/exp_normal");
//            HttpResponse responseimg =  httpclient.execute(httpimg);
//            File file=new File("E:\\zjt\\img\\"+name+".jpg");
//            OutputStream out=new FileOutputStream(file);
//            responseimg.getEntity().writeTo(out);
//            out.close();
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "E:\\zjt\\img\\"+name+".jpg";
//    }
//    /**
//     * 合成指定的多张图片到一张图片
//     *
//     * @param imgSrcList       图片的地址列表
//     * @param topLeftPointList 每张小图片的偏移量
//     * @param countOfLine 每行的小图片个数
//     * @param cutWidth         每张小图片截取的宽度（像素）
//     * @param cutHeight        每张小图片截取的高度（像素）
//     * @param savePath         合并后图片的保存路径
//     * @param subfix         合并后图片的后缀
//     * @return 是否合并成功
//     */
//    public static boolean combineImages(ArrayList<String> imgSrcList, ArrayList<String[]> topLeftPointList, int countOfLine, int cutWidth, int cutHeight, String savePath, String subfix) {
//        if (imgSrcList == null || savePath == null || savePath.trim().length() == 0)
//            return false;
//        BufferedImage lastImage = new BufferedImage(cutWidth * countOfLine, cutHeight * ((int) (Math.floor(imgSrcList.size() / countOfLine))), BufferedImage.TYPE_INT_RGB);
//        String prevSrc = "";
//        BufferedImage prevImage = null;
//        try {
//            for (int i = 0; i < imgSrcList.size(); i++) {
//                String src = imgSrcList.get(i);
//                BufferedImage image;
//                if (src.equals(prevSrc))
//                    image = prevImage;
//                else {
//                    if (src.trim().toLowerCase().startsWith("http"))
//                        image = ImageIO.read(new URL(src));
//                    else
//                        image = ImageIO.read(new File(src));
//                    prevSrc = src;
//                    prevImage = image;
//
//                }
//                if (image == null)
//                    continue;
//                String[] topLeftPoint = topLeftPointList.get(i);
//                int[] pixArray = image.getRGB(0 - Integer.parseInt(topLeftPoint[0].trim()), 0 - Integer.parseInt(topLeftPoint[1].trim()), cutWidth, cutHeight, null, 0, cutWidth);
//                int startX = ((i) % countOfLine) * cutWidth;
//                int startY = ((i) / countOfLine) * cutHeight;
//
//                lastImage.setRGB(startX, startY, cutWidth, cutHeight, pixArray, 0, cutWidth);
//            }
//            File file = new File(savePath);
//            return ImageIO.write(lastImage, subfix, file);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return false;
//        }
//    }
//    /**
//     * 通过背景的完整图片与有缺失的图片进行对比，得到偏移量
//     * @param imgSrc1   有缺失的图片路径
//     * @param imgSrc2   完整的背景图路径
//     * @return
//     */
//    public static int findXDiffRectangeOfTwoImage(String imgSrc1, String imgSrc2) {
//        try {
//            BufferedImage image1 = ImageIO.read(new File(imgSrc1));
//            BufferedImage image2 = ImageIO.read(new File(imgSrc2));
//            int width1 = image1.getWidth();
//            int height1 = image1.getHeight();
//            int width2 = image2.getWidth();
//            int height2 = image2.getHeight();
//
//            if (width1 != width2) return -1;
//            if (height1 != height2) return -1;
//
//            int left = 0;
//            /**
//             * 从左至右扫描
//             */
//            boolean flag = false;
//            for (int i = 0; i < width1; i++) {
//                for (int j = 0; j < height1; j++)
//                    if (isPixelNotEqual(image1, image2, i, j)) {
//                        left = i;
//                        flag = true;
//                        break;
//                    }
//                if (flag) break;
//            }
//            return left;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return -1;
//        }
//    }
//
//    private static boolean isPixelNotEqual(BufferedImage image1, BufferedImage image2, int i, int j) {
//        int pixel1 = image1.getRGB(i, j);
//        int pixel2 = image2.getRGB(i, j);
//
//        int[] rgb1 = new int[3];
//        rgb1[0] = (pixel1 & 0xff0000) >> 16;
//        rgb1[1] = (pixel1 & 0xff00) >> 8;
//        rgb1[2] = (pixel1 & 0xff);
//
//        int[] rgb2 = new int[3];
//        rgb2[0] = (pixel2 & 0xff0000) >> 16;
//        rgb2[1] = (pixel2 & 0xff00) >> 8;
//        rgb2[2] = (pixel2 & 0xff);
//
//        for (int k = 0; k < 3; k++)
//            if (Math.abs(rgb1[k] - rgb2[k]) > 50)//因为背景图会有一些像素差异
//                return true;
//
//        return false;
//    }
//    /**
//     * 在此方法内有尝试进行生成滑动轨迹并且提交滑动后的数据的信息
//     * @param xpos
//     */
//    public void GetValidate(int xpos)
//    {
//        JSONObject actions = GetActions(xpos);
//
//        int imgLoadTime = rnd.nextInt(200) + 50;
//        String passtime=actions.getString("passtime");
//        String actString=actions.getString("action");
//        //String response=GetResponseString(xpos, this.challenge);
//        System.out.println("xpos:\t"+xpos+"\tthis.challenge:\t"+this.challenge+"\nactString:"+actString);
//        String response=ResponseJS.getResponseforJS(xpos, this.challenge, "D:\\src\\code1\\geetest\\GetResponseString.js");
//        System.out.println("this.gt"+this.gt);
//        String url="http://api.geetest.com/ajax.php?gt="+this.gt+"&challenge="+this.challenge+"&imgload="+imgLoadTime+"&passtime="+passtime+"&userresponse="+response+"&a="+actString+"&callback=cb";
//        try {
//            Thread.sleep(imgLoadTime+Integer.parseInt(passtime));
//        } catch (NumberFormatException e2) {
//            // TODO Auto-generated catch block
//            e2.printStackTrace();
//        } catch (InterruptedException e2) {
//            // TODO Auto-generated catch block
//            e2.printStackTrace();
//        }
//        HttpGet httpPost=new HttpGet(url);
//        httpPost.setHeader("Connection", "Keep-Alive");
//        httpPost.setHeader("Host", "api.geetest.com");
//        httpPost.setHeader("Pragma", "no-cache");
//        httpPost.setHeader("Referer", "http://antirobot.tianyancha.com/captcha/verify?return_url=http://www.tianyancha.com/search?key=%E6%B8%A9%E5%B7%9E%E6%B8%A9%E5%95%86%E6%96%87%E5%8C%96%E4%BC%A0%E5%AA%92%E8%82%A1%E4%BB%BD%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&checkFrom=searchBox&rnd=YZTvuxLYLFV9xdh7mX0Lzw==");
//        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36");
//        try {
//            Thread.sleep(Long.parseLong(passtime));
//        } catch (NumberFormatException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        } catch (InterruptedException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
//        String html="";
//        try {
//            CloseableHttpResponse cresponse = httpclient.execute(httpPost);
//            HttpEntity entitySort = cresponse.getEntity();
//            html=EntityUtils.toString(entitySort, "utf-8");
//            System.out.println(html);
//            if(html.indexOf("forbidden")==-1&&html.indexOf("fail")==-1)
//            {
//                System.exit(-1);
//            }
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
//    /**
//     * 计算参数
//     * @param xpos
//     * @return
//     */
//    private JSONObject GetActions(int xpos)
//    {
//
//        JSONObject act = new JSONObject();
//        act.put("pos", xpos+"");
//        ArrayList<int[]> action =generate(xpos);
//        for(int ac=0;ac<action.size();ac++)
//        {
//            int[] is=action.get(ac);
//            for(int iii=0;iii<is.length;iii++)
//            {
//                System.out.print(is[iii]+"\t");
//            }
//            System.out.println("");
//        }
//        act.put("action", encrypt(action));
//        int pt = 0;
//        for(int j=0;j<action.size();j++)
//        {
//            int[] ffints=action.get(j);
//            pt=ffints[2];
//        }
//        act.put("passtime", pt+"");
//        return act;
//    }
//    /**
//     * 从数据库中获得距离相似的数据
//     * @param xpos
//     * @return
//     */
//    public ArrayList<int[]> getDBdata(int xpos)
//    {
//        ArrayList<int[]> list=new ArrayList<int[]>();
//        ArrayList<String> actlist=new ArrayList<String>();
//        String sql="select posx,data from poxsData";
//        try {
//            ResultSet rs=dbu.Execute(sql);
//            while(rs.next())
//            {
//                String posx=rs.getString("posx").trim();
//                String data=rs.getString("data").trim();
//                int dbposx=Integer.parseInt(posx);
//                int wc=dbposx-xpos;
//                if(wc<2&&wc>-2)//满足误差
//                {
//                    actlist.add(data);
//                }
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        Random myR = new Random(System.currentTimeMillis());
//        if(actlist.size()==0)
//        {
//            return list;
//        }
//        int mt=Math.abs(myR.nextInt() %actlist.size());
//        String data=actlist.get(mt).replace("{", "a").replace("}", "b");
//        System.out.println(data);
//        String [] str=data.split("ba");
//        for(int i=0;i<str.length;i++)
//        {
//            String fstr=str[i].replace("a","").replace("b","");
//            String[] points=fstr.split(",");
//            int[] pointdata=new int[3];
//            int flag=i%2;
//            for(int j=0;j<3;j++)
//            {
//                String x=points[0];
//                String y=points[1];
//                String t=points[2];
//                pointdata[0]=Integer.parseInt(x);
//                pointdata[1]=Integer.parseInt(y);
//                pointdata[2]=Integer.parseInt(t);
//
//            }
//            list.add(pointdata);
//        }
//        for(int i=list.size()-1;i>0;i--)
//        {
//            int[] end=list.get(i);
//            int[] start=list.get(i-1);
//            int[] ns=new int[3];
//            ns[0]=end[0]-start[0];
//            ns[1]=end[1]-start[1];
//            ns[2]=end[2]-start[2];
//            list.set(i, ns);
//        }
//        ArrayList<int[]> bxlist=new ArrayList<int[]>();//对原有的人工轨迹进行修改
//
//        for(int i=0;i<list.size();i++)
//        {
//            int[] xyzold=list.get(i);
//            if(i==0)
//            {
//                int[] xyz=new int[3];
//                xyz[0]=xyzold[0];
//                xyz[0]=xyzold[0];
//                xyz[0]=xyzold[2];
//                bxlist.add(xyz);
//            }else
//            {
//                xyzold[2]--;
//                bxlist.add(xyzold);
//            }
//
//        }
//        return list;
//    }
//    private String encrypt(ArrayList<int[]> action)
//    {
//        ArrayList<int[]> d = action;// diff(action);
//        String dx = "", dy = "", dt = "";
//        for(int j=0; j<d.size(); j++)
//        {
//            char b = replace(d.get(j));
//            if(b != 0){
//                dy += b+"";
//            }
//            else
//            {
//                dx += (d.get(j)[0]);
//                dy += (d.get(j)[1]);
//            }
//            dt += (encode(d.get(j)[2]));
//        }
//        return  dx + "!!" + dy + "!!" + dt;
//    }
//    private String encode(int n)
//    {
//        String b = "()*,-./0123456789:?@ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqr";
//        int c = b.length();
//        char d = (char)0;
//        int e = Math.abs(n);
//        int f = e / c;
//        if (f >= c)
//            f = c - 1;
//        if (f != 0)
//        {
//            d = b.charAt(f);
//            e %= c;
//        }
//        String g = "";
//        if (n < 0)
//            g += "!";
//        if (d != 0)
//            g += "$";
//
//        return g + (d == 0 ? "": d+"" + b.charAt(e));
//    }
//    private char replace(int[] a2)
//    {
//        int[][] b = new int[][] { new int[] { 1, 0 }, new int[] { 2, 0 }, new int[] { 1, -1 },
//                new int[] { 1, 1 }, new int[] { 0, 1 }, new int[] { 0, -1 },
//                new int[] { 3, 0 }, new int[] { 2, -1 }, new int[] { 2, 1 } };
//        String c = "stuvwxyz~";
//        for (int d = 0; d < b.length; d++)
//            if (a2[0] == b[d][0] && a2[1] == b[d][1])
//                return c.charAt(d);
//        return '\0';
//    }
//    private ArrayList<int[]> generate(int xpos)
//    {
//        System.out.println(xpos);
//        int sx = rnd.nextInt(15)-25;
//        int sy = rnd.nextInt(15)-25;
//        ArrayList<int[]> arr = new ArrayList<int[]>();
//        arr.add(new int[] { sx, sy, 0 });
//        int maxCount = 300; // max len 100
//        double x = 0;
//        double lx = xpos - x;
//        while (Math.abs(lx) > 0.8 && maxCount-- > 0)
//        {
//            double rn = rnd.nextDouble();
//
//            double dx = rn * lx * 0.6;
//            if (Math.abs(dx) < 0.5)
//                continue;
//            double dt = rnd.nextDouble() *  (rn * 80 + 50)+ 10;
//
//            rn = rnd.nextDouble();
//            double dy = 0;
//            if (rn < 0.2 && dx > 10) //
//            {
//                dy = rn * 20.0;
//                if (rn < 0.05)
//                    dy = -rn * 80;
//            }
//
//            x += dx;
//            arr.add(new int[] { (int)(dx + 0.5), (int)(dy + 0.5), (int)(dt + 0.5) });
//            lx = xpos - x;
//        }
//        double dtlast = 500.0 * rnd.nextDouble() + 100.0;
//        arr.add(new int[] { -1, 0, (int)(dtlast) });
//        return arr;
//    }
//    /**
//     * 自己写的轨迹算法
//     * @param xpos
//     * @return
//     */
//    private ArrayList<int[]> generate3(int xpos)
//    {
//        int sx = rnd.nextInt(15)+15;
//        int sy = rnd.nextInt(5)+15;
//        ArrayList<int[]> arr = new ArrayList<int[]>();
//        int[] ints=new int[3];
//        ints[0]=sx;
//        ints[1]=sy;
//        ints[2]=0;
//        arr.add(ints);
//
//        int maxCount = 100; // max len 100
//        double mds = 0.25;
//        double speed = rnd.nextDouble() * 0.3 + 0.05;
//        double ds = rnd.nextDouble() * 0.5 * mds;
//        int dsign = 1;
//        double x = 0;
//        double lx = xpos - x;
//        while (Math.abs(lx) > 1.0 && maxCount-- > 0)
//        {
//            double rn = rnd.nextDouble();
//            double dt = rn * 100 + 10;
//            if (rn < 0.2)
//            {
//                dt += rn * 200;
//            }
//
//            speed += ds * dsign;
//            if (speed > 0.25)
//                speed = 0.25;
//            rn = rnd.nextDouble();
//
//            if (rn < (speed / 0.25))
//                dsign = -dsign;
//            ds = rnd.nextDouble() * mds * 0.5;
//            if (Math.abs(lx) < 10)
//            {
//                speed *= lx / 20;
//            }
//            else if (x < xpos / 3)
//            {
//                speed *= (x / xpos + 1.0);
//            }
//
//            if (speed < 0)
//                speed = -speed;
//            double dx = speed * dt;
//            if (Math.abs(dx) < 0.6)
//                continue;
//
//            x += dx;
//            if (x - xpos > 0 && dx > 0)
//            {
//                speed = -speed;
//                x -= 2 * dx;
//            }
//
//            rn = rnd.nextDouble();
//            double dy = 0;
//            if (rn < 0.1 && dt > 70)
//            {
//                dy = rn * 30;
//                if (rn < 0.05)
//                    dy = -rn * 60;
//            }
//            arr.add(new int[] { (int)(dx + 0.5), (int)(dy + 0.5), (int)(dt + 0.5) });
//            lx = xpos - x;
//            speed = rnd.nextDouble() * 0.2 + 0.01;
//        }
//        double dtlast = 50.0 * rnd.nextDouble() + 10.0;
//        arr.add(new int[] { 0, 0, (int)(dtlast+20) });
//        return arr;
//    }
//    private ArrayList<int[]> generate2(int xpos)
//    {
//        int sx = rnd.nextInt(15)+15;
//        int sy = rnd.nextInt(5)+15;
//        ArrayList<int[]> arr = new ArrayList<int[]>();
//        int[] ints=new int[3];
//        ints[0]=sx;
//        ints[1]=sy;
//        ints[2]=0;
//        arr.add(ints);
//
//        int maxCount = 200; // max len 100
//        double mds = 0.21;
//        double speed = rnd.nextDouble() * 0.1 + 0.01;
//        double ds = rnd.nextDouble() * 0.4 * mds;
//        int dsign = 1;
//        double x = 0;
//        double lx = xpos - x;
//        double lsadd=0;
//        while (Math.abs(lx) > 1.0 && maxCount-- > 0)
//        {
//            double rn = rnd.nextDouble();
//            double dt = rn * 100 + 10;
//            if (rn < 0.2)
//            {
//                dt += rn * 200;
//            }
//
//            speed += ds * dsign;
//            if (speed > 0.25)
//                speed = 0.25;
//            rn = rnd.nextDouble();
//
//            if (rn < (speed / 0.25))
//                dsign = -dsign;
//            ds = rnd.nextDouble() * mds * 0.5;
//            if (Math.abs(lx) < 10)
//            {
//                speed *= lx / 20;
//            }
//            else if (x < xpos / 3)
//            {
//                speed *= (x / xpos + 1.0);
//            }
//
//            if (speed < 0)
//                speed = -speed;
//            double dx = speed * dt;
//            if (Math.abs(dx) < 0.6)
//                continue;
//
//            x += dx;
//            if (x - xpos > 0 && dx > 0)
//            {
//                speed = -speed;
//                x -= 2 * dx;
//            }
//
//            rn = rnd.nextDouble();
//            double dy = 0;
//            if (rn < 0.1 && dt > 70)
//            {
//                dy = rn * 30;
//                if (rn < 0.05)
//                    dy = -rn * 60;
//            }
//            arr.add(new int[] { (int)(dx + 0.5), (int)(dy + 0.5), (int)(dt + 0.5) });
//            lx = xpos - x;
//            speed = rnd.nextDouble() * 0.2 + 0.01;
//        }
//        double dtlast = 50.0 * rnd.nextDouble() + 10.0;
//        arr.add(new int[] { 0, 0, (int)(dtlast) });
//        return arr;
//    }
//    public static String getCookie(String cookiename,CloseableHttpResponse response )
//    {
//        Header[] cookie=response.getAllHeaders();
//        for(int i=0;i<cookie.length;i++)
//        {
//            HeaderElement[] he=cookie[i].getElements();
//            for(int j=0;j<he.length;j++)
//            {
//                String name=he[j].getName();
//                if(cookiename.equals(name))
//                    return he[j].getValue();
//            }
//        }
//        return "";
//    }
//    public static void main(String[] args)
//    {
//        Geek g=new Geek();
//        g.startPama();
//        g.getpage_comp();
//        JSONObject json=JSONObject.fromObject(g.json);
//        String imgUrlBase="http://static.geetest.com/";
//        String bg=json.getString("bg");
//        String fullbg=json.getString("fullbg");
//        String slice=json.getString("slice");
//        int ypos=Integer.parseInt((String)json.getString("ypos"))+3;
//        String imgbgpath=g.getImage("gt", imgUrlBase+bg);
//        System.out.println("imgbgpath="+imgbgpath);
//        String imgFullBgpath=g.getImage("fullbg", imgUrlBase+fullbg);
//        System.out.println("imgFullBgpath:="+imgFullBgpath);
//        String imgSlicepath=g.getImage("slice", imgUrlBase+slice);
//        System.out.println("imgSlicepath="+imgSlicepath);
//        Toolkit tookkit = Toolkit.getDefaultToolkit();
//        Image imgBg=tookkit.getImage(imgbgpath);
//        Image imgFullBg=tookkit.getImage(imgFullBgpath);
//        Image imgSlice=tookkit.getImage(imgSlicepath);
//        ArrayList<String> imgSrcList_bg=new ArrayList<String>();
//        for(int i=0;i<52;i++)
//        {
//            imgSrcList_bg.add(imgbgpath);
//        }
//        ArrayList<String> imgSrcList_full=new ArrayList<String>();
//        for(int i=0;i<52;i++)
//        {
//            imgSrcList_full.add(imgFullBgpath);
//        }
//        ArrayList<String[]> topLeftPointList=new ArrayList<String[]>();//存储偏移量的信息
//        /**
//         * 存储的偏移量
//         **/
//        int[] ss={157, 145, 265, 277,181, 169, 241, 253, 109, 97, 289, 301, 85, 73, 25, 37, 13, 1, 121, 133, 61, 49, 217, 229, 205, 193,145, 157, 277, 265, 169, 181, 253, 241, 97, 109, 301, 289, 73, 85, 37, 25, 1, 13, 133, 121, 49, 61, 229, 217, 193, 205};
//        for(int i=0;i<26;i++)
//        {
//            String[] fstrs={"-"+ss[i],"-58"};
//            topLeftPointList.add(fstrs);
//        }
//        for(int i=26;i<52;i++)
//        {
//            String[] fstrs={"-"+ss[i],"0"};
//            topLeftPointList.add(fstrs);
//        }
//        combineImages(imgSrcList_bg, topLeftPointList, 26, 10, 58, "E:\\zjt\\img\\imgSrcList_bgAlign.jpg", "jpg");
//        combineImages(imgSrcList_full, topLeftPointList, 26, 10, 58, "E:\\zjt\\img\\imgSrcList_fullAlign.jpg", "jpg");
//        //计算偏移量
//        int xpoint=findXDiffRectangeOfTwoImage("E:\\zjt\\img\\imgSrcList_bgAlign.jpg", "E:\\zjt\\img\\imgSrcList_fullAlign.jpg");
//        System.out.println("xpoint:"+xpoint);
//        int xpoints=0;
//        long rm=System.currentTimeMillis()%3;//通过随机数来最终确定需要滑动的偏移量
//        if(rm==0)
//        {
//            xpoints=xpoint-4;
//        }if(rm==1)
//    {
//        xpoints=xpoint-5;
//    }
//        if(rm==2)
//        {
//            xpoints=xpoint-3;
//        }
//        g.GetValidate(xpoints);
//    }
//}
