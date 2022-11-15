package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoConstants.LOTTO_PRICE;
import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.LOTTO_SIZE;

public class LottoGenerator {
    public static List<Lotto> generateLottos(int paidMoney) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoQuantity = paidMoney / LOTTO_PRICE.getValue();

        for (int index = 0; index < lottoQuantity; index++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                    MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(), LOTTO_SIZE.getValue()
            ));
            sortNumbers(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    private static void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
