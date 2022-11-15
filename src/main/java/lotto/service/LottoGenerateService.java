package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoSettings;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerateService {
    public List<Lotto> generate(Money money) {
        int numberOfLotto = calculateNumberOfLotto(money);

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> numbers = getSortedRandomLottoNumbers();
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    private int calculateNumberOfLotto(Money money) {
        return money.getAmount() / LottoSettings.LOTTO_PRICE;
    }

    private List<Integer> getSortedRandomLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Randoms.pickUniqueNumbersInRange(LottoSettings.LOTTO_NUMBER_RANGE_START, LottoSettings.LOTTO_NUMBER_RANGE_END, LottoSettings.LOTTO_SIZE));
        Collections.sort(numbers);
        return numbers;
    }
}
