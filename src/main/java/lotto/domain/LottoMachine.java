package lotto.domain;

import java.util.ArrayList;
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
        List<Integer> result = List.of(0, 0, 0, 0, 0);
        calRank(result, lottos, numbers, bonus);
        return result;
    }

    private void calRank (List<Integer> result, List<Lotto> lottos, List<Integer> numbers, int bonus) {
        for (Lotto lotto : lottos) {
            int matchBonus = lotto.getNumbers().contains(bonus) ? 1 : 0;
            lotto.getNumbers().retainAll(numbers);
            Rank rank = Rank.findRank(lotto.getNumbers().size(), matchBonus);
            result.set(rank.getIndex(), result.get(rank.getIndex() + 1));
        }
    }

    private List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.lottoMinNumber, Lotto.lottoMaxNumber, Lotto.lottoLength);
    }
}
