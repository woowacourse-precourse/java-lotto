package lotto.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoPublisher {

    private static final int LOTTO_RANDOM_RANGE_START = 1;
    private static final int LOTTO_RANDOM_RANGE_END = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    public List<Integer> makeRandomLottoNumber() {
        List<Integer> randomLottoNumberList = Randoms.pickUniqueNumbersInRange(LOTTO_RANDOM_RANGE_START, LOTTO_RANDOM_RANGE_END, LOTTO_NUMBER_SIZE);
        randomLottoNumberList = sortRandomLottoNumber(randomLottoNumberList);

        return randomLottoNumberList;
    }

    public List<Integer> sortRandomLottoNumber(List<Integer> randomLottoNumberList) {
        Collections.sort(randomLottoNumberList);

        return randomLottoNumberList;
    }
}
