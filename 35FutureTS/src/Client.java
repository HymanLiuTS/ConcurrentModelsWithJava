
public class Client {
	public Data request(final String queryStr){
		final FutureData future=new FutureData();
		new Thread(){
			public void run(){
				RealData realData=new RealData(queryStr);
				future.setReadData(realData);
			}
		}.start();
		return future;
	}
}
