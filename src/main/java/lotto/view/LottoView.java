package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoIssuingMachine;
import lotto.model.LottoWinningStatistics;

import java.util.List;

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
        List<Lotto> lottos = issuingMachine.getLottos();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
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
