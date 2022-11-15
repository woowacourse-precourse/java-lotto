package lotto.domain;

public class IssuedLotto {
    LottoList lottoList = new LottoList();

    public IssuedLotto(int amount) {
        for(int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(LottoNumbers.generateNumber());
            lottoList.addLottoList(lotto);
        }
    }

    public LottoList getLottoList() {
        return lottoList;
    }
}
