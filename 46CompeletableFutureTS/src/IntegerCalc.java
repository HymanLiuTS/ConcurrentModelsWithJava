import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class IntegerCalc {

	public static Integer calc2(Integer para) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	return para / 2 ;
}
	
	public static Integer calc(Integer para) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		return para * para;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final CompletableFuture<Integer> future=CompletableFuture.supplyAsync(()->calc(50));
		System.out.println(future.get());
		CompletableFuture<Object> fu=CompletableFuture.supplyAsync(()->calc(50))
				.exceptionally(ex->{System.out.println(ex);return 0;})
				.thenApply(x->Integer.toString(x))
				.thenApply((str)->"\""+str+"\"");
		System.out.println(fu.get());
		
		fu=CompletableFuture.supplyAsync(()->calc(50))
				.thenCompose((i)->CompletableFuture.supplyAsync(()->calc2(i)));
		System.out.println(fu.get());
		
		CompletableFuture<Integer> fu1=CompletableFuture.supplyAsync(()->calc(50));
		CompletableFuture<Integer> fu2=CompletableFuture.supplyAsync(()->calc(25));
		fu=fu1.thenCombine(fu2, (x,y) -> (x+y));
		System.out.println(fu.get());
	}

}
