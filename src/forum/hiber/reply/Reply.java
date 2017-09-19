package forum.hiber.reply;

import java.util.Date;

/**
 * Reply entity. @author MyEclipse Persistence Tools
 */

public class Reply implements java.io.Serializable {

	// Fields

	private Short replyid;
	private String replycontent;
	private Short pid;
	private String replyname;
	private Date replytime;
	private String replydname;
	private Boolean seed;

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** minimal constructor */
	public Reply(Short replyid) {
		this.replyid = replyid;
	}

	/** full constructor */
	public Reply(Short replyid, String replycontent, Short pid,
			String replyname, Date replytime, String replydname, Boolean seed) {
		this.replyid = replyid;
		this.replycontent = replycontent;
		this.pid = pid;
		this.replyname = replyname;
		this.replytime = replytime;
		this.replydname = replydname;
		this.seed = seed;
	}

	// Property accessors

	public Short getReplyid() {
		return this.replyid;
	}

	public void setReplyid(Short replyid) {
		this.replyid = replyid;
	}

	public String getReplycontent() {
		return this.replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

	public Short getPid() {
		return this.pid;
	}

	public void setPid(Short pid) {
		this.pid = pid;
	}

	public String getReplyname() {
		return this.replyname;
	}

	public void setReplyname(String replyname) {
		this.replyname = replyname;
	}

	public Date getReplytime() {
		return this.replytime;
	}

	public void setReplytime(Date replytime) {
		this.replytime = replytime;
	}

	public String getReplydname() {
		return this.replydname;
	}

	public void setReplydname(String replydname) {
		this.replydname = replydname;
	}

	public Boolean getSeed() {
		return this.seed;
	}

	public void setSeed(Boolean seed) {
		this.seed = seed;
	}
	
	//添加功能：
	public String registReply(){
		Reply reply=new Reply();
		reply.setReplycontent(this.getReplycontent());
		
		if(RunReply.addReply(reply)){
			System.out.println("回复");
			return "success";
		}
		else
			return "fail";
	}

}