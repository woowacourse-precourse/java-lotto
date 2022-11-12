package lotto.view.output;

public class LottoPrinter {

    public void printMessage(String serviceMessage) {
        System.out.println(serviceMessage);
    }

    public void printGuideMessageForPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printGuideMessageForWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printGuideMessageForBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
