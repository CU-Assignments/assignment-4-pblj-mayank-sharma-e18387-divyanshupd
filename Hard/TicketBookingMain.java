package Hard;


import java.util.*;

class TicketBookingSystem {
    private final int totalSeats;
    private final Set<Integer> bookedSeats = new HashSet<>();

    public TicketBookingSystem(int seats) {
        this.totalSeats = seats;
    }

    public synchronized boolean bookSeat(int seatNumber, String customer) {
        if (seatNumber < 1 || seatNumber > totalSeats) {
            System.out.println(customer + " attempted to book an invalid seat: " + seatNumber);
            return false;
        }
        if (!bookedSeats.contains(seatNumber)) {
            bookedSeats.add(seatNumber);
            System.out.println(customer + " successfully booked seat: " + seatNumber);
            return true;
        } else {
            System.out.println(customer + " attempted to book an already booked seat: " + seatNumber);
            return false;
        }
    }
}

class BookingThread extends Thread {
    private final TicketBookingSystem system;
    private final int seatNumber;
    private final String customer;

    public BookingThread(TicketBookingSystem system, int seatNumber, String customer, int priority) {
        this.system = system;
        this.seatNumber = seatNumber;
        this.customer = customer;
        this.setPriority(priority);
    }

    @Override
    public void run() {
        system.bookSeat(seatNumber, customer);
    }
}

public class TicketBookingMain {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem(10);
        Thread vip1 = new BookingThread(system, 3, "VIP_Customer_1", Thread.MAX_PRIORITY);
        Thread vip2 = new BookingThread(system, 5, "VIP_Customer_2", Thread.MAX_PRIORITY);
        Thread regular1 = new BookingThread(system, 3, "Regular_Customer_1", Thread.MIN_PRIORITY);
        Thread regular2 = new BookingThread(system, 5, "Regular_Customer_2", Thread.MIN_PRIORITY);
        Thread regular3 = new BookingThread(system, 7, "Regular_Customer_3", Thread.NORM_PRIORITY);

        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
        regular3.start();
    }
}
