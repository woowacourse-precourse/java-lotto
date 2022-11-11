package lotto.model;

import lotto.util.Utils;

import java.util.List;

public class LottoService {
    private List<Lotto> lottoList;

    public LottoService(int money) {
        int count = getLottoCount(money);
        for (int cnt = 0; cnt < count; cnt++) {
            // 추 후 SORT 기능 추가
            addLotto(createLotto());
        }
    }

    private int getLottoCount(int money) {
        int count = money / 1000;

        return count;
    }

    private Lotto createLotto() {
        List<Integer> numbers = Utils.getIntegerList(1, 45, 6);
        Lotto createdLotto = new Lotto(numbers);

        return createdLotto;
    }

    private void addLotto(Lotto lotto) {
        lottoList.add(lotto);
    }

//    private Lotto sortLotto(Lotto lotto) {
//
//        return null;
//    }
}
