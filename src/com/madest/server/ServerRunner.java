package com.madest.server;

public class ServerRunner {
    public static void main(String[] args) {
        Server server = new Server(9999,"Dragons.csv");
        server.run();
    }
}
