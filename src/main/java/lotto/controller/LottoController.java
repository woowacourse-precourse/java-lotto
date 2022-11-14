package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoDrawingMachine;
import lotto.model.LottoIssuingMachine;
import lotto.model.LottoWinningStatistics;
import lotto.view.LottoView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.LottoConstant.*;

public class LottoController {

    private final LottoIssuingMachine issuingMachine;
    private final LottoDrawingMachine drawingMachine;
    private final LottoWinningStatistics winningStatistics;
    private final LottoView lottoView;

    public LottoController(LottoIssuingMachine issuingMachine, LottoDrawingMachine drawingMachine,
                           LottoWinningStatistics winningStatistics, LottoView lottoView) {
        this.issuingMachine = issuingMachine;
        this.drawingMachine = drawingMachine;
        this.winningStatistics = winningStatistics;
        this.lottoView = lottoView;
    }

    public void play() {
        purchaseLottos();
        drawLotto();
        generateStatistics();
    }

    protected void purchaseLottos() {
        lottoView.printPurchaseMoneyInputCommand();
        int purchaseMoney = inputPurchaseMoney();
        issuingMachine.issue(purchaseMoney);
        lottoView.printIssuedLottos(issuingMachine);
    }

    private int inputPurchaseMoney() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_ONLY_NUMBER);
        }
    }

    protected void drawLotto() {
        lottoView.printWinningNumbersInputCommand();
        List<Integer> winningNumbers = inputWinningNumbers();
        lottoView.printBonusNumberInputCommand();
        Integer bonusNumber = inputBonusNumber();
        drawingMachine.draw(winningNumbers, bonusNumber);
    }

    private List<Integer> inputWinningNumbers() {
        return parseNumbers(Console.readLine(), ",");
    }

    private List<Integer> parseNumbers(String token, String separator) {
        try {
            return Arrays.stream(token.split(separator))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_ONLY_NUMBER_COMMA);
        }
    }

    private Integer inputBonusNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_ONLY_NUMBER);
        }
    }

    protected void generateStatistics() {
        winningStatistics.generate(issuingMachine, drawingMachine);
        lottoView.printWinningStatistics(winningStatistics);
    }
}
