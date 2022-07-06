package JDBC;

import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

	public static void main(String[] args) {
	
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.ResourceBundle.app", new Locale("hi"));
		
		System.out.println(rb.getString("greeting"));
	}

}
