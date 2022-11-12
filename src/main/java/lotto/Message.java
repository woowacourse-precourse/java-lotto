package lotto;

public class Message {
    public void printPurchaseMsg() {
        printMsg("구입금액을 입력해 주세요.");
    }

    public void printMsg(String msg) {
        System.out.println(msg);
    }
}
