package lotto.view;

import lotto.domain.lottomachine.lottoticket.LottoTickets;

import java.util.List;

public class OutputMessenger {
    private static final int FIRST_COLUMN = 0;
    private static final int SECOND_COLUMN = 1;
    private static final int THIRD_COLUMN = 2;
    private static final int FIRST_LETTER = 0;

    public void printPaymentInputMessage() {
        System.out.print(OutputMessage.PAYMENT.getMessage());
    }

    public void printOrderMessage(int number) {
        System.out.printf(OutputMessage.ORDER.getMessage(), number);
    }

    public void printLottoTicketsMessage(LottoTickets lottoTickets) {
        System.out.println(lottoTickets);
    }

    public void printWinningNumberInputMessage() {
        System.out.print(OutputMessage.WINNING_NUMBER_INPUT.getMessage());
    }

    public void printBonusNumberInputMessage() {
        System.out.print(OutputMessage.BONUS_NUMBER_INPUT.getMessage());
    }

    public void printStatisticsByAscendingRanking(List<String> row) {
        System.out.print(makeStatisticsMessage(row));
    }

    public void printStatisticsIntro() {
        System.out.print(OutputMessage.STATISTICS_TITLE.getMessage());
        System.out.print(OutputMessage.DIVIDING_LINE.getMessage());
    }

    private String makeStatisticsMessage(List<String> row) {
        String numberOfMatching = row.get(FIRST_COLUMN);
        String cash = row.get(SECOND_COLUMN);
        String frequency = row.get(THIRD_COLUMN);

        if (numberOfMatching.equals("5B")) {
            return String.format(OutputMessage.STATISTICS_BONUS_SENTENCE.getMessage(), numberOfMatching.charAt(FIRST_LETTER), cash, frequency);
        }
        return String.format(OutputMessage.STATISTICS_NORMAL_SENTENCE.getMessage(), numberOfMatching, cash, frequency);
    }

    public void printRateOfReturnMessage(String rateOfReturn) {
        System.out.printf(OutputMessage.RATE_OF_RETURN.getMessage(), rateOfReturn);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
