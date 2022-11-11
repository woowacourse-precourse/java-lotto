package lotto;

public class Purchase {
    private final Integer price;

    public Purchase(String input) throws IllegalArgumentException {
        Integer price = Integer.valueOf(input);

        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
