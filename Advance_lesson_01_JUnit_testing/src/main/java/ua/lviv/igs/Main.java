package ua.lviv.igs;

import java.util.Scanner;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) throws TimeException {

		Supplier<Integer> menu = () -> {

			System.out.println();
			System.out.println("1 -> Добавити кінострічку");
			System.out.println("2 -> Видалити кінострічку");
			System.out.println("3 -> Вивести всі кінострічки на консоль");
			System.out.println("4 -> Добавити сеанс");
			System.out.println("5 -> Видалити сеанс");
			System.out.println("6 -> Вивести всі заплановані сеанси на запланований день");
			System.out.println("7 -> Встановити час відкритя та закриття кінотеатру");
			System.out.println("8 -> Вихід з программи");
			
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int menuChoise = sc.nextInt();

			return menuChoise;
		};

		while (true) {
			switch (menu.get()) {
				
			case 1: {
				Cinema.addMovie();
				break;
			}

			case 2: {
				Cinema.removeMovie();
				break;
			}

			case 3: {
				Cinema.allMovies();
				break;
			}

			case 4: {
				Schedule.addSeance();
				break;
			}

			case 5: {
				break;
			}

			case 6: {
				break;
			}

			case 7: {
				break;
			}

			case 8: {
				System.exit(0);
				break;
			}
			}
		}

	}

}
