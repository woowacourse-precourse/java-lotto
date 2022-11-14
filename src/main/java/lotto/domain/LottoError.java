package lotto.domain;

public class LottoError {
	public static final String LOTTO_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
	public static final String LOTTO_DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호끼리는 중복 될 수 없습니다.";
	public static final String LOTTO_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호의 범위는 1부터 45까지 입니다.";
	public static final int LOTTO_SIZE = 6;
	public static final int LOTTO_START_RANGE = 1;
	public static final int LOTTO_END_RANGE = 45;
}
