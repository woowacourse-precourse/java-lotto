package lotto.domain;

import java.text.DecimalFormat;

public class Game {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String BUY_SOMETHING = "개를 구매했습니다.";
    private static final String ENTER_WINNING_LOTTO_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String SHOW_WIN_STATISTICS = "\n당첨 통계 \n---";

    Price price = new Price();
    NumberGenerator numberGenerator = new NumberGenerator();
    WinningNumber winningNumber = new WinningNumber();
    Lotto lotto;
    BonusNumber bonusNumber = new BonusNumber();

    public void start() {
        askPrice();
        int purchasePrice = price.inputPurchaseAmount();
        showNumberOfPurchase();
        numberGenerator.showPurchaseLottery(getCount());
        askWinningNumber();
        String winningNumbers = winningNumber.inputWinningNumbers();
        lotto = new Lotto(winningNumber.seperatedByComma(winningNumbers));
        askBonusNumber();
        int number = bonusNumber.inputBonusNumber();
        lotto.validateDuplicateWinningNumbersAndBonusNumber(number);
        lotto.duplicateWinningNumbersAndGeneratorNumbers(numberGenerator.numbers, number);
        showWinStatistics();
        makeGrossReturn(purchasePrice);
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

    public void askBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER);
    }

    public int getCount() {
        return price.divideAmountTo1000Won();
    }

    public void showWinStatistics() {
        PrizeMoney[] prizeMoneys = PrizeMoney.values();
        PrizeMoney prizeBonus = PrizeMoney.BONUS;
        System.out.println(SHOW_WIN_STATISTICS);

        for (PrizeMoney prizeMoney : prizeMoneys) {
            if (prizeMoney.equals(prizeBonus)) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                        prizeMoney.getMatchingNumbers(), formatCommaInPrize(prizeMoney.getPrize()),
                        prizeMoney.getCount());
            }
            if (!prizeMoney.equals(prizeBonus)) {
                System.out.printf("%d개 일치 (%s원)- %d개\n", prizeMoney.getMatchingNumbers(),
                        formatCommaInPrize(prizeMoney.getPrize()), prizeMoney.getCount());
            }
        }
    }

    public String formatCommaInPrize(int prize) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String commaPrize = decimalFormat.format(prize);
        return commaPrize;
    }

    public void makeGrossReturn(int purchasePrice) {
        PrizeMoney[] prizeMoneys = PrizeMoney.values();
        double result = 0;
        for (PrizeMoney prizeMoney : prizeMoneys) {
            result += prizeMoney.getPrize() * prizeMoney.getCount();
        }
        result = (result / purchasePrice) * 100;
        System.out.println("총 수익률은 " + result + "%입니다.");
    }
}

