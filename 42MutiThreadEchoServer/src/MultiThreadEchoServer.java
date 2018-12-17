import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadEchoServer {

	private static ExecutorService tp = Executors.newCachedThreadPool();

	public static void main(String[] args) throws IOException {
		ServerSocket echoServer = null;
		Socket clientSocket = null;
		echoServer=new ServerSocket(8000);
		while(true){
			clientSocket=echoServer.accept();
			System.out.println(clientSocket.getRemoteSocketAddress()+" connect");
			tp.execute(new HandleMsg(clientSocket));
		}
	}

}
