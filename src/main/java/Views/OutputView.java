package Views;

public class OutputView {
    public static final OutputView OUTPUT_VIEW = new OutputView();

    public void PrintPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void PrintCountPurchasingLotto(int readLine) {
        System.out.println(readLine + "개를 구매했습니다.");
    }
}
