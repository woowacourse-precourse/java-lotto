package lotto.domain;

public class LottoStore {
    private LottoStoreClerk lottoStoreClerk;

    public LottoStore(LottoStoreClerk lottoStoreClerk) {
        this.lottoStoreClerk = lottoStoreClerk;
    }
    public void sellLotto(Customer customer) {
        lottoStoreClerk.sellLottoTo(customer);
    }
}
