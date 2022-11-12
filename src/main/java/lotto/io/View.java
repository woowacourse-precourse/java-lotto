package lotto.io;

import lotto.model.Lotto;

import java.util.List;

public class View {
    private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String GET_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final Input input;
    private final Output output;

    public View(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void requestAmount() {
        output.printOutput(REQUEST_PURCHASE_AMOUNT);
    }

    public String getInput() {
        return input.input();
    }

    public void showLotto(List<Lotto> lottos) {
        showCount(lottos.size());
        lottos.forEach(lotto -> output.printOutput(lotto.toString()));
    }

    private void showCount(int count) {
        output.printOutput(count + PURCHASE_MESSAGE);
    }

    public void requestNumbers() {
        output.printOutput(GET_LOTTO_NUMBER);
    }

    public void requestBonus() {
        output.printOutput(GET_BONUS_NUMBER);
    }

    public void printError(String message) {
        output.printOutput(message);
    }
}

