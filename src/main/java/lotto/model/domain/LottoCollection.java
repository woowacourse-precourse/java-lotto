package lotto.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCollection {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int START_INDEX = 0;

    private final List<Lotto> lottoCollection;

    public LottoCollection(int numOfLotto) {
        lottoCollection = IntStream.range(START_INDEX, numOfLotto)
                .mapToObj(i -> new Lotto(createLottoNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_SIZE);
    }


}
