package lotto.messages;

public class PrintMessage {

    public static String createPurchaseQuantityMsg(int quantity) {
        return String.format("%d개를 구매했습니다.", quantity);
    }
}
