package forum.hiber.admin;
/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Short adminid;
	private String adminname;
	private String adminpwd;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(Short adminid) {
		this.adminid = adminid;
	}

	/** full constructor */
	public Admin(Short adminid, String adminname, String adminpwd) {
		this.adminid = adminid;
		this.adminname = adminname;
		this.adminpwd = adminpwd;
	}

	// Property accessors

	public Short getAdminid() {
		return this.adminid;
	}

	public void setAdminid(Short adminid) {
		this.adminid = adminid;
	}

	public String getAdminname() {
		return this.adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpwd() {
		return this.adminpwd;
	}

	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}
	
	//Struts2的执行函数
	//登录功能：{用Struts2的默认规则}
	public String execute() throws Exception {
		AdminDAO adminDao = new AdminDAO();  
		Admin admin = new Admin();  
		admin.setAdminname(adminname);  
		admin.setAdminpwd(adminpwd);  
		if(adminDao.check(admin)) {  
        	return "success";  
        }  
        return "registadmin";
	}

}