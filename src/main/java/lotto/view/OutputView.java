package lotto.view;

public class OutputView {

    public static final String PRINT_PURCHASE_DETAILS_DESCRIPTION = "개를 구매했습니다.";
    public static final String PRINT_RESULT_DESCRIPTION = "당첨 통계\n---";
    public static final String PRINT_PROFIT_RATE_DESCRIPTION = "총 수익률은 %s입니다.%n";

    private OutputView() {
    }

    public static void printPurchaseDetails(int count,String purchaseDetails){
        System.out.println(count+ PRINT_PURCHASE_DETAILS_DESCRIPTION);
        System.out.println(purchaseDetails);
    }

    public static void printResult(String result) {
        System.out.println(PRINT_RESULT_DESCRIPTION);
        System.out.println(result);
    }

    public static void printProfitRate(String profitRate) {
        System.out.printf(PRINT_PROFIT_RATE_DESCRIPTION, profitRate);
    }
}
