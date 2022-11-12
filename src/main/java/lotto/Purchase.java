package lotto;

public class Purchase {

    private int money;
    private int lottoNumber;

    public void printPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printConfirmPurchase() {
        System.out.println(this.lottoNumber+"개를 구매했습니다.");
    }

    public Purchase(String money) {
        validateMoneyType(money);
        validateMoneyUnit(Integer.valueOf(money));
        this.money = Integer.valueOf(money);
        this.lottoNumber = (this.money / 1000);
    }

    public int getLottoNumber() {
        return this.lottoNumber;
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
