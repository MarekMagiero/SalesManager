package com.magierowski.SalesManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalesManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesManagerApplication.class, args);
	}
	
	/**
	 * Co zrobiliśmy:
	 * - apka Springowa (serwer)
	 * - model danych
	 * - logika fakturowania
	 * - zwracanie info o fakturze
	 * - przyjmowanie danych
	 * - wersjonowanie kodu w GIT (GitHub)
	 * 
	 * Do zrobienia:
	 * - zapisywanie danych do bazy MySQL
	 * - obsługa błędów
	 */
}
