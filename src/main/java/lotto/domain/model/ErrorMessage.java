package lotto.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum ErrorMessage {

    COMMON_MESSAGE("[ERROR] "),
    INPUT_NULL("입력을 하지 않았습니다."),

    LOTTE_SIZE_INVALID("로또 번호 개수가 유효하지 않습니다 (유효한 숫자 개수 : 6) | 입력 개수 : "),
    LOTTE_NUMBER_DUPLICATION("중복된 번호를 입력하셨습니다 | 중복 번호 : "),
    PURCHASE_PAY_CONSISTENCE("숫자 이외의 값을 입력하셨습니다. | 입력 : "),
    PURCHASE_PAY_REMINDER("1000원 단위로 구매하실 수 있습니다. | 입력 : "),
    NOT_DIVIDE_COMMAS("\",\" 를 사용하여 올바른 입력을 해 주세요"),
    BONUS_NUMBER_OUT_BOUND("유효범위에서 벗어난 숫자를 입력하셨습니다 (유효범위 : 1 ~ 45) | 입력 : "),
    BONUS_NUMBER_DUPLICATION("당첨번호에 속한 보너스 번호를 입력하였습니다 | 당첨 번호: "),
    BONUS_NUMBER_INVALID("올바른 로또 번호를 입력 해 주세요 | 입력 : "),
    INVALID_MATCH_COUNT("도출 퇼 수 없는 결과입니다 | MATCH COUNT : ");


    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getErrorMessage(final ErrorMessage errorMessage) {
        return COMMON_MESSAGE.getMessage() + errorMessage.getMessage();
    }
    public static String getErrorMessage(final ErrorMessage errorMessage, final Set<Integer> errorNumbers) {
        List<Integer> errorNumber = new ArrayList<>(errorNumbers);
        Collections.sort(errorNumber);
        return COMMON_MESSAGE.getMessage() + errorMessage.getMessage()
                + errorNumber.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    public static void printErrorMessage(final Exception e) {
        System.out.println(e.getMessage());
    }
}
