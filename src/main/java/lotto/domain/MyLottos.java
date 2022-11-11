package lotto.domain;

import java.util.List;

public class MyLottos {
    private List<LottoNumbersIssuance> myLottos;

    public MyLottos(List<LottoNumbersIssuance> myLottos) {
        this.myLottos = myLottos;
    }

    public LottoNumbersIssuance getMyLotto(int index) {
        return myLottos.get(index);
    }

    public int getMyLottoSize() {
        return myLottos.size();
    }
}
