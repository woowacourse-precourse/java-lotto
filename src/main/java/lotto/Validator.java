package lotto;

public class Validator {

    public static final String INVALID_COST_ERROR_MESSAGE = "[ERROR] 1000원 단위로 입력해야합니다.";

    public static void validateForDividedBy1000(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_COST_ERROR_MESSAGE);
        }
    }
}
