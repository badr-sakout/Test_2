import java.util.*;

public class Service {
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        for (Room r : rooms) {
            if (r.roomNumber == roomNumber) return;
        }
        rooms.add(0, new Room(roomNumber, roomType, roomPricePerNight));
    }

    public void setUser(int userId, int balance) {
        for (User u : users) {
            if (u.getId() == userId) return;
        }
        users.add(0, new User(userId, balance));
    }

    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
        if (!checkIn.before(checkOut)) {
            System.out.println("Invalid date range.");
            return;
        }

        Room room = null;
        for (Room r : rooms) {
            if (r.roomNumber == roomNumber) {
                room = r;
                break;
            }
        }
        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        User user = null;
        for (User u : users) {
            if (u.getId() == userId) {
                user = u;
                break;
            }
        }
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        for (Booking b : bookings) {
            if (b.room.roomNumber == roomNumber && b.overlaps(checkIn, checkOut)) {
                System.out.println("Room not available in this period.");
                return;
            }
        }

        long nights = (checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24); // converted again to days because 1 day = 86_400_000 ms
        int totalCost = (int) (room.getPricePerNight() * nights);

        if (user.getBalance() < totalCost) {
            System.out.println("Insufficient balance.");
            return;
        }

        user.deductBalance(totalCost);
        bookings.add(0, new Booking(user, room, checkIn, checkOut));
        System.out.println("Booking successful.");
    }

    public void printAll() {
        System.out.println("------Rooms------");
        for (Room room : rooms) {
            System.out.println(room);
        }
        System.out.println("------Bookings------");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public void printAllUsers() {
        System.out.println("------Users------");
        for (User user : users) {
            System.out.println(user);
        }
    }
}