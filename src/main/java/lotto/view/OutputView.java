package lotto.view;

public class OutputView {
    private static OutputView instance;

    private OutputView() {}

    public OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }

        return instance;
    }

    public void printNumberOfLottos(int numberOfLottos) {
        System.out.println();
        System.out.println(numberOfLottos + "개를 구매했습니다.");
    }
}
