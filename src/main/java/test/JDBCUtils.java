package test;

import java.util.ArrayList;

public class JDBCUtils {
	private static JDBCUtils instance;

	private JDBCUtils() {
	}

	public static JDBCUtils getInstance() {
		if (instance == null) {
			instance = new JDBCUtils();
		}
		return instance;
	}

	public ArrayList<Product> getAll() {
		ArrayList<Product> products = new ArrayList<>();
		products.add(new Product(0, "my cay", 12000));
		products.add(new Product(1, "kim chi", 6000));
		products.add(new Product(2, "xuc xich", 52000));
		products.add(new Product(3, "co ca", 16000));
		products.add(new Product(4, "nuoc cam", 16000));
		products.add(new Product(5, "pho mai", 22000));
		products.add(new Product(6, "keo tau", 2000));
		products.add(new Product(7, "tuong ot", 12000));
		products.add(new Product(8, "da", 2000));
		products.add(new Product(9, "lap suon", 32000));
		return products;
	}
}
