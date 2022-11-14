package lotto;

public class OutputView {
    private static final String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.";

    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(String.format(LOTTO_PURCHASE_MESSAGE, lottoCount));
    }

    public static void printLotto(String lotto) {
        System.out.println(lotto);
    }
}