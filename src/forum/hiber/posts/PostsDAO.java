package forum.hiber.posts;

import forum.hiber.BaseHibernateDAO;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for Posts
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see forum.hiber.posts.Posts
 * @author MyEclipse Persistence Tools
 */
public class PostsDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(PostsDAO.class);
	// property constants
	public static final String PLATEID = "plateid";
	public static final String TITLE = "title";
	public static final String AUTHOR = "author";
	public static final String CLICKNUM = "clicknum";
	public static final String REPLYNUM = "replynum";
	public static final String GOODNUM = "goodnum";
	public static final String CONTENT = "content";

	//相当于DB的insert into语句
	public boolean save(Posts transientInstance) {
		boolean b=false;
		log.debug("saving Posts instance");
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
	public boolean update(Posts transientInstance) {
		boolean b=false;
		log.debug("saving Posts instance");
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
	public boolean delete(Posts persistentInstance) {
		boolean b=false;
		log.debug("deleting Posts instance");
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
	public Posts findById(Short id) {
		log.debug("getting Posts instance with id: " + id);
		try {
			Posts instance = (Posts) getSession().get(
					"forum.hiber.posts.Posts", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	//相当于DB的select * from 表 where 列2=？，列3=？...；
	public List findByExample(Posts instance) {
		log.debug("finding Posts instance by example");
		try {
			List results = getSession()
					.createCriteria("forum.hiber.posts.Posts")
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
		log.debug("finding Posts instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Posts as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPlateid(Object plateid) {
		return findByProperty(PLATEID, plateid);
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List findByClicknum(Object clicknum) {
		return findByProperty(CLICKNUM, clicknum);
	}

	public List findByReplynum(Object replynum) {
		return findByProperty(REPLYNUM, replynum);
	}

	public List findByGoodnum(Object goodnum) {
		return findByProperty(GOODNUM, goodnum);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	//相当于DB的select * from 表
	public List findAll() {
		log.debug("finding all Posts instances");
		try {
			String queryString = "from Posts";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findPart(String cond) {
		log.debug("finding all Posts instances");
		try {
			String queryString = "from Posts as posts"+cond;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	public Posts merge(Posts detachedInstance) {
		log.debug("merging Posts instance");
		try {
			Posts result = (Posts) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Posts instance) {
		log.debug("attaching dirty Posts instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Posts instance) {
		log.debug("attaching clean Posts instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}