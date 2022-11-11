package lotto.verifiable;

public interface Verifiable<T> {
    public T check(T input);
}
