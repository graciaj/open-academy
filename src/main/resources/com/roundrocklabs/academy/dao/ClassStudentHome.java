// default package
// Generated Sep 26, 2014 4:14:15 PM by Hibernate Tools 3.1.0.beta4

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;



/**
 * Home object for domain model class ClassStudent.
 * @see .ClassStudent
 * @author Hibernate Tools
 */
public class ClassStudentHome {

    private static final Log log = LogFactory.getLog(ClassStudentHome.class);

    private final SessionFactory sessionFactory = getSessionFactory();
    
    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        }
        catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }
    
    public void persist(ClassStudent transientInstance) {
        log.debug("persisting ClassStudent instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(ClassStudent instance) {
        log.debug("attaching dirty ClassStudent instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ClassStudent instance) {
        log.debug("attaching clean ClassStudent instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(ClassStudent persistentInstance) {
        log.debug("deleting ClassStudent instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ClassStudent merge(ClassStudent detachedInstance) {
        log.debug("merging ClassStudent instance");
        try {
            ClassStudent result = (ClassStudent) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public ClassStudent findById( ClassStudentId id) {
        log.debug("getting ClassStudent instance with id: " + id);
        try {
            ClassStudent instance = (ClassStudent) sessionFactory.getCurrentSession()
                    .get("ClassStudent", id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ClassStudent instance) {
        log.debug("finding ClassStudent instance by example");
        try {
            List results = sessionFactory.getCurrentSession()
                    .createCriteria("ClassStudent")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 

}