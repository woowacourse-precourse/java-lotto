package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoDrawingMachine;
import lotto.model.LottoIssuingMachine;
import lotto.model.LottoWinningStatistics;
import lotto.view.LottoView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private final LottoIssuingMachine issuingMachine;
    private final LottoDrawingMachine drawingMachine;
    private final LottoWinningStatistics winningStatistics;
    private final LottoView lottoView;

    public LottoGame(LottoIssuingMachine issuingMachine, LottoDrawingMachine drawingMachine,
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
        lottoView.printIssuedLottoDetails(issuingMachine);
    }

    private int inputPurchaseMoney() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만을 입력해야 합니다.");
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
            throw new IllegalArgumentException("[ERROR] 쉼표(,)와 숫자만을 입력해야 합니다.");
        }
    }

    private Integer inputBonusNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만을 입력해야 합니다.");
        }
    }

    protected void generateStatistics() {
        //TODO: 로또 당첨 통계 내기, winningStatistics.generate(issuingMachine.getLottos(), drawingMachine.getWinningNumbers(), drawingMachine.getBonusNumber());
        lottoView.printWinningStatistics(winningStatistics);
    }
}
