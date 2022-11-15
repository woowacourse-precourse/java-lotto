package lotto;

public enum Prize {
    nothing("0원"),
    fifth("5,000원"),
    fourth("50,000원"),
    third("1,500,000원"),
    first("2,000,000,000원"),
    second("30,000,000원");

    private final String price;
    private int count;

    Prize(String price) {
        this.price = price;
    }

    public int getCount() {
        return this.count;
    }

    public void addCount() {
        this.count++;
    }

    public String getPrice() {
        return this.price;
    }
}
