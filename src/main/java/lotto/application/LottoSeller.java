package lotto.application;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoConstant;

public class LottoSeller {

    private static final int LOTTO_PRICE = 1000;

    private static LottoSeller instance;

    private LottoSeller() {
    }

    public static LottoSeller getInstance() {
        if (instance == null) {
            instance = new LottoSeller();
        }
        return LottoSeller.instance;
    }

    public List<Lotto> sellLotto(long amount) {
        validateAmount(amount);

        long sellableLotto = amount / LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < sellableLotto; i++) {
            List<Integer> numbers = createRandomNumbers();
            Lotto lotto = new Lotto(numbers);

            lottos.add(lotto);
        }
        return lottos;
    }

    private void validateAmount(long amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("로또 구매 금액은 1,000 단위로만 입력 가능합니다.");
        }
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstant.MIN_NUMBER.getValue(),
                LottoConstant.MAX_NUMBER.getValue(),
                LottoConstant.NUMBERS_SIZE.getValue())
            .stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    }
}
