package com.roundrocklabs.academy.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import com.roundrocklabs.academy.dao.IRoomDAO;
import com.roundrocklabs.academy.model.Room;
import com.roundrocklabs.academy.utils.HibernateUtil;

public class RoomDAOImpl implements IRoomDAO {
	private static final Log log = LogFactory.getLog(RoomDAOImpl.class);
	private static EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("oaPu");
	private static EntityManager entityManager;
	
	public void create(Room room) {
		log.debug("room created from: " + room.toString());
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(room);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public List<Room> read(Room r) {
		log.debug("Reading a Room: " + r.toString());
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		if (r.getRoom_id() != null) {
			List<Room> rooms = (List<Room>) entityManager.find(Room.class, r.getRoom_id());
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
				return null;
			} else {
				return results;
			}
		}

	}

	
	public void update(Room room) {
		log.debug("updating room: " + room.toString());
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Room room2 = (Room) session.load(Room.class, room.getRoom_id());

		if (!room.getName().isEmpty() || !(room == null))
			room2.setName(room.getName());

		if (!room.getDescription().isEmpty() || !(room.getDescription() == null))
			room2.setDescription(room.getDescription());

		if (!(room.getStart_date() == null))
			room2.setStart_date(room.getStart_date());

		if (!(room.getRetire_date() == null))
			room2.setRetire_date(room.getRetire_date());

		session.getTransaction().commit();
	}


	public void delete(Room room) {
		log.debug("Deleting room: " + room.toString());
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Room db_room = (Room) session.load(Room.class, room.getRoom_id());
		session.delete(db_room);

		session.getTransaction().commit();

	}

}
