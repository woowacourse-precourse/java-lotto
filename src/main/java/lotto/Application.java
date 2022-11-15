package lotto;

import lotto.logic.LottoMain;
import lotto.view.ErrorView;

public class Application {
    public static void main(String[] args) {
        try {
            LottoMain.lotto();
        } catch (IllegalArgumentException exception) {
            String message = ErrorView.getErrorMessage(exception);
            System.out.println(message);
        }
    }
}
