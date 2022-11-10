package lotto;

import java.util.List;

public class Record {

    private static final String ENTER_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final String WINNING_STATS_BORDER = "당첨 통계" + "\n" + "---";
    private static final String THREE_MATCHES_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String FOUR_MATCHES_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String FIVE_MATCHES_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_BONUS_MATCHES_MESSAGE = "5개 일치, 보너스 볼 일치 (3,000,000원) - ";
    private static final String SIX_MATCHES_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String TOTAL_RETURN_MESSAGE = " 총 수익률은 ";
    private static final String COUNT_MESSAGE = "개";
    private static final String PERCENT_MESSAGE = "%입니다.";


    private static void printWinningStats(List<Integer> lottoResults) {

        int resultIndex = 0;

        System.out.print(WINNING_STATS_BORDER);
        System.out.print(THREE_MATCHES_MESSAGE + lottoResults.get(resultIndex++) + COUNT_MESSAGE);
        System.out.print(FOUR_MATCHES_MESSAGE + lottoResults.get(resultIndex++) + COUNT_MESSAGE);
        System.out.print(FIVE_MATCHES_MESSAGE + lottoResults.get(resultIndex++) + COUNT_MESSAGE);
        System.out.print(FIVE_BONUS_MATCHES_MESSAGE + lottoResults.get(resultIndex++) + COUNT_MESSAGE);
        System.out.print(SIX_MATCHES_MESSAGE + lottoResults.get(resultIndex++) + COUNT_MESSAGE);

        double totalReturn = LottoTickets.getTotalReturn();

        System.out.print(TOTAL_RETURN_MESSAGE + totalReturn + PERCENT_MESSAGE);
    }
}
