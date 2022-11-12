package lotto.io;

public class View {
    private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final Input input;
    private final Output output;

    public View(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void requestPurchaseAmount() {
        output.printOutput(REQUEST_PURCHASE_AMOUNT);
    }

    public String getPurchaseAmount() {
        return input.input();
    }
}
