package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public List<List<Integer>> createRandomNumbers(Integer lottoTickets) {
        List<List<Integer>> lotto = new ArrayList<>();
        for (int count = 0; count < lottoTickets; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Integer::compareTo);
            lotto.add(numbers);
            System.out.println(numbers);
        }
        return lotto;
    }
}
