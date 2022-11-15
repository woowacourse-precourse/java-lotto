package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerator {
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_LENGTH = 6;

    public List<List<Integer>> createRandomNumbers(Integer lottoTickets) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int count = 0; count < lottoTickets; count++) {
            lottoNumbers.add(createLottoNumber());
        }
        return lottoNumbers;
    }

    private List<Integer> createLottoNumber() {
        List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER,
                        END_LOTTO_NUMBER, LOTTO_NUMBERS_LENGTH));
        lotto.sort(Integer::compareTo);
        return lotto;
    }
}
