package lotto.constants;

public class Message {
	private Message() {}

	public static final String ERROR_PREFIX = "[ERROR] ";

	public static final String ERROR_HAS_DUPLICATED_LOTTO_NUMBER = ERROR_PREFIX + "중복된 로또 번호 입니다.";
	public static final String ERROR_INVALID_LOTTO_LENGTH = ERROR_PREFIX + "유효하지 않는 로또번호 개수 입니다.";
	public static final String ERROR_HAS_INVALID_LOTTO_NUMBER_VALUE = ERROR_PREFIX + "로또 번호는 1~45 사이어야 합니다.";
}
