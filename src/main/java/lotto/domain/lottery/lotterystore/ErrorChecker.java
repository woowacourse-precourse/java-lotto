package lotto.domain.lottery.lotterystore;

public class ErrorChecker {
	public boolean isValidMoneyFromBuyer(String money) {
		if (isNotNumber(money) || isNotPositiveNumber(money) || isNotZeroRemainder(money)) {
			throw new IllegalArgumentException("[ERROR] 지불하실 금액을 1000원 단위로 입력해주세요!\n");
		}
		return true;
	}

	private boolean isNotNumber(String money) {
		// 숫자가 아닌 경우 참값 반환
		try {
			Integer.parseInt(money);
		} catch (IllegalArgumentException e) {
			return true;
		}
		return false;
	}

	private boolean isNotPositiveNumber(String money) {
		// 양수가 아닌 0이나 음수일 경우 참값 반환
		return Integer.parseInt(money) <= 0;
	}

	private boolean isNotZeroRemainder(String money) {
		// 천원 단위로 입력이 안되었다면 참값 반환
		return (Integer.parseInt(money) % 1000) != 0;
	}
}
