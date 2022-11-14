package lotto.domain;

import lotto.constant.LottoConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

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
        long count = money.ableToBuy();
        List<Lotto> lottos = new ArrayList<>();
        LongStream.range(0, count)
                .forEach(__ -> addLotto(lottos));
        return new Lottos(lottos);
    }

    private void addLotto(List<Lotto> lottos) {
        List<Integer> numbers = pickNumbers.pickUniquesInRange(
                LottoConstants.LOTTO_START_INCLUSIVE.value(),
                LottoConstants.LOTTO_END_INCLUSIVE.value(),
                LottoConstants.LOTTO_LENGTH.value());
        lottos.add(new Lotto(numbers));
    }
}
