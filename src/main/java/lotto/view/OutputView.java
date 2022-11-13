package lotto.view;

public class OutputView {
    private static final String PRINT_LOTTO_COUNT = "%d개를 구매했습니다.";
    public static void printPurchaseLotto(int lottoCount){
        System.out.printf(PRINT_LOTTO_COUNT,lottoCount);
    }
}
