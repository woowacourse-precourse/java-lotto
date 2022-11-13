package lotto.model;

public enum LottoPrice {
    UNIT(1_000);

    private final int price;

    LottoPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return Integer.toString(price);
    }
}
