package com.atguigu.ioStream;

import org.junit.Test;

import java.io.*;

public class FileOutputStreamDemo {
    @Test
    public void outputStearm() throws IOException {
        FileOutputStream fos = new FileOutputStream("d:\\a.txt");
        //流对象的方法write写数据
        //写1个字节
        fos.write(98);
        //关闭资源
        fos.close();

    }

    @Test
    public void outPutStreamByte() throws IOException {
        FileOutputStream fos = new FileOutputStream("d:\\b.txt");
        //流对象的方法write写数据
        //写字节数组
        byte[] bytes = {65,66,67,68};
        fos.write(bytes);

        //写字节数组的一部分,开始索引,写几个
        fos.write(bytes, 1, 2);

        //写入字节数组的简便方式
        //写字符串
        fos.write("hello".getBytes());

        //关闭资源
        fos.close();

    }

    @Test
    public void outPutStream3() throws IOException {
        File file = new File("d:\\b.txt");
        FileOutputStream fos = new FileOutputStream(file,true);
        fos.write("hello\r\n".getBytes());
        fos.write("world".getBytes());
        fos.close();

    }

    @Test
    public void outPutStream4() throws IOException {
        FileInputStream fis = new FileInputStream("d:\\a.txt");
        //读取一个字节,调用方法read 返回int
        //使用循环方式,读取文件,  循环结束的条件  read()方法返回-1
        int len = 0;//接受read方法的返回值

        while( (len = fis.read()) != -1){
            System.out.print((char)len);
        }
        //关闭资源
        fis.close();


    }
}
