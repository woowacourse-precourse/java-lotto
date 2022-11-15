package lotto.view;

public class OutputView {
    private static OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }
}
