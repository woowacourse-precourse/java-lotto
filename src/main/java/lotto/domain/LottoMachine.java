package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
    public List<Lotto> publishLotto(int amount) {
        int count = amount / Lotto.lottoPrice;
        List<Lotto> lottos = new ArrayList<>();

        for (; count > 0; count--) {
            lottos.add(new Lotto(createNumbers()));
        }

        return lottos;
    }

    public List<Integer> getResult(List<Lotto> lottos, List<Integer> numbers, int bonus) {
        List<Integer> result = Arrays.asList(0, 0, 0, 0, 0);
        Calculator.calRank(result, lottos, numbers, bonus);
        return result;
    }

    private List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.lottoMinNumber, Lotto.lottoMaxNumber, Lotto.lottoLength);
    }
}
