package lotto;

import lotto.veiw.ViewHandler;

public class Application {

    public static void main(String[] args) {
        ViewHandler viewHandler = new ViewHandler();
        try {
            viewHandler.inputMoney();
            viewHandler.inputLottoWithBonus();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
