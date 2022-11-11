package lotto.domain;

public class Game {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String BUY_SOMETHING = "개를 구매했습니다.";

    Price price = new Price();
    NumberGenerator numberGenerator = new NumberGenerator();

    public void start() {
        askPrice();
        price.inputPurchaseAmount();
        showNumberOfPurchase();
        numberGenerator.showPurchaseLottery(getCount());
    }

    public void askPrice() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
    }

    public void showNumberOfPurchase() {
        int count = getCount();
        System.out.println();
        System.out.println(count + BUY_SOMETHING);
    }

    public int getCount() {
        return price.divideAmountTo1000Won();
    }
}

