package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.ConstValue.LottoConst;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto createRandomLotto() {
        final List<Integer> lottoNumber =
                Randoms.pickUniqueNumbersInRange(LottoConst.START_NUMBER, LottoConst.END_NUMBER, LottoConst.LOTTO_LENGTH);
        List<Integer> sortedLottoNumber = new ArrayList<>(lottoNumber);
        sortedLottoNumber.sort(Integer::compareTo);
        return new Lotto(sortedLottoNumber);
    }

}
