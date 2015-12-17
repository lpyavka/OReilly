package com.bionic4.socket;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Sony on 13.12.2015.
 */
public class DownloadImage {


    public static void main(String[] arguments) throws IOException {

//       URL url = new URL("http://edu.bionic-university.com/file.php/147/Class_docs/ImageUrls.txt");
        URL url = new URL("file:///D:\\workspace\\bionic\\images\\ImageUrls.txt");
        URLConnection connection = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String imageUrl;
        int count = 1;
        while ((imageUrl = br.readLine()) != null) {
            System.out.println(imageUrl);
            String destinationFile = "D:\\workspace\\bionic\\images\\";
            String picName = "picture" + count+ ".jpg";
            saveImage(imageUrl, destinationFile + picName);
            count++;
        }
        br.close();
//        saveImage("http://pictures.dealer.com/g/graysonsubarusoa/0023/9be008d20a0d028a0098a8b834786af3.jpg",
//                "D:\\workspace\\bionic\\images\\1.jpg");
    }

       /* String imageUrl = "http://pictures.dealer.com/g/graysonsubarusoa/0023/9be008d20a0d028a0098a8b834786af3.jpg";
        String destinationFile = "image.txt";*/
/*
    */


    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
        httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");

        InputStream is = httpcon.getInputStream();
        BufferedInputStream br = new BufferedInputStream(is);
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = br.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
}


