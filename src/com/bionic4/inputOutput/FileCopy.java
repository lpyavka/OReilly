package com.bionic4.inputOutput;

import java.io.*;
import java.nio.channels.FileChannel;


public class FileCopy {
    public static void main(String[] args) {
        File source = new File("D:\\workspace\\bionic\\fileToCopy.txt");
        File dest1 = new File("D:\\workspace\\bionic\\fileToCop1.txt");
        File dest2 = new File("D:\\workspace\\bionic\\fileToCopy2.txt");
        File dest3 = new File ("D:\\workspace\\bionic\\fileToCopy3.txt");
        try {
            copyFile(source, dest1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            copyFile2(source, dest2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            copyFile3(source, dest3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile(File source, File dest) throws IOException {

        InputStream input = null;
        OutputStream output = null;


        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;

            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally

        {
            input.close();
            output.close();
        }
    }

    private static void copyFile2(File source, File dest) throws IOException {

            FileChannel inputChannel = null;
            FileChannel outputChannel = null;
            try {
                inputChannel = new FileInputStream(source).getChannel();
                outputChannel = new FileOutputStream(dest).getChannel();
                outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
            } finally {
                inputChannel.close();
                outputChannel.close();
            }
        }
    private static void copyFile3(File source, File dest) throws IOException {

        InputStream input = null;
        OutputStream output = null;


        try {
            input = new BufferedInputStream(new FileInputStream(source));
            output = new BufferedOutputStream(new FileOutputStream(dest));
            byte[] buf = new byte[1024];
            int bytesRead;

            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally

        {
            input.close();
            output.close();
        }
    }

    }


