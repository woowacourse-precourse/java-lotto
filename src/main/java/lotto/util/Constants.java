package lotto.util;

public class Constants {
    // 입력요청 메시지 관련 상수
    public static final String PRINT_INPUT_MONEY = "구입금액을 입력해 주세요.";
    public static final String PRINT_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String PRINT_INPUT_WINNING_BONUS = "보너스 번호를 입력해 주세요.";

    // 출력 메시지 관련 상수
    public static final String PRINT_OUTPUT_MONEY = "개를 구매했습니다.";

    // 에러 메시지 관련 상수
    public static final String ERROR = "[ERROR] ";

    public static final String ERROR_MONEY_NUMBER = ERROR + "구입금액은 숫자만 입력 받아야 합니다.";
    public static final String ERROR_MONEY_THOUSAND = ERROR + "구입금액은 1000단위 양수여야 합니다.";
    public static final String ERROR_MONEY_POSITIVE = ERROR + "구입금액은 양수여야 합니다.";

    public static final String ERROR_LOTTO_LENGTH = ERROR + "로또 번호는 6개 입니다.";
    public static final String ERROR_LOTTO_DUPLICATED = ERROR + "로또 번호는 중복되지 않아야 합니다.";
    public static final String ERROR_LOTTO_RANGE = ERROR + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static final String ERROR_WINNING_NUMBER_STRING = ERROR + "당첨 입력 번호에 ','과 숫자 제외는 입력할 수 없습니다.";
    public static final String ERROR_WINNING_NUMBER_COMMA = ERROR + "당첨 입력 번호 문자열 처음과 끝에 ',는 입력할 수 없습니다.";
    public static final String ERROR_WINNING_NUMBER_LENGTH_ZERO = ERROR + "당첨 입력 번호 문자열의 길이는 0이 될 수 없습니다.";
    public static final String ERROR_BONUS_NUMBER_INT = ERROR + "보너스 번호 문자열은 숫자 제외는 입력할 수 없습니다.";
    public static final String ERROR_BONUS_NUMBER_DUPLICATED = ERROR + "보너스 번호는 당첨 입력 번호와 중복되지 않아야 합니다.";
    public static final String ERROR_BONUS_NUMBER_Range = ERROR + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    // 당첨 통계 메시지 관련 상수
    public static final String WINNING_RATE_SCRIPT = "당첨 통계";
    public static final String WINNING_RATE_SCRIPT_BAR = "---";
    public static final String PROFIT_RATE_SCRIPT_FRONT = "총 수익률은 ";
    public static final String PROFIT_RATE_SCRIPT_BACK = "%입니다.";
}
