package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoNumbersIssuance {
    private List<Integer> numbers;

    public LottoNumbersIssuance() {
        this.numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        sort();
        printLotto();
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    public boolean contain(int winningNumber) {
        for (Integer number : numbers) {
            if (winningNumber == number) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        this.numbers.sort(Comparator.naturalOrder());
    }
}
