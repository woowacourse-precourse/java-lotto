package lotto.domain;

import java.util.List;

public class Clerk {
    private static final String NOT_POSITIVE_NUM_ERROR_MESSAGE = "[ERROR] 양수를 입력해야 합니다.";
    private static final String WRONG_AMOUNT_ERROR_MESSAGE = "[ERROR] 1000원 단위로 입력해야 합니다.";
    private static final int UNIT_OF_AMOUNT = 1000;
    private static final int ZERO = 0;

    public static List<Lotto> issueLottos(int money) {
        int numberOfLottos = calculateNumberOfLottos(money);
        return LottoGenerator.generateLottos(numberOfLottos);
    }

    public static int calculateNumberOfLottos(int money) {
        validate(money);
        return money / UNIT_OF_AMOUNT;
    }

    private static void validate(int money) {
        if (money <= ZERO) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUM_ERROR_MESSAGE);
        }

        if (money % UNIT_OF_AMOUNT != ZERO) {
            throw new IllegalArgumentException(WRONG_AMOUNT_ERROR_MESSAGE);
        }
    }
}
