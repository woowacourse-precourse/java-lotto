package lotto;

public class UI {
    static final String LOTTO_PRICE = "구입금액을 입력해 주세요.";
    static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    static final String WINNING_MESSAGE = "당첨 통계";

    public void lottoPrice() {
        System.out.println(LOTTO_PRICE);
    }

    public void winningNumber() {
        System.out.println(WINNING_NUMBER);
    }

    public void bonusNumber() {
        System.out.println(BONUS_NUMBER);
    }

    public void winningMessage() {
        System.out.println(WINNING_MESSAGE);
        System.out.println("---");
    }
}
