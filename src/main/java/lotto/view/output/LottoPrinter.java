package lotto.view.output;

import java.util.List;

public class LottoPrinter {

    public void printGuideMessageForPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    // 발행한 로또 수량을 출력한다.
    public void printTheNumberOfLottos(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    // 발행한 로또 번호를 출력한다.
    public void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void printGuideMessageForWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printGuideMessageForBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }


    // 당첨 통계를 출력한다.
    public void printWinningStatistics(String resultsFormat, int rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(resultsFormat);
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    // 예외 메세지를 출력한다.
    public void printError(String errorMessage) {
        System.out.println("[ERROR]" + errorMessage);
    }
}
