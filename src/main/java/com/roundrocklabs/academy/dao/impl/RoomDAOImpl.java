package com.roundrocklabs.academy.dao.impl;

import java.sql.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import com.roundrocklabs.academy.dao.IRoomDAO;
import com.roundrocklabs.academy.model.Room;
import com.roundrocklabs.academy.utils.HibernateUtil;

public class RoomDAOImpl implements IRoomDAO {
	private static final Log log = LogFactory.getLog(RoomDAOImpl.class);

	@Override
	public Integer create(Room room) {
		log.debug("room created from: " + room.toString());

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(room);
		session.getTransaction().commit();
		room.setRoom_id(id);
		return id;
	}

	@Override
	public Integer create(String name) {
		Room room = new Room();
		room.setName(name);
		return create(room);
	}

	@Override
	public Integer create(String name, String description) {
		Room room = new Room();
		room.setName(name);
		room.setDescription(description);
		return create(room);
	}

	@Override
	public Integer create(String name, String description, Integer size) {
		Room room = new Room();
		room.setName(name);
		room.setDescription(description);
		room.setSize(size);
		return create(room);
	}

	@Override
	public Integer create(String name, String description, Integer size, Date start_date) {
		Room room = new Room();
		room.setName(name);
		room.setDescription(description);
		room.setSize(size);
		room.setStart_date(start_date);
		return create(room);
	}

	@Override
	public Room readById(Integer id) {
		log.debug("Reading a Room by id: " + id);

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("from Room r where r.room_id = :id").setParameter("id", id);

		Room room = (Room) query.uniqueResult();
		session.getTransaction().commit();
		return room;
	}

	@Override
	public List<Room> readByName(String name) {
		log.debug("Looking for string " + name + " in the list of rooms.");

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("from Room r where str(r.name) like :name").setParameter("name", name);

		List<Room> results = query.list();

		if (results == null || results.isEmpty()) {
			Query query2 = session.createQuery("from Room r where str(r.description) like :description").setParameter(
					"description", name);
			results = query2.list();
		}

		session.getTransaction().commit();

		if (results == null || results.isEmpty()) {
			return null;
		} else {
			return results;
		}
	}

	@Override
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

	@Override
	public void delete(Room room) {
		log.debug("Deleting room: " + room.toString());
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Room db_room = (Room) session.load(Room.class, room.getRoom_id());
		session.delete(db_room);

		session.getTransaction().commit();

	}

}
