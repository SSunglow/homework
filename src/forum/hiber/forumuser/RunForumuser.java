package forum.hiber.forumuser;

import java.util.List;

public class RunForumuser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������ӣ�
		Forumuser me=new Forumuser();
		me.setUsername("�½�");
		me.setUserpwd("666666");
		//addForumuser(me);
		searchAll();
	}
	public static Forumuser searchForumuserById(Short userid){
		ForumuserDAO fdao=new ForumuserDAO();
		Forumuser forumuser=fdao.findById(userid);
		System.out.println("id="+forumuser.getUserid()
				+",��¼��="+forumuser.getUsername()
				+",��¼����="+forumuser.getUserpwd());
		return forumuser;
	}

	//��ӣ�
	public static boolean addForumuser(Forumuser user){
		ForumuserDAO fdao=new ForumuserDAO();
		return fdao.save(user);
	}
	
	//�޸ģ�
	public static boolean modifyForumuser(Forumuser user){
		ForumuserDAO fdao=new ForumuserDAO();
		return fdao.update(user);
	}
	
	//ɾ����
	public static boolean RemoveForumuser(Forumuser user){
		ForumuserDAO fdao=new ForumuserDAO();
		return fdao.delete(user);
	}
	
	//ȫ��ѯ��
	public static List searchAll(){
		ForumuserDAO fdao=new ForumuserDAO();
		List all=fdao.findAll();
		Forumuser forumuser;
		for(int i=0;i<all.size();i++){
			forumuser=(Forumuser)all.get(i);
			System.out.println("��¼ID="+forumuser.getUserid()
					+",��¼��="+forumuser.getUsername()
					+",��¼����="+forumuser.getUserpwd());
		}
		return all;
	}
	//ģ����ѯ�������ֶ�������ѯ��
	public static List findPart(String where){
		ForumuserDAO fdao=new ForumuserDAO();
		return fdao.findPart(where);
	}
}
