package lotto.service;

public enum WinningHistory {
    FIRST_PLACE(0),
    SECOND_PLACE(0),
    THIRD_PLACE(0),
    FOURTH_PLACE(0),
    FIFTH_PLACE(0);
    private int quantity;

    WinningHistory(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity() {
        this.quantity = quantity + 1;
    }

    public int getQuantity() {
        return quantity;
    }
}
