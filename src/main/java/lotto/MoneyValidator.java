package lotto;

public class MoneyValidator {

	public static void isOverThousand(int money) {
		if(money < 1000){
			throw new IllegalArgumentException("로또 구입 금액은 1000원 이상이어야 합니다.");
		}
	}

	public static void isDivideByThousand(int money) {
		if(money % 1000 != 0){
			throw new IllegalArgumentException("로또 구입 금액은 1000 단위여야 합니다.");
		}
	}
}