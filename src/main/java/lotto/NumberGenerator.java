package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static constants.Constant.*;

public class NumberGenerator {
    public int numberOfLotto;
    List<List<Integer>> myLotto = new ArrayList<>();


    NumberGenerator(int numberOfLotto) {
        this.numberOfLotto = numberOfLotto;
    }

    public void generateNumbers() {
        for (int i = 0; i < this.numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);

            this.myLotto.add(numbers);
        }

    }
}