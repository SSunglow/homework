package forum.hiber.good;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

/**
 * Good entity. @author MyEclipse Persistence Tools
 */

public class Good implements java.io.Serializable {

	// Fields

	private Integer goodid;
	private Integer goodpostid;
	private Integer goodnameid;

	// Constructors

	/** default constructor */
	public Good() {
	}

	/** minimal constructor */
	public Good(Integer goodid) {
		this.goodid = goodid;
	}

	/** full constructor */
	public Good(Integer goodid, Integer goodpostid, Integer goodnameid) {
		this.goodid = goodid;
		this.goodpostid = goodpostid;
		this.goodnameid = goodnameid;
	}

	// Property accessors

	public Integer getGoodid() {
		return this.goodid;
	}

	public void setGoodid(Integer goodid) {
		this.goodid = goodid;
	}

	public Integer getGoodpostid() {
		return this.goodpostid;
	}

	public void setGoodpostid(Integer goodpostid) {
		this.goodpostid = goodpostid;
	}

	public Integer getGoodnameid() {
		return this.goodnameid;
	}

	public void setGoodnameid(Integer goodnameid) {
		this.goodnameid = goodnameid;
	}

    //��ӵ�����Ϣ
	public String registGood(){
		Good good=new Good();
		good.setGoodid(this.getGoodid());
		good.setGoodnameid(this.getGoodnameid());
		good.setGoodpostid(this.goodpostid);
		
		if(RunGood.addGood(good)){
			System.out.println("��ӵ�����Ϣ");
			return "success";
		}
		else
			return "fail";
	}
	
	//�޸Ĺ��ܣ�
	/*
	public String modifyGood(){
		Good good=new Good();
		good.setGoodid(this.getGoodid());
		good.setGood(this.getGood());
		good.setFansid(this.getFansid());
		
		if(RunGood.modifyGood(good)){
			System.out.println("�޸�");
			return "success";
		}
		else
			return "fail";
	}
	*/
	
	//ɾ�����ܣ�ȡ������
	public String deleteGood(){
		Good good=new Good();
		good.setGoodid(this.getGoodid());
		good.setGoodnameid(this.getGoodnameid());
		good.setGoodpostid(this.goodpostid);
		
		if(RunGood.RemoveGood(good)){
			System.out.println("ȡ������");
			return "success";
		}
		else
			return "fail";
	}
	
	//ģ����ѯ:��ѯ������Ϣ
	public String SearchGood(){
		List lst;
		String where=" where 1=1 ";
		Good good=new Good();
		good.setGoodid(this.getGoodid());
		good.setGoodnameid(this.getGoodnameid());
		good.setGoodpostid(this.goodpostid);
		
		if(//ȫ��ѯ��
			 this.getGoodid() == null
		  && this.getGoodnameid() == null
		  && this.getGoodpostid() == null)
		{
			lst=RunGood.searchAll();
		}
		else {//ģ����ѯ��
			if(this.getGoodid() != null)
			    where+=" and good.goodid = "+this.getGoodid().toString()+" ";
			if(this.getGoodnameid() != null)
				where+=" and good.good = "+ this.getGoodnameid() + " ";
			if(this.getGoodpostid() != null)
				where+=" and good.fansid = "+ this.getGoodpostid() + " ";
			
				System.out.println(where);
				lst=RunGood.findPart(where);
		}		
		if(lst!=null){
			//����Servlet-api:
			ActionContext atx=ActionContext.getContext();
			atx.getSession().put("goods", lst);
			System.out.println("��ѯ");
			return "success";
		}
		else
			return "fail";

	}
}