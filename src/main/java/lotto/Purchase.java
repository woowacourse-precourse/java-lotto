package lotto;

public class Purchase {

    private int money;

    public void PurchaseGuild() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public Purchase(String money) {
        ValidateMoneyType(money);
        ValidateMoneyUnit(Integer.valueOf(money));
        this.money = Integer.valueOf(money);
    }

    public void ValidateMoneyType(String money) {
        try {
            Double.parseDouble(money);
        } catch(NumberFormatException e) {
            System.out.println("구입 금액은 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void ValidateMoneyUnit(int money) {
        if (money % 1000 != 0) {
            System.out.println("구입 금액을 1,000원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
}
