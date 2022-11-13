package lotto.message;

public enum ErrorMessage {

    NUMBER_RANGE_MESSAGE("[ERROR] 1에서 45 사이의 숫자를 입력해주세요."),
    DUPLICATE_BONUS_NUMBER_MESSAGE("[ERROR] 보너스 번호는 당첨 번호에 포함되어 있지 않아야 합니다."),
    NOT_CORRECT_NUMBER_MESSAGE("[ERROR] 올바른 숫자 입력이 아니거나, 너무 큰 수입니다."),
    ONE_THOUSAND_UNIT_MONEY_MESSAGE("[ERROR] 1000원 단위만 입력 가능합니다."),
    SIX_NUMBER_MESSAGE("[ERROR] 정확히 6개의 당첨 번호를 입력해주세요.");

    public String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
