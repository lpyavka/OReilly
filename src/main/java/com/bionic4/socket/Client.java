package com.bionic4.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;

/**
 * Created by Sony on 13.12.2015.
 */
public class Client {
    public static void main(String[] args) throws IOException {

        String serverHostname = new String("127.0.0.1");

        if (args.length > 0)
            serverHostname = args[0];
        System.out.println("Trying to connect to host " +
                serverHostname + " on port 19001.");

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            socket = new Socket(serverHostname, 19001);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: " + serverHostname);
            System.exit(1);
        }

        BufferedReader brSystemIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        while ((userInput = brSystemIn.readLine()) != null) {
            out.println("Guest: " + userInput);


            if (userInput.equals("Bye."))
                break;

            System.out.println("server: " + in.readLine());
        }

        out.close();
        in.close();
        brSystemIn.close();
        socket.close();
    }
}
