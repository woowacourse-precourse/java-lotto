package lotto.controller;

import lotto.domain.lottomachine.lottoticket.LottoTickets;
import lotto.domain.lottomachine.messages.InputErrorMessage;
import lotto.domain.lottomachine.payment.Payment;
import lotto.domain.lottomachine.ranking.Frequency;
import lotto.domain.lottomachine.ranking.Ranking;
import lotto.domain.lottomachine.ranking.RankingTable;
import lotto.view.InputMessenger;
import lotto.view.OutputMessenger;

import java.util.List;
import java.util.Map;

public class InputOutputController {
    private final OutputMessenger outputMessenger = new OutputMessenger();
    private final InputMessenger inputMessenger = InputMessenger.using(outputMessenger);

    public String receivePayment() {
        String userInput = inputMessenger.receivePayment();
        validateForm(userInput, InputErrorMessage.PAYMENT);
        return userInput;
    }

    public void printLottoTicketsOrder(LottoTickets tickets) {
        outputMessenger.printOrderMessage(tickets.size());
        outputMessenger.printLottoTicketsMessage(tickets);
    }

    public String receiveWinningNumbers() {
        String userInput = inputMessenger.receiveWinningNumbers();
        validateForm(userInput, InputErrorMessage.WINNING_NUMBERS);
        return userInput;
    }

    public String receiveBonusNumber() {
        String userInput = inputMessenger.receiveBonusNumber();
        validateForm(userInput, InputErrorMessage.BONUS_NUMBER);
        return userInput;
    }

    public void printStatistics(RankingTable table) {
        outputMessenger.printStatisticsIntro();
        table.getEntryByAscendingRanking()
                .stream()
                .map(this::createFigures)
                .forEach(outputMessenger::printStatisticsByAscendingRanking);
    }

    private List<String> createFigures(Map.Entry<Ranking, Frequency> entry) {
        Ranking value = entry.getKey();
        Frequency frequency = entry.getValue();
        return List.of(value.getNumberOfMatching(), value.getCashInDecimalFormat(), frequency.toString());
    }

    public void printRateOfReturn(RankingTable table, Payment money) {
        outputMessenger.printRateOfReturnMessage(table.calculateRateOfReturn(money));
    }

    public void printErrorMessage(String error) {
        outputMessenger.printErrorMessage(error);
    }

    private void validateForm(String userInput, InputErrorMessage value) {
        if (!userInput.matches(value.getRegularExpression())) {
            throw new IllegalArgumentException(value.getErrorMessage());
        }
    }
}
