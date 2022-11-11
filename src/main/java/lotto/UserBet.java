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

	public void checkAmount() {
		amount = bettingMoney / 1000;
	}

	public int getAmount() {
		return amount;
	}
}