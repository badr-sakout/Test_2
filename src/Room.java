public class Room {
    int roomNumber;
    RoomType type;
    int pricePerNight;

    public Room(int roomNumber, RoomType type, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() { return roomNumber; }
    public int getPricePerNight() { return pricePerNight; }

    @Override
    public String toString() {
        return "Room number: " + roomNumber + ",type = " + type + ", price per night = " + pricePerNight;
    }
}