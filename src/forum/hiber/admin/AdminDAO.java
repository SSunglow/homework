package forum.hiber.admin;

import forum.hiber.BaseHibernateDAO;
import forum.hiber.HibernateUtil;
import forum.hiber.forumuser.Forumuser;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for Admin
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see forum.hiber.admin.Admin
 * @author MyEclipse Persistence Tools
 */
public class AdminDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(AdminDAO.class);
	// property constants
	public static final String ADMINNAME = "adminname";
	public static final String ADMINPWD = "adminpwd";

	private Session session;  
	private Transaction tx;  
	public AdminDAO() {  
        session = HibernateUtil.getSession();  
    } 
	
	//�൱��DB��insert into���
	public boolean save(Admin transientInstance) {
		boolean b=false;
		log.debug("saving Admin instance");
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

	//�൱��DB��update���
	public boolean update(Admin transientInstance) {
		boolean b=false;
		log.debug("saving Admin instance");
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
	
	//�൱��DB��delete from �� where id=����
	public boolean delete(Admin persistentInstance) {
		boolean b=false;
		log.debug("deleting Admin instance");
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

	//�൱��DB��select * from �� where id=����
	public Admin findById(Short id) {
		log.debug("getting Admin instance with id: " + id);
		try {
			Admin instance = (Admin) getSession().get(
					"forum.hiber.admin.Admin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Admin instance) {
		log.debug("finding Admin instance by example");
		try {
			List results = getSession()
					.createCriteria("forum.hiber.admin.Admin")
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
		log.debug("finding Admin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Admin as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAdminname(Object adminname) {
		return findByProperty(ADMINNAME, adminname);
	}

	public List findByAdminpwd(Object adminpwd) {
		return findByProperty(ADMINPWD, adminpwd);
	}

	//�൱��DB��select * from ��
	public List findAll() {
		log.debug("finding all Admin instances");
		try {
			String queryString = "from Admin";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findPart(String cond) {
		log.debug("finding all Admin instances");
		try {
			String queryString = "from Admin as admin"+cond;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Admin merge(Admin detachedInstance) {
		log.debug("merging Admin instance");
		try {
			Admin result = (Admin) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Admin instance) {
		log.debug("attaching dirty Admin instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Admin instance) {
		log.debug("attaching clean Admin instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public boolean check(Admin admin) {  
	    tx = session.beginTransaction();  
	    String sql = "select a.adminpwd from Admin a where a.adminname='" +admin.getAdminname()+ "'";  
	    List list = session.createQuery(sql).list();  
	    if(!list.isEmpty()) {  
	         Iterator it = list.iterator();  
	         while(it.hasNext()) {  
	             String get = (String) it.next();  
	             System.out.println(get);  
	             if(get.equals(admin.getAdminpwd())) {  
	                 HibernateUtil.closeSession();  
	                 return true;  
	             }  
	         }  
	    }  
	    HibernateUtil.closeSession();  
	    return false;     
	}  
}