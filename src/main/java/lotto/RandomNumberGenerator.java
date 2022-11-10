package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
public class RandomNumberGenerator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;


    public List<Integer> generator() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
    }
}
