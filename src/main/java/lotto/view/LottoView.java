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

    public void printIssuedLottos(LottoIssuingMachine issuingMachine) {
        System.out.println("\n" + issuingMachine.getNumberOfIssuedLottos() + "개를 구매했습니다.");
        System.out.println(issuingMachine);
    }

    public void printWinningNumbersInputCommand() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberInputCommand() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatistics(LottoWinningStatistics winningStatistics) {
        System.out.println("\n당첨 통계\n" + "---");
        System.out.print(winningStatistics);
        System.out.println("총 수익률은 " + String.format("%.1f", winningStatistics.getEarningsRate()) + "%입니다.");
    }
}
