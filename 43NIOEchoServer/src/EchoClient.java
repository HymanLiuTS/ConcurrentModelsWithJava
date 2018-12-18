import java.nio.ByteBuffer;
import java.util.LinkedList;

public class EchoClient {
	private LinkedList<ByteBuffer> outq;

	public EchoClient() {
		this.outq = new LinkedList<ByteBuffer>();
	}

	public LinkedList<ByteBuffer> getOutq() {
		return outq;
	}

	public void enqueue(ByteBuffer bb) {
		this.outq.addFirst(bb);
	}
}
