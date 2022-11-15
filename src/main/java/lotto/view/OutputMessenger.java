package lotto.view;

import lotto.domain.lottomachine.lottoticket.LottoTickets;

import java.util.List;

public class OutputMessenger {

    public void printPaymentMessage() {
        System.out.print(OutputMessages.PAYMENT.getMessage());
    }

    public void printOrderMessage(int number) {
        System.out.printf(OutputMessages.ORDER.getMessage(), number);
    }

    public void printLottoTicketsMessage(LottoTickets lottoTickets) {
        System.out.println(lottoTickets);
    }

    public void printWinningNumberInputMessage() {
        System.out.print(OutputMessages.WINNING_NUMBER_INPUT.getMessage());
    }

    public void printBonusNumberInputMessage() {
        System.out.print(OutputMessages.BONUS_NUMBER_INPUT.getMessage());
    }

    public void printStatisticsMessage(List<List<String>> table) {
        System.out.print(OutputMessages.STATISTICS_TITLE.getMessage());
        System.out.print(OutputMessages.DIVIDING_LINE.getMessage());
        for (List<String> row : table) {
            System.out.print(makeStatisticsMessage(row));
        }
    }

    private String makeStatisticsMessage(List<String> row) {
        String numberOfMatching = row.get(0);
        String cash = row.get(1);
        String frequency = row.get(2);

        if (numberOfMatching.equals("5B")) {
            return String.format(OutputMessages.STATISTICS_BONUS_SENTENCE.getMessage(), numberOfMatching.charAt(0), cash, frequency);
        }
        return String.format(OutputMessages.STATISTICS_NORMAL_SENTENCE.getMessage(), numberOfMatching, cash, frequency);
    }

    public void printRateOfReturnMessage(String rateOfReturn) {
        System.out.printf(OutputMessages.RATE_OF_RETURN.getMessage(), rateOfReturn);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
