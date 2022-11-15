package lotto;

public enum Massages {
    INPUT_MONEY("구매금액을 입력해 주세요."),
    INVALID_MONEY("[ERROR] 올바른 금액을 입력해주세요."),
    UNIT_PRICE("[ERROR] 구입 금액은 1,000원 단위 입니다."),
    PURCHASED_TICKET("개를 구입했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INVALID_NUMBERS_SIZE("[ERROR] 6개의 숫자를 뽑아주세요."),
    DUPLICATED_NUMBERS("[ERROR] 중복되지 않는 숫자를 뽑아주세요."),
    INPUT_BONUS_NUBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---"),
    INVALID_BONUS_NUMBER("[ERROR] 당첨번호와 중복되지 않는 숫자를 뽑아주세요.");
}
