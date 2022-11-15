import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.LookAndFeel;

public class GamblingSimulation {
	public int oneDayGamestake = 100;
	public int perGameBet = 1;

	public static void main(String[] args) {
		System.out.println("This is  the Gambling Simulator!!!");
		System.out.println("Gambler start with a stake 100");

		GamblingSimulation gambling = new GamblingSimulation();

		gambling.calculateWonAndLooDay();
	}

	public int randomCheckGame() {

		return (int) (Math.random() * 2);
	}

	public void calculateWonAndLooDay() {
		int day = 30;
		int totalAmount = 0;
		ArrayList<Integer> winNumberList = new ArrayList<>();
		ArrayList<Integer> loosNumberList = new ArrayList<>();
		char choice;
		Scanner scanObj = new Scanner(System.in);
		do {

			for (int i = 1; i <= day; i++) {
				int winStake = 0;
				int looseStake = 0;
				int cash = 0;
				int gameNumber = 0;
				while (winStake < oneDayGamestake * 50 / 100 && looseStake < oneDayGamestake * 50 / 100) {
					int isGameWinOrLoose = randomCheckGame();
					switch (isGameWinOrLoose) {
					case 0:
						gameNumber++;
						looseStake = looseStake + perGameBet;

						cash = oneDayGamestake - perGameBet;
						break;
					case 1:

						gameNumber++;
						winStake = winStake + perGameBet;

						cash = oneDayGamestake + perGameBet;
						break;

					}

				}
				winNumberList.add(winStake);
				loosNumberList.add(looseStake);
				System.out.println("Total Game play in One Day : " + gameNumber);
				
				System.out.println("Case collection of Game Day " + i + ": " + cash);
				System.out.println("----------------------------");

			}
			System.out.println("number of win :" + winNumberList);
			System.out.println("number of loos: " + loosNumberList);
			System.out.println("Total Amount in month: " + totalAmount);
			

			findLuckiestDay(winNumberList);
			findUnluckiestDay(loosNumberList);

			System.out.println("would you like to continue playing next month ?");
			choice = scanObj.next().charAt(0);
		} while ((choice == 'y') || (choice == 'Y'));

	}

	private void findUnluckiestDay(ArrayList<Integer> loosNumberList) {
		int maximum = loosNumberList.get(0);
		for (Integer x : loosNumberList) {
			if (x > maximum)
				maximum = x;

		}
		System.out.println(
				"Gambler Unluckiest day where he lost maximum is : Day " + (loosNumberList.indexOf(maximum) + 1));

	}

	private void findLuckiestDay(ArrayList<Integer> winNumberList) {
		int maximum = winNumberList.get(0);
		for (int j = 1; j < winNumberList.size(); j++) {
			if (maximum < winNumberList.get(j))
				maximum = winNumberList.get(j);

		}
		System.out
				.println("Gambler luckiest day where he won maximum is : Day " + (winNumberList.indexOf(maximum) + 1));

	}
}