package lotto.controller;

import lotto.service.LottoMachine.LotteryNumbersDraw;
import lotto.service.LottoMachine.LotteryResult;
import lotto.service.LottoMachine.LotteryTicketsIssuance;
import lotto.view.InputView;

public class LottoController {

    LotteryTicketsIssuance ticketsIssue = new LotteryTicketsIssuance(InputView.getAmountInput());

    // 금액 받아와서 티켓 발급하기 (값 검증)
    private void issueTickets() {
        try {
            InputView.printTicketCounts(ticketsIssue.getAmount());
            ticketsIssue.setTickets();
            InputView.printTickets(ticketsIssue.getTickets());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    // 발급한 티켓으로 결과 값 판단
    // 티켓, 보너스 넘버 여기서 validate
    // 통계를 만들어서 view 로 넘겨줌
    private void getResult() {
        LotteryNumbersDraw lotteryNumbersDraw = new LotteryNumbersDraw(InputView.drawLotteryNumbers());
        LotteryResult lotteryResult = new LotteryResult(ticketsIssue.getTickets(), lotteryNumbersDraw.getDrawNumbers());
        lotteryResult.setScores(InputView.drawBonusNumber());
    }
}
