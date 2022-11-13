package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    public List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().collect(Collectors.toList());
    }

    public LottoList createLotto(Money money) {
        List<Lotto> lottoList = new ArrayList<>();
        int lottoCount = money.lottoCount();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto(generateNumber()));
        }

        return new LottoList(lottoList);
    }
}
