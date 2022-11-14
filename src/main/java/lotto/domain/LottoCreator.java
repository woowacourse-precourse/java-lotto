package lotto.domain;

import lotto.constant.LottoConstants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class LottoCreator {
    private static final String NULL_MESSAGE = "숫자를 뽑는 방식에 null 이 들어왔습니다";
    private final PickNumbers pickNumbers;

    public LottoCreator(PickNumbers pickNumbers) {
        validate(pickNumbers);
        this.pickNumbers = pickNumbers;
    }

    private void validate(PickNumbers pickNumbers) {
        if (pickNumbers == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    public Lottos createLottos(Money money) {
        final long count = money.ableToBuy();
        final List<Lotto> lottos = Stream.generate(() -> generateNumbers())
                .limit(count)
                .map(Lotto::new)
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    private List<Integer> generateNumbers() {
        return pickNumbers.pickUniquesInRange(
                LottoConstants.LOTTO_START_INCLUSIVE.value(),
                LottoConstants.LOTTO_END_INCLUSIVE.value(),
                LottoConstants.LOTTO_LENGTH.value()
        );
    }
}
