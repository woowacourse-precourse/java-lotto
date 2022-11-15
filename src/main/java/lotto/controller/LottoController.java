package lotto.controller;

import lotto.service.LottoMachine.LotteryNumbersDraw;
import lotto.service.LottoMachine.LotteryResult;
import lotto.service.LottoMachine.LotteryTicketsIssuance;
import lotto.service.validation.AmountValidation;
import lotto.service.validation.LotteryNumberValidation;
import lotto.service.validation.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private List<List<Integer>> tickets;
    private Map<Integer, Integer> rank;
    private double yield;

    public void run() {
        try {
            issueTickets();
            drawLottery();
            getRank();
            printResult();
        } catch (IllegalArgumentException e ) {
            System.out.println(e.getMessage());
        }
    }

    // 금액 받아와서 티켓 발급하기 (값 검증)
    private void issueTickets() {
            int amount = InputView.getAmountInput();
            AmountValidation.isValidAmount(amount);
            InputView.printTicketCounts(amount);
            LotteryTicketsIssuance ticketsIssue = new LotteryTicketsIssuance(amount);
            ticketsIssue.setTickets();
            List<List<Integer>> tickets = ticketsIssue.getTickets();
            InputView.printTickets(tickets);
            this.tickets = tickets;

    }


    private void drawLottery() {
        String rawWinningNumbers = InputView.drawLotteryNumbers();
        LotteryNumbersDraw draw = new LotteryNumbersDraw(rawWinningNumbers);
        List<Integer> splitString = draw.getDrawNumbers();
        Lotto lotto = new Lotto(splitString);
        List<Integer> winningNumbers = lotto.getWinningNumbers();
        LotteryResult lotteryResult = new LotteryResult(getTickets(), winningNumbers);
        int bonusNumber = InputView.drawBonusNumber();
        LotteryNumberValidation bonusValidation = new LotteryNumberValidation(winningNumbers, bonusNumber);
        lotteryResult.setScores(bonusValidation.getBonus());
        Map<Integer, Integer> rank = lotteryResult.getScoresCount();
        this.rank = rank;
        lotteryResult.setYield(rank);
        this.yield = lotteryResult.getYield();
    }

    private void printResult() {
        ResultView.printHeader();
        ResultView.printRanks(getRank(), getYield());
    }

    private List<List<Integer>> getTickets() {
        return tickets;
    }

    private Map<Integer, Integer> getRank() {
        return rank;
    }

    public double getYield() {
        return yield;
    }
}
