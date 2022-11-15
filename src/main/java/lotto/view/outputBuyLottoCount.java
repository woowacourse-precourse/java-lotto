package lotto.view;

public class outputBuyLottoCount {
    private static final String OUTPUT_MESSAGE = "%d개를 구매했습니다.";

    public static String printBuyLotto(int buyLottoCount) {
        return String.format(OUTPUT_MESSAGE, buyLottoCount);
    }
}
