package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumbersIssuance {
    private final List<Integer> numbers;

    public LottoNumbersIssuance() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
}
