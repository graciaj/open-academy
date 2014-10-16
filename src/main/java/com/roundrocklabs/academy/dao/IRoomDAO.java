package com.roundrocklabs.academy.dao;

import java.util.List;

import com.roundrocklabs.academy.model.Room;

public interface IRoomDAO {

	public Room create(Room a);
	
	public void update(Room a);
	
	public List<Room> read(Room a);
	
	public void delete(Room a);
	
}
