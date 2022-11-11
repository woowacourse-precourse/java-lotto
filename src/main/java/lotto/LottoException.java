package lotto;

public enum LottoException {
    SIZE_EXCEPTION("[ERROR] 로또 번호는 총 6개 입니다."),
    DUPLICATE_EXCEPTION("[ERROR] 로또 번호는 중복되면 안됩니다.");

    private final String message;

    LottoException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}