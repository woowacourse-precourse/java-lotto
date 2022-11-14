package lotto;

public class Simulator {
    private int quantity;

    public Simulator(int price) {
        validatePrice(price);
        this.quantity = toQuantity(price);
    }

    public int getQuantity() {
        return this.quantity;
    }

    private void validatePrice(int price) {
        if ((price % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야합니다.");
        }
    }

    private int toQuantity(int price) {
        return price / 1000;
    }
}
