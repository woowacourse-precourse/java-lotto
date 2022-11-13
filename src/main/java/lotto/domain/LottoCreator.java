package lotto.domain;

import lotto.constant.LottoConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoCreator {
    private final PickNumbers random;

    public LottoCreator(PickNumbers random) {
        this.random = random;
    }

    public Lottos createLottos(Money money) {
        int count = money.ableToBuy();
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, count)
                .forEach(ignored -> addLotto(lottos));
        return new Lottos(lottos);
    }

    private void addLotto(List<Lotto> lottos) {
        List<Integer> numbers = random.pickUniquesInRange(
                LottoConstants.LOTTO_START_INCLUSIVE.value(),
                LottoConstants.LOTTO_END_INCLUSIVE.value(),
                LottoConstants.LOTTO_LENGTH.value());
        lottos.add(new Lotto(numbers));
    }
}
