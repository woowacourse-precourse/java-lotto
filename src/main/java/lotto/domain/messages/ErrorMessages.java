package lotto.domain.messages;

public class ErrorMessages {
    public static final String SIZE_ERROR_MESSAGE = "로또 번호는 6개 입니다";
    public static final String DUPLICATE_ERROR_MESSAGE = "로또 번호는 서로 중복될 수 없습니다";
    public static final String RANGE_ERROR_MESSAGE = "로또 번호는 1~45사이의 수로 구성되어야 합니다";
    public static final String DUPLICATE_BONUS_ERROR_MESSAGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다";
    public static final String EXPENSES_RANGE_ERROR_MESSAGE = "금액은 1000이상의 1000의 배수여야 합니다";
    public static final String WINNIG_NUMBERS_INPUT_FORMAT_ERROR_MESSAGE = "당첨 번호는 ,를 구분자로 숫자인 문자를 입력해야 합니다";
    public static final String EXPENSES_INPUT_FORMAT_ERROR_MESSAGE = "지출 금액은 2,147,483,647이하의 숫자인 문자여야 합니다";
    public static final String BONUS_INPUT_FORMAT_ERROR_MESSAGE = "보너스 번호는 숫자인 문자를 입력해야 합니다";

}
