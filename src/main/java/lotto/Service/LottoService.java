package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.Model.ValidNumbers;

import java.util.List;

public class LottoService {

    private static final int MIN_LOTTO_RANGE = ValidNumbers.MIN_LOTTO_RANGE.getValue();
    private static final int MAX_LOTTO_RANGE = ValidNumbers.MAX_LOTTO_RANGE.getValue();
    private static final int MAX_LOTTO_SIZE = ValidNumbers.MAX_LOTTO_SIZE.getValue();

    public Lotto createRandomLotto() {
        List<Integer> numbers;
        numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_RANGE, MAX_LOTTO_RANGE, MAX_LOTTO_SIZE);

        Lotto lotto = new Lotto(numbers);

        return lotto;
    }


}
