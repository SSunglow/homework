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
		System.out.println("管理员ID="+admin.getAdminid()
				+",管理员名="+admin.getAdminname()
				+",管理员密码="+admin.getAdminpwd());
		return admin;
	}

	//添加：
	public static boolean addAdmin(Admin admin){
		AdminDAO adao=new AdminDAO();
		return adao.save(admin);
	}
	
	//修改：
	public static boolean modifyAdmin(Admin admin){
		AdminDAO adao=new AdminDAO();
		return adao.update(admin);
	}
	
	//删除：
	public static boolean RemoveAdmin(Admin admin){
		AdminDAO adao=new AdminDAO();
		return adao.delete(admin);
	}
	
	//全查询：
	public static List searchAll(){
		AdminDAO adao=new AdminDAO();
		List all=adao.findAll();
		Admin admin;
		for(int i=0;i<all.size();i++){
			admin=(Admin)all.get(i);
			System.out.println("管理员ID="+admin.getAdminid()
					+",管理员名="+admin.getAdminname()
					+",管理员密码="+admin.getAdminpwd());
		}
		return all;
	}
	//模糊查询：（多字段条件查询）
	public static List findPart(String where){
		AdminDAO adao=new AdminDAO();
		return adao.findPart(where);
	}
}
