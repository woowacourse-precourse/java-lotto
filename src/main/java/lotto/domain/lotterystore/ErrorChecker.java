package lotto.domain.lotterystore;

public class ErrorChecker {
	public void validateMoneyFromBuyer(String money) {
		if (isNotNumber(money) || isNotPositiveNumber(money) || isNotZeroRemainder(money)) {
			throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력해주세요!\n");
		}
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
