package forum.hiber.concern;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

/**
 * Concern entity. @author MyEclipse Persistence Tools
 */

public class Concern implements java.io.Serializable {

	// Fields

	private Integer concernid;
	private Integer fansid;
	private Integer concern;

	// Constructors

	/** default constructor */
	public Concern() {
	}

	/** full constructor */
	public Concern(Integer concernid, Integer fansid, Integer concern) {
		this.concernid = concernid;
		this.fansid = fansid;
		this.concern = concern;
	}

	// Property accessors

	public Integer getConcernid() {
		return this.concernid;
	}

	public void setConcernid(Integer concernid) {
		this.concernid = concernid;
	}

	public Integer getFansid() {
		return this.fansid;
	}

	public void setFansid(Integer fansid) {
		this.fansid = fansid;
	}

	public Integer getConcern() {
		return this.concern;
	}

	public void setConcern(Integer concern) {
		this.concern = concern;
	}
	public String registConcern(){
		Concern concern=new Concern();
		concern.setConcernid(this.getConcernid());
		concern.setConcern(this.getConcern());
		concern.setFansid(this.fansid);
		
		if(RunConcern.addConcern(concern)){
			System.out.println("添加关注信息");
			return "success";
		}
		else
			return "fail";
	}
	
	//修改功能：
	/*
	public String modifyConcern(){
		Concern concern=new Concern();
		concern.setConcernid(this.getConcernid());
		concern.setConcern(this.getConcern());
		concern.setFansid(this.getFansid());
		
		if(RunConcern.modifyConcern(concern)){
			System.out.println("修改");
			return "success";
		}
		else
			return "fail";
	}
	*/
	
	//删除功能：取消关注
	public String deleteConcern(){
		Concern concern=new Concern();
		concern.setConcernid(this.getConcernid());
		concern.setConcern(this.getConcern());
		concern.setFansid(this.getFansid());
		
		if(RunConcern.RemoveConcern(concern)){
			System.out.println("取消关注");
			return "success";
		}
		else
			return "fail";
	}
	
	//模糊查询:查询关注人/粉丝
	public String SearchConcern(){
		List lst;
		String where=" where 1=1 ";
		Concern concern=new Concern();
		concern.setConcernid(this.getConcernid());
		concern.setConcern(this.concern);
		concern.setFansid(this.fansid);
		
		if(//全查询：
			 this.getConcernid() == null
		  && this.getConcern() == null
		  && this.getFansid() == null)
		{
			lst=RunConcern.searchAll();
		}
		else {//模糊查询：
			if(this.getConcernid()!=null)
			    where+=" and concern.concernid = "+this.getConcernid().toString()+" ";
			if(this.getConcern() != null)
				where+=" and concern.concern = "+ this.getConcern() + " ";
			if(this.getFansid() != null)
				where+=" and concern.fansid = "+ this.getFansid() + " ";
			
				System.out.println(where);
				lst=RunConcern.findPart(where);
		}		
		if(lst!=null){
			//访问Servlet-api:
			ActionContext atx=ActionContext.getContext();
			atx.getSession().put("concerns", lst);
			System.out.println("查询关注");
			return "success";
		}
		else
			return "fail";

	}
}