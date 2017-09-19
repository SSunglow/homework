package forum.hiber.plate;

import forum.hiber.BaseHibernateDAO;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for Plate
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see forum.hiber.plate.Plate
 * @author MyEclipse Persistence Tools
 */
public class PlateDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(PlateDAO.class);
	// property constants
	public static final String PLATENAME = "platename";
	public static final String DESCRIBE = "describe";
	public static final String POSTSCOUNT = "postscount";
	public static final String MASTER = "master";

	//相当于DB的insert into语句
	public boolean save(Plate transientInstance) {
		boolean b=false;
		log.debug("saving Plate instance");
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().save(transientInstance);
			log.debug("save successful");
			tx.commit();
			b=true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		return b;
	}
	
	//相当于DB的update语句
	public boolean update(Plate transientInstance) {
		boolean b=false;
		log.debug("saving Plate instance");
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().update(transientInstance);
			log.debug("save successful");
			tx.commit();
			b=true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		return b;
	}

	//相当于DB的delete from 表 where id=？；
	public boolean delete(Plate persistentInstance) {
		boolean b=false;
		log.debug("deleting Plate instance");
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().delete(persistentInstance);
			log.debug("delete successful");
			tx.commit();
			b=true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		return b;
	}

	//相当于DB的select * from 表 where id=？；
	public Plate findById(Short id) {
		log.debug("getting Plate instance with id: " + id);
		try {
			Plate instance = (Plate) getSession().get(
					"forum.hiber.plate.Plate", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	//相当于DB的select * from 表 where 列2=？，列3=？...；
	public List findByExample(Plate instance) {
		log.debug("finding Plate instance by example");
		try {
			List results = getSession()
					.createCriteria("forum.hiber.plate.Plate")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	//相当于DB的select * from 表 where 列=？(列多对象，列多同值)；
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Plate instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Plate as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPlatename(Object platename) {
		return findByProperty(PLATENAME, platename);
	}

	public List findByDescribe(Object describe) {
		return findByProperty(DESCRIBE, describe);
	}

	public List findByPostscount(Object postscount) {
		return findByProperty(POSTSCOUNT, postscount);
	}

	public List findByMaster(Object master) {
		return findByProperty(MASTER, master);
	}

	//相当于DB的select * from 表
	public List findAll() {
		log.debug("finding all Plate instances");
		try {
			String queryString = "from Plate";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findPart(String cond) {
		log.debug("finding all Plate instances");
		try {
			String queryString = "from Plate as plate"+cond;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Plate merge(Plate detachedInstance) {
		log.debug("merging Plate instance");
		try {
			Plate result = (Plate) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Plate instance) {
		log.debug("attaching dirty Plate instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Plate instance) {
		log.debug("attaching clean Plate instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}