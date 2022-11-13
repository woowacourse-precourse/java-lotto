package view;

public class OutputMessage {
    private static final String NUMBER_OF_PURCHASE = "개를 구매했습니다.";
    private static final String STATISTICS = "당첨 통계";
    private static final String DIVIDING_LINE = "---";
    private static final String MATCH_COUNT = "개 일치 (";
    private static final String MATCH_COUNT_WITH_BOUNUS = "개 일치 , 보너스 볼 일치 (";
    private static final String REWARD = "원) - ";
    private static final String NUMBER_OF_MATCHES = "개";

    public void printNumberOfPurchase(int purchaseNumber) {
        System.out.println("\n" + purchaseNumber + NUMBER_OF_PURCHASE);
    }

    public void printPurchaseLotto(String purchaseLotto) {
        System.out.println(purchaseLotto);
    }
}
