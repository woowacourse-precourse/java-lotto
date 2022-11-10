package lotto;

public final class LottoExceptions {

    private LottoExceptions() throws IllegalAccessException {
        throw new IllegalAccessException("Access Denied: Should not create a util instance");
    }

    public static Exception createLottoException(String message) {
        return new IllegalArgumentException(message);
    }
}