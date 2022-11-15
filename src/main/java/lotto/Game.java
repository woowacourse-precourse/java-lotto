package lotto;

import java.util.List;

public class Game {
    private final LottoPublisher lottoPublisher;
    private Customer customer;
    private LottoManager manager;
    public Game() {
        this.lottoPublisher = new LottoPublisher();
        this.customer = new Customer();
        this.manager = new LottoManager();
    }
    public void ini(){
        try {
            askMoney();
            purchaseLotto();
            askWinningNumber();
            reportResult();
        }catch (Exception e){
            Message.printErrorMessage(e);
        }
    }

    private void askWinningNumber() {
        manager.askWinningNumber();
        manager.askBonusNumber();
    }

    private void reportResult() {
        manager.reportResult(customer);
    }

    private void purchaseLotto() {
        List<Lotto> lotto = lottoPublisher.createLotto(customer.payMoney());
        customer.purchaseLotto(lotto);
    }

    private void askMoney() {
        customer.setAsset();
    }
}
