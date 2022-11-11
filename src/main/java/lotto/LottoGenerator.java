package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final Integer lottoAmount;
    LottoGenerator(Integer purchasedAmount) {
        this.lottoAmount = purchasedAmount / 1000;
    }

    public List<Lotto> generateLotto() {
        List<Lotto> result = new ArrayList<>(lottoAmount);
        for (int i = 0; i < lottoAmount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            result.add(new Lotto(numbers));
        }
        return result;
    }
}
