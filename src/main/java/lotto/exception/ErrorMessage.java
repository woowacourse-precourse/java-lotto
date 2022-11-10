package lotto.exception;

import lotto.domain.LottoMachine;
import lotto.domain.Money;

public enum ErrorMessage {

	NOT_NUMBER_ERROR("[ERROR] 숫자를 입력 해주세요"),
	ZERO_MONEY_ERROR("[ERROR] 로또 구입 금액은 0원을 초과 해야 합니다"),
	NOT_DIVISIBLE_MONEY_ERROR("[ERROR] 로또 구입 금액은 " + LottoMachine.LOTTO_COST + "원 으로 나누어 떨어져야 합니다");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
