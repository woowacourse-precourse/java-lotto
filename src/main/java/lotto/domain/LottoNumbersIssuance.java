package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumbersIssuance {
    private final List<Integer> numbers;

    public LottoNumbersIssuance() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void sortLottoNumbers() {
        this.numbers.sort(Integer::compareTo);
    }

    public void printLotto() {
        System.out.println(numbers);
    }
}
