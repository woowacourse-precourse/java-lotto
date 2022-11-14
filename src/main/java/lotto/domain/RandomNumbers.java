package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class RandomNumbers {
    private final static int LOTTO_COUNT = 6;

    public List<Integer> generateRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_COUNT);
        List<Integer> sortedLottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toList());
        return sortedLottoNumbers;
    }
}
