package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoMachine {

    private List<Integer> numbers;

    public List<Integer> generateLottoNumbers() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
