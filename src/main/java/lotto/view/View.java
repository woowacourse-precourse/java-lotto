package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class View {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String GAME_START = "구입금액을 입력해 주세요.";
    private static final String GAME_START_FEEDBACK = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT_REQUEST = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_REQUEST = "보너스 번호를 입력해 주세요.";
    private static final String NUMBER_INPUT_FEEDBACK = "당첨 통계" + LINE_SEPARATOR + "---";

    public void printStart() {
        System.out.println(GAME_START);
    }

    public void printStartFeedback(List<Lotto> lottos) {
        StringBuilder feedback = new StringBuilder();
        feedback.append(lottos.size()).append(GAME_START_FEEDBACK).append(LINE_SEPARATOR);
        lottos.forEach(lotto -> feedback.append(lotto.toString()).append(LINE_SEPARATOR));
        System.out.println(feedback);
    }

    public void printWinningNumbersInputRequest() {
        System.out.println(WINNING_NUMBER_INPUT_REQUEST);
    }

    public void printBonusNumberInputRequest() {
        System.out.println(BONUS_NUMBER_INPUT_REQUEST);
    }

    public void printWinningResult(Map<Rank, Integer> countOfWinning, double profitRate) {
        StringBuilder result = new StringBuilder();
        result.append(NUMBER_INPUT_FEEDBACK).append(LINE_SEPARATOR);
        printWinningInfo(result, countOfWinning);
        result.append(String.format("총 수익률은 %.1f%s입니다.", profitRate * 100, "%"));
        System.out.println(result);
    }

    private void printWinningInfo(StringBuilder printer, Map<Rank, Integer> countOfRank) {
        for (Rank current : Rank.values()) {
            printer.append(current.getSameCount())
                   .append("개 일치");

            if (current == Rank.SECOND) {
                printer.append(", 보너스 볼 일치");
            }

            printer.append(
                    String.format(
                            " (%d원) - %d개%n",
                            current.getWinnings(),
                            countOfRank.get(current)
                    )
            );
        }
    }

}
