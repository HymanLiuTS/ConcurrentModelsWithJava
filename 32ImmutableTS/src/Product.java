
public final class Product { // ȷ��������

	private final String no; //˽�����Բ��ᱻ���������ȡ��final�ؼ��ֱ�֤���Բ�����θ�ֵ

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
