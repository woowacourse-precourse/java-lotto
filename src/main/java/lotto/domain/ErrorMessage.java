package lotto.domain;

public enum ErrorMessage {
    ERROR_LOTTO_SIZE("[ERROR] 로또의 번호 개수가 6개가 아닙니다."),
    ERROR_LOTTO_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_DUPLICATE("[ERROR] 중복된 번호가 있습니다."),
    ERROR_PRICE_THOUSAND_UNITS("[ERROR] 잘못된 금액을 입력하셨습니다. 금액은 1000단위로 입력하셔야 합니다."),
    ERROR_NUMBER_RANGE("[ERROR] 1부터 45 사이의 숫자들을 입력해야 합니다."),
    ERROR_LOTTO_LENGTH("[ERROR] 6개의 당첨번호를 입력해야 합니다."),
    ERROR_BONUS_NUMBER("[ERROR] 1부터 45 사이의 숫자들을 입력해야 합니다."),
    ERROR_SEPARATOR("[ERROR] 당첨 번호는 \",\" 쉼표를 기준으로 입력해야합니다."),
    ERROR_INPUT_PRICE("[ERROR] 당첨 금액은 공백없이 숫자만 입력해야합니다."),
    ERROR_BLANK("[ERROR] 입력한 당첨 번호에 공백이 있습니다. 공백없이 입력해주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
