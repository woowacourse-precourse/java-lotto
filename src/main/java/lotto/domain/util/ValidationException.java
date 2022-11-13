package lotto.domain.util;

public class ValidationException extends IllegalArgumentException{
	public static final String EMPTY = "입력하지 않으셨습니다.";

	public static final String AMOUNT_NOT_A_NUMBER = "구입금액은 숫자만 입력이 가능합니다.";
	public static final String AMOUNT_LESS_THAN_1000 = "구입금액은 1000원 이상부터 가능합니다.";
	public static final String AMOUNT_NOT_ASSIGNED_CURRENCY_UNIT = String.format("구입금액은 %d원 단위로 입력이 가능합니다.", Rule.LOTTO_PRICE.getValue());

	public static final String WINNING_NUMBER_NOT_CORRECTLY_FORMATTED = "당첨 번호는 1,2,3,4,5,6 형식으로 입력해야 합니다.";
	public static final String WINNING_NUMBER_NOT_CORRECTLY_COUNTED = "당첨 번호는 6개의 숫자를 입력해야 합니다.";
	public static final String WINNING_NUMBER_NOT_IN_BETWEEN_1_45 = "당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
	public static final String WINNING_NUMBER_DUPLICATED = "당첨 번호는 중복이 없어야 합니다.";

	public static final String BONUS_NUMBER_NOT_IN_BETWEEN_1_45 = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
	public static final String BONUS_NUMBER_NOT_CORRECTLY_COUNTED = "보너스 번호는 1개의 숫자를 입력해야 합니다.";
	public static final String BONUS_NUMBER_DUPLICATED = "보너스 번호는 로또 번호와 중복이 없어야 합니다.";

	public static final String LOTTO_NUMBER_NOT_CORRECTLY_COUNTED = "로또 번호의 자릿수가 6자리가 아닙니다.";
	public static final String LOTTO_NUMBER_DUPLICATED = "로또 번호에서 중복이 발생하였습니다.";

	public ValidationException(String message){
		super(message);
	}
}
