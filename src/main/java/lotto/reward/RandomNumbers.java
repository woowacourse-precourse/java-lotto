package lotto.reward;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomNumbers {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT = 6;
    private static List<Numbers> lottoNumbers = new ArrayList<>();

    static {
        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            lottoNumbers.add(Numbers.of(i));
        }
    }
    public List<Numbers> getLottoNumbers() {
        Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(START_NUMBER,COUNT);
    }
}
