package lotto;

public class Application {
    public static void main(String[] args) {
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        LottoCount lottoCount = new LottoCount();
        System.out.println(lottoCount + "개를 구매했습니다.");
        LottoManager lottoManager = new LottoManager();

    }
}
