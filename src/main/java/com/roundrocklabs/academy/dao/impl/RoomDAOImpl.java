package com.roundrocklabs.academy.dao.impl;

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

	public Room create(Room room) {
		log.debug("room created from: " + room.toString());

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(room);
		session.getTransaction().commit();
		room.setRoom_id(id);
		return room;
	}

	public List<Room> read(Room r) {
		log.debug("Reading a Room: " + r.toString());

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		if (r.getRoom_id() != null) {
			Query query = session.createQuery("from Room r where r.room_id = :id").setParameter("id", r.getRoom_id());
			List<Room> rooms = query.list();
			session.getTransaction().commit();
			return rooms;
		} else {
			Query query = session.createQuery("from Room r where str(r.name) like :name").setParameter("name",
					r.getName());

			List<Room> results = query.list();

			if (results == null || results.isEmpty()) {
				Query query2 = session.createQuery("from Room r where str(r.description) like :description")
						.setParameter("description", r.getDescription());
				results = query2.list();
			}

			session.getTransaction().commit();

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
