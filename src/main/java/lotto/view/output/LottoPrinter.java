package lotto.view.output;

import lotto.domain.winning.WinningStatistics;

public class LottoPrinter {

    public void printGuideMessageForPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printTheNumberOfPurchaseLottos(int number, String suffix) {
        System.out.println(number + suffix);
    }

    public void printLottoNumbers(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void printGuideMessageForWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printGuideMessageForBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println(winningStatistics);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
