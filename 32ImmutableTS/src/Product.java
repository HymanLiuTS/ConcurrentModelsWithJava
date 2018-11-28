
public final class Product { // 确保无子类

	private final String no; //私用属性不会被其它对象获取，final关键字保证属性不会二次赋值

	private final String name;

	private final double price;

	public Product(String no, String name, double price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
	}

	public String getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

}
