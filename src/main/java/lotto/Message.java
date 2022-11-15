package lotto;

public class Message {
    public static void requestPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void printPurchaseAmount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }
}
