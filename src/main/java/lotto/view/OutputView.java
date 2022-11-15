package lotto.view;

import lotto.domain.Rank;

import java.util.List;

public class OutputView {

    private static final String PRINT_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String FIRST_YIELD_MESSAGE = "총 수익률은 ";
    private static final String SECOND_YIELD_MESSAGE = "%입니다.";
    private static final String STATICS_MESSAGE = "당첨 통계";
    private static final String MIDDLE_BAR = "---";
    private static final int START_WINNING_LIST = 3;
    private static final int END_WINNING_LIST = 8;


    public void printLottoCount(int count) {
        System.out.println(count + PRINT_LOTTO_COUNT);
        System.out.println();
    }

    public void printLottoNumbers(List<List<Integer>> numbers) {
        numbers.stream()
                .forEach(System.out::println);
    }

    public void printWinningList(List<Integer> winningList) {
        System.out.println(STATICS_MESSAGE);
        System.out.println(MIDDLE_BAR);
        for (int i = START_WINNING_LIST; i < END_WINNING_LIST; i++) {
            System.out.println(Rank.findMoney(i).getMessage(winningList.get(i)));
        }
    }

    public void printYield(double percent) {
        System.out.println(FIRST_YIELD_MESSAGE + String.format("%.1f", percent) + SECOND_YIELD_MESSAGE);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
