package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER, Constant.SIZE);
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        //sort(generated)
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constant.SIZE) {
            throw new IllegalArgumentException();
        }
        // 숫자인지
        // 1~45
        // 중복
        // validate 분리?
    }

}
