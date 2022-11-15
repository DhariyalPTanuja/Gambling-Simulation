
public class GamblingSimulation {
	public int oneDayGamestake = 100;
	public int perGameBet = 1;

	public static void main(String[] args) {
		System.out.println("This is  the Gambling Simulator!!!");
		System.out.println("Gambler start with a stake 100");

		GamblingSimulation gambling = new GamblingSimulation();

		gambling.checkTotalAmount();
	}

	public int randomCheckGame() {

		return (int) (Math.random() * 2);
	}
	
	
	public void checkTotalAmount() {

		int day = 30;
		int totalAmount = 0;
		for (int i = 1; i <= day; i++) {
			int winStake = 0;
			int looseStake = 0;
			int cash = 0;
			int gameNumber = 0;
			System.out.println("Start the Day " + i + " Game");
			while (winStake < oneDayGamestake * 50 / 100 && looseStake < oneDayGamestake * 50 / 100) {
				int isGameWinOrLoose = randomCheckGame();
				switch (isGameWinOrLoose) {
				case 0:
//					System.out.println("Gambler loose the game");
					gameNumber++;
					looseStake = looseStake + perGameBet;

					cash = oneDayGamestake - perGameBet;
					break;
				case 1:
//					System.out.println("Gambler win the game");
					gameNumber++;
					winStake = winStake + perGameBet;

					cash = oneDayGamestake + perGameBet;
					break;

				}
				
				totalAmount = totalAmount + cash;
			}
			System.out.println("Total Game play in One Day : " + gameNumber);
			System.out.println("Number of game Gambler Loose: " + looseStake);
			System.out.println("Number of game Gambler Win : " + winStake);
			
			System.out.println("Case collection of Game Day " + i + ": " + cash);
			System.out.println("----------------------------");
			
			if(cash > oneDayGamestake)
				System.out.println("gambler won by " + (cash - oneDayGamestake) );
			else if(cash < oneDayGamestake)
				System.out.println("gambler loss by " + ( oneDayGamestake - cash) );
			else
				System.out.println("No profit no loss");
		}
		//System.out.println("Total Amount in month: " + totalAmount);
	}

}