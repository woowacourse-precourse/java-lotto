package ui;

import controller.Lotto;

import java.util.List;

public class Output {
    private static final String PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String STATISTICS = "당첨 통계\n---";
    private static final String THREE_WINNING = "3개 일치 (5,000원) - ";
    private static final String FOUR_WINNING = "4개 일치 (50,000원) - ";
    private static final String FIVE_WINNING = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_AND_BONUS_WINNING = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_WINNING = "6개 일치 (2,000,000,000원) - ";
    private static final String UNIT = "개";

    public void printPriceInputMessage() {
        System.out.println(PRICE_INPUT_MESSAGE);
    }

    public void printPurchaseQuantity(int purchaseQuantity) {
        System.out.println(purchaseQuantity + "개를 구매했습니다");
    }

    public void printLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumber = lotto.getNumbers();
            System.out.println(lottoNumber);
        }
    }

    public void printWinningNumberInputMessage() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printWinningStatistics(List<Integer> winningCount){
        System.out.println(STATISTICS);
        System.out.println(THREE_WINNING + winningCount.get(0) + UNIT);
        System.out.println(FOUR_WINNING + winningCount.get(1) + UNIT);
        System.out.println(FIVE_WINNING + winningCount.get(2) + UNIT);
        System.out.println(FIVE_AND_BONUS_WINNING + winningCount.get(3) + UNIT);
        System.out.println(SIX_WINNING + winningCount.get(4) + UNIT);
    }

    public void printYield(String yield){
        System.out.println("총 수익률은 "+yield+"입니다.");
    }
}
