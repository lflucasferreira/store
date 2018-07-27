package store;

import config.PropertiesFile;

public class Register extends Actions {

	public static void main(String[] args) {
		properties();
		signIn();
		createAccount();
	}
	
	private static void createAccount() {
		String firstname = "Lucas";
		String lastname = "Ferreira";
		
		/*
		 * Limpa o campo de email, preenche com o email e submete para a próxima etapa do cadastro
		 */
		clearByID("email_create");
		sendKeysByID("email_create", PropertiesFile.getEmail());
		clickByID("SubmitCreate");
		
		/**
		 * Limpa todos os campos só para assegurar que as informações passadas são inseridas em campo vazio
		 */
		wait("customer_firstname");
		clearByID("customer_firstname");
		clearByID("customer_lastname");
		clearByID("email");
		clearByID("passwd");
		
		clearByID("firstname");
		clearByID("lastname");
		clearByID("company");
		clearByID("address1");
		clearByID("address2");
		clearByID("city");
		clearByID("postcode");
		clearByID("other");
		clearByID("phone");
		clearByID("phone_mobile");
		clearByID("alias");
		
		/**
		 * Informações Pessoais
		 */		
		clickByID("id_gender1");
		sendKeysByID("customer_firstname", firstname);
		sendKeysByID("customer_lastname", lastname);
		sendKeysByID("email", PropertiesFile.getEmail());
		sendKeysByID("passwd", PropertiesFile.getPassword());
		
		selectByID("days", "30");
		selectByID("days", "30");
		selectByID("months", "4");
		selectByID("years", "1988");
		
		/**
		 * Endereço Residencial
		 */
		sendKeysByID("firstname", firstname);
		sendKeysByID("lastname", lastname);
		sendKeysByID("company", "Stefanini");
		sendKeysByID("address1", "7504 Taylor Drive");
		sendKeysByID("city", "Brooklyn");
		selectByID("id_state", "32");
		sendKeysByID("postcode", "11238");
		selectByID("id_country", "21");
		sendKeysByID("phone_mobile", "347-200-1230");
		sendKeysByID("alias", "Home Address");
		
		/*
		 * Finaliza o cadastro, submetendo-o. Exibe mensagem de sucesso.
		 */
		clickByID("submitAccount");
		System.out.println("Account created successfully!");	
	}
}
