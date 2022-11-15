package lotto.view;

public enum ErrorMessage {
    numberType("[ERROR] 올바른 형식의 숫자를 입력해 주세요."),
    numberMultiple("[ERROR] 로또는 1000원 단위로만 구매하실 수 있습니다."),
    lottoIndex("[ERROR] 6개의 숫자를 입력해 주세요."),
    lottoRepeatation("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}