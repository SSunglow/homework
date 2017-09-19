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
				+",�����="+plate.getPlatename()
				+",���="+plate.getDescribe());
		return plate;
	}

	//��ӣ�
	public static boolean addPlate(Plate plate){
		PlateDAO pdao=new PlateDAO();
		return pdao.save(plate);
	}
	
	//�޸ģ�
	public static boolean modifyPlate(Plate plate){
		PlateDAO pdao=new PlateDAO();
		return pdao.update(plate);
	}
	
	//ɾ����
	public static boolean RemovePlate(Plate plate){
		PlateDAO pdao=new PlateDAO();
		return pdao.delete(plate);
	}
	
	//ȫ��ѯ��
	public static List searchAll(){
		PlateDAO pdao=new PlateDAO();
		List all=pdao.findAll();
		Plate plate;
		for(int i=0;i<all.size();i++){
			plate=(Plate)all.get(i);
			System.out.println("id="+plate.getPlateid()
					+",�����="+plate.getPlatename()
					+",���="+plate.getDescribe());
		}
		return all;
	}
	//ģ����ѯ�������ֶ�������ѯ��
	public static List findPart(String where){
		PlateDAO pdao=new PlateDAO();
		return pdao.findPart(where);
	}
}
