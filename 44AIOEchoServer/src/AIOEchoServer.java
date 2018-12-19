import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AIOEchoServer {
	public final static int PORT = 8000;
	private AsynchronousServerSocketChannel server;

	public AIOEchoServer() throws IOException {
		this.server = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(PORT));
	}

	public void start() {
		System.out.println("Server listen on " + PORT);
		server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

			final ByteBuffer buffer = ByteBuffer.allocate(1024);

			@Override
			public void completed(AsynchronousSocketChannel result, Object attachment) {
				System.out.println(Thread.currentThread().getName());
				Future<Integer> writeResult = null;

				buffer.clear();
				try {
					result.read(buffer).get(100, TimeUnit.SECONDS);// 读也是异步的，返回是一个Future，这里调用了future的get方法是阻塞的。
					buffer.flip();
					writeResult = result.write(buffer);// 写也是异步的
				} catch (InterruptedException | ExecutionException | TimeoutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					// 这里可以进行其它的操作
					try {
						server.accept(null, this);// 为下一个客户端的连接做准备,否则客户端只能连接一次
						writeResult.get();// 阻塞获取异步调用Write的结果
						result.close();
					} catch (InterruptedException | ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			@Override
			public void failed(Throwable exc, Object attachment) {
				System.out.println("failed: " + exc);

			}
		});
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		(new AIOEchoServer()).start();
		while (true) {
			Thread.sleep(1000);
		}
	}
}
