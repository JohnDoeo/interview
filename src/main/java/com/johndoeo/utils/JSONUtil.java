package com.johndoeo.utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class JSONUtil {
    public static String readFile(String file){
        BufferedReader br = null;
        try{
             br = new BufferedReader(new FileReader(file));// 读取NAMEID对应值
            String s = null;
            StringBuilder sb = new StringBuilder();
            while ((s = br.readLine()) != null){
                sb.append(s);
            }
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(br != null){
                try{
                    br.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
