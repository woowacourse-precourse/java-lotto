package lotto.io;

import lotto.model.Lotto;

import java.util.List;

public class View {
    private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WRONG_PURCHASE_AMOUNT = "[ERROR] 1000 단위만 입력할 수 있습니다.";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private final Input input;
    private final Output output;

    public View(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void requestPurchaseAmount() {
        output.printOutput(REQUEST_PURCHASE_AMOUNT);
    }

    public int getPurchaseAmount() {
        int inputAmount = Integer.parseInt(input.input());
        checkThousand(inputAmount);
        return inputAmount;
    }

    private void checkThousand(int inputAmount) {
        if (inputAmount % 1000 != 0) {
            throw new IllegalArgumentException(WRONG_PURCHASE_AMOUNT);
        }
    }

    public void showLotto(List<Lotto> lottos) {
        showCount(lottos.size());
        lottos.forEach(lotto -> output.printOutput(lotto.toString()));
    }

    private void showCount(int count){
        output.printOutput(count+PURCHASE_MESSAGE);
    }
}

