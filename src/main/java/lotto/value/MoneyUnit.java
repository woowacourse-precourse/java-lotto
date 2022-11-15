package lotto.value;

public enum MoneyUnit {
    KRW("원", 1000);

    private final String unitChar;
    private final int price;

    MoneyUnit(String unitChar, int price) {
        this.unitChar = unitChar;
        this.price = price;
    }

    public String getUnitChar() {
        return unitChar;
    }

    public int getPrice() {
        return price;
    }
}
