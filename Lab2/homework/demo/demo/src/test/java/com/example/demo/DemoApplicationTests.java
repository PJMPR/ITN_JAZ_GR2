package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@ActiveProfiles(profiles = "pl")
class DemoApplicationTests {

	@Autowired
	DialogService dialog;

	@Test
	void contextLoads() {

		LoginMessages messages = dialog.getLoginMessages();

		String welcome = messages.welcome();
		assertThat(welcome, equalTo("Witaj"));
		String provideUsername = messages.getUsernameMessage();

		assertThat(provideUsername, equalTo("podaj nazwe uzytkownika:"));
		messages.setUsername("admin");
		String loggedAsMessage = messages.getLoggedAsMessage();
		assertThat(loggedAsMessage, equalTo("Zalogowany jako admin"));

		messages.setUsername("jankowal");

		loggedAsMessage = messages.getLoggedAsMessage();

		assertThat(loggedAsMessage, equalTo("Zalogowany jako jankowal"));
	}
}

@SpringBootTest
@ActiveProfiles(profiles = "en")
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
