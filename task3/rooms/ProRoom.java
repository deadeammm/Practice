package org.example.rooms;

public abstract class ProRoom extends Room {
    public ProRoom(int roomNumber, int maxOccupancy, int pricePerNight) {
        super(roomNumber, maxOccupancy, pricePerNight);
    }
}