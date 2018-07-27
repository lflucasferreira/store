package store;

import config.PropertiesFile;

public class Login extends Actions {

	public static void main(String[] args) {
		properties();
		signIn();
		loginAccount();
	}

	public static void loginAccount() {
		/*
		 * Limpa os campos de email e senha. Depois preenche-os com as credenciais do usuário.
		 */
		clearByID("email");
		clearByID("passwd");
		sendKeysByID("email", PropertiesFile.getEmail());
		sendKeysByID("passwd", PropertiesFile.getPassword());
		
		/*
		 * Realiza o login e exibe a mensagem de sucesso.
		 */
		clickByID("SubmitLogin");
		System.out.println("Login done successfully!");
	}

}
