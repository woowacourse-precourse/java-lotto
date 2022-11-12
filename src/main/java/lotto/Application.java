package lotto;

import static lotto.domain.model.ErrorMessage.printErrorMessage;

public class Application {
    public static void main(String[] args) {
        try {
            LottoProgram.getInstance().start();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
        }
    }
}
