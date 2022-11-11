package lotto.domain.money;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Money {

    private final int value;

    private Money(final int value) {
        this.value = value;
    }

    public static Money valueOf(int value) {
        return new Money(value);
    }

    /**
     * 돈을 주어진 인자에 해당하는 단위로 교환한다.
     * ex : 10,000.exchangeFor(1,000) = 1,000 원 10장
     *
     * @param exchanged 교환할 단위
     * @throws IllegalArgumentException 화폐가 정확히 교환되지 않고 나머지가 남는 경우 발생한다.
     */
    public List<Money> exchangeFor(Money exchanged) {
        exchangeValidate(exchanged);

        int count = (this.value / exchanged.value);
        return IntStream.range(0, count)
                .mapToObj(i -> Money.valueOf(exchanged.value))
                .collect(toList());
    }

    private void exchangeValidate(Money exchanged) {
        if (this.value % exchanged.value != 0) {
            throw new IllegalArgumentException();
        }
    }
}
