
public class GamblingSimulation {
	public int oneDayGamestake = 100;
	public int perGameBet = 1;
	public int gameNumber = 0;

	public static void main(String[] args) {
		System.out.println("This is  the Gambling Simulator!!!");
		System.out.println("Gambler start with a stake 100");

		GamblingSimulation gambling = new GamblingSimulation();
		//gambling.playGame();
	gambling.oneDayGame();
	}

	public void playGame() {
		int winStack = 0;
		int looseStack = 0;
		int isGameWinOrLoose = (int) (Math.random() * 2);

		switch (isGameWinOrLoose) {
		case 0:
			System.out.println("Gambler loose the game");
			gameNumber++;
			looseStack = looseStack + perGameBet;
			System.out.println(looseStack);
			oneDayGamestake = oneDayGamestake - looseStack;
			break;
		case 1:
			System.out.println("Gambler win the game");
			gameNumber++;
			winStack = winStack + perGameBet;
			System.out.println(winStack);
			oneDayGamestake = oneDayGamestake + winStack;
			break;
		}
		System.out.println("Game Stake : " + oneDayGamestake);

	}
	public void oneDayGame() {
		int winStake = 0;
		int looseStake = 0;

		int cash = oneDayGamestake;
		
		while(winStake < oneDayGamestake*50/100 && looseStake < oneDayGamestake*50/100) {
			int isGameWinOrLoose = (int) (Math.random() * 2);
			
			switch (isGameWinOrLoose) {
			case 0:
				System.out.println("Gambler loose the game");
				gameNumber++;
				looseStake = looseStake + perGameBet;
				System.out.println(looseStake);
				cash = oneDayGamestake - looseStake;
				break;
			case 1:
				System.out.println("Gambler win the game");
				gameNumber++;
				winStake = winStake + perGameBet;
				System.out.println(winStake);
				cash = oneDayGamestake + winStake;
				break;
		}
			System.out.println("Game Stack : " + cash);
			System.out.println("Game number : " + gameNumber);
			System.out.println("Loosing game:" +looseStake);
			System.out.println("wining game : " + winStake);
		}
			
		
		
	}
}