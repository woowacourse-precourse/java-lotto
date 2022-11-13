package lotto.domain;

import lotto.constant.LottoConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

final class LottoCreator {
    private final PickNumbers random;

    public LottoCreator(PickNumbers random) {
        validate(random);
        this.random = random;
    }

    private void validate(PickNumbers random) {
        if (random == null) {
            throw new IllegalArgumentException();
        }
    }

    public Lottos createLottos(Money money) {
        int count = money.ableToBuy();
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, count)
                .forEach(__ -> addLotto(lottos));
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
