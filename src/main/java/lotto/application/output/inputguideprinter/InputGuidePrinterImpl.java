package lotto.application.output.inputguideprinter;

public class InputGuidePrinterImpl implements InputGuidePrinter {

    @Override
    public void inputPurchaseMoneyGuide() {
        System.out.println("구매금액을 입력해 주세요.");
    }

    @Override
    public void finalPurchaseLottoCountGuide(int purchaseMoney) {
        System.out.printf("\n%d개를 구매했습니다.\n", purchaseMoney / 1000);
    }

    @Override
    public void inputWinningNumberGuide() {
        System.out.println("\n당첨 번호를 입력해주세요.");
    }

    @Override
    public void inputBonusNumberGuide() {
        System.out.println("\n보너스 번호를 입력해주세요.");
    }
}
