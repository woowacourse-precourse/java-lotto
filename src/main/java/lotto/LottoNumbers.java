package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    public LottoNumbers() {
    }

    public List<Integer> start() {
        return generateLottoNumbers();
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers;
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
