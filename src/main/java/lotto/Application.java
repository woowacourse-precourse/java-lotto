package lotto;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Message.requestPurchase();
        int lottoCount = user.inputAmount();
    }
}
