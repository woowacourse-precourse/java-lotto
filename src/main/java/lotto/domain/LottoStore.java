package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public static List<Lotto> saleLotto(int lottoCount) {
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 45;
        final int NUMBER_SIZE = 6;
        List<Lotto> lottoPapers = new ArrayList<Lotto>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_SIZE);
            lottoPapers.add(new Lotto(numbers));
        }
        return lottoPapers;
    }
}
