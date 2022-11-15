package lotto.domian.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Lotto> lottos = new ArrayList<>();
    private final List<List<Integer>> lottosNumber = new ArrayList<>();

    public List<List<Integer>> generateLotto(int count) {
        getNewLottes(count);
        validateLottos(count, lottos);
        getNumbersFromLottos(lottos);
        return lottosNumber;
    }

    private void getNewLottes(int count) {
        while (lottos.size() < count) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE)));
        }
    }

    private void getNumbersFromLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lottosNumber.add(lotto.getNumbers());
        }
    }

    private void validateLottos(int count, List<Lotto> lottos) {
        if (count != lottos.size()) {
            throw new IllegalArgumentException("[ERROR] 올바른 개수만큼의 로또가 생성되지 않았습니다.");
        }
    }
}
