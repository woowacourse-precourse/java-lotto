package lotto.view;

public class OutputView {
    private static final String LOTTO_ISSUE_MESSAGE = "%d개를 구매했습니다.";

    public static void printNumberOfIssuedLotto(int lottoNumbers) {
        printEmptyLine();
        System.out.println(String.format(LOTTO_ISSUE_MESSAGE, lottoNumbers));
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
