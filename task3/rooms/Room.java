package org.example.rooms;

import java.util.Random;

public abstract class Room {
    private int roomNumber;
    private int maxOccupancy;
    private int pricePerNight;  // теперь int
    private boolean isReserved;

    // Полный конструктор
    public Room(int roomNumber, int maxOccupancy, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.maxOccupancy = maxOccupancy;
        this.pricePerNight = pricePerNight;
        this.isReserved = false;
    }

    // Удобный конструктор: random occupancy
    public Room(int roomNumber, int pricePerNight) {
        this(roomNumber, new Random().nextInt(4) + 1, pricePerNight);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public int getPricePerNight() {  // теперь int
        return pricePerNight;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        this.isReserved = reserved;
    }
}