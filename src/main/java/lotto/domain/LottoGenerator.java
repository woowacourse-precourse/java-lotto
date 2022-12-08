package lotto.domain;

import static lotto.constant.LottoNumberConstant.COUNT;
import static lotto.constant.LottoNumberConstant.END;
import static lotto.constant.LottoNumberConstant.START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
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
