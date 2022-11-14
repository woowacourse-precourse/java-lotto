package lotto;

public class LottoNumber {
    private final int number;

    public LottoNumber(Money money) {
        // Money money = new Money();
        this.number = computeLottoNumber(money.getMoney());
        printGuideMessage();
    }

    private int computeLottoNumber(int money) {
        final int LOTTO_SELLING_PRICE = 1000;

        return money / LOTTO_SELLING_PRICE;
    }

    private void printGuideMessage() {
        final String GUIDE_MESSAGE = "개를 구매했습니다.";

        System.out.println(this.number + GUIDE_MESSAGE);
    }

    public int getLottoNumber() {
        return this.number;
    }
}
