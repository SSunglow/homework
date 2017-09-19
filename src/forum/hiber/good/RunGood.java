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
				+",点赞人="+good.getGoodnameid()
				+",点赞帖="+good.getGoodpostid());
		return good;
	}

	//添加：
	public static boolean addGood(Good good){
		GoodDAO pdao=new GoodDAO();
		return pdao.save(good);
	}
	
	//修改：
	public static boolean modifyGood(Good good){
		GoodDAO pdao=new GoodDAO();
		return pdao.update(good);
	}
	
	//删除：
	public static boolean RemoveGood(Good good){
		GoodDAO pdao=new GoodDAO();
		return pdao.delete(good);
	}
	
	//全查询：
	public static List searchAll(){
		GoodDAO pdao=new GoodDAO();
		List all=pdao.findAll();
		Good good;
		for(int i=0;i<all.size();i++){
			good=(Good)all.get(i);
			System.out.println("id="+good.getGoodid()
					+",点赞人="+good.getGoodnameid()
					+",点赞帖="+good.getGoodpostid());
		}
		return all;
	}
	//模糊查询：（多字段条件查询）
	public static List findPart(String where){
		GoodDAO pdao=new GoodDAO();
		return pdao.findPart(where);
	}
}
