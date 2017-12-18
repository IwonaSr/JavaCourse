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


    }
}
