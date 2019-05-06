package com.johndoeo.base.io;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/5/5 22:20
 * @Description:
 */
public class ReadAndWriteBigFile {
    public static String fff = "";

    public static void main(String[] args) throws Exception {
        final int BUFFER_SIZE = 0x300000;// 缓冲区大小为3M
        File f = new File(fff);
        MappedByteBuffer inputBuffer = new RandomAccessFile(f, "r").getChannel().map(FileChannel.MapMode.READ_ONLY,
                f.length() / 2, f.length() / 2);
        byte[] dst = new byte[BUFFER_SIZE];// 每次读出3M的内容
        long start = System.currentTimeMillis();
        for (int offset = 0; offset < inputBuffer.capacity(); offset += BUFFER_SIZE) {
            if (inputBuffer.capacity() - offset >= BUFFER_SIZE) {
                for (int i = 0; i < BUFFER_SIZE; i++)
                    dst[i] = inputBuffer.get(offset + i);
            } else {
                for (int i = 0; i < inputBuffer.capacity() - offset; i++)
                    dst[i] = inputBuffer.get(offset + i);
            }
            int length = (inputBuffer.capacity() % BUFFER_SIZE == 0) ? BUFFER_SIZE
                    : inputBuffer.capacity() % BUFFER_SIZE;
            System.out.println(new String(dst, 0, length));// new
            // String(dst,0,length)这样可以取出缓存保存的字符串，可以对其进行操作
        }
        long end = System.currentTimeMillis();
        System.out.println("读取文件文件一半内容花费：" + (end - start) + "毫秒");
    }
}
