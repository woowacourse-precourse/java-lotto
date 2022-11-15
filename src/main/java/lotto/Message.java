package lotto;

public enum Message {
    INPUT_MONEY("구입금액을 입력해 주세요."), ERROR_MONEY("[ERROR] 구입 금액은 0부터 2,147,483,647 사이의 숫자여야 합니다."), OUTPUT_LOTTO_NUMBER(
            "개를 구매했습니다."), ERROR_LOTTO_DUPLICATE("[ERROR] 로또 번호는 중복되지 않는 값이여야 합니다."), ERROR_LOTTO_NUMBERS_SIZE(
            "[ERROR] 로또 번호는 6개 선택해야 합니다."), INPUT_LOTTO_WIN("당첨 번호를 입력해 주세요."), ERROR_LOTTO_INPUT(
            "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."), ERROR_WIN_LOTTO_NUMBERS_SIZE(
            "[ERROR] 당첨 번호는 6개를 입력해야 합니다."), INPUT_BONUS("보너스 번호를 입력해 주세요."), ERROR_BONUS(
            "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."), ERROR_BONUS_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 값이여야 합니다."),
    ;

    final String message;

    Message(String message) {
        this.message = message;
    }
}
