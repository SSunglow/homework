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
				+",版块id="+posts.getPlateid()
				+",标题="+posts.getTitle());
		return posts;
	}

	//添加：
	public static boolean addPosts(Posts posts){
		PostsDAO pdao=new PostsDAO();
		return pdao.save(posts);
	}
	
	//修改：
	public static boolean modifyPosts(Posts posts){
		PostsDAO pdao=new PostsDAO();
		return pdao.update(posts);
	}
	
	//删除：
	public static boolean RemovePosts(Posts posts){
		PostsDAO fdao=new PostsDAO();
		return fdao.delete(posts);
	}
	
	//全查询：
	public static List searchAll(){
		PostsDAO pdao=new PostsDAO();
		List all=pdao.findAll();
		Posts posts;
		for(int i=0;i<all.size();i++){
			posts=(Posts)all.get(i);
			System.out.println("id="+posts.getConid()
					+",版块id="+posts.getPlateid()
					+",标题="+posts.getTitle());
		}
		return all;
	}
	//模糊查询：（多字段条件查询）
	public static List findPart(String where){
		PostsDAO pdao=new PostsDAO();
		return pdao.findPart(where);
	}
}
