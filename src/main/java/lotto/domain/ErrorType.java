package lotto.domain;

public enum ErrorType {
    ERROR_INPUT_PAYMENT("[ERROR] 로또 구매 금액 입력 에러: 로또 구매 금액은 1,000원 단위로 입력합니다. (화폐 단위 생략)"),
    ERROR_INPUT_WINNING_LOTTO_NUMBERS("[ERROR] 당첨 번호 입력 에러: 당첨 번호는 쉼표(,)를 기준으로 구분한 1~45 범위의 중복되지 않은 6개의 수입니다."),
    ERROR_INPUT_BONUS_NUMBER("[ERROR] 보너스 번호 입력 에러: 보너스 번호의 숫자 범위는 1~45 입니다."),
    ERROR_UNDER_LOTTO_PRICE("[ERROR] 로또 1매 판매 금액은 1,000원 입니다. 1,000원 단위로 구매 금액을 입력해주세요."),
    ERROR_LOTTO_SIZE("[ERROR] 로또 번호 리스트는 총 6개의 숫자를 포함하고 있습니다."),
    ERROR_LOTTO_NUMBER_RANGE("[ERROR] 로또 각 번호의 숫자 범위는 1~45입니다."),
    ERROR_LOTTO_HAS_DUPLICATE("[ERROR] 로또의 각 숫자는 서로 중복되지 않아야 합니다."),
    ERROR_WINNING_LOTTO_CONTAIN_BONUS("[ERROR] 로또 당첨 번호 리스트가 보너스 번호를 포함하고 있습니다. 보너스 번호는 로또 당첨 번호와 중복되지 않게 선택해주세요.");

    private final String errorMessage;

    ErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
