package lotto.UI;

public enum ErrorMessage {
    INPUT_MULTIPLE_OF_1000("[ERROR] 로또는 1000원 단위로만 구매하실 수 있습니다."),
    INPUT_NUMBER("[ERROR] 올바른 형식의 숫자를 임력해 주세요."),
    INPUT_SIX_NUMBER("[ERROR] 6개의 숫자를 입력해 주세요."),
    INPUT_UNIQUE("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    INPUT_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
