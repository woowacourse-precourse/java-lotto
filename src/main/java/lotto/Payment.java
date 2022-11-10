package lotto;

public class Payment {

    private final int pay;

    public Payment(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        if (money == 0) {
            throw new IllegalArgumentException();
        }
        pay = money;
    }
    public int purchase() {
        return pay / 1000;
    }
}
