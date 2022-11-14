package lotto;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        LottoMachine lottoMachine = new LottoMachine();
        user.inputPurchaseAmount();
        user.computeLottoAmount();
        user.purchaseLotto();
        lottoMachine.inputWinningNumber();
        // TODO: 프로그램 구현
    }
}
