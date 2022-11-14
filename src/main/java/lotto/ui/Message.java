package lotto.ui;

public class Message {

    private static final String INPUT_PRICE_MESSAGE = "구입 금액을 입력하세요.";
    private static final String INPUT_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요";

    public void INPUT_PRCIE_MESSAGE() {
        System.out.println(INPUT_PRICE_MESSAGE);
    }

    public void INPUT_NUMBER_MESSAGE() {
        System.out.println(INPUT_NUMBER_MESSAGE);
    }

    public void INPUT_BONUS_NUMBER_MESSAGE() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }
}
