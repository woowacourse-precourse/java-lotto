package lotto.view.output;

public class Guide {
    public void printInputPriceGuide() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoCount(long lottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }

    public void printInputLottoGuide() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusGuide() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

}
