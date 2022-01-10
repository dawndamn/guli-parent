package com.atguigu.ioStream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    @Test
    public void FileInputStreamDemo1() throws IOException {
        FileInputStream fis = new FileInputStream("d:\\a.txt");
        // 创建字节数组
        byte[] b = new byte[2];

        int len = fis.read(b);
        System.out.println(new String(b));// ab
        System.out.println(len);// 2

        len = fis.read(b);
        System.out.println(new String(b));// cd
        System.out.println(len);// 2

        len = fis.read(b);
        System.out.println(new String(b));// ed
        System.out.println(len);// 1

        len = fis.read(b);
        System.out.println(new String(b));// ed
        System.out.println(len);// -1

        len = fis.read(b);
        System.out.println(new String(b));// ed
        System.out.println(len);// -1

        len = fis.read(b);
        System.out.println(new String(b));// ed
        System.out.println(len);// -1

        fis.close();

    }
}
