package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Exercise2 {

    public static List<TimeSlot> createTimeSlots(){
        return Arrays.asList(
                new TimeSlot(),new TimeSlot(),new TimeSlot(),
                new TimeSlot(),new TimeSlot(),new TimeSlot()
        );
    }

    public static void main(String[] args) {
        List<TimeSlot> timeSlots = createTimeSlots();

        String bookingDetails = null;
        for (TimeSlot slot: timeSlots){
            if (slot.isAvailable()) {
                bookingDetails = slot.schedule();
                break;
            }
        }

        if (bookingDetails != null){
            System.out.println(bookingDetails);
        }else {
            System.out.println("Booking not available");
        }


        //Functional Style code
        createTimeSlots().stream()
                .filter(TimeSlot::isAvailable)
                .findFirst()
                .map(TimeSlot::schedule)
                .orElse("Not Available");

        ;
    }
}

class TimeSlot{

    static Random random = new Random(System.nanoTime());

    public String schedule(){
        return "booking details "  + hashCode();
    }

    public boolean isAvailable(){
        return random.nextBoolean();
    }

}
