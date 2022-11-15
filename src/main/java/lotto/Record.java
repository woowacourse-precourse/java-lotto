package lotto;

import java.util.List;

public class Record {

    public static void printNumberError() {
        System.out.println(ErrorMessage.IS_ERROR.getMessage() + ErrorMessage.IS_NUMBER.getMessage());
    }

    public static void printPriceError() {
        System.out.println(ErrorMessage.IS_ERROR.getMessage() + ErrorMessage.DIVIDED_PRICE.getMessage());
    }

    public static void printPriceRangeError() {
        System.out.println(ErrorMessage.IS_ERROR.getMessage() + ErrorMessage.PRICE_RANGE.getMessage());
    }

    public static void printSizeError() {
        System.out.println(ErrorMessage.IS_ERROR.getMessage() + ErrorMessage.DIFFERENT_SIZE.getMessage());
    }

    public static void printRangeError() {
        System.out.println(ErrorMessage.IS_ERROR.getMessage() + ErrorMessage.OUT_OF_RANGE.getMessage());
    }

    public static void printBonusDuplicateError() {
        System.out.println(ErrorMessage.IS_ERROR.getMessage() + ErrorMessage.DUPLICATE_BONUS.getMessage());
    }

    public static void printDuplicateError() {
        System.out.println(ErrorMessage.IS_ERROR.getMessage() + ErrorMessage.DUPLICATE_NUMBER.getMessage());
    }

    public static void printDuplicateLottoError() {
        System.out.println(ErrorMessage.IS_ERROR.getMessage() + ErrorMessage.DUPLICATE_LOTTO.getMessage());
    }

    public static void printLottoCountsError() {
        System.out.println(ErrorMessage.IS_ERROR.getMessage() + ErrorMessage.DIFFERENT_LOTTO_COUNTS.getMessage());
    }

    public static String getBonusNumber() {
        return EnterMessage.BONUS_NUMBER.getMessage();
    }

    public static String getWinningNumbers() {
        return EnterMessage.WINNING_NUMBER.getMessage();
    }

    public static String getBuyCounts(long counts) {
        return String.format(EnterMessage.BUY_THINGS.getMessage(), counts);
    }

    public static String getLotto(Lotto lotto) {
        String lottoNumbers = lotto.getLotto();
        return lottoNumbers;
    }

    public static void printEnterPrice() {
        System.out.println(EnterMessage.MONEY.getMessage());
    }

    public static String getWinningStats(LottoTickets lottoTickets) {
        StringBuilder winningStats = new StringBuilder();
        List<Integer> matches = lottoTickets.getMatches();
        winningStats.append(ResultMessage.BORDER.getMessage() + ReferenceValue.LINE_BREAK);

        winningStats.append(getAllMatchMessage(matches));
        winningStats.append(getTotalReturnMessage(lottoTickets));
        return winningStats.toString();
    }

    private static String getAllMatchMessage(List<Integer> matches) {
        int matchesListSize = 6;
        int winningStart = ReferenceValue.
                WinningStats.
                THREE_MATCHES.
                getIndex();

        StringBuilder allMathMessage = new StringBuilder();
        for (int index = winningStart; index < matchesListSize; index++) {
            int matchesCount = matches.get(index);
            String matchesMessage = getMatchesMessage(index, matchesCount);
            allMathMessage.append(matchesMessage + ReferenceValue.LINE_BREAK);
        }
        return allMathMessage.toString();
    }

    private static String getTotalReturnMessage(LottoTickets lottoTickets) {
        double totalReturn = lottoTickets.getTotalReturn();
        String message = String.format(ResultMessage.TOTAL_RETURN.getMessage(), totalReturn);

        return message;
    }

    public static String getMatchesMessage(int index, int count) {

        String matchesMessage = "";

        for (ReferenceValue.WinningStats winningStats : ReferenceValue.WinningStats.values()) {
            if (winningStats.equalsIndex(index)) {
                matchesMessage = winningStats.getMessage();
            }
        }

        matchesMessage = String.format(matchesMessage,count);

        return matchesMessage;
    }

    public enum ErrorMessage {
        IS_ERROR("[ERROR]"),
        DIFFERENT_SIZE(" 번호를 6개 입력해주세요."),
        DIFFERENT_LOTTO_COUNTS(" 구입금액과 로또 개수가 다릅니다."),
        DUPLICATE_NUMBER(" 중복된 숫자가 있습니다."),
        DUPLICATE_LOTTO(" 이미 존재하는 로또입니다."),
        IS_NUMBER(" 해당 입력값은 숫자로 전환할 수 없습니다."),
        OUT_OF_RANGE(" 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        PRICE_RANGE(" 가격이 허용 범위에서 벗어났습니다."),
        DIVIDED_PRICE(" 입력값이 1,000 으로 나눠떨어져야 합니다."),
        DUPLICATE_BONUS(" 이미 당첨 번호에 해당 숫자가 있습니다.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }

    }

    public enum EnterMessage {
        MONEY("구입금액을 입력해 주세요."),
        BUY_THINGS("%d개를 구매했습니다."),
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
        TOTAL_RETURN("총 수익률은 %,.1f%%입니다.");

        private final String message;

        ResultMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }
}
