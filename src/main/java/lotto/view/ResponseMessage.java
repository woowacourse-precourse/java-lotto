package lotto.view;

public class ResponseMessage {
    static StringBuilder responseMessage = new StringBuilder();

    public static void initStringBuilder() {
        responseMessage.setLength(0);
        responseMessage.append('\n');
    }
}
