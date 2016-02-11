package others;

public class Product {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Product create(String name) {
		return new Product(name);
	}

	public Product(String name) {
		super();
		this.name = name;
	}

}
