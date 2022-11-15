package lotto;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Message.requestPurchase();
        int lottoCount = user.inputPrice();
        Message.printPurchaseAmount(lottoCount);
        user.purchaseLotto(lottoCount);
        LottoGenerator lottoGenerator = new LottoGenerator(lottoCount);
        lottoGenerator.publishLotto();
//        lottoGenerator.printLotto();
    }
}
