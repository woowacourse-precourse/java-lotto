package lotto.verifiable;

public interface Verifiable<T> {

    Integer checkWithValue(T input);
}
