package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {
    private final Integer lottoAmount;
    LottoGenerator(Integer purchasedAmount) {
        this.lottoAmount = purchasedAmount / 1000;
    }

    public List<List<Integer>> generateLotto() {
        List<List<Integer>> result = null;
        for (int i = 0; i < lottoAmount; i++){
            result.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return result;
    }
}
