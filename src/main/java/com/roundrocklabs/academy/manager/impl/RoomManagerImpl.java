package com.roundrocklabs.academy.manager.impl;

import java.util.List;

import com.roundrocklabs.academy.dao.IRoomDAO;
import com.roundrocklabs.academy.dao.impl.RoomDAOImpl;
import com.roundrocklabs.academy.manager.IRoomManager;
import com.roundrocklabs.academy.model.Room;

public class RoomManagerImpl implements IRoomManager {

	private IRoomDAO roomDAO = new RoomDAOImpl();

	public void create(Room r) {
		roomDAO.create(r);
	}

	public List<Room> read(Room r) {
		return roomDAO.read(r);
	}

	public void update(Room r) {
		roomDAO.update(r);
	}

	public void delete(Room r) {
		roomDAO.delete(r);
	}

}
