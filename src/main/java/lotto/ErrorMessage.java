package lotto;

public abstract class ErrorMessage {
    public static final String PREFIX = "[ERROR] ";
    public static final String NOT_INTEGER = "정수를 입력해 주세요.";
    public static final String NEGATIVE = "양수를 입력해 주세요.";
    public static final String NOT_DIVIDABLE_WITH_THOUSAND = "1000으로 나누어 떨어지는 수를 입력해 주세요.";
    public static final String INVALID_LOTTO_SIZE = "로또를 발행하기 위해서는 6개의 숫자가 필요합니다.";
    public static final String DUPLICATED_NUMBER = "로또에 중복되는 숫자가 있습니다.";
    public static final String INVALID_LOTTO_NUMBER = "로또 숫자는 1~45까지의 수여야 합니다.";
    public static final String INVALID_PRIZE_NUMBER_FORMAT = "당첨 번호 형식에 맞게 입력해 주세요. 1~45사이 숫자와 ,로만 이루어져야 합니다.";
    public static final String DUPLICATED_BONUS_NUMBER = "당첨 번호에 이미 보너스 번호가 들어 있습니다. 당첨 번호에 없는 보너스 번호를 입력해 주세요.";
}
