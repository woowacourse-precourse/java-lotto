package lotto;

public class Application {
    public static void main(String[] args) {
        View.Output("구입금액을 입력해 주세요.");
        String inputLottoAmount = View.Input();
    }
}
