package lotto.model;

import lotto.util.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    private List<Lotto> lottoList = new ArrayList<>();

    public LottoService(int money) {
        int count = getLottoCount(money);
        for (int cnt = 0; cnt < count; cnt++) {
            addLotto(createLotto());
        }
    }

    public int getLottoCount(int money) {
        int count = money / 1000;

        return count;
    }

    public Lotto createLotto() {
        List<Integer> numbers = Utils.getIntegerList(1, 45, 6);
        numbers = sortLotto(numbers);
        Lotto createdLotto = new Lotto(numbers);

        return createdLotto;
    }

    public void addLotto(Lotto lotto) {
        lottoList.add(lotto);
    }

    public List<Integer> sortLotto(List<Integer> numbers) {
        Collections.sort(numbers);

        return numbers;
    }
}
