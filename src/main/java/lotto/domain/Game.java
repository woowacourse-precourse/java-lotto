package lotto.domain;

public class Game {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String BUY_SOMETHING = "개를 구매했습니다.";
    private static final String ENTER_WINNING_LOTTO_NUMBER = "\n당첨 번호를 입력해 주세요.";

    Price price = new Price();
    NumberGenerator numberGenerator = new NumberGenerator();
    WinningNumber winningNumber = new WinningNumber();
    Lotto lotto;

    public void start() {
        askPrice();
        price.inputPurchaseAmount();
        showNumberOfPurchase();
        numberGenerator.showPurchaseLottery(getCount());
        askWinningNumber();
        String winningNumbers = winningNumber.inputWinningNumbers();
        lotto = new Lotto(winningNumber.seperatedByComma(winningNumbers));
    }

    public void askPrice() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
    }

    public void showNumberOfPurchase() {
        int count = getCount();
        System.out.println();
        System.out.println(count + BUY_SOMETHING);
    }

    public void askWinningNumber() {
        System.out.println(ENTER_WINNING_LOTTO_NUMBER);
    }

    public int getCount() {
        return price.divideAmountTo1000Won();
    }
}

