package forum.hiber.plate;

import java.util.List;

public class RunPlate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		searchAll();
	}
	public static Plate searchPlateById(Short plateid){
		PlateDAO pdao=new PlateDAO();
		Plate plate=pdao.findById(plateid);
		System.out.println("id="+plate.getPlateid()
				+",版块名="+plate.getPlatename()
				+",简介="+plate.getDescribe());
		return plate;
	}

	//添加：
	public static boolean addPlate(Plate plate){
		PlateDAO pdao=new PlateDAO();
		return pdao.save(plate);
	}
	
	//修改：
	public static boolean modifyPlate(Plate plate){
		PlateDAO pdao=new PlateDAO();
		return pdao.update(plate);
	}
	
	//删除：
	public static boolean RemovePlate(Plate plate){
		PlateDAO pdao=new PlateDAO();
		return pdao.delete(plate);
	}
	
	//全查询：
	public static List searchAll(){
		PlateDAO pdao=new PlateDAO();
		List all=pdao.findAll();
		Plate plate;
		for(int i=0;i<all.size();i++){
			plate=(Plate)all.get(i);
			System.out.println("id="+plate.getPlateid()
					+",版块名="+plate.getPlatename()
					+",简介="+plate.getDescribe());
		}
		return all;
	}
	//模糊查询：（多字段条件查询）
	public static List findPart(String where){
		PlateDAO pdao=new PlateDAO();
		return pdao.findPart(where);
	}
}
