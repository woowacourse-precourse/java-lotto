package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.LottoConfig;
import lotto.validate.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public Lotto generateWinningLotto(List<Integer> numbers) {
        checkNumbers(numbers);
        return new Lotto(numbers);
    }

    public List<Lotto> generateLotto(int money) {
        Validator.validatePrice(money);
        List<Lotto> lotteries = new ArrayList<>();

        int size = money / LottoConfig.PRICE;
        for (int i = 0; i < size; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoConfig.RANGE_MIN, LottoConfig.RANGE_MAX, LottoConfig.NUMBER_COUNT);

            checkNumbers(numbers);

            Lotto lotto = new Lotto(numbers);
            lotteries.add(lotto);
        }
        return lotteries;
    }

    private void checkNumbers(List<Integer> numbers) {
        numbers = new ArrayList<>(numbers);
        Collections.sort(numbers);
        Validator.validateNumbers(numbers);
    }
}
