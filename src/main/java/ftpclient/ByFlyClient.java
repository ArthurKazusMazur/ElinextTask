package ftpclient;

import java.io.*;
import java.net.Socket;



public class ByFlyClient {
    //сокет для общения
    protected Socket clientSocket;
    //поток чтения
    protected BufferedReader in;
    //поток записи
    protected BufferedWriter out;

    public static void main(String[] args) {
        ByFlyClient byFly = new ByFlyClient("ftp.byfly.by", 21);
        byFly.Login("anonymous", "anonymous");

    }

        ByFlyClient(String hostname, int port) {
        try {
            this.clientSocket = new Socket(hostname, port);
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            //сообщение от сервера
            String response = in.readLine();
            System.out.println(response);

        } catch (IOException e) {
            System.err.println(e);
        }

    }

    public boolean Login(String user, String password) {
        boolean succces = false;
        try {
            sendOut("USER " + user);
            sendOut("PASS " + password);
            succces = true;
            String loginResponse = in.readLine();
            System.out.println(loginResponse);
        } catch (Exception e) {
            System.out.println("Ошибка авторизации");
            succces = false;
        }
        return (succces);
    }

    public void sendOut(String command) throws Exception {
        if (clientSocket == null) {
            throw new Exception("Соединение не установлено");
        }

        try {
            out.write(command + "\r\n");
            out.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}


