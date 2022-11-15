package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoPublisher lottoPublisher = new LottoPublisher();
        Customer customer = new Customer();
        customer.setAsset();
        List<Lotto> lotto = lottoPublisher.createLotto(customer.payMoney());
        customer.purchaseLotto(lotto);
        LottoManager lottoManager = new LottoManager();
        lottoManager.askWinningNumber();
        lottoManager.askBonusNumber();
        lottoManager.reportResult(customer);
    }
}
