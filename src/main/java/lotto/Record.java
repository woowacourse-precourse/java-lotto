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
    private static final String FIVE_BONUS_MATCHES_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_MATCHES_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String TOTAL_RETURN_MESSAGE = " 총 수익률은 ";
    private static final String COUNT_MESSAGE = "개";
    private static final String PERCENT_MESSAGE = "%입니다.";


    private static final String ERROR_NUMBER_MESSAGE = ReferenceValue.IS_ERROR + " 입력값이 숫자로 바뀔 수 없습니다.";
    private static final String ERROR_PRICE_MESSAGE = ReferenceValue.IS_ERROR + " 입력값이 1,000 으로 나눠떨어져야 합니다.";
    private static final String ERROR_MINIMUM_MESSAGE = ReferenceValue.IS_ERROR + " 입력값이 1,000 이상 되야합니다.";
    private static final String ERROR_SIZE_MESSAGE = ReferenceValue.IS_ERROR + " 입력 크기가 초과했습니다.";
    private static final String ERROR_DUPLICATE_MESSAGE = ReferenceValue.IS_ERROR + " 중복된 숫자가 있습니다.";
    private static final String ERROR_RANGE_MESSAGE = ReferenceValue.IS_ERROR + " 범위를 벗어난 숫자가 있습니다.";
    private static final String ERROR_BONUS_DUPLICATE_MESSAGE = ReferenceValue.IS_ERROR + " 이미 당첨 번호에 해당 숫자가 있습니다.";

    public static void printNumberError() {
        System.out.print(ERROR_NUMBER_MESSAGE);
    }

    public static void printPriceError() {
        System.out.print(ERROR_PRICE_MESSAGE);
    }

    public static void printMinimumError() {
        System.out.print(ERROR_MINIMUM_MESSAGE);
    }

    public static void printSizeError() {
        System.out.println(ERROR_SIZE_MESSAGE);
    }

    public static void printRangeError() {
        System.out.println(ERROR_RANGE_MESSAGE);
    }

    public static void printBonusDuplicateError() {
        System.out.println(ERROR_BONUS_DUPLICATE_MESSAGE);
    }

    public static void printDuplicateError() {
        System.out.println(ERROR_DUPLICATE_MESSAGE);
    }

    public static String getBonusNumber() {
        return ENTER_BONUS_NUMBER_MESSAGE;
    }

    public static String getWinningNumbers() {
        return ENTER_WINNING_NUMBER_MESSAGE;
    }

    public static String getBuyCounts(int counts) {
        return counts + BUY_MESSAGE;
    }

    public static String getLotto(Lotto lotto) {
        String lottoNumbers = lotto.getLotto();
        return lottoNumbers;
    }

    public static void printEnterPrice() {
        System.out.println(ENTER_MONEY_MESSAGE);
    }

    public static String getWinningStats(LottoTickets lottoTickets) {

        StringBuilder winningStats = new StringBuilder();

        winningStats.append(WINNING_STATS_BORDER + ReferenceValue.LINE_BREAK);

        int matchesListSize = 6;

        List<Integer> matches = lottoTickets.getMatches();

        for (int index = ReferenceValue.INDEX_THREE_MATCHES; index < matchesListSize; index++) {
            int matchesCount = matches.get(index);
            String matchesMessage = getMatchesMessage(index, matchesCount);
            winningStats.append(matchesMessage + COUNT_MESSAGE + ReferenceValue.LINE_BREAK);
        }

        double totalReturn = lottoTickets.getTotalReturn();
        winningStats.append(TOTAL_RETURN_MESSAGE + totalReturn + PERCENT_MESSAGE + ReferenceValue.LINE_BREAK);

        return winningStats.toString();
    }


    public static String getMatchesMessage(int index, int count) {

        String matchesMessage = "";

        if (index == ReferenceValue.INDEX_THREE_MATCHES) {
            matchesMessage = THREE_MATCHES_MESSAGE;
        } else if (index == ReferenceValue.INDEX_FOUR_MATCHES) {
            matchesMessage = FOUR_MATCHES_MESSAGE;
        } else if (index == ReferenceValue.INDEX_FIVE_MATCHES) {
            matchesMessage = FIVE_MATCHES_MESSAGE;
        } else if (index == ReferenceValue.INDEX_FIVE_BONUS_MATCHES) {
            matchesMessage = FIVE_BONUS_MATCHES_MESSAGE;
        } else if (index == ReferenceValue.INDEX_SIX_MATCHES) {
            matchesMessage = SIX_MATCHES_MESSAGE;
        }

        matchesMessage += count;

        return matchesMessage;
    }
}
