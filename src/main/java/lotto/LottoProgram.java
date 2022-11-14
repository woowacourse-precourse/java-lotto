package lotto;

public class LottoProgram {
    private LottoStore lottoStore = new LottoStore();
    private User user = new User();

    public void makeUserLotto() {
        lottoStore.printInputMoney();
        int money = user.inputMoney();
        lottoStore.makePurchaseNumber(money);
        lottoStore.makeUserLotto();
        lottoStore.printUserLotto();
    }
}
