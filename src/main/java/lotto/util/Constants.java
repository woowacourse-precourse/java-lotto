package lotto.util;

public class Constants {
    // 입력요청 메시지 관련 상수
    public static final String PRINT_INPUT_MONEY = "구입금액을 입력해 주세요.";

    // 출력 메시지 관련 상수
    public static final String PRINT_OUTPUT_MONEY = "개를 구매했습니다.";

    // 에러 메시지 관련 상수
    public static final String ERROR = "[ERROR] ";

    public static final String ERROR_MONEY_NUMBER = ERROR + "구입금액은 숫자만 입력 받아야 합니다.";
    public static final String ERROR_MONEY_THOUSAND = ERROR + "구입금액은 1000단위 양수여야 합니다.";
    public static final String ERROR_MONEY_POSITIVE = ERROR + "구입금액은 양수여야 합니다.";

    public static final String ERROR_LOTTO_LENGTH = ERROR + "발급 로또 번호는 6개 입니다.";
    public static final String ERROR_LOTTO_DUPLICATED = ERROR + "발급 로또 번호는 중복되지 않아야 합니다.";
    public static final String ERROR_LOTTO_RANGE = ERROR + "발급 로또 번호의 범위는 1에서 45까지 입니다.";
}
