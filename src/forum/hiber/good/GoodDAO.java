package forum.hiber.good;

import forum.hiber.BaseHibernateDAO;
import forum.hiber.plate.Plate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for Good
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see forum.hiber.good.Good
 * @author MyEclipse Persistence Tools
 */
public class GoodDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(GoodDAO.class);
	// property constants
	public static final String GOODPOSTID = "goodpostid";
	public static final String GOODNAMEID = "goodnameid";

	public boolean save(Good transientInstance) {
		log.debug("saving Good instance");
		boolean b = false;
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().save(transientInstance);
			log.debug("save successful");
			tx.commit();
			b = true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		return b;
	}
	
	public boolean update(Good transientInstance) {
		boolean b=false;
		log.debug("saving Good instance");
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
	
	public boolean delete(Good persistentInstance) {
		log.debug("deleting Good instance");
		boolean b = false;
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().delete(persistentInstance);
			log.debug("delete successful");
			tx.commit();
			b = true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		return b;
	}

	public Good findById(java.lang.Integer id) {
		log.debug("getting Good instance with id: " + id);
		try {
			Transaction tx=getSession().beginTransaction();
			Good instance = (Good) getSession()
					.get("forum.hiber.good.Good", id);
			tx.commit();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Good instance) {
		log.debug("finding Good instance by example");
		try {
			List results = getSession().createCriteria("forum.hiber.good.Good")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Good instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Good as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGoodpostid(Object goodpostid) {
		return findByProperty(GOODPOSTID, goodpostid);
	}

	public List findByGoodnameid(Object goodnameid) {
		return findByProperty(GOODNAMEID, goodnameid);
	}

	public List findAll() {
		log.debug("finding all Good instances");
		try {
			Transaction tx=getSession().beginTransaction();
			String queryString = "from Good";
			Query queryObject = getSession().createQuery(queryString);
			tx.commit();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findPart(String cond) {
		log.debug("finding all Good instances");
		try {
			Transaction tx = getSession().beginTransaction();
			String queryString = "from Good as good"+cond;
			Query queryObject = getSession().createQuery(queryString);
			tx.commit();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Good merge(Good detachedInstance) {
		log.debug("merging Good instance");
		try {
			Good result = (Good) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Good instance) {
		log.debug("attaching dirty Good instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Good instance) {
		log.debug("attaching clean Good instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}