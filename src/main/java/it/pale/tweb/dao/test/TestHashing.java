package it.pale.tweb.dao.test;
import it.pale.tweb.dao.utils.SecurityPassword;

public class TestHashing {
	public static void main(String[] args) {
		String password="HelloSHA512!";
		String hashCorretto="9ccdcdcc5ed9eced19f44cac16395ae1714c3414b1c3f573781b895bc86e931cc074657d63843bb3fc9fd326d87ab0e604c3985eec99dc971a92d951c02d1b50";
		try {
			String hashProva=SecurityPassword.sha512(password);
			System.out.println(hashProva);
			if(hashProva.equals(hashCorretto)) {
				System.out.println("corretto");
			}
		}catch(Exception e) {}
	}
}
