package forum.hiber.posts;

import java.util.List;

public class RunPosts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		searchAll();
	}
	public static Posts searchPostsById(Short conid){
		PostsDAO pdao=new PostsDAO();
		Posts posts=pdao.findById(conid);
		System.out.println("id="+posts.getConid()
				+",���id="+posts.getPlateid()
				+",����="+posts.getTitle());
		return posts;
	}

	//��ӣ�
	public static boolean addPosts(Posts posts){
		PostsDAO pdao=new PostsDAO();
		return pdao.save(posts);
	}
	
	//�޸ģ�
	public static boolean modifyPosts(Posts posts){
		PostsDAO pdao=new PostsDAO();
		return pdao.update(posts);
	}
	
	//ɾ����
	public static boolean RemovePosts(Posts posts){
		PostsDAO fdao=new PostsDAO();
		return fdao.delete(posts);
	}
	
	//ȫ��ѯ��
	public static List searchAll(){
		PostsDAO pdao=new PostsDAO();
		List all=pdao.findAll();
		Posts posts;
		for(int i=0;i<all.size();i++){
			posts=(Posts)all.get(i);
			System.out.println("id="+posts.getConid()
					+",���id="+posts.getPlateid()
					+",����="+posts.getTitle());
		}
		return all;
	}
	//ģ����ѯ�������ֶ�������ѯ��
	public static List findPart(String where){
		PostsDAO pdao=new PostsDAO();
		return pdao.findPart(where);
	}
	
	//��ѯĳһ�������ǰn�����ӣ�
	public static List findHot(int num,int plateid){
		PostsDAO pdao=new PostsDAO();
		String where = "where rownum <= "+ num+"and plateid = "+plateid+
				   "order by clicknum desc";
		return pdao.findPart(where);
	}
	public static List findHot(int num){
		PostsDAO pdao=new PostsDAO();
		String where = "where rownum <= "+ num+"order by clicknum desc";
		return pdao.findPart(where);
	}
}
