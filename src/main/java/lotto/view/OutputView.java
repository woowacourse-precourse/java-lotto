package lotto.view;


public class OutputView {

    private final String PURCHASE_COUNT = "개를 구매했습니다.";

    public void printPurchaseLotto(int ticketCnt) {
        System.out.println(ticketCnt + PURCHASE_COUNT);
    }


}
