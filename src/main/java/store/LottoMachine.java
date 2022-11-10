package store;

import java.util.List;

public class LottoMachine {
    private static final int START_LOTTO_NUMBER_RANGE = 1;
    private static final int END_LOTTO_NUMBER_RANGE = 45;
    private static final int LOTTO_NUMBERS = 6;

    private static LottoMachine lottoMachine;

    private LottoMachine() {
    }

    public static LottoMachine getInstance() {
        if (lottoMachine == null) {
            lottoMachine = new LottoMachine();
        }
        return lottoMachine;
    }

    public List<Integer> extractRandomNumbers() {
        return camp.nextstep.edu.missionutils.Randoms
                .pickUniqueNumbersInRange(START_LOTTO_NUMBER_RANGE, END_LOTTO_NUMBER_RANGE, LOTTO_NUMBERS);
    }
}
