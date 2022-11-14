package lotto;

public class Ui {

    public static void inputMoneyOutUi() {
        System.out.println("구입금액을 입력해 주세요");
    }
    public static void numberOfPurchaseUi(int purchaseMoney) {
        int purchaseAmount = purchaseMoney/1000;
        System.out.println(purchaseAmount +"개를 구매했습니다.");
    }

}
