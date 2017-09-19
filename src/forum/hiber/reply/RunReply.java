package forum.hiber.reply;

import java.util.List;

public class RunReply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		searchAll();
	}
	public static Reply searchReplyById(Short replyid){
		ReplyDAO adao=new ReplyDAO();
		Reply reply=adao.findById(replyid);
		System.out.println("ID="+reply.getReplyid()
				+",����="+reply.getReplycontent()
				+",����id="+reply.getPid());
		return reply;
	}

	//��ӣ�
	public static boolean addReply(Reply reply){
		ReplyDAO rdao=new ReplyDAO();
		return rdao.save(reply);
	}
	
	//�޸ģ�
	public static boolean modifyReply(Reply reply){
		ReplyDAO rdao=new ReplyDAO();
		return rdao.update(reply);
	}
	
	//ɾ����
	public static boolean RemoveReply(Reply reply){
		ReplyDAO rdao=new ReplyDAO();
		return rdao.delete(reply);
	}
	
	//ȫ��ѯ��
	public static List searchAll(){
		ReplyDAO rdao=new ReplyDAO();
		List all=rdao.findAll();
		Reply reply;
		for(int i=0;i<all.size();i++){
			reply=(Reply)all.get(i);
			System.out.println("ID="+reply.getReplyid()
					+",����="+reply.getReplycontent()
					+",����id="+reply.getPid());
		}
		return all;
	}
	//ģ����ѯ�������ֶ�������ѯ��
	public static List findPart(String where){
		ReplyDAO rdao=new ReplyDAO();
		return rdao.findPart(where);
	}
}
