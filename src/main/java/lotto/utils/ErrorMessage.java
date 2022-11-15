package lotto.utils;

public enum ErrorMessage {

    INVALID_MONEY_UNIT("[ERROR] 구입금액은 1,000원 단위로 투입하셔야 합니다."),
    INVALID_WINNING_NUMBERS("[ERROR] 당첨번호는 ','로 구분되는 1~45 사이의 숫자로 6개 입력하셔야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 1~45 사이의 숫자로 하나만 입력 가능합니다."),
    ISSUE_LOTTO_ERROR("[ERROR] 로또 발행 도중 오류가 발생했습니다."),
    DUPLICATED_RANDOM_NUMBER("[ERROR] 랜덤 번호 생성 시 중복된 번호가 생성되었습니다."),
    INVALID_RANGE_RANDOM_NUMBER("[ERROR] 랜덤 번호 생성 시 유효하지 않은 번호가 생성되었습니다."),
    DUPLICATED_WINNING_NUMBERS("[ERROR] 당첨 번호에 중복된 번호가 있습니다."),
    INVALID_MATCH_TYPE_RANK("[ERROR] 로또 순위에 유효하지 않은 타입입니다."),
    CANNOT_CALCULATE_YIELD("[ERROR] 수익률 계산 도중 오류가 발생했습니다."),
    FAILED_CREATE_LOTTO("[ERROR] 로또 발행에 실패 했습니다."),
    WINNINGNUMBER_CONTAINS_BONUSNUMBER("[ERROR] 보너스 번호와 당첨 번호에 중복이 있습니다.");



    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

}
