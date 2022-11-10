package lotto.client;

import lotto.lotteryshop.Store;

import java.util.List;

public class Client {

    public void buyLotto() {
        Store store = new Store();
        int purchaseNumberOfLotto = store.getPurchaseMoney();
        List<List<Integer>> generatedLottoNumber = store.generateLottoNumber(purchaseNumberOfLotto);
        store.getPublishedLottoNumber(generatedLottoNumber);
    }
}
