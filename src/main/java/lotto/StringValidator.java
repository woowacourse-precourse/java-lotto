package lotto;

import java.util.List;

public class StringValidator {

	public void validateMoneyString(String string) {
		checkIsNaturalNumber(string);
		checkIsMultipliedBy1000(string);
	}

	public void checkIsNaturalNumber(String string) {
		if (!string.matches("[0-9]+")) {
			throw new IllegalArgumentException("[ERROR] 띄어쓰기 없는 자연수를 입력해야 합니다.");
		}
	}

	public void checkIsMultipliedBy1000(String string) {
		int money = Integer.parseInt(string);
		if (money % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해야 합니다.");
		}
	}

	public void validateCorrectString(String string) {
		checkHasOnlyNumberAndComma(string);
	}

	public void checkHasOnlyNumberAndComma(String string) {
		if (!string.matches("[0-9]+(,[0-9]+)*")) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 숫자로만 구성되어야 합니다.");
		}
	}

	public void validateBonusString(String string, Lotto lotto) {
		checkIsNaturalNumber(string);
		checkIsInValidRange(string);
		checkCorrectLottoContainsBonusNumber(string, lotto);
	}

	private void checkIsInValidRange(String string) {
		int bonus = Integer.parseInt(string);
		if (bonus < 1 || bonus > 45) {
			throw new IllegalArgumentException("[ERROR] 적절한 범위의 보너스 번호를 입력해야 합니다.");
		}
	}

	private void checkCorrectLottoContainsBonusNumber(String string, Lotto lotto) {
		List<Integer> lottoNumbers = lotto.getLotto();
		if (lottoNumbers.contains(Integer.parseInt(string))) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호에 포함되지 않은 보너스 번호를 입력해야 합니다.");
		}
	}
}
