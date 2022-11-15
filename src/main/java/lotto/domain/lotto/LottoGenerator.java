package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class LottoGenerator {

    private LottoGenerator() {}

    public static List<Integer> createRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(Constant.MIN_LOTTO_RANGE, Constant.MAX_LOTTO_RANGE, Constant.LOTTO_SIZE);
    }

    public static List<Lotto> createRandomLottoNumberList(int issueCount) {
        List<Lotto> lotties = new ArrayList<>();
        IntStream.range(0, issueCount)
                .forEach(x -> lotties.add(new Lotto(LottoGenerator.createRandomLottoNumber())));
        return lotties;
    }
}
