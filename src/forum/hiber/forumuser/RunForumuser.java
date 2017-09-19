package forum.hiber.forumuser;

import java.util.List;

public class RunForumuser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ÔËÐÐÌí¼Ó£º
		Forumuser me=new Forumuser();
		me.setUsername("³Â½à");
		me.setUserpwd("666666");
		//addForumuser(me);
		searchAll();
	}
	public static Forumuser searchForumuserById(Short userid){
		ForumuserDAO fdao=new ForumuserDAO();
		Forumuser forumuser=fdao.findById(userid);
		System.out.println("id="+forumuser.getUserid()
				+",µÇÂ¼Ãû="+forumuser.getUsername()
				+",µÇÂ¼ÃÜÂë="+forumuser.getUserpwd());
		return forumuser;
	}

	//Ìí¼Ó£º
	public static boolean addForumuser(Forumuser user){
		ForumuserDAO fdao=new ForumuserDAO();
		return fdao.save(user);
	}
	
	//ÐÞ¸Ä£º
	public static boolean modifyForumuser(Forumuser user){
		ForumuserDAO fdao=new ForumuserDAO();
		return fdao.update(user);
	}
	
	//É¾³ý£º
	public static boolean RemoveForumuser(Forumuser user){
		ForumuserDAO fdao=new ForumuserDAO();
		return fdao.delete(user);
	}
	
	//È«²éÑ¯£º
	public static List searchAll(){
		ForumuserDAO fdao=new ForumuserDAO();
		List all=fdao.findAll();
		Forumuser forumuser;
		for(int i=0;i<all.size();i++){
			forumuser=(Forumuser)all.get(i);
			System.out.println("µÇÂ¼ID="+forumuser.getUserid()
					+",µÇÂ¼Ãû="+forumuser.getUsername()
					+",µÇÂ¼ÃÜÂë="+forumuser.getUserpwd());
		}
		return all;
	}
	//Ä£ºý²éÑ¯£º£¨¶à×Ö¶ÎÌõ¼þ²éÑ¯£©
	public static List findPart(String where){
		ForumuserDAO fdao=new ForumuserDAO();
		return fdao.findPart(where);
	}
}
