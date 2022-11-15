package lotto.view;

import java.util.List;

public class OutputView {
    private static final String ERROR_HEADER = "[ERROR] ";

    public static void printPurchaseResult(List<List<Integer>> purchaseResult) {
        System.out.printf("%n%d���� �����߽��ϴ�.%n", purchaseResult.size());
        for (List<Integer> lottoNumbers : purchaseResult) {
            System.out.println(lottoNumbers);
        }
    }

    public static void printWinningResult(List<String> winningResults) {
        System.out.println("\n��÷ ���\n---");
        for (String winningResult : winningResults) {
            System.out.println(winningResult);
        }
    }

    public static void printProfitRate(String profitRate) {
        System.out.printf("�� ���ͷ��� %s�Դϴ�.", profitRate);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_HEADER + errorMessage);
    }
}