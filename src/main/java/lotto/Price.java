package lotto;

public class Price {
    private final String price;

    public Price(String price) {
        validate(price);
        this.price = price;
    }

    private void validate(String price) {
        // 1-1. 숫자가 아니면 예외처리를 한다.
        for (int idx = 0; idx < price.length(); idx++) {
            if(!('0' <= price.charAt(idx) && price.charAt(idx) <= '9')) throw new IllegalArgumentException();
        }
    }
}
