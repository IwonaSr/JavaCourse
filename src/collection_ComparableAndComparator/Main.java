package collection_CollectionsListMethods;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);
        //Copy seats to new ArrayList
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);

        seatCopy.get(1).reserve();
        if(theatre.reserveSeat("A02")){
            System.out.println("Please pay for A02");
        }else{
            System.out.println("Seat already reserved.");
        }

//        //REVERSE SORTING
//        Collections.reverse(seatCopy); //sort with reverse order
//        System.out.println("Printing seatCopy");
//        printList(seatCopy);
//        System.out.println("Printing theatre.seat");
//        printList(theatre.seats);

        //SHUFFLE
        Collections.shuffle(seatCopy); //sort with reverse order
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theatre.seat");
        printList(theatre.seats);

        //this method don't sort before the searching max and minimum element
        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        //swap method
        sortList(seatCopy);
        System.out.println("Printing sort seatcopy");
        printList(seatCopy);

        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
        Collections.copy(newList, theatre.seats);



    }

    public static void printList(List<Theatre.Seat> list){
        for (Theatre.Seat seat : list){
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("==========================================================");
    }

    //Bubble sort - slower than merge sort, but merge sort requires far more memory than a bubble sort
    //We can use this sort for any kind of list of theatre as long as they implement the comparable interface
    public static void sortList(List<? extends  Theatre.Seat> list){
        for(int i=0; i < list.size()-1 ; i++){
            for( int j=i+1; j < list.size(); j++){
                if(list.get(i).compareTo(list.get(j)) > 0){
                    Collections.swap(list,i,j);
                }
            }

        }
    }
}
