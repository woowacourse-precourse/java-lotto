package lotto.view.output;

import static lotto.view.output.StringFormatter.errorMessageFormat;
import static lotto.view.output.StringFormatter.purchasedNumberOfLottosFormat;
import static lotto.view.output.StringFormatter.resultStatisticsFormat;

public class LottoPrinter {

    public void printGuideMessageForPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printTheNumberOfPurchaseLottos(int number) {
        System.out.println(purchasedNumberOfLottosFormat(number));
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

    public void printWinningStatistics(String lottoResults, double rateOfReturn) {
        System.out.println(resultStatisticsFormat(lottoResults, rateOfReturn));
    }

    public void printError(String message) {
        System.out.println(errorMessageFormat(message));
    }
}
