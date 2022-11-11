package lotto.exception;

import lotto.domain.LottoMachine;
import lotto.domain.LottoRule;
import lotto.domain.Money;

public enum ErrorMessage {

	NOT_NUMBER_ERROR("[ERROR] 숫자를 입력 해주세요"),
	ZERO_MONEY_ERROR("[ERROR] 로또 구입 금액은 0원을 초과 해야 합니다"),
	NOT_DIVISIBLE_MONEY_ERROR("[ERROR] 로또 구입 금액은 " + LottoRule.LOTTO_COST.getValue() + "원 으로 나누어 떨어져야 합니다"),
	NOT_NUMBERS_ERROR("[ERROR] ,로 구분 지어 숫자만 입력해 주세요"),
	NUMBER_COUNT_ERROR("[ERROR] 숫자 6개를 입력해 주세요"),
	DUPLICATE_NUMBER_ERROR("[ERROR] 서로 다른 숫자를 입력해 주세요"),
	NUMBER_RANGE_ERROR("[ERROR] " + LottoRule.MIN_NUMBER.getValue() + "에서 " + LottoRule.MAX_NUMBER.getValue() +
		"사이의 숫자를 입력해 주세요"),
	DUPLICATE_BONUS_NUMBER_ERROR("[ERROR] 보너스 번호는 당첨 번호와 다른 번호로 입력해 주세요")
	;

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
