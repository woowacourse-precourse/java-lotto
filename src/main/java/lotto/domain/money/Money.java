package lotto.domain.money;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.String.*;
import static java.util.stream.Collectors.toList;

public class Money {

    private static final String MONEY_FORMAT = "###,###";
    private static final String DIVIDE_ERROR_MESSAGE_FORMAT = "%d원은 %d원으로 나누어 떨어지지 않습니다.";
    private static final DecimalFormat FORMAT = new DecimalFormat(MONEY_FORMAT);

    private final int value;

    private Money(final int value) {
        this.value = value;
    }

    public static Money valueOf(final int value) {
        return new Money(value);
    }

    /**
     * 돈을 주어진 인자에 해당하는 단위로 교환한다.
     * ex : 10,000.exchangeFor(1,000) = 1,000 원 10장
     *
     * @param exchanged 교환할 단위
     * @throws IllegalArgumentException 화폐가 정확히 교환되지 않고 나머지가 남는 경우 발생한다.
     */
    public List<Money> exchangeFor(final Money exchanged) {
        exchangeValidate(exchanged);

        int count = (this.value / exchanged.value);

        return IntStream.range(0, count)
                .mapToObj(i -> Money.valueOf(exchanged.value))
                .collect(toList());
    }

    private void exchangeValidate(final Money exchanged) {
        if (this.value % exchanged.value != 0) {
            throw new IllegalArgumentException(
                    format(DIVIDE_ERROR_MESSAGE_FORMAT, this.value, exchanged.value)
            );
        }
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return FORMAT.format(value);
    }
}
