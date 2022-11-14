package lotto;

public class Purchase {
    static Integer lottoSize;
    public static final String ERROR_PRICE = "[ERROR] Price should be at least 1000.";

    public Purchase(Integer price) {
        checkSizeValidity(price);
        lottoSize = price / 1000;
    }

    private void checkSizeValidity(Integer price) throws IllegalArgumentException {
        if (price / 1000 <= 0) {
            new IllegalArgumentException(ERROR_PRICE);
        }
    }

}
