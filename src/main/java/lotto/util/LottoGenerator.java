package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.InputConfig;
import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoGenerator {
    private final int START_INCLUSIVE = InputConfig.START_INCLUSIVE;
    private final int END_INCLUSIVE = InputConfig.END_INCLUSIVE;
    private final int LOTTO_NUMBER_COUNT = InputConfig.LOTTO_NUMBER_COUNT;


    public List<Lotto> purchase(long amount) {
        List<Lotto> purchased = LongStream.range(0, amount)
                .mapToObj(i -> getLotto())
                .collect(Collectors.toList());
        return purchased;
    }

    private Lotto getLotto() {
        List<Integer> numbers = generateLottoNumbers();
        return new Lotto(numbers);
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> lottoNum = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_NUMBER_COUNT);
        return lottoNum;
    }

    public Lotto forTest_getLotto() {
        return getLotto();
    }
}
