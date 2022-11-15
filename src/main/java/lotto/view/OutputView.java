package lotto.view;

public class OutputView {
    private static final String PURCHASED_SENTENCE = "개를 구매했습니다.";
    private static final String RESULT_TITLE = "당첨 통계";
    private static final String LINE_DIVISION = "---";
    private static final String TOTAL_YIELD = "총 수익률은 %.1f%%입니다.";


    public static void printBuyResult(int buyLottoSize) {
        System.out.println();
        System.out.println(buyLottoSize + PURCHASED_SENTENCE);
    }

    public static void printResultIntro() {
        System.out.println("");
        System.out.println(RESULT_TITLE);
        System.out.println(LINE_DIVISION);
    }

    public static void printYield(double lastResult) {
        System.out.printf(TOTAL_YIELD, lastResult);
    }
}
