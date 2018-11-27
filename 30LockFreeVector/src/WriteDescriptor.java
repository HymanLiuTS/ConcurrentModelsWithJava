import java.util.concurrent.atomic.AtomicReferenceArray;

public class WriteDescriptor<E> {

	public E oldV;
	public E newV;
	public AtomicReferenceArray<E> addr;
	public int addr_ind;

	public WriteDescriptor(AtomicReferenceArray<E> addr, int addr_ind, E oldV, E newV) {
		this.oldV = oldV;
		this.newV = newV;
		this.addr = addr;
		this.addr_ind = addr_ind;
	}

	public void doIt() {
		addr.compareAndSet(addr_ind, oldV, newV);
	}
}
