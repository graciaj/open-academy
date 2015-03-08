package com.roundrocklabs.academy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import com.roundrocklabs.academy.dao.IRoomDAO;
import com.roundrocklabs.academy.model.Room;
import com.roundrocklabs.academy.utils.HibernateUtil;

public class RoomDAOImpl implements IRoomDAO {
	private static final Log LOG = LogFactory.getLog(RoomDAOImpl.class);
	private static EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("oaPu");
	private static EntityManager entityManager;

    @Override
	public void create(Room room) {
		LOG.debug("room created from: " + room.toString());
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(room);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

    @Override
	public List<Room> read(Room r) {
		LOG.debug("Reading a Room: " + r.toString());
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		if (r.getRoomId() != null) {
			List<Room> rooms = (List<Room>) entityManager.find(Room.class, r.getRoomId());
			entityManager.getTransaction().commit();
			entityManager.close();
			return rooms;
		} else {

			List<Room> results = (List<Room>) entityManager.find(Room.class, r.getName());
			if (results == null || results.isEmpty()) {
				results = (List<Room>) entityManager.find(Room.class, r.getDescription());
			}

			entityManager.getTransaction().commit();
			entityManager.close();

			if (results == null || results.isEmpty()) {
				return new ArrayList<Room>();
			} else {
				return results;
			}
		}

	}

    @Override
	public void update(Room room) {
		LOG.debug("updating room: " + room.toString());
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Room room2 = (Room) session.load(Room.class, room.getRoomId());

		if (!room.getName().isEmpty() || !(room == null))
			room2.setName(room.getName());

		if (!room.getDescription().isEmpty() || !(room.getDescription() == null))
			room2.setDescription(room.getDescription());

		if (!(room.getStartDate() == null))
			room2.setStartDate(room.getStartDate());

		if (!(room.getRetireDate() == null))
			room2.setRetireDate(room.getRetireDate());

		session.getTransaction().commit();
	}

    @Override
	public void delete(Room room) {
		LOG.debug("Deleting room: " + room.toString());
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Room dbRoom = (Room) session.load(Room.class, room.getRoomId());
		session.delete(dbRoom);

		session.getTransaction().commit();

	}

}
