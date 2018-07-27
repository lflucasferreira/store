package store;

public class Buy extends Actions {

	public static void main(String[] args) {
		properties();
		signIn();
		Login.loginAccount();
		clickByLinkText("Women");
		clickByCssSeletor(3);
	}

}
