package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoDrawingMachine;
import lotto.model.LottoIssuingMachine;
import lotto.model.LottoWinningStatistics;
import lotto.view.LottoView;

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
        int purchaseMoney = Integer.parseInt(Console.readLine()); //TODO: 구입금액 입력 !예외처리
        issuingMachine.issue(purchaseMoney);
        lottoView.printIssuedLottoDetails(issuingMachine);
    }

    protected void drawLotto() {
        lottoView.printWinningNumbersInputCommand();
        //TODO: 당첨 번호 문자열 입력 !예외처리, List<Integer> winningNumbers = inputWinningNumbers();
        //TODO: 당첨 번호 확정 !예외처리, drawingMachine.setWinningNumbers(winningNumbers);

        lottoView.printBonusNumberInputCommand();
        //TODO: 보너스 번호 문자열 입력 !예외처리, Integer bonusNumber = inputBonusNumber();
        //TODO: 보너스 번호 확정 !예외처리, drawingMachine.setBonusNumber(bonusNumber);
    }

    protected void generateStatistics() {
        //TODO: 로또 당첨 통계 내기, winningStatistics.generate(issuingMachine.getLottos(), drawingMachine.getWinningNumbers(), drawingMachine.getBonusNumber());
        lottoView.printWinningStatistics(winningStatistics);
    }
}
