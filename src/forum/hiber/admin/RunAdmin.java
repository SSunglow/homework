package forum.hiber.admin;

import java.util.List;

public class RunAdmin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		searchAll();
	}
	public static Admin searchAdminById(Short adminid){
		AdminDAO adao=new AdminDAO();
		Admin admin=adao.findById(adminid);
		System.out.println("����ԱID="+admin.getAdminid()
				+",����Ա��="+admin.getAdminname()
				+",����Ա����="+admin.getAdminpwd());
		return admin;
	}

	//��ӣ�
	public static boolean addAdmin(Admin admin){
		AdminDAO adao=new AdminDAO();
		return adao.save(admin);
	}
	
	//�޸ģ�
	public static boolean modifyAdmin(Admin admin){
		AdminDAO adao=new AdminDAO();
		return adao.update(admin);
	}
	
	//ɾ����
	public static boolean RemoveAdmin(Admin admin){
		AdminDAO adao=new AdminDAO();
		return adao.delete(admin);
	}
	
	//ȫ��ѯ��
	public static List searchAll(){
		AdminDAO adao=new AdminDAO();
		List all=adao.findAll();
		Admin admin;
		for(int i=0;i<all.size();i++){
			admin=(Admin)all.get(i);
			System.out.println("����ԱID="+admin.getAdminid()
					+",����Ա��="+admin.getAdminname()
					+",����Ա����="+admin.getAdminpwd());
		}
		return all;
	}
	//ģ����ѯ�������ֶ�������ѯ��
	public static List findPart(String where){
		AdminDAO adao=new AdminDAO();
		return adao.findPart(where);
	}
}
