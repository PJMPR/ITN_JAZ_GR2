package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@ActiveProfiles(profiles = "pl")
/*
Utworzyc profile dla konfiguracji (application-pl.properties ew. yml)
* */
class DemoApplicationTests {

	@Autowired
	/*
	 * Utworzyć klase DialogService i zarajestrować ją w kontenerze DI
	 * */
			DialogService dialog;

	@Test
	void contextLoads() {
		/*
		 * Utworzyć klase LoginMessages i zarajestrować ją w kontenerze DI
		 * */

		LoginMessages messages = dialog.getLoginMessages();

		/*
		 * login messages ma metodę która wyswietla powitanie
		 * */

		String welcome = messages.welcome();
		assertThat(welcome, equalTo("Witaj"));
		String provideUsername = messages.getUsernameMessage();

		/*
		 * login messages ma metodę która wyswietla prośbę o wprowadzenie nazwy uzytkownika
		 * */
		assertThat(provideUsername, equalTo("Podaj nazwe uzytkownika:"));

		/*
		 * login messages ma metodę która pozwala ustawić login
		 * */
		messages.setUsername("admin");

		/*
		 * login messages ma metodę która wyswietla zalogowanego uzytkownika
		 * */

		String loggedAsMessage = messages.getLoggedAsMessage();
		assertThat(loggedAsMessage, equalTo("Zalogowany jako admin"));

		messages.setUsername("jankowal");

		loggedAsMessage = messages.getLoggedAsMessage();

		assertThat(loggedAsMessage, equalTo("Zalogowany jako jankowal"));
	}
}

@SpringBootTest
@ActiveProfiles(profiles = "en")/*
Utworzyc profile dla konfiguracji (application-en.properties ew. yml)
* */

class DemoApplicationEngTests {

	@Autowired
	DialogService dialog;

	@Test
	void contextLoads() {

		LoginMessages messages = dialog.getLoginMessages();

		String welcome = messages.welcome();
		assertThat(welcome, equalTo("Welcome"));
		String provideUsername = messages.getUsernameMessage();

		assertThat(provideUsername, equalTo("provide username:"));
		messages.setUsername("admin");
		String loggedAsMessage = messages.getLoggedAsMessage();
		assertThat(loggedAsMessage, equalTo("Logged as admin"));

		messages.setUsername("jankowal");

		loggedAsMessage = messages.getLoggedAsMessage();

		assertThat(loggedAsMessage, equalTo("Logged as jankowal"));
	}
}