package com.bionic4.inputOutput;

import java.io.*;


/**
 * Created by Sony on 11.11.2015.
 */
public class FileToCopy {
    public static void main(String[] args) {

        File source = new File("D:\\workspace\\bionic\\fileToCopy.txt");
        File destination = new File("D:\\workspace\\bionic\\fileToCopy4.txt");
        try {
            fileToCopy(source, destination);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fileToCopy(File source, File destination) throws Exception {
        InputStream input = null;
        OutputStream output = null;



        input = new BufferedInputStream(new FileInputStream(source));

        output = new BufferedOutputStream(new FileOutputStream(destination));

        byte[] buf = new byte[1024];
        int byteRead;
        while ((byteRead = input.read(buf)) > 0) {
            output.write(buf, 0, byteRead);
        }
        input.close();
        output.close();


    }
}
