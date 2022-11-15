package lotto.global.message;

public interface ErrorMessage {

    String NEGATIVE_NUMBER = "[ERROR] 양수만 입력해주세요.";
    String NOT_INPUT_NUMBER = "[ERROR] 입력하지 않았습니다.";
    String NOT_IN_THOUSANDS_OF_NUMBER = "[ERROR] 금액이 천원 단위가 아닙니다.";
    String IS_NOT_INTEGER = "[ERROR] 숫자가 아닙니다.";

    String INVALID_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";;
    String DUPLICATE_NUMBER = "[ERROR] 중복되는 숫자가 존재합니다.";
    String INVALID_WINNING_NUMBERS = "[ERROR] 당첨번호가 잘못 입력되었습니다.";
    String INVALID_SIZE = "[ERROR] 로또는 6개의 숫자로 구성되어야 합니다.";
    String INVALID_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 업습니다.";

}
