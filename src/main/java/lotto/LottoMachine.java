package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoMachine {

    public int numberOfLotto;
    List<List<Integer>> myLotto;

    LottoMachine(int numberOfLotto) {
        this.numberOfLotto = numberOfLotto;
    }

    public void generateNumbers() {
        for (int i = 0; i < this.numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            myLotto.add(numbers);
        }
    }
}