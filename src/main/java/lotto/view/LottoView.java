package lotto.view;

import lotto.model.LottoIssuingMachine;
import lotto.model.LottoWinningStatistics;

public class LottoView {

    private static LottoView instance;

    private LottoView() {}

    public static LottoView getInstance() {
        if (instance == null) instance = new LottoView();
        return instance;
    }

    public void printPurchaseMoneyInputCommand() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printIssuedLottoDetails(LottoIssuingMachine issuingMachine) {
        System.out.println(issuingMachine);
    }

    public void printWinningNumbersInputCommand() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberInputCommand() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatistics(LottoWinningStatistics winningStatistics) {
        System.out.println("당첨 통계\n" + "---");
        System.out.println(winningStatistics);
    }
}
