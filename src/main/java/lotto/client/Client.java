package lotto.client;

import lotto.host.LottoHost;
import lotto.lotteryshop.Store;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public void buyLotto() {
        Store store = new Store();
        int purchaseNumberOfLotto = store.getPurchaseMoney();
        List<List<Integer>> generatedLottoNumber = store.generateLottoNumber(purchaseNumberOfLotto);
        store.getPublishedLottoNumber(generatedLottoNumber);
    }

    public void getLottoPaper() {
        LottoHost lottoHost = new LottoHost();
        List<Integer> lottoNumbers = lottoHost.inputLottoNumbers(new ArrayList<>());
        lottoHost.inputBonusNumber(lottoNumbers);
    }
}
