package forum.hiber.reply;

import forum.hiber.BaseHibernateDAO;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for Reply
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see forum.hiber.reply.Reply
 * @author MyEclipse Persistence Tools
 */
public class ReplyDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(ReplyDAO.class);
	// property constants
	public static final String REPLYCONTENT = "replycontent";
	public static final String PID = "pid";
	public static final String REPLYNAME = "replyname";
	public static final String REPLYDNAME = "replydname";
	public static final String SEED = "seed";

	//相当于DB的insert into语句
	public boolean save(Reply transientInstance) {
		boolean b=false;
		log.debug("saving Reply instance");
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
	public boolean update(Reply transientInstance) {
		boolean b=false;
		log.debug("saving Reply instance");
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
	public boolean delete(Reply persistentInstance) {
		boolean b=false;
		log.debug("deleting Reply instance");
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
	public Reply findById(Short id) {
		log.debug("getting Reply instance with id: " + id);
		try {
			Reply instance = (Reply) getSession().get(
					"forum.hiber.reply.Reply", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	//相当于DB的select * from 表 where 列2=？，列3=？...；
	public List findByExample(Reply instance) {
		log.debug("finding Reply instance by example");
		try {
			List results = getSession()
					.createCriteria("forum.hiber.reply.Reply")
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
		log.debug("finding Reply instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Reply as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByReplycontent(Object replycontent) {
		return findByProperty(REPLYCONTENT, replycontent);
	}

	public List findByPid(Object pid) {
		return findByProperty(PID, pid);
	}

	public List findByReplyname(Object replyname) {
		return findByProperty(REPLYNAME, replyname);
	}

	public List findByReplydname(Object replydname) {
		return findByProperty(REPLYDNAME, replydname);
	}

	public List findBySeed(Object seed) {
		return findByProperty(SEED, seed);
	}

	//相当于DB的select * from 表
	public List findAll() {
		log.debug("finding all Reply instances");
		try {
			String queryString = "from Reply";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findPart(String cond) {
		log.debug("finding all Reply instances");
		try {
			String queryString = "from Reply as reply"+cond;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Reply merge(Reply detachedInstance) {
		log.debug("merging Reply instance");
		try {
			Reply result = (Reply) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Reply instance) {
		log.debug("attaching dirty Reply instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Reply instance) {
		log.debug("attaching clean Reply instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}