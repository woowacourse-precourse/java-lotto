package lotto;

public interface ExceptionMessage {

    static final String ERRORMESSAGE_PREFIX = "[ERROR] ";
    static final String PURCHASE_ERROR =ERRORMESSAGE_PREFIX + "구입 금액은 1,000원 단위 입니다.";
    static final String PURCHASE_INPUT_ERROR =ERRORMESSAGE_PREFIX + "입력은 정수입니다.";
    static final String INPUT_NUMBER_BOUND_ERROR = ERRORMESSAGE_PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    static final String INPUT_NUMBER_ERROR = ERRORMESSAGE_PREFIX + "로또 번호는 6개 입니다.";
    static final String INPUT_NUMBER_REPETITION_ERROR = ERRORMESSAGE_PREFIX + "로또 번호는 중복될수 없습니다.";




}
