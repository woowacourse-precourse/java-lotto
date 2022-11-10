package lotto.domain.view;

public class OutputView {
    private static final String BUY_LOTTO = "%d개를 구매했습니다.";
    public static void printCountByBuyLotto(int lottoCount) {
        System.out.printf((BUY_LOTTO) + "%n", lottoCount);
    }
}
