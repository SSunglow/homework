package forum.hiber.posts;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import forum.hiber.plate.Plate;
import forum.hiber.plate.RunPlate;

/**
 * Posts entity. @author MyEclipse Persistence Tools
 */

public class Posts implements java.io.Serializable {

	// Fields

	private Integer conid;
	private Short plateid;
	private String title;
	private String author;
	private Integer clicknum;
	private Integer replynum;
	private Date replytime;
	private Integer goodnum;
	private String content;
	private Date ctime;
    private int page;
	// Constructors

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	/** default constructor */
	public Posts() {
	}

	/** minimal constructor */
	public Posts(Integer conid) {
		this.conid = conid;
	}

	/** full constructor */
	public Posts(Integer conid, Short plateid, String title, String author,
			Integer clicknum, Integer replynum, Date replytime,
			Integer goodnum, String content, Date ctime) {
		this.conid = conid;
		this.plateid = plateid;
		this.title = title;
		this.author = author;
		this.clicknum = clicknum;
		this.replynum = replynum;
		this.replytime = replytime;
		this.goodnum = goodnum;
		this.content = content;
		this.ctime = ctime;
	}

	// Property accessors

	public Integer getConid() {
		return this.conid;
	}

	public void setConid(Integer conid) {
		this.conid = conid;
	}

	public Short getPlateid() {
		return this.plateid;
	}

	public void setPlateid(Short plateid) {
		this.plateid = plateid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getClicknum() {
		return this.clicknum;
	}

	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}

	public Integer getReplynum() {
		return this.replynum;
	}

	public void setReplynum(Integer replynum) {
		this.replynum = replynum;
	}

	public Date getReplytime() {
		return this.replytime;
	}

	public void setReplytime(Date replytime) {
		this.replytime = replytime;
	}

	public Integer getGoodnum() {
		return this.goodnum;
	}

	public void setGoodnum(Integer goodnum) {
		this.goodnum = goodnum;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCtime() {
		return this.ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String registPosts(){
		Posts posts=new Posts();
		posts.setConid(this.getConid());
		posts.setPlateid(this.getPlateid());
		posts.setTitle(this.getTitle());
		posts.setAuthor(this.getAuthor());
		posts.setClicknum(this.getClicknum());
		posts.setReplynum(this.getReplynum());
		posts.setReplytime(this.getReplytime());
		posts.setGoodnum(this.getGoodnum());
		posts.setContent(this.getContent());
		posts.setCtime(this.getCtime());
		
		if(RunPosts.addPosts(posts)){
			System.out.println("帖子");
			return "success";
		}
		else
			return "fail";
	}
	
	//修改功能：
	public String modifyPosts(){
		Posts posts=new Posts();
		posts.setConid(this.getConid());
		posts.setPlateid(this.getPlateid());
		posts.setTitle(this.getTitle());
		posts.setAuthor(this.getAuthor());
		posts.setClicknum(this.getClicknum());
		posts.setReplynum(this.getReplynum());
		posts.setReplytime(this.getReplytime());
		posts.setGoodnum(this.getGoodnum());
		posts.setContent(this.getContent());
		posts.setCtime(this.getCtime());
		
		if(RunPosts.modifyPosts(posts)){
			System.out.println("修改");
			return "success";
		}
		else
			return "fail";
	}
	
	//删除功能
	public String deletePosts(){
		Posts posts=new Posts();
		posts.setConid(this.getConid());
		posts.setPlateid(this.getPlateid());
		posts.setTitle(this.getTitle());
		posts.setAuthor(this.getAuthor());
		posts.setClicknum(this.getClicknum());
		posts.setReplynum(this.getReplynum());
		posts.setReplytime(this.getReplytime());
		posts.setGoodnum(this.getGoodnum());
		posts.setContent(this.getContent());
		posts.setCtime(this.getCtime());
		
		if(RunPosts.RemovePosts(posts)){
			System.out.println("注销");
			return "success";
		}
		else
			return "fail";
	}

	//模糊查询:
	public String SearchPosts(){
		List lst;
		String where=" where 1=1 ";
		Posts posts=new Posts();
		posts.setConid(this.getConid());
		posts.setPlateid(this.getPlateid());
		posts.setTitle(this.getTitle());
		posts.setAuthor(this.getAuthor());
		posts.setClicknum(this.getClicknum());
		posts.setReplynum(this.getReplynum());
		posts.setReplytime(this.getReplytime());
		posts.setGoodnum(this.getGoodnum());
		posts.setContent(this.getContent());
		posts.setCtime(this.getCtime());
		if(//全查询：
			this.getConid()==null&&this.getPlateid()==null&&
			this.getTitle().length()==0&&this.getAuthor().length()==0&&
			this.getClicknum()==null&&this.getReplynum()==null&&
			this.getReplytime()==null&&this.getGoodnum()==null&&
			this.getContent().length()==0&&this.getCtime()==null)
		{
			lst=RunPlate.searchAll();
		}
		{//模糊查询：
			if(this.getConid()!=null)
			    where+=" and posts.conid = "+this.getConid().toString()+" ";
			if(this.getPlateid()!=null)
				where+=" and posts.plateid like '%"+this.getPlateid().toString()+"%' ";
			if(this.getTitle().length()!=0)
				where+=" and posts.title like '%"+this.getTitle()+"%' ";
			if(this.getAuthor().length()!=0)
				where+=" and posts.author like '%"+this.getAuthor()+"%' ";
			if(this.getClicknum()!=null)
				where+=" and posts.clicknum like '%"+this.getClicknum().toString()+"%' ";
			if(this.getReplynum()!=null)
				where+=" and posts.replynum like '%"+this.getReplynum().toString()+"%' ";
			if(this.getGoodnum()!=null)
				where+=" and posts.goodnum like '%"+this.getGoodnum().toString()+"%' ";
			if(this.getContent().length()!=0)
				where+=" and posts.content like '%"+this.getContent()+"%' ";
			if(this.getCtime()!=null)
				where+=" and posts.ctime like '%"+this.getCtime().toString()+"%' ";
				
				System.out.println(where);
				lst=RunPosts.findPart(where);
		}		

		if(lst!=null){
			//访问Servlet-api:
			ActionContext atx=ActionContext.getContext();
			atx.getSession().put("postss", lst);
			System.out.println("查询");
			return "success";
		}
		else
			return "fail";

	}
  
	public String showPosts(){
		System.out.println("showPosts:"+this.getPlateid());
		List list;
		Plate plate = RunPlate.searchPlateById(this.getPlateid());
		forum.other.page p = new forum.other.page(this.getPage(),plate.getPostscount(),20);
		String where =" where plateid =" + this.getPlateid() 
				/*
				             +"and rownum >=" + p.getFirst(page) 
				             +"and rownum <=" + p.getLast(page)*/;
		list = RunPosts.findPart(where);
		if (list != null) {
			ActionContext atx = ActionContext.getContext();
			atx.getSession().put("plate", plate );
			atx.getSession().put("posts", list);
			atx.getSession().put("page", page);
			return "success";
		}
		else {
			return "fail";
		}
	}
	
	public String showHotPosts(){
		List list;
		String where = "where rownum <= 10 order by clicknum desc";
		list = RunPosts.findPart(where);
		if (list != null) {
			ActionContext atx = ActionContext.getContext();
			atx.getSession().put("hotPosts", list);
			return "success";
		}
		else {
			return "fail";
		}
	}

}