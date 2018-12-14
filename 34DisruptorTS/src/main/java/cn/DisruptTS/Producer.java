package cn.DisruptTS;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

public class Producer {
	private final RingBuffer<PCData> ringBuffer;

	public Producer(RingBuffer<PCData> ringBuffer) {
		this.ringBuffer = ringBuffer;

	}

	public void pushData(ByteBuffer bb) {
		long sequence = this.ringBuffer.next();
		try {
			PCData event = this.ringBuffer.get(sequence);
			event.setValue(bb.getLong());
		} finally {
			this.ringBuffer.publish(sequence);
		}
	}
}
