package lotto.domain;

public class Game {
    Price price = new Price();
    NumberGenerator numberGenerator = new NumberGenerator();

    public void start() {
        askPrice();
        price.inputPurchaseAmount();
        showNumberOfPurchase();
        numberGenerator.showPurchaseLottery(getCount());
    }

    public void askPrice() {
        System.out.println("수입금액을 입력해 주세요.");
    }

    public void showNumberOfPurchase() {
        int count = getCount();
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public int getCount() {
        return price.divideAmountTo1000Won();
    }
}

