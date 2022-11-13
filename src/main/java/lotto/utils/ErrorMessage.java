package lotto.utils;

public enum ErrorMessage {

    INVALID_MONEY_UNIT("[ERROR] 구입금액은 1,000원 단위로 투입하셔야 합니다."),
    INVALID_WINNING_NUMBERS("[ERROR] 당첨번호는 ','로 구분되는 1~45 사이의 숫자로 6개 입력하셔야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 1~45 사이의 숫자로 하나만 입력 가능합니다."),
    ISSUE_LOTTO_ERROR("[ERROR] 로또 발행 도중 오류가 발생했습니다.");

    ErrorMessage(String message) {
    }

}
