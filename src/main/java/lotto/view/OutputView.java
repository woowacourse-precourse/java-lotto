package lotto.view;

public class OutputView {

    private static final String ERROR_HEAD_MESSAGE = "[ERROR]";

    private OutputView() {
    }

    public static void printException(Exception exception) {
        System.out.println(ERROR_HEAD_MESSAGE + exception.getMessage());
    }
}
