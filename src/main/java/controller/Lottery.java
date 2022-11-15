package controller;

import common.regulation.NumberRule;
import domain.Lotto;
import domain.Rank;
import exception.InputException;
import service.Calculator;

import camp.nextstep.edu.missionutils.Randoms;
import service.Comparison;
import service.Extraction;

import java.util.ArrayList;
import java.util.List;

public class Lottery {

    private List<Integer> winningNumbers;
    private int bonusNumber;
    private List<Lotto> lottos;
    private List<Rank> ranks;

    public void start() {
        try {
            purchaseLottos();
            Output.outputPurchaseLottosResult(lottos);
            getWinningNumbers();
            getBonusNumbers();
            ranks = Rank.getRanks();
            Comparison.compareLottos(ranks, lottos, winningNumbers, bonusNumber);
            printResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void purchaseLottos() {
        int quantity = Calculator.getQuantity(Input.inputAmount());
        this.lottos = getLottos(quantity);
    }

    public List<Lotto> getLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        while (quantity-- > 0) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(
                    NumberRule.NUMBER_RANGE_START.getValue(),
                    NumberRule.NUMBER_RANGE_END.getValue(),
                    NumberRule.LOTTO_ONE_SIZE.getValue())));
        }

        return lottos;
    }

    public void getWinningNumbers() {
        this.winningNumbers = Extraction.extractWinningNumbers(Input.inputWinningNumbers());
    }

    public void getBonusNumbers() {
        this.bonusNumber = InputException.validateBonusNumber(Input.inputBonusNumber());
    }

    public void printResult() {
        Output.printResult(ranks, lottos.size());
    }

}
