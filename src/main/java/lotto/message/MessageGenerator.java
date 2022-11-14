package lotto;

public class MessageGenerator {
    private static final String PURCHASE_COUNT_MESSAGE_TEMPLATE = "개를 구매했습니다.";

    public static String getPurchaseCountMessage(Integer count) {
        return count + PURCHASE_COUNT_MESSAGE_TEMPLATE;
    }
}
