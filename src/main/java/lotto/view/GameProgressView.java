package lotto.view;

public class GameProgressView {
    public static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String COUNT_MESSAGE = "개를 구매했습니다.";

    public static void showPurchaseMessage() {
        System.out.println(PURCHASE_MESSAGE);
    }

    public static void showCountMessage(int count){
        System.out.println(count+COUNT_MESSAGE);
    }
}
