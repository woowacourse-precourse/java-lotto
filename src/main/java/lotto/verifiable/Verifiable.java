package lotto.verifiable;

import lotto.Profit;

public interface Verifiable<T> {
    Integer checkWithValue(Profit input);

    Integer checkWithValue(T input);
}
