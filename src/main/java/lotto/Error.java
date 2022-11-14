package lotto;

public enum Error {
    ERROR_GAME_MONEY_AVAILABLE("[ERROR] 로또 1매 가격은 1000원입니다. 1000원 단위를 맞춰주세요."),
    ERROR_INPUT_PARSING_NUMBER("[ERROR] 해당 입력 값은 숫자형이 아닙니다."),
    ERROR_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45사이 숫자만 입력 가능합니다."),
    ERROR_LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복된 숫자는 입력할 수 없습니다."),
    ERROR_LOTTO_NUMBER_SIZE("[ERROR] 로또 번호는 6자리 입력해야합니다."),
    ERROR_LOTTO_BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 넘버는 당첨번호에 없는 숫자를 입력해주세요.");

    private String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getValue() {
        return this.errorMessage;
    }
}
