package lotto.domain.lotto;

import lotto.exception.lottoMoney.LottoMoneyDivideException;
import lotto.exception.lottoMoney.LottoMoneyLessException;
import java.util.Objects;

public class LottoMoney {
    private static final int DIVIDE_UNIT = 1000;
    private final int value;

    private LottoMoney(final int value) {
        validate(value);
        this.value = value;
    }

    public static LottoMoney from(final int value) {
        return new LottoMoney(value);
    }

    private static void validate(final int value) {
        if (value < DIVIDE_UNIT) {
            throw new LottoMoneyLessException(value);
        }
        if (value % DIVIDE_UNIT != 0) {
            throw new LottoMoneyDivideException(value);
        }
    }

    public int toLottoCount() {
        return value / DIVIDE_UNIT;
    }

    public int get() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoMoney lottoMoney1 = (LottoMoney) o;
        return value == lottoMoney1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}