package org.example;

import org.example.rooms.*;
import org.example.service.*;

public class Main {
    public static void main(String[] args) {
        RoomService<Room> service = new RoomServiceImpl<>();

        EconomyRoom econ = new EconomyRoom(101, 2, 80);    // цена — int
        StandardRoom std  = new StandardRoom(201, 3, 120); // тоже int
        LuxRoom lux       = new LuxRoom(301, 2, 200);
        UltraLuxRoom ulux = new UltraLuxRoom(401, 2, 300);

        // Работа с econ
        service.clean(econ);
        service.reserve(econ);
        service.free(econ);
        service.reserve(econ);

        // Работа со std
        service.reserve(std);
        service.free(std);
        RoomService<StandardRoom> stdService = new RoomServiceImpl<>();
        stdService.reserve(std);
    }
}