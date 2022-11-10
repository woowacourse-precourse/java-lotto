package lotto.view;

public class OutputView {

    private OutputView() {
    }

    public static void printPurchaseDetails(int count,String purchaseDetails){
        System.out.println(count+"개를 구매했습니다.");
        System.out.println(purchaseDetails);
    }

    public static void printResult(String result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(result);
    }

    public static void printProfitRate(String profitRate) {
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }
}
