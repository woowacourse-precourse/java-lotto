package enumCollections;

public enum Exceptions {
    CHARACTER_INCLUDED("로또 번호에는 문자가 포함될 수 없습니다."),
    WRONG_MONEY_UNIT("구입금액은 1,000원 단위로만 입력 가능합니다."),
    WRONG_NUMBER_LENGTH("6개의 번호를 입력해야 합니다."),
    OUT_OF_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    HAS_DUPLICATED_NUMBER("중복되는 숫자를 입력할 수 없습니다."),
    HAS_SAME_NUMBER("당첨 번호와 중복되는 숫자를 입력할 수 없습니다.");

    private final String message;

    Exceptions(String message) {
        this.message = "[ERROR] " + message;
    }

    public static String getMessage(Exceptions exception) {
        return exception.message;
    }
}
