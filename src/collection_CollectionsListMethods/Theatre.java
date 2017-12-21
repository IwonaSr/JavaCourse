package collection_BinarySearch;

import java.util.*;

public class Theatre {

    private final String theatreName;
    //    private List<Seat> seats = new LinkedList<>();
//    private List<Seat> seats = new TreeSet<>();
//    private Collection<Seat> seats = new LinkedHashSet<>();
//    private Collection<Seat> seats = new ArrayList<>();
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }

        }
    }

    public String getTheatreName() {
        return theatreName;
    }

//    public boolean reserveSeat(String seatNumber) {
//        Seat requestedSeat = new Seat(seatNumber);
//        //The fastest way to find item in sorted list
//        //It works by checking the element in the midpoint of the list
//        //if the middle element is greater than the item that we're looking for in the first psrt of the list
//        // until element is not founded the list is reduced to half each time
//        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
//        if (foundSeat >= 0) {
//            return seats.get(foundSeat).reserve();
//        } else {
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//    }

    public boolean reserveSeat(String seatNumber) {

        int low = 0;
        int high = seats.size() - 1;

        while (low <= high) {
            System.out.println(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);

            int cmp = midVal.getSeatNumber().compareTo(seatNumber);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat " + seatNumber);
        return false;
    }

    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        private Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reserveation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }


    }
}
