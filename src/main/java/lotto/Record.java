package lotto;

import java.util.List;

public class Record {

    private static final String ENTER_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final String BUY_MESSAGE = "개를 구매했습니다.";

    private static final String WINNING_STATS_BORDER = "당첨 통계" + "\n" + "---";
    private static final String THREE_MATCHES_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String FOUR_MATCHES_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String FIVE_MATCHES_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_BONUS_MATCHES_MESSAGE = "5개 일치, 보너스 볼 일치 (3,000,000원) - ";
    private static final String SIX_MATCHES_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String TOTAL_RETURN_MESSAGE = " 총 수익률은 ";
    private static final String COUNT_MESSAGE = "개";
    private static final String PERCENT_MESSAGE = "%입니다.";


    private static final String ERROR_SIZE_MESSAGE = "[ERROR] 입력 크기가 초과했습니다.";
    private static final String ERROR_DUPLICATE_MESSAGE = "[ERROR] 중복된 숫자가 있습니다.";

    public static void printSizeError() {
        System.out.print(ERROR_SIZE_MESSAGE);
    }
    public static void printDuplicateError() {
        System.out.print(ERROR_DUPLICATE_MESSAGE);
    }
    public static void printBonusNumber() {
        System.out.print(ENTER_BONUS_NUMBER_MESSAGE);
    }
    public static void printWinningNumbers() {
        System.out.print(ENTER_WINNING_NUMBER_MESSAGE);
    }
    public static void printBuyCounts(int counts) {
        System.out.print(counts + BUY_MESSAGE);
    }
    public static void printLotto(List<Integer> lottoNumbers) {
        System.out.print(lottoNumbers);
    }
    public static void printEnterMoney() {
        System.out.print(ENTER_MONEY_MESSAGE);
    }
    public static void printWinningStats() {
        int resultIndex = 0;
        List<Integer> lottoResults = LottoTickets.getLottoResults();

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
