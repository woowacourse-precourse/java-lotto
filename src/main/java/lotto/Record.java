package lotto;

import java.util.List;

public class Record {

    private static final String BUY_MESSAGE = "개를 구매했습니다.";
    private static final String COUNT_MESSAGE = "개";

    public static void printNumberError() {
        System.out.println(ErrorMessage.IS_NUMBER.getMessage());
    }

    public static void printPriceError() {
        System.out.println(ErrorMessage.DIVIDED_PRICE.getMessage());
    }

    public static void printMinimumError() {
        System.out.println(ErrorMessage.MINIMUM_PRICE.getMessage());
    }

    public static void printSizeError() {
        System.out.println(ErrorMessage.EXCEED_SIZE.getMessage());
    }

    public static void printRangeError() {
        System.out.println(ErrorMessage.OUT_OF_RANGE.getMessage());
    }

    public static void printBonusDuplicateError() {
        System.out.println(ErrorMessage.DUPLICATE_BONUS.getMessage());
    }

    public static void printDuplicateError() {
        System.out.println(ErrorMessage.DUPLICATE_NUMBER.getMessage());
    }

    public static String getBonusNumber() {
        return EnterMessage.BONUS_NUMBER.getMessage();
    }

    public static String getWinningNumbers() {
        return EnterMessage.WINNING_NUMBER.getMessage();
    }

    public static String getBuyCounts(int counts) {
        return counts + BUY_MESSAGE;
    }

    public static String getLotto(Lotto lotto) {
        String lottoNumbers = lotto.getLotto();
        return lottoNumbers;
    }

    public static void printEnterPrice() {
        System.out.println(EnterMessage.MONEY.getMessage());
    }

    public static String getWinningStats(LottoTickets lottoTickets) {
        int matchesListSize = 6;
        StringBuilder winningStats = new StringBuilder();
        List<Integer> matches = lottoTickets.getMatches();
        winningStats.append(ResultMessage.BORDER.getMessage() + ReferenceValue.LINE_BREAK);

        int winningStart = ReferenceValue.
                WinningStats.
                THREE_MATCHES.
                getIndex();

        System.out.println(matches);

        for (int index = winningStart; index < matchesListSize; index++) {
            int matchesCount = matches.get(index);
            String matchesMessage = getMatchesMessage(index, matchesCount);
            winningStats.append(matchesMessage + COUNT_MESSAGE + ReferenceValue.LINE_BREAK);
        }

        winningStats.append(getTotalReturnMessage(lottoTickets));
        return winningStats.toString();
    }

    private static String getTotalReturnMessage(LottoTickets lottoTickets) {
        double totalReturn = lottoTickets.getTotalReturn();
        String message = ResultMessage.TOTAL_RETURN_FRONT.getMessage()
                + totalReturn
                + ResultMessage.TOTAL_RETURN_BACK.getMessage()
                + ReferenceValue.LINE_BREAK;

        return message;
    }

    public static String getMatchesMessage(int index, int count) {

        String matchesMessage = "";

        for (ReferenceValue.WinningStats winningStats : ReferenceValue.WinningStats.values()) {
            if (winningStats.equalsIndex(index)) {
                matchesMessage = winningStats.getMessage();
            }
        }

        matchesMessage += count;

        return matchesMessage;
    }

    public enum ErrorMessage {
        IS_ERROR("[ERROR]"),
        EXCEED_SIZE(" 입력 크기가 초과했습니다."),
        DUPLICATE_NUMBER(" 중복된 숫자가 있습니다."),
        IS_NUMBER(" 입력값이 숫자로 바뀔 수 없습니다."),
        OUT_OF_RANGE(" 범위를 벗어난 숫자가 있습니다."),
        MINIMUM_PRICE(" 입력값이 1,000 이상 되야합니다."),
        DIVIDED_PRICE(" 입력값이 1,000 으로 나눠떨어져야 합니다."),
        DUPLICATE_BONUS(" 이미 당첨 번호에 해당 숫자가 있습니다.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return IS_ERROR.message + this.message;
        }

    }

    public enum EnterMessage {
        MONEY("구입금액을 입력해 주세요."),
        WINNING_NUMBER("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요.");
        private final String message;

        EnterMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public enum ResultMessage {

        BORDER("당첨 통계 \n---"),
        TOTAL_RETURN_FRONT("총 수익률은 "),
        TOTAL_RETURN_BACK("%입니다.");

        private final String message;

        ResultMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }
}
