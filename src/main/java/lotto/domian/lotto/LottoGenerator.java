package lotto.domian.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    List<Lotto> lottos = new ArrayList<>();
    List<List<Integer>> lottosNumber = new ArrayList<>();

    public List<List<Integer>> generateLotto(int count) {
        getNewLottes(count);
        validateLottos(count, lottos);
        getNumbersFromLottos(lottos);
        return lottosNumber;
    }

    private void getNewLottes(int count) {
        while (lottos.size() < count) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    private void getNumbersFromLottos(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            lottosNumber.add(lotto.getNumbers());
        }
    }

    private void validateLottos(int count, List<Lotto> lottos) {
        if (count != lottos.size()) {
            throw new IllegalArgumentException("[ERROR] 올바른 개수만큼의 로또가 생성되지 않았습니다.");
        }
    }
}
