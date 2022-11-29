package player;

public class CoinErrorCheck {
	public static void CEC(int Coin) {
		if(Coin%1000!=0) {
			System.out.println("[Error] 투입 금액은 1000의 배수여야 합니다");
			throw new IllegalArgumentException();
		}
	}
}
