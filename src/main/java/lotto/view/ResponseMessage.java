package lotto.view;

public class ResponseMessage {
    static StringBuilder responseMessage = new StringBuilder();

    public static void initStringBuilder() {
        responseMessage.setLength(0);
        responseMessage.append('\n');
    }

    public static void printPurchaseMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
    }
}
