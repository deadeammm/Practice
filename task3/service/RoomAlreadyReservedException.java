package org.example.service;

public class RoomAlreadyReservedException extends RuntimeException {
    public RoomAlreadyReservedException(int roomNumber) {
        super("Room " + roomNumber + " is already reserved.");
    }
}