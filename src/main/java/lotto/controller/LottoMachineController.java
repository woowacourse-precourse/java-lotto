package lotto.controller;

import lotto.domain.lottomachine.lottoticket.LottoTicketSystem;
import lotto.domain.lottomachine.lottoticket.LottoTickets;
import lotto.domain.lottomachine.payment.Payment;
import lotto.domain.lottomachine.ranking.RankingTable;
import lotto.domain.lottomachine.ranking.RankingTableSystem;
import lotto.domain.lottomachine.winningnumber.WinningNumber;
import lotto.domain.lottomachine.winningnumber.WinningNumberSystem;
import lotto.domain.lottomachine.winningnumber.WinningNumbers;

public class LottoMachineController {
    private final InputOutputController inputOutputController;

    public LottoMachineController() {
        this.inputOutputController = new InputOutputController();
    }

    public void runMainLottoMachine() {
        try {
            runLottoMachine();
        } catch (IllegalArgumentException | ArithmeticException e) {
            printErrorMessage(e);
        }
    }

    private void runLottoMachine() {
        Payment money = receivePayment();
        LottoTickets tickets = issueTicketsWith(money);

        WinningNumbers winningNumbers = receiveWinningNumbers();
        WinningNumber bonusNumber = receiveBonusNumber(winningNumbers);

        RankingTableSystem system = createRankingTableSystem(winningNumbers, bonusNumber);
        RankingTable table = createRankingTable(tickets, system);

        printResult(table, money);
    }

    private Payment receivePayment() {
        String userInput = inputOutputController.receivePayment();
        return Payment.from(toInt(userInput));
    }

    private int toInt(String word) {
        return Integer.parseInt(word);
    }

    private LottoTickets issueTicketsWith(Payment money) {
        LottoTicketSystem lottoTicketSystem = LottoTicketSystem.getInstance();
        LottoTickets tickets = lottoTicketSystem.issueLottoTickets(money);
        inputOutputController.printLottoTicketsOrder(tickets);
        return tickets;
    }

    private WinningNumbers receiveWinningNumbers() {
        String userInput = inputOutputController.receiveWinningNumbers();
        WinningNumberSystem winningNumberSystem = WinningNumberSystem.getInstance();
        return winningNumberSystem.createWinningNumbers(userInput);
    }

    private WinningNumber receiveBonusNumber(WinningNumbers winningNumbers) {
        String userInput = inputOutputController.receiveBonusNumber();
        WinningNumberSystem winningNumberSystem = WinningNumberSystem.getInstance();
        return winningNumberSystem.creativeBonusNumber(userInput, winningNumbers);
    }

    private RankingTable createRankingTable(LottoTickets tickets, RankingTableSystem system){
        return system.createRankingTable(tickets);
    }

    private RankingTableSystem createRankingTableSystem(WinningNumbers winningNumbers, WinningNumber bonusNumber) {
        return RankingTableSystem.of(winningNumbers, bonusNumber);
    }

    private void printResult(RankingTable table, Payment money) {
        inputOutputController.printStatistics(table);
        inputOutputController.printRateOfReturn(table, money);
    }

    private void printErrorMessage(RuntimeException e) {
        inputOutputController.printErrorMessage(e.getMessage());
    }
}
