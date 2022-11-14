package lotto.buy;

public class Payment {

    public static int LOTTO_PRICE = 1000;
    private final int pay;

    public Payment(int money) {
        if (money % LOTTO_PRICE != 0) {
            System.out.print("[ERROR] 1,000원으로 나누어 떨어지는 값을 입력해야합니다.");
            throw new IllegalArgumentException();
        }
        pay = money;
    }
    public int purchase() {
        return pay / LOTTO_PRICE;
    }
    public int getPay() {
        return pay;
    }
}
