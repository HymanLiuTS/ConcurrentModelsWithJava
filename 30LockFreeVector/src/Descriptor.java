
public class Descriptor<E> {

	public int size;

	volatile WriteDescriptor<E> writeop;

	public Descriptor(int size, WriteDescriptor<E> writeop) {
		this.size = size;
		this.writeop = writeop;
	}

	public void completeWrite() {
		WriteDescriptor<E> tmpOp = writeop;
		if (tmpOp != null) {
			tmpOp.doIt();
			writeop = null;
		}
	}
}
