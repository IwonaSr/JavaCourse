package com.oop;

import Dimensions.Dimensions;

public class Main {

    public static void main(String[] args){
        Dimensions dimensions =  new Dimensions(20,20,5);
        Case theCase = new Case("220B", "Dell", "240", dimensions);

        Monitor theMonitor = new Monitor("27inch bease", "Acer", 27, new Resolution(2530, 1440));

        Motherboard motherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

        PC thePC = new PC(theCase, theMonitor, motherboard);

//        thePC.getMonitor().drawPixelAt(1500, 2000, "red");
//
//        thePC.getMotherboard().loadProgram("Windows 1.0");
//
//        thePC.getTheCase().pressPowerButton();
        thePC.powerUp();

        //SECOND EXAMPLE

        Wall wall1 = new Wall("West");
        Wall wall2 = new Wall("East");
        Wall wall3 = new Wall("South");
        Wall wall4 = new Wall("North");

        Ceiling ceiling = new Ceiling(12, 55);

        Bed bed = new Bed("Modern", 4,3,2,1);

        Lamp lamp = new Lamp("Classic", false, 12);

        Bedroom bedroom = new Bedroom("Tims", wall1, wall2, wall3, wall4, ceiling, bed, lamp);
        bedroom.makeBed();
        bedroom.getLamp().turnOn();


    }
}
