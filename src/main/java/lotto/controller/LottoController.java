package lotto.controller;

import lotto.io.Input;
import lotto.io.Output;
import lotto.message.LottoMessage;
import lotto.message.WinningMessage;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {

    private final static Input input = new Input();
    private final static Output output = new Output();
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }
    public void run() {
        int lottoCount = inputPurchaseMoney();
        List<List<Integer>> lottoNumbersList = lottoService.makeRandomLottoNumbers(lottoCount);
        printUserLottoNumber(lottoNumbersList, lottoCount);
        List<Integer> winningNumberList = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumberList);
        int[] ranks = lottoService.compareUserNumbersAndWinningNumber(lottoNumbersList, winningNumberList, bonusNumber);
        printRanks(ranks);
        calculateProfit(ranks, lottoCount);

    }
    private int inputPurchaseMoney() {
        int lottoCount = input.inputPurchaseMoney();
        return lottoCount;
    }

    private List<Integer> inputWinningNumbers() {
        output.printMessageWithEnter(LottoMessage.INPUT_WINNING_MONEY);
        List<Integer> winningNumberList = input.inputWinningNumbers();
        return winningNumberList;
    }

    private void printUserLottoNumber(List<List<Integer>> lottoNumbersList, int lottoCount) {
        output.printMessageWithEnter(lottoCount + LottoMessage.LOTTO_QUANTITY_MESSAGE);
        for(List<Integer> lottoList : lottoNumbersList) {
            printEachUserLottoNumbers(lottoList);
        }
        output.printEnter();
    }

    private int inputBonusNumber(List<Integer> winningNumberList) {
        output.printMessageWithEnter(LottoMessage.INPUT_BONUS_MONEY);
        int bonusNumber = input.inputBonusNumber(winningNumberList);
        return bonusNumber;
    }

    private void printEachUserLottoNumbers(List<Integer> lottoList) {
        int len = lottoList.size();
        output.printMessageWithoutEnter("[");
        for(int num = 0; num < len; num++) {
            output.printMessageWithoutEnter(lottoList.get(num));
            if(num != len - 1) {
                output.printMessageWithoutEnter(", ");
            }
        }
        output.printMessageWithEnter("]");
    }

    private void printRanks(int[] ranks) {
        output.printMessageWithEnter(LottoMessage.AVERAGE);
        output.printMessageWithEnter(WinningMessage.FIFTH_WINNING + ranks[5] + WinningMessage.COUNT);
        output.printMessageWithEnter(WinningMessage.FORTH_WINNING + ranks[4] + WinningMessage.COUNT);
        output.printMessageWithEnter(WinningMessage.THIRD_WINNING + ranks[3] + WinningMessage.COUNT);
        output.printMessageWithEnter(WinningMessage.SECOND_WINNING + ranks[2] + WinningMessage.COUNT);
        output.printMessageWithEnter(WinningMessage.FIRST_WINNING + ranks[1] + WinningMessage.COUNT);
    }

    private void calculateProfit(int[] ranks, int lottoCount) {
        String result = lottoService.calculateProfit(ranks, lottoCount);
        printProfitResult(result);
    }

    private void printProfitResult(String result) {
        output.printMessageWithEnter("총 수익률은 " + result + "%입니다.");
    }
}
