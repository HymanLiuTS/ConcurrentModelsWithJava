
public class App {
	public static void main(String[] args) {
		Client client = new Client();
		Data data = client.request("name");
		System.out.println("请求完毕！");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("数据= " + data.getResult());
	}
}
