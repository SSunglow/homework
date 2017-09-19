
public class page {
	int nowPage;
	int total;
	int num;
	
	public page(int nowPage, int total, int num) {
		super();
		this.nowPage = nowPage;
		this.total = total;
		this.num = num;
	}

	public int getFirst(int page){
		return (page-1)*num + 1;
	}
	
	public int getLast(int page){
		return page*num;
	}
}
