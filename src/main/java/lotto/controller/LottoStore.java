package lotto.controller;

import java.util.List;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoStoreClerk;
import lotto.view.BuyOutputView;
import lotto.view.InputView;

public class LottoStore {
    private LottoStoreClerk lottoStoreClerk;

    public LottoStore(LottoStoreClerk lottoStoreClerk) {
        this.lottoStoreClerk = lottoStoreClerk;
    }

    public void sellLottoTo(Customer customer) {
        BuyOutputView.guideBuying();
        customer.setMoney(InputView.input());
        List<Lotto> lottos = lottoStoreClerk.sellLotto(customer.pay());
        customer.setLottos(lottos);
        BuyOutputView.printTheNumberOfBuyingLottos(lottos.size());
        BuyOutputView.printLottos(lottos);
    }
}
