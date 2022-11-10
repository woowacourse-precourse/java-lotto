package lotto.view;

public class OutputView {

    private static final String NUMBER_OF_LOTTOS_PHRASE = "%d개를 구매했습니다.";

    public OutputView() {
    }

    public static void printNumberOfLottos(int numberOfLottos) {
        System.out.printf(NUMBER_OF_LOTTOS_PHRASE, numberOfLottos);
    }
}
