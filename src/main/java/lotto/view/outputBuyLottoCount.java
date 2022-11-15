package lotto.view;

public class outputBuyLottoCount {
    private static final String OUTPUT_MESSAGE = "%d개를 구매했습니다.";

    public static void printBuyLotto(int buyLottoCount) {
        System.out.printf((OUTPUT_MESSAGE) + "%n", buyLottoCount);
    }
}
