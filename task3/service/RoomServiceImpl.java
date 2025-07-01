package org.example.service;

import org.example.rooms.Room;

public class RoomServiceImpl<T extends Room> implements RoomService<T> {
    @Override
    public void clean(T room) {
        System.out.println("Cleaning room #" + room.getRoomNumber());
    }

    @Override
    public void reserve(T room) {
        if (room.isReserved()) {
            throw new RoomAlreadyReservedException(room.getRoomNumber());
        }
        room.setReserved(true);
        System.out.println("Reserved room #" + room.getRoomNumber());
    }

    @Override
    public void free(T room) {
        room.setReserved(false);
        System.out.println("Freed room #" + room.getRoomNumber());
    }
}