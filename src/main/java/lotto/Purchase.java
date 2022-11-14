package lotto;

public class Purchase {

    private final int money;
    private final int lottoNumber;

    public Purchase(String money) throws Exception {
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
        } catch (Exception e) {
            System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateMoneyUnit(int money) {
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 구입 금액을 1,000원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
}
