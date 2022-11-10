package lotto;

public final class LottoExceptions {

    private LottoExceptions() throws IllegalAccessException {
        throw new IllegalAccessException("Access Denied: Should not create a util instance");
    }

    public static RuntimeException createLottoException(String message) {
        return new IllegalArgumentException("[ERROR]" + message);
    }
}