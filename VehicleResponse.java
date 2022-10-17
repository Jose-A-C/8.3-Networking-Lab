package edu.sdccd.cisc191;

import java.io.Serializable;
import java.util.Arrays;

public class VehicleResponse implements Serializable {
    private VehicleRequest request;
    private int milesOnVehicle;
    private int price;
    private int numberOfSeats;
    private int numberOfDoors;
    private String[] options;
    public String message;
    
    public VehicleResponse(VehicleRequest request, int milesOnVehicle, int price, int numberOfSeats, int numberOfDoors, String[] options){
        this.request = request;
        this.milesOnVehicle = milesOnVehicle;
        this.price = price;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;

        this.options = options;
        message = request.message +
                " \nVehicle Statistics: " +
                " \nMileage:" + milesOnVehicle +
                " \nPrice:" + price +
                " \nNumber Of Seats:" + numberOfSeats +
                " \nNumber Of Doors:" + numberOfDoors +
                " \nExtra Options:" + Arrays.toString(options);
    }
}