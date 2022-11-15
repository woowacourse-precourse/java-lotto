package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {

    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private static final int LOTTO_AMOUNT_OF_NUMBER_ENTRY = 6;
    private static final int LOTTO_AMOUNT_OF_NUMBER_WIN = 7;

    public static Lotto generate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_START,
                LOTTO_NUMBER_END,
                LOTTO_AMOUNT_OF_NUMBER_ENTRY)
        );
    }

    public static LottoWinNumber generateWinNumber() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_AMOUNT_OF_NUMBER_WIN);
        Lotto winNumbers = new Lotto(integers.subList(0, LOTTO_AMOUNT_OF_NUMBER_ENTRY));
        Integer bonusNumber = integers.get(LOTTO_AMOUNT_OF_NUMBER_ENTRY);

        return new LottoWinNumber(winNumbers, bonusNumber);
    }
}
