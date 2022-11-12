package lotto.domain.errorenum;

public enum Error {
    HEAD("[ERROR] "),
    NOT_6_LENGTH("로또 번호는 총 6개여야 합니다."),
    DUPLICATE_FOUND("로또 번호는 서로 다른 숫자여야 합니다."),
    NOT_IN_RANGE("로또 번호는 1~45 사이의 숫자여야 합니다."),
    NOT_NUMBER_INCLUDED("숫자만 입력 가능합니다."),
    WRONG_DELIMITER("구분자는 쉼표(,) 여야 합니다.");

    private final String code;

    Error(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
