package lotto;

public class Purchase {

    private int money;

    public void PurchaseGuild() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public Purchase(String money) {
        ValidateMoneyType(money);
        this.money = Integer.valueOf(money);
    }

    public void ValidateMoneyType(String money) {
        try {
            Double.parseDouble(money);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
