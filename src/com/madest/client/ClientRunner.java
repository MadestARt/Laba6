package com.madest.client;

import com.madest.exceptions.ServerConnectionException;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class ClientRunner {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            runClient();
        }

    }

    private static void runClient() throws InterruptedException {
        try {
            runServerWork();
        } catch (IOException e) {
            System.out.println("Сервер не доступен");
            Thread.sleep(5000);
        }
    }

    private static void runServerWork() throws IOException {
        try (Socket socket = new Socket("localhost", 9999);
        var outputStream = new DataOutputStream(socket.getOutputStream());
        var inputStream = new DataInputStream(socket.getInputStream())) {
            Scanner scan = new Scanner(System.in);

            var commandWithArgs = scan.nextLine();
            outputStream.writeUTF(commandWithArgs);
            var serverResponse = inputStream.readUTF();
            System.out.println(serverResponse);
        }

    }
}
