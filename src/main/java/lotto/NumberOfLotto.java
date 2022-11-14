package lotto;

public class NumberOfLotto {
    private final int number;

    public NumberOfLotto(Money money) {
        this.number = computeNumberOfLotto(money.getMoney());
        printGuideMessage();
    }

    private int computeNumberOfLotto(int money) {
        final int LOTTO_SELLING_PRICE = 1000;

        return money / LOTTO_SELLING_PRICE;
    }

    private void printGuideMessage() {
        final String GUIDE_MESSAGE = "개를 구매했습니다.";

        System.out.println(this.number + GUIDE_MESSAGE);
    }

    public int getNumberOfLotto() {
        return this.number;
    }
}
