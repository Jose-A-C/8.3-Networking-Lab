
package edu.sdccd.cisc191;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket s = new Socket("localhost", 4999);

        ObjectOutputStream outStream = new ObjectOutputStream(s.getOutputStream());
        VehicleRequest vehicleRequest = new VehicleRequest(2014, "Subaru", "Sedan" );
        outStream.writeObject(vehicleRequest);
        outStream.flush();

        ObjectInputStream inStream = new ObjectInputStream(s.getInputStream());
        VehicleResponse receiveResponse = (VehicleResponse)inStream.readObject();
        System.out.println("Vehicle response received.");
        System.out.println(receiveResponse.message);

        outStream.close();
        s.close();
    }
}