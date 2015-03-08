package com.roundrocklabs.academy.manager;

import java.util.List;

import com.roundrocklabs.academy.model.Room;

public interface IRoomManager {

    public void create(Room a);

    public void update(Room a);

    public List<Room> read(Room a);

    public void delete(Room a);

}
