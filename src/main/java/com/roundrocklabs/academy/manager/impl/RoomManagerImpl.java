package com.roundrocklabs.academy.manager.impl;

import java.sql.Date;
import java.util.List;

import com.roundrocklabs.academy.dao.IRoomDAO;
import com.roundrocklabs.academy.dao.impl.RoomDAOImpl;
import com.roundrocklabs.academy.manager.IRoomManager;
import com.roundrocklabs.academy.model.Room;

public class RoomManagerImpl implements IRoomManager {
	IRoomDAO roomDAO = new RoomDAOImpl();

	@Override
	public Integer create(Room room) {
		return roomDAO.create(room);
	}

	@Override
	public Integer create(String name) {
		return roomDAO.create(name);
	}

	@Override
	public Integer create(String name, String description) {
		return roomDAO.create(name, description);
	}

	@Override
	public Integer create(String name, String description, Integer size) {
		return roomDAO.create(name, description, size);
	}

	@Override
	public Integer create(String name, String description, Integer size, Date start_date) {
		return roomDAO.create(name, description, size, start_date);
	}

	@Override
	public Room readById(Integer id) {
		return roomDAO.readById(id);
	}

	@Override
	public List<Room> readByName(String name) {
		return roomDAO.readByName(name);
	}

	@Override
	public void update(Room room) {
		roomDAO.update(room);
	}

	@Override
	public void delete(Room room) {
		roomDAO.delete(room);
	}

}
