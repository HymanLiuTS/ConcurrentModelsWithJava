import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class LockFreeVector<E> {
	private final AtomicReferenceArray<AtomicReferenceArray<E>> buckets;
	private AtomicReference<Descriptor<E>> descriptor;

	public LockFreeVector() {
		buckets = new AtomicReferenceArray<AtomicReferenceArray<E>>(30);
		buckets.set(0, new AtomicReferenceArray<E>(8));
		descriptor = new AtomicReference<Descriptor<E>>(new Descriptor<E>(0, null));
	}

	public void push_back(E e) {
		Descriptor<E> desc;
		Descriptor<E> newd;

		do {
			desc = descriptor.get();
			desc.completeWrite();
			int pos = desc.size + 8;
			int zeroNumPos = Integer.numberOfLeadingZeros(pos);
			int zeroNumFirst = Integer.numberOfLeadingZeros(0);
			int bucketInd = zeroNumFirst - zeroNumPos;

			if (buckets.get(bucketInd) == null) {
				int newLen = 2 * buckets.get(bucketInd - 1).length();
				buckets.compareAndSet(bucketInd, null, new AtomicReferenceArray<E>(newLen));

			}
			int idx = (0x80000000 >>> zeroNumPos) ^ pos;
			newd = new Descriptor<E>(desc.size + 1, new WriteDescriptor<E>(buckets.get(bucketInd), idx, null, e));
		} while (!descriptor.compareAndSet(desc, newd));
		descriptor.get().completeWrite();
	}

	public E get(int index) {
		int pos = index + 8;
		int zeroNumPos = Integer.numberOfLeadingZeros(pos);
		int zeroNumFirst = Integer.numberOfLeadingZeros(0);
		int bucketInd = zeroNumFirst - zeroNumPos;
		int idx = (0x80000000 >>> zeroNumPos) ^ pos;
		return buckets.get(bucketInd).get(idx);
	}
}
