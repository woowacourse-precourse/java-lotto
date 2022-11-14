package lotto;

public class LottoStore {
    private int money;
    private int purchaseNumber;

    public void printInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void makePurchaseNumber(int money) {
        this.money = money;
        purchaseNumber = money / 1000;
    }
}
