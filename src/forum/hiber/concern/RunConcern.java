package forum.hiber.concern;

import java.util.List;


public class RunConcern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		searchAll();
	}
	public static Concern searchConcernById(Integer concernid){
		ConcernDAO pdao=new ConcernDAO();
		Concern concern=pdao.findById(concernid);
		System.out.println("id="+concern.getConcernid()
				+",关注人="+concern.getConcern()
				+",粉丝="+concern.getFansid());
		return concern;
	}

	//添加：
	public static boolean addConcern(Concern concern){
		ConcernDAO pdao=new ConcernDAO();
		return pdao.save(concern);
	}
	
	//修改：
	public static boolean modifyConcern(Concern concern){
		ConcernDAO pdao=new ConcernDAO();
		return pdao.update(concern);
	}
	
	//删除：
	public static boolean RemoveConcern(Concern concern){
		ConcernDAO pdao=new ConcernDAO();
		return pdao.delete(concern);
	}
	
	//全查询：
	public static List searchAll(){
		ConcernDAO pdao=new ConcernDAO();
		List all=pdao.findAll();
		Concern concern;
		for(int i=0;i<all.size();i++){
			concern=(Concern)all.get(i);
			System.out.println("id="+concern.getConcernid()
					+",关注人="+concern.getConcern()
					+",粉丝="+concern.getFansid());
		}
		return all;
	}
	//模糊查询：（多字段条件查询）
	public static List findPart(String where){
		ConcernDAO pdao=new ConcernDAO();
		return pdao.findPart(where);
	}
}
