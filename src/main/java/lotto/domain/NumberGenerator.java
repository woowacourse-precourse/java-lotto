package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    public List<List<Integer>> createRandomNumbers(int lottoTicket) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoTicket; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            lottoNumbers.add(randomNumbers);
        }

        return lottoNumbers;
    }
}