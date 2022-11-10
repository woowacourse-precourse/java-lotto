package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGenerator {
    static final int AVAILABLE_MONEY_UNIT = 1000;

    public static void generate(String payment) {
        validatePayment(Integer.valueOf(payment));
    }

    public static void validatePayment(int amount) {
        if (amount % AVAILABLE_MONEY_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static int countNumberOfLotto(String amount) {
        return 0;
    }

    public static void orderNumbers(Lotto lotto) {

    }
}
