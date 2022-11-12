package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Generator {
    public final static int START_RANGE = 1;
    public final static int END_RANGE = 45;
    public static final int NUMBER_COUNT = 6;

    public Lotto generateLotto() {
        List<Integer> numbers = generateNumbers();
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, NUMBER_COUNT);
        return numbers;
    }
}
