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
        //TODO: 발행된 로또 내역 출력
    }

    public void printWinningNumbersInputCommand() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberInputCommand() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatistics(LottoWinningStatistics winningStatistics) {
        //TODO: 로또 당첨 통계 출력
    }
}
