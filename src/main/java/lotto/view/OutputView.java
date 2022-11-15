package lotto.view;

import java.util.*;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;


public class OutputView {

    private static final String SECOND_RANK_RESULT_MESSAGE = "%,d개 일치, 보너스 볼 일치 (%,d원) - %,d개";
    private static final String NOT_SECOND_RANK_RESULT_MESSAGE = "%,d개 일치 (%,d원) - %,d개";
    private static final String PROFIT_RESULT_MESSAGE = "총 수익률은 %,.1f%c입니다.";
    private static final String RESULT_TITLE_MESSAGE = "당첨 통계\n---";
    private static final String REQUEST_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_LOTTOS = "%,d개를 구매했습니다.";
    private static final String REQUEST_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String errorMessage) {
        printMessage(errorMessage);
    }

    private void printNewLine() {
        System.out.println();
    }

    public void printRequestMoney() {
        printMessage(REQUEST_MONEY_MESSAGE);
    }

    public void printLottoNumberOfTicket(List<Lotto> lottoTicket) {
        printNewLine();
        printMessage(String.format(NUMBER_OF_LOTTOS, lottoTicket.size()));
        for (Lotto lotto : lottoTicket) {
            printLottoNumbers(sortNumbers(lotto.lottoNumbers()));
        }
    }

    private List<Integer> sortNumbers(List<Integer> lottoNumbers) {
        List<Integer> sortedLottoNumbers = new ArrayList<>();
        sortedLottoNumbers.addAll(lottoNumbers);
        Collections.sort(sortedLottoNumbers);
        return sortedLottoNumbers;
    }

    private void printLottoNumbers(List<Integer> sortedNumbers) {
        printMessage(Arrays.toString(sortedNumbers.toArray()));
    }

    public void printRequestWinningNumbers() {
        printNewLine();
        printMessage(REQUEST_WINNING_NUMBERS_MESSAGE);
    }

    public void printRequestBonusNumber() {
        printNewLine();
        printMessage(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    public void printResultStatistic(Map<LottoRanking, Integer> winningResult) {
        printNewLine();
        printMessage(RESULT_TITLE_MESSAGE);
        for (LottoRanking ranking : winningResult.keySet()) {
            printMessage(generateRankingMessage(ranking, winningResult.get(ranking)));
        }
    }

    private String generateRankingMessage(LottoRanking ranking, Integer count) {
        if (ranking == LottoRanking.SECOND) {
            return String.format(SECOND_RANK_RESULT_MESSAGE, ranking.correctNumbers(), ranking.prize(), count);
        }
        return String.format(NOT_SECOND_RANK_RESULT_MESSAGE, ranking.correctNumbers(), ranking.prize(), count);
    }

    public void printRateOfProfit(double rateOfProfit) {
        printMessage(String.format(PROFIT_RESULT_MESSAGE, rateOfProfit, '%'));
    }
}