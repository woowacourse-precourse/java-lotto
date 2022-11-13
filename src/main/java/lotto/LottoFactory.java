package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class LottoFactory {
    public Lottos create(int count) {
        Lottos lottos = new Lottos();
        IntStream.range(0, count)
                .forEach((i) -> lottos.add(createOne()));

        return lottos;
    }

    private Lotto createOne() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LottoSetting.MIN_NUMBER.getValue(),
                LottoSetting.MAX_NUMBER.getValue(),
                LottoSetting.COUNT.getValue());

        return new Lotto(lottoNumbers);
    }
}
