package store;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final String UNIT_ERROR = "[ERROR] 올바른 단위가 아닙니다.";
    private static final int START_LOTTO_NUMBER_RANGE = 1;
    private static final int END_LOTTO_NUMBER_RANGE = 45;
    private static final int LOTTO_NUMBERS = 6;
    private static final int LOTTO_PRICE = 1000;

    private static LottoMachine lottoMachine;

    private LottoMachine() {
    }

    public static LottoMachine getInstance() {
        if (lottoMachine == null) {
            lottoMachine = new LottoMachine();
        }
        return lottoMachine;
    }

    private void validatePayUnit(int pay) {
        if (pay % 1000 != 0) {
            throw new IllegalArgumentException(UNIT_ERROR);
        }
    }

    private List<Integer> extractRandomNumbers() {
        return camp.nextstep.edu.missionutils.Randoms
                .pickUniqueNumbersInRange(START_LOTTO_NUMBER_RANGE, END_LOTTO_NUMBER_RANGE, LOTTO_NUMBERS);
    }

    private Lotto convertLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void putLotteries(List<Lotto> lotteries, Lotto lotto) {
        lotteries.add(lotto);
    }

    public List<Lotto> pickLotteries(int pay) {
        validatePayUnit(pay);
        int startIndex = 0;
        List<Lotto> lotteries = new ArrayList<>();

        while (startIndex < pay / LOTTO_PRICE) {
            putLotteries(lotteries, convertLotto(extractRandomNumbers()));
            startIndex++;
        }
        return lotteries;
    }

}
