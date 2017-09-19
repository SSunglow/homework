package forum.hiber.forumuser;

import forum.hiber.BaseHibernateDAO;
import forum.hiber.HibernateUtil;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * Forumuser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see forum.hiber.forumuser.Forumuser
 * @author MyEclipse Persistence Tools
 */
public class ForumuserDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(ForumuserDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String USERPWD = "userpwd";
	public static final String GENDER = "gender";
	public static final String AGE = "age";
	public static final String IDENTITY = "identity";
	public static final String EMAIL = "email";
	public static final String INTEGRAL = "integral";
	public static final String POSTSCOUNT = "postscount";
	public static final String FANSNUM = "fansnum";
	public static final String CONCERNNUM = "concernnum";
	public static final String HOME = "home";
	public static final String SCHOOL = "school";

	private Session session;  
	private Transaction tx;  
	public ForumuserDAO() {  
        session = HibernateUtil.getSession();  
    } 
	
	//相当于DB的insert into语句
	public boolean save(Forumuser transientInstance) {
		boolean b=false;
		log.debug("saving Forumuser instance");
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
	public boolean update(Forumuser transientInstance) {
		boolean b=false;
		log.debug("saving Forumuser instance");
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
	public boolean delete(Forumuser persistentInstance) {
		boolean b=false;
		log.debug("deleting Forumuser instance");
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
	public Forumuser findById(Short id) {
		log.debug("getting Forumuser instance with id: " + id);
		try {
			Forumuser instance = (Forumuser) getSession().get(
					"forum.hiber.forumuser.Forumuser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	//相当于DB的select * from 表 where 列2=？，列3=？...；
	public List findByExample(Forumuser instance) {
		log.debug("finding Forumuser instance by example");
		try {
			List results = getSession()
					.createCriteria("forum.hiber.forumuser.Forumuser")
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
		log.debug("finding Forumuser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Forumuser as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByUserpwd(Object userpwd) {
		return findByProperty(USERPWD, userpwd);
	}

	public List findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List findByIdentity(Object identity) {
		return findByProperty(IDENTITY, identity);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByIntegral(Object integral) {
		return findByProperty(INTEGRAL, integral);
	}

	public List findByPostscount(Object postscount) {
		return findByProperty(POSTSCOUNT, postscount);
	}

	public List findByFansnum(Object fansnum) {
		return findByProperty(FANSNUM, fansnum);
	}

	public List findByConcernnum(Object concernnum) {
		return findByProperty(CONCERNNUM, concernnum);
	}
	
	public List findByHome(Object home) {
		return findByProperty(HOME, home);
	}

	public List findBySchool(Object school) {
		return findByProperty(SCHOOL, school);
	}

	//相当于DB的select * from 表
	public List findAll() {
		log.debug("finding all Forumuser instances");
		try {
			String queryString = "from Forumuser";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findPart(String cond) {
		log.debug("finding all Forumuser instances");
		try {
			String queryString = "from Forumuser as forumuser"+cond;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Forumuser merge(Forumuser detachedInstance) {
		log.debug("merging Forumuser instance");
		try {
			Forumuser result = (Forumuser) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Forumuser instance) {
		log.debug("attaching dirty Forumuser instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Forumuser instance) {
		log.debug("attaching clean Forumuser instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	 
	public boolean check(Forumuser forumuser) {  
	    tx = session.beginTransaction();  
	    String sql = "select u.userpwd from Forumuser u where u.username='" +forumuser.getUsername()+ "'";  
	    List list = session.createQuery(sql).list();  
	    if(!list.isEmpty()) {  
	         Iterator it = list.iterator();  
	         while(it.hasNext()) {  
	             String get = (String) it.next();  
	             System.out.println(get);  
	             if(get.equals(forumuser.getUserpwd())) {  
	                 HibernateUtil.closeSession();  
	                 return true;  
	             }  
	         }  
	    }  
	    HibernateUtil.closeSession();  
	    return false;     
	}  
}