package lotto.util;

public final class ErrorConst {
	public static final String PREFIX_ERROR = "[ERROR] ";
	public static final String NOT_NUMBER_ERROR = PREFIX_ERROR + "숫자를 입력하세요";
	public static final String NOT_DIVIDED_BY_THOUSAND = PREFIX_ERROR + "1000 으로 나눠 지지 않습니다";
	public static final String DUPLICATED_ERROR = PREFIX_ERROR + "중복된 숫자가 있습니다";
	public static final String OUT_OF_LOTTO_RANGE_ERROR = PREFIX_ERROR + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
	public static final String OUT_OF_BONUS_RANGE_ERROR = PREFIX_ERROR + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
	public static final String NUMBERS_SIZE_ERROR = PREFIX_ERROR + "사이즈가 6인 숫자를 입력하세요";
}
