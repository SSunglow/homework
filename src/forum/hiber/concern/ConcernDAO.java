package forum.hiber.concern;

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
 * A data access object (DAO) providing persistence and search support for
 * Concern entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see forum.hiber.concern.Concern
 * @author MyEclipse Persistence Tools
 */
public class ConcernDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(ConcernDAO.class);
	// property constants
	public static final String FANSID = "fansid";
	public static final String CONCERN = "concern";

	public boolean save(Concern transientInstance) {
		log.debug("saving Concern instance");
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
	
	public boolean update(Concern transientInstance) {
		boolean b=false;
		log.debug("saving Concern instance");
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
	
	public boolean delete(Concern persistentInstance) {
		log.debug("deleting Concern instance");
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

	public Concern findById(java.lang.Integer id) {
		log.debug("getting Concern instance with id: " + id);
		try {
			Transaction tx=getSession().beginTransaction();
			Concern instance = (Concern) getSession().get(
					"forum.hiber.concern.Concern", id);
			tx.commit();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Concern instance) {
		log.debug("finding Concern instance by example");
		try {
			List results = getSession()
					.createCriteria("forum.hiber.concern.Concern")
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
		log.debug("finding Concern instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Concern as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFansid(Object fansid) {
		return findByProperty(FANSID, fansid);
	}

	public List findByConcern(Object concern) {
		return findByProperty(CONCERN, concern);
	}

	public List findAll() {
		log.debug("finding all Concern instances");
		try {
			Transaction tx=getSession().beginTransaction();
			String queryString = "from Concern";
			Query queryObject = getSession().createQuery(queryString);
			tx.commit();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List findPart(String cond) {
		log.debug("finding all Concern instances");
		try {
			Transaction tx = getSession().beginTransaction();
			String queryString = "from Concern as concern"+cond;
			Query queryObject = getSession().createQuery(queryString);
			tx.commit();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public Concern merge(Concern detachedInstance) {
		log.debug("merging Concern instance");
		try {
			Concern result = (Concern) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Concern instance) {
		log.debug("attaching dirty Concern instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Concern instance) {
		log.debug("attaching clean Concern instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}