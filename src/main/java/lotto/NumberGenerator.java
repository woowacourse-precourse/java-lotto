package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private final int START_LOTTO_NUMBER = 1;
    private final int END_LOTTO_NUMBER = 45;
    private final int LOTTO_NUMBERS_LENGTH = 6;

    public List<List<Integer>> createRandomNumbers(Integer lottoTickets) {
        List<List<Integer>> lotto = new ArrayList<>();
        for (int count = 0; count < lottoTickets; count++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER,
                    END_LOTTO_NUMBER, LOTTO_NUMBERS_LENGTH));
            numbers.sort(Integer::compareTo);
            lotto.add(numbers);
        }
        return lotto;
    }
}
