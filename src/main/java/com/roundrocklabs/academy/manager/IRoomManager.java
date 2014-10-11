package com.roundrocklabs.academy.manager;

import java.sql.Date;
import java.util.List;

import com.roundrocklabs.academy.model.Room;

public interface IRoomManager {

	public Integer create(Room room);

	public Integer create(String name);

	public Integer create(String name, String description);

	public Integer create(String name, String description, Integer size);

	public Integer create(String name, String description, Integer size, Date start_date);

	public Room readById(Integer id);

	public List<Room> readByName(String name);

	public void update(Room room);

	public void delete(Room room);

}
