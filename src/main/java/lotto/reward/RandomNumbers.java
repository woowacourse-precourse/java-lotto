package lotto.reward;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomNumbers implements Comparable<RandomNumbers> {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT = 6;
    private static final List<Lotto> lottoNumbers = new ArrayList<>();

    public Lotto createRandomNumbers() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT));
        lottoNumbers.add(lotto);
        return lotto;
    }

    public List<Lotto> getLottoNumbers(){
        return lottoNumbers;
    }

    @Override
    public int compareTo(RandomNumbers o) {
        return 0;
    }
}
