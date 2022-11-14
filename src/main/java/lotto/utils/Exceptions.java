package lotto.utils;

public enum Exceptions {
    NOT_NATURAL_NUMBER("입력은 자연수여야 합니다."),
    NOT_UNIT_OF_1000_WON("로또는 1000원 단위로 구매할 수 있습니다."),
    EXIST_DUPLICATE_NUMBER("중복된 번호가 포함되어 있습니다."),
    NOT_SIX_NUMBERS("로또 번호는 6개여야 합니다."),
    NOT_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    CAN_NOT_SPLIT("6개의 번호는 공백 없는 콤마로 구분되어야 합니다.");

    private final String description;

    Exceptions(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "[ERROR] " + description;
    }
}