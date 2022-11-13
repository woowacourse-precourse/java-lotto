package lotto.controller;

import lotto.service.Calculator;
import lotto.domain.*;
import lotto.exception.LottoException;
import lotto.service.CompareLotto;
import lotto.service.Convertor;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Machine {
    private List<Lotto> lottos;
    private List<Rank> ranks;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void start() {
        try {
            issueLotto();
            getWinningNumbersAndBonusNumber();
            ranks = RankGenerator.getRanks();
            CompareLotto.compare(ranks, lottos, winningNumbers, bonusNumber);
            printResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getWinningNumbersAndBonusNumber() {
        winningNumbers = Convertor.getNumbers(InputView.winningNumbers());
        bonusNumber = Convertor.getNumber(InputView.bonusNumber());
        LottoException.validDuplication(winningNumbers, bonusNumber);
    }

    private void issueLotto() {
        int quantity = Convertor.getQuantity(InputView.amount());
        lottos = LottoGenerator.getLottos(quantity);
        OutputView.showLottoNumber(lottos);
    }

    private void printResult() {
        OutputView.result(ranks, Calculator.getYield(ranks, lottos.size()));
    }
}
