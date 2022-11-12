package lotto;

public class Purchase {

    private int money;

    public void purchaseGuild() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public Purchase(String money) {
        validateMoneyType(money);
        validateMoneyUnit(Integer.valueOf(money));
        this.money = Integer.valueOf(money);
    }

    public int lottoToGet() {
        return (money / 1000);
    }

    public void validateMoneyType(String money) {
        try {
            Double.parseDouble(money);
        } catch(NumberFormatException e) {
            System.out.println("구입 금액은 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateMoneyUnit(int money) {
        if (money % 1000 != 0) {
            System.out.println("구입 금액을 1,000원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
}
