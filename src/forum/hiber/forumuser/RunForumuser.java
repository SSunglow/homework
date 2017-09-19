package forum.hiber.forumuser;

import java.util.List;

public class RunForumuser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//运行添加：
		Forumuser me=new Forumuser();
		me.setUsername("cj");
		me.setUserpwd("123456");
		//addForumuser(me);
		searchAll();
	}
	public static Forumuser searchForumuserById(Short userid){
		ForumuserDAO fdao=new ForumuserDAO();
		Forumuser forumuser=fdao.findById(userid);
		System.out.println("id="+forumuser.getUserid()
				+",登录名="+forumuser.getUsername()
				+",登录密码="+forumuser.getUserpwd());
		return forumuser;
	}

	//添加：
	public static boolean addForumuser(Forumuser user){
		ForumuserDAO fdao=new ForumuserDAO();
		return fdao.save(user);
	}
	
	//修改：
	public static boolean modifyForumuser(Forumuser user){
		ForumuserDAO fdao=new ForumuserDAO();
		return fdao.update(user);
	}
	
	//删除：
	public static boolean RemoveForumuser(Forumuser user){
		ForumuserDAO fdao=new ForumuserDAO();
		return fdao.delete(user);
	}
	
	//全查询：
	public static List searchAll(){
		ForumuserDAO fdao=new ForumuserDAO();
		List all=fdao.findAll();
		Forumuser forumuser;
		for(int i=0;i<all.size();i++){
			forumuser=(Forumuser)all.get(i);
			System.out.println("登录ID="+forumuser.getUserid()
					+",登录名="+forumuser.getUsername()
					+",登录密码="+forumuser.getUserpwd());
		}
		return all;
	}
	//模糊查询：（多字段条件查询）
	public static List findPart(String where){
		ForumuserDAO fdao=new ForumuserDAO();
		return fdao.findPart(where);
	}
}
