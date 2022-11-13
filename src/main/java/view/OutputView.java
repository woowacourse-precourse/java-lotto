package view;

import static lotto.constant.Message.ERROR_MESSAGE;

public class OutputView {
    public void getErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
}
