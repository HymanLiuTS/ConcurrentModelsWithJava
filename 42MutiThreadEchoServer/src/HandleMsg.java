import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HandleMsg implements Runnable {

	Socket clientSocket;

	public HandleMsg(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		BufferedReader is = null;
		PrintWriter os = null;

		try {
			is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			os = new PrintWriter(clientSocket.getOutputStream());
			String inputline = null;
			long b = System.currentTimeMillis();
			while ((inputline = is.readLine()) != null) {
				os.println(inputline);
				os.flush();
			}
			long e = System.currentTimeMillis();
			System.out.println("spend: " + (e - b) + "ms");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(is!=null) is.close();
					if(os!=null) os.close();
					clientSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}

}
