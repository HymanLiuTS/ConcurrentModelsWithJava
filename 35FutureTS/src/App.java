
public class App {
	public static void main(String[] args) {
		Client client = new Client();
		Data data = client.request("name");
		System.out.println("������ϣ�");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("����= " + data.getResult());
	}
}
