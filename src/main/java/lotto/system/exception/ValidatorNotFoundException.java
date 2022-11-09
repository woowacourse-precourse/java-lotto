package lotto.system.exception;

public class ValidatorNotFoundException extends IllegalStateException {

	public static final String VALIDATOR_NOT_FOUND_MESSAGE = "입력된 값에 알맞는 Validator 를 찾지 못했습니다.";

	public ValidatorNotFoundException() {
		super(VALIDATOR_NOT_FOUND_MESSAGE);
	}
}
