package lotto.model;

import lotto.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private List<Lotto> lottoList = new ArrayList<>();

    public LottoService(int lottoCount) {
        for (int count = 0; count < lottoCount; count++) {
            createLotto();
        }
    }

    public Lotto createLotto() {
        List<Integer> numbers = Utils.getIntegerList(1, 45, 6);
        Lotto createdLotto = new Lotto(numbers);
        lottoList.add(createdLotto);

        return createdLotto;
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }
}
