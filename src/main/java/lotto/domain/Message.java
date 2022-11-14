package lotto.domain;

public class Message {
    public static final String DUPLICATE_NUMBER_ERROR = "[ERROR] 로또 번호가 중복됩니다.";
    public static final String NOT_NUMBER_ERROR = "[ERROR] 숫자 외의 것이 입력되었습니다.";
    public static final String NOT_NUMBER_OR_NOT_COMMA_ERROR = "[ERROR] 숫자, 콤마 외의 것이 입력되었습니다.";
    public static final String ALREADY_CONTAINS_BONUS_NUMBER = "[ERROR] 보너스 번호가 이미 로또 번호에 포함됩니다.";
    public static final String RANGE_OF_NUMBER = "[ERROR] 1과45 사이의 숫자가 입력되어야 합니다.";
    public static final String SIZE_IS_NOT_SIX = "[ERROR] 사이즈가 6이 아닙니다.";
    public static final String STRING_IS_DUPLICATE = "[ERROR] 숫자가 중복됩니다.";
    public static final String CANNOT_FIND_RANK = "[ERROR] 해당하는 등수를 찾을 수 없습니다.";
    public static final String IS_RIGHT_MONEY = "[ERROR] 1000원 이상이고 1000원으로 나누어떨어지는 금액이어야 합니다.";

    public static final String BONUS_BALL_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    public static final String RESULT_MESSAGE = "%d개 일치 (%,d원) - %d개";
    public static final String WINNING_NUMBER_INPUT = "당첨 번호를 입력해주세요.";
    public static final String MONEY_INPUT = "구입금액을 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";
}
