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
				+",��ע��="+concern.getConcern()
				+",��˿="+concern.getFansid());
		return concern;
	}

	//��ӣ�
	public static boolean addConcern(Concern concern){
		ConcernDAO pdao=new ConcernDAO();
		return pdao.save(concern);
	}
	
	//�޸ģ�
	public static boolean modifyConcern(Concern concern){
		ConcernDAO pdao=new ConcernDAO();
		return pdao.update(concern);
	}
	
	//ɾ����
	public static boolean RemoveConcern(Concern concern){
		ConcernDAO pdao=new ConcernDAO();
		return pdao.delete(concern);
	}
	
	//ȫ��ѯ��
	public static List searchAll(){
		ConcernDAO pdao=new ConcernDAO();
		List all=pdao.findAll();
		Concern concern;
		for(int i=0;i<all.size();i++){
			concern=(Concern)all.get(i);
			System.out.println("id="+concern.getConcernid()
					+",��ע��="+concern.getConcern()
					+",��˿="+concern.getFansid());
		}
		return all;
	}
	//ģ����ѯ�������ֶ�������ѯ��
	public static List findPart(String where){
		ConcernDAO pdao=new ConcernDAO();
		return pdao.findPart(where);
	}
}
