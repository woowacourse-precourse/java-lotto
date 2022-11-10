package lotto;

public class Payment {

    private final int pay;

    public Payment(int money) {
        if (money % 1000 != 0) {
            System.out.print("[ERROR] 1,000원으로 나누어 떨어지는 값을 입력해야합니다.");
            throw new IllegalArgumentException();
        }
        pay = money;
    }
    public int purchase() {
        return pay / 1000;
    }
    public int getPay() {
        return pay;
    }
}
