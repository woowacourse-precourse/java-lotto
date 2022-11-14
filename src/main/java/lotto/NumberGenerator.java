package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public int numberOfLotto;
    List<List<Integer>> myLotto = new ArrayList<>();


    NumberGenerator(int numberOfLotto) {
        this.numberOfLotto = numberOfLotto;
    }

    public void generateNumbers() {
        for (int i = 0; i < this.numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            Lotto lotto = new Lotto(numbers);
            this.myLotto.add(lotto.getNumbers());
        }

    }
}