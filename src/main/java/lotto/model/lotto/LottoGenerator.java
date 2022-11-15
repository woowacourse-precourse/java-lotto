package lotto.model.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoWinNumber;

import java.util.List;

public class LottoGenerator {

    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private static final int LOTTO_AMOUNT_OF_NUMBER_ENTRY = 6;
    private static final int LOTTO_AMOUNT_OF_NUMBER_WIN = 7;
    private static final int SUBLIST_START_INDEX = 0;


    public static Lotto generate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_START,
                LOTTO_NUMBER_END,
                LOTTO_AMOUNT_OF_NUMBER_ENTRY)
        );
    }

    public static LottoWinNumber autoGenerateWinNumber() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_AMOUNT_OF_NUMBER_WIN);
        Lotto winNumbers = new Lotto(integers.subList(SUBLIST_START_INDEX, LOTTO_AMOUNT_OF_NUMBER_ENTRY));
        Integer bonusNumber = integers.get(LOTTO_AMOUNT_OF_NUMBER_ENTRY);

        return new LottoWinNumber(winNumbers, bonusNumber);
    }
}
