package forum.hiber.forumuser;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

/**
 * Forumuser entity. @author MyEclipse Persistence Tools
 */

public class Forumuser implements java.io.Serializable {

	// Fields

	private Short userid;
	private String username;
	private String userpwd;
	private String gender;
	private Short age;
	private String identity;
	private String email;
	private Integer integral;
	private Integer postscount;
	private Integer fansnum;
	private Short concernnum;

	// Constructors

	/** default constructor */
	public Forumuser() {
	}

	/** minimal constructor */
	public Forumuser(Short userid) {
		this.userid = userid;
	}

	/** full constructor */
	public Forumuser(Short userid, String username, String userpwd,
			String gender, Short age, String identity, String email,
			Integer integral, Integer postscount, Integer fansnum,
			Short concernnum) {
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.gender = gender;
		this.age = age;
		this.identity = identity;
		this.email = email;
		this.integral = integral;
		this.postscount = postscount;
		this.fansnum = fansnum;
		this.concernnum = concernnum;
	}

	// Property accessors

	public Short getUserid() {
		return this.userid;
	}

	public void setUserid(Short userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return this.userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Short getAge() {
		return this.age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public String getIdentity() {
		return this.identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIntegral() {
		return this.integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getPostscount() {
		return this.postscount;
	}

	public void setPostscount(Integer postscount) {
		this.postscount = postscount;
	}

	public Integer getFansnum() {
		return this.fansnum;
	}

	public void setFansnum(Integer fansnum) {
		this.fansnum = fansnum;
	}

	public Short getConcernnum() {
		return this.concernnum;
	}

	public void setConcernnum(Short concernnum) {
		this.concernnum = concernnum;
	}

	//Struts2的执行函数
	//登录功能：{用Struts2的默认规则}
	public String execute(){
		Short userid=new Short(this.getUserid());
		Forumuser forumuser=RunForumuser.searchForumuserById(userid);
		if(this.getUsername().equals(forumuser.getUsername())&&this.getUserpwd().equals(forumuser.getUserpwd()))
		{
			//访问Servlet-api:
			ActionContext atx=ActionContext.getContext();
			atx.getSession().put("name", this.getUsername());
			return "success";
		}
		else{
			return "fail";
		}
	}
	
	//注册功能：
	public String registUser(){
		Forumuser forumuser=new Forumuser();
		//forumuser.setUserid(this.getUserid());
		forumuser.setUsername(this.getUsername());
		forumuser.setUserpwd(this.getUserpwd());
		
		if(RunForumuser.addForumuser(forumuser)){
			System.out.println("正在注册");
			return "success";
		}
		else
			return "fail";
	}
	
	/*//修改密码功能：
	public String modifyPwd(){
		Forumuser forumuser=new Forumuser();
		forumuser.setUsername(this.getUsername());
		forumuser.setUserpwd(this.getUserpwd());
		
		if(RunForumuser.modifyForumuser(forumuser)){
			System.out.println("修改密码");
			return "success";
		}
		else
			return "fail";
	}*/
	
	//修改功能：
	public String modifyUser(){
		Forumuser forumuser=new Forumuser();
		forumuser.setUsername(this.getUsername());
		forumuser.setUserpwd(this.getUserpwd());
		forumuser.setGender(this.getGender());
		forumuser.setAge(this.getAge());
		forumuser.setIdentity(this.getIdentity());
		forumuser.setEmail(this.getEmail());
		forumuser.setIntegral(this.getIntegral());
		forumuser.setPostscount(this.getPostscount());
		forumuser.setFansnum(this.getFansnum());
		forumuser.setConcernnum(this.getConcernnum());
		
		if(RunForumuser.modifyForumuser(forumuser)){
			System.out.println("修改");
			return "success";
		}
		else
			return "fail";
	}
	
	//删除功能
	public String deleteUser(){
		Forumuser forumuser=new Forumuser();
		forumuser.setUsername(this.getUsername());
		forumuser.setUserpwd(this.getUserpwd());
		forumuser.setGender(this.getGender());
		forumuser.setAge(this.getAge());
		forumuser.setIdentity(this.getIdentity());
		forumuser.setEmail(this.getEmail());
		forumuser.setIntegral(this.getIntegral());
		forumuser.setPostscount(this.getPostscount());
		forumuser.setFansnum(this.getFansnum());
		forumuser.setConcernnum(this.getConcernnum());
		
		if(RunForumuser.RemoveForumuser(forumuser)){
			System.out.println("注销");
			return "success";
		}
		else
			return "fail";
	}
	
	//模糊查询:
	public String SearchForumuser(){
		List lst;
		//String where=" where ";
		String where=" where 1=1 ";
		Forumuser forumuser=new Forumuser();
		forumuser.setUserid(this.getUserid());
		forumuser.setUsername(this.getUsername());
		forumuser.setUserpwd(this.getUserpwd());
		forumuser.setGender(this.getGender());
		forumuser.setAge(this.getAge());
		forumuser.setIdentity(this.getIdentity());
		forumuser.setEmail(this.getEmail());
		forumuser.setIntegral(this.getIntegral());
		forumuser.setPostscount(this.getPostscount());
		forumuser.setFansnum(this.getFansnum());
		forumuser.setConcernnum(this.getConcernnum());
		if(//全查询：
			this.getUsername().length()==0&&this.getUserpwd().length()==0&&this.getUserid()==null)
		{
			lst=RunForumuser.searchAll();
		}
		{//模糊查询：
			if(this.getUserid()!=null)
			    where+=" and forumuser.userid = "+this.getUserid().toString()+" ";
			if(this.getUsername().length()!=0)
				where+=" and forumuser.username like '%"+this.getUsername()+"%' ";
			if(this.getUserpwd().length()!=0)
				where+=" and forumuser.userpwd like '%"+this.getUserpwd()+"%' ";
			if(this.getGender().length()!=0)
				where+=" and forumuser.gender like '%"+this.getGender()+"%' ";
			if(this.getAge()!=null)
				where+=" and forumuser.age like '%"+this.getAge()+"%' ";
			if(this.getIdentity().length()!=0)
				where+=" and forumuser.identity like '%"+this.getIdentity()+"%' ";
			if(this.getEmail().length()!=0)
				where+=" and forumuser.email like '%"+this.getEmail()+"%' ";
			if(this.getIntegral()!=null)
				where+=" and forumuser.integral like '%"+this.getIntegral()+"%' ";
			if(this.getPostscount()!=null)
				where+=" and forumuser.postscount like '%"+this.getPostscount()+"%' ";
			if(this.getFansnum()!=null)
				where+=" and forumuser.fansnum like '%"+this.getFansnum()+"%' ";
			if(this.getConcernnum()!=null)
				where+=" and forumuser.concernnum like '%"+this.getConcernnum()+"%' ";
			
				
				System.out.println(where);
				lst=RunForumuser.findPart(where);
		}		

		if(lst!=null){
			//访问Servlet-api:
			ActionContext atx=ActionContext.getContext();
			atx.getSession().put("forumusers", lst);
			System.out.println("查询");
			return "success";
		}
		else
			return "fail";

	}
}