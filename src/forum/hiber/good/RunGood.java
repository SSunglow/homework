package forum.hiber.good;

import java.util.List;


public class RunGood {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		searchAll();
	}
	public static Good searchGoodById(Integer goodid){
		GoodDAO pdao=new GoodDAO();
		Good good=pdao.findById(goodid);
		System.out.println("id="+good.getGoodid()
				+",������="+good.getGoodnameid()
				+",������="+good.getGoodpostid());
		return good;
	}

	//��ӣ�
	public static boolean addGood(Good good){
		GoodDAO pdao=new GoodDAO();
		return pdao.save(good);
	}
	
	//�޸ģ�
	public static boolean modifyGood(Good good){
		GoodDAO pdao=new GoodDAO();
		return pdao.update(good);
	}
	
	//ɾ����
	public static boolean RemoveGood(Good good){
		GoodDAO pdao=new GoodDAO();
		return pdao.delete(good);
	}
	
	//ȫ��ѯ��
	public static List searchAll(){
		GoodDAO pdao=new GoodDAO();
		List all=pdao.findAll();
		Good good;
		for(int i=0;i<all.size();i++){
			good=(Good)all.get(i);
			System.out.println("id="+good.getGoodid()
					+",������="+good.getGoodnameid()
					+",������="+good.getGoodpostid());
		}
		return all;
	}
	//ģ����ѯ�������ֶ�������ѯ��
	public static List findPart(String where){
		GoodDAO pdao=new GoodDAO();
		return pdao.findPart(where);
	}
}
