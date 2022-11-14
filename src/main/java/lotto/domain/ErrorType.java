package lotto.domain;

public enum ErrorType {
    ERROR_INPUT_PAYMENT("[ERROR] 로또 구매 금액 입력 에러: 로또 구매 금액은 1,000원 단위로 입력합니다. (화폐 단위 생략)"),
    ERROR_INPUT_WINNING_LOTTO_NUMBERS("[ERROR] 당첨 번호 입력 에러: 당첨 번호는 쉼표(,)를 기준으로 구분한 1~45 범위의 중복되지 않은 6개의 수입니다."),
    ERROR_INPUT_BONUS_NUMBER("[ERROR] 보너스 번호 입력 에러: 보너스 번호의 숫자 범위는 1~45 입니다.");

    private final String errorMessage;

    ErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
