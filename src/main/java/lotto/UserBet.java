package lotto;

public class UserBet {
	private int bettingMoney;
	private int amount;

	public UserBet(String userInput){
		bettingMoney = Integer.parseInt(userInput);
	}

	public int getBettingMoney() {
		return bettingMoney;
	}
}