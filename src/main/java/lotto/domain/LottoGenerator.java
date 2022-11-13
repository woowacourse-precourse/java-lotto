package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;

    public List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(START, END, COUNT).stream().sorted().collect(Collectors.toList());
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
