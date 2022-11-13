package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private List<Integer> generateNumbers() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lotto;
    }

    public List<Lotto> generate(int money) {
        List<Lotto> lottoList = new ArrayList<Lotto>();
        int count = money / 1000;
        while (count-- > 0) {
            lottoList.add(new Lotto(generateNumbers()));
        }

        return lottoList;
    }
}
