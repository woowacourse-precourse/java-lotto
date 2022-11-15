package lotto.lotto.randomNumber;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumber {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public static List<Integer> createNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_SIZE);
        return numbers;
    }
}
