package lotto.view.output;

public class LottoPrinter {

    public void printGuideMessageForPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    // 발행한 로또 수량을 출력한다.
    public void printTheNumberOfLottos(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    // 발행한 로또 번호를 출력한다.
    public void printLottoNumbers(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void printGuideMessageForWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printGuideMessageForBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }


    // 당첨 통계를 출력한다.
    public void printWinningStatistics(String resultsFormat, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(resultsFormat);
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    // 예외 출력
    public void printError(String message) {
        System.out.println("[ERROR]" + message);
    }
}
