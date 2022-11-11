package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {

    public static final int START = 1;
    public static final int END = 45;
    public static final int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        NumbersValidator.validateLotto(numbers);
        this.numbers = numbers;
    }

    public static Lotto generate(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(START, END, SIZE));
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
