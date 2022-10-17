package edu.sdccd.cisc191;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server  {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();
        System.out.println("Client connected");

        ObjectInputStream inStream = new ObjectInputStream(s.getInputStream());
        VehicleRequest receiveRequest = (VehicleRequest)inStream.readObject();
        System.out.println("Vehicle Request received.");
        System.out.println(receiveRequest.message);

        ObjectOutputStream outStream = new ObjectOutputStream(s.getOutputStream());
        VehicleResponse vehicleResponse = new VehicleResponse(receiveRequest, 20000 , 8569, 4, 4, new String[]{"N/A" , "N/A"});
        outStream.writeObject(vehicleResponse);
        outStream.flush();

        ss.close();
    }
}