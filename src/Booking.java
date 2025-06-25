import java.util.Date;

public class Booking {
    User user;
    Room room;
    Date checkIn;
    Date checkOut;

    public Booking(User user, Room room, Date checkIn, Date checkOut) {
        this.user = user;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public boolean overlaps(Date in, Date out) {
        return !(out.before(checkIn) || in.after(checkOut));
    }

    @Override
    public String toString() {
        return "Booking: User " + user.getId() + ", Room " + room.roomNumber +
                " from " + checkIn + " to " + checkOut + ", Paid: " +
                (room.getPricePerNight() * getNights());
    }

    private long getNights() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return (diff / (1000 * 60 * 60 * 24)); // converted to days because 1 day = 86_400_000 ms
    }
}