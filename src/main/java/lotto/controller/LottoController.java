package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void start() {
        // 금액 입력 받음
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        System.out.println();
        // 로또 n장 생성 (1장 당 6자리 숫자 랜덤 생성) -> Lotto.java
        LottoTicket lottoTicket = getTickets(purchaseAmount);
        Output.printTicketsList(purchaseAmount, lottoTicket);
        // 당첨 번호 입력 받음
        WinningBonusNumber winningBonusNumber = inputWinningBonusNumber();
        // 결과 생성
        Result result = getResult(lottoTicket, winningBonusNumber);
        // 결과 출력
        printResult(result, purchaseAmount);
    }

    private PurchaseAmount inputPurchaseAmount() {
        return new PurchaseAmount(Input.getInputPurchaseAmount());
    }

    private int calculateTicketNumber(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getPurchaseAmount() / purchaseAmount.getUNIT_PRICE();
    }

    private LottoTicket getTickets(PurchaseAmount purchaseAmount) {
        int ticketNumber = calculateTicketNumber(purchaseAmount);

        LottoTicket lottoTicket = new LottoTicket(ticketNumber);

        return lottoTicket;
    }

    private WinningBonusNumber inputWinningBonusNumber() {
        String inputWinningNumbers = Input.getInputWinningNumber();
        List<Integer> winningNumbers = makeStringToList(inputWinningNumbers);
        System.out.println();

        int inputBonusNumber = Input.getInputBonusNumber();
        System.out.println();

        WinningBonusNumber winningBonusNumber = new WinningBonusNumber(winningNumbers, inputBonusNumber);

        return winningBonusNumber;
    }

    private List<Integer> makeStringToList(String inputWinningNumbers) {
        List<Integer> numbers = new ArrayList<>();
        String[] inputNumbers = inputWinningNumbers.split(",");

        for (int index = 0; index < inputNumbers.length; index++) {
            int number = Integer.parseInt(inputNumbers[index]);
            numbers.add(number);
        }

        return numbers;
    }

    private Result getResult(LottoTicket lottoTicket, WinningBonusNumber winningBonusNumber) {
        List<Ranking> rankingResults = Calculator.calculateTicketRankings(lottoTicket, winningBonusNumber);
        Result result = new Result(rankingResults);

        return result;
    }

    private void printResult(Result result, PurchaseAmount purchaseAmount) {
        Output.printTitle();
        Output.printWinningStatistic(result);
        Output.printYield(purchaseAmount.divideTotalMoneyByAmount(result.calculateTotalMoney()));
    }

}
