package lotto;

public enum Message {
    
    WELCOME_MESSAGE("구입 금액을 입력해 주세요."),
    COUNT_MESSAGE("개를 구매했습니다."),
    INPUT_WINNING_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_MESSAGE("보너스 번호를 입력해주세요."),
    WINNING_STATIC_MESSAGE("당첨통계\n---"),
    WINNING_INPUT_MESSAGE("정확히 숫자를 입력하고 `,`로 구분 지을 수 있습니다."),
    BONUS_INPUT_MESSAGE("보너스 번호는 숫자만 입력할 수 있습니다."),
    NOT_MOD_ZERO_MESSAGE("[ERROR] 1000으로 나누어지는 금액이 아닙니다."),
    REJECT_ZERO("[ERROR] 구입 금액에 0을 입력할 수 없습니다."),
    REJECT_NOT_NUMBERS("[ERROR] 구입 금액에 숫자를 제외한 다른 입력이 올 수 없습니다."),
    RANGE_EXCEED_MESSAGE("[ERROR] 숫자는 1 ~ 45로 입력할 수 있습니다."),
    LENGTH_MESSAGE("[ERROR] 6개의 숫자를 입력해야 합니다."),
    OVERLAP_MESSAGE("[ERROR] 중복되는 숫자가 존재합니다."),
    OVERLAP_BONUS_NUMBER_MESSAGE("[ERROR] 보너스 숫자가 당첨번호에 존재합니다.");

    private final String value;
    Message(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
