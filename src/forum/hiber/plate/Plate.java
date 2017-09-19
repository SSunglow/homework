package forum.hiber.plate;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

/**
 * Plate entity. @author MyEclipse Persistence Tools
 */

public class Plate implements java.io.Serializable {

	// Fields

	private Short plateid;
	private String platename;
	private String describe;
	private Date platedate;
	private Short postscount;
	private String master;

	// Constructors

	/** default constructor */
	public Plate() {
	}

	/** minimal constructor */
	public Plate(Short plateid) {
		this.plateid = plateid;
	}

	/** full constructor */
	public Plate(Short plateid, String platename, String describe,
			Date platedate, Short postscount, String master) {
		this.plateid = plateid;
		this.platename = platename;
		this.describe = describe;
		this.platedate = platedate;
		this.postscount = postscount;
		this.master = master;
	}

	// Property accessors

	public Short getPlateid() {
		return this.plateid;
	}

	public void setPlateid(Short plateid) {
		this.plateid = plateid;
	}

	public String getPlatename() {
		return this.platename;
	}

	public void setPlatename(String platename) {
		this.platename = platename;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Date getPlatedate() {
		return this.platedate;
	}

	public void setPlatedate(Date platedate) {
		this.platedate = platedate;
	}

	public Short getPostscount() {
		return this.postscount;
	}

	public void setPostscount(Short postscount) {
		this.postscount = postscount;
	}

	public String getMaster() {
		return this.master;
	}

	public void setMaster(String master) {
		this.master = master;
	}
	
	public String registPlate(){
		Plate plate=new Plate();
		plate.setPlateid(this.getPlateid());
		plate.setPlatename(this.getPlatename());
		plate.setDescribe(this.getDescribe());
		plate.setPlatedate(this.getPlatedate());
		plate.setPostscount(this.getPostscount());
		plate.setMaster(this.getMaster());
		
		if(RunPlate.addPlate(plate)){
			System.out.println("���");
			return "success";
		}
		else
			return "fail";
	}
	
	//�޸Ĺ��ܣ�
	public String modifyPlate(){
		Plate plate=new Plate();
		plate.setPlateid(this.getPlateid());
		plate.setPlatename(this.getPlatename());
		plate.setDescribe(this.getDescribe());
		plate.setPlatedate(this.getPlatedate());
		plate.setPostscount(this.getPostscount());
		plate.setMaster(this.getMaster());
		
		if(RunPlate.modifyPlate(plate)){
			System.out.println("�޸�");
			return "success";
		}
		else
			return "fail";
	}
	
	//ɾ������
	public String deletePlate(){
		Plate plate=new Plate();
		plate.setPlateid(this.getPlateid());
		plate.setPlatename(this.getPlatename());
		plate.setDescribe(this.getDescribe());
		plate.setPlatedate(this.getPlatedate());
		plate.setPostscount(this.getPostscount());
		plate.setMaster(this.getMaster());
		
		if(RunPlate.RemovePlate(plate)){
			System.out.println("ע��");
			return "success";
		}
		else
			return "fail";
	}
	
	//ģ����ѯ:
	public String SearchPlate(){
		List lst;
		String where=" where 1=1 ";
		Plate plate=new Plate();
		plate.setPlateid(this.getPlateid());
		plate.setPlatename(this.getPlatename());
		plate.setDescribe(this.getDescribe());
		plate.setPlatedate(this.getPlatedate());
		plate.setPostscount(this.getPostscount());
		plate.setMaster(this.getMaster());
		if(//ȫ��ѯ��
			this.getPlateid()==null&&this.getPlatename().length()==0&&
			this.getDescribe().length()==0&&this.getPlatedate()==null&&
			this.getPostscount()==null&&this.getMaster().length()==0)
		{
			lst=RunPlate.searchAll();
		}
		else {//ģ����ѯ��
			if(this.getPlateid()!=null)
			    where+=" and plate.plateid = "+this.getPlateid().toString()+" ";
			if(this.getPlatename().length()!=0)
				where+=" and plate.platename like '%"+this.getPlatename()+"%' ";
			if(this.getDescribe().length()!=0)
				where+=" and plate.describe like '%"+this.getDescribe()+"%' ";
			if(this.getPlatedate()!=null)
				where+=" and plate.platedate like '%"+this.getPlatedate().toString()+"%' ";
			if(this.getPostscount()!=null)
				where+=" and plate.postscount like '%"+this.getPostscount().toString()+"%' ";
			if(this.getMaster().length()!=0)
				where+=" and plate.master like '%"+this.getMaster()+"%' ";
				
				System.out.println(where);
				lst=RunPlate.findPart(where);
		}		
		if(lst!=null){
			//����Servlet-api:
			ActionContext atx=ActionContext.getContext();
			atx.getSession().put("plates", lst);
			System.out.println("��ѯ");
			return "success";
		}
		else
			return "fail";

	}

}