package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBundle {
    private int count;
    private final List<Lotto> lottoList;

    public LottoBundle(int count) {
        this.count = count;
        this.lottoList = createLottoList();
    }

    @Override
    public String toString() {
        String print = "";
        for (Lotto lotto : this.lottoList) {
            print += lotto.getNumbers() + "\n";
        }
        return print;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public List<Lotto> createLottoList() {
        List<Lotto> lottoList1 = new ArrayList<>();
        while (this.count-- > 0) {
            //로또 한개 생성 후 로또 뭉치에 추가
            lottoList1.add(createOneLotto());
        }
        return lottoList1;
    }

    public Lotto createOneLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> numbers_clone = new ArrayList<>(numbers);
        Collections.sort(numbers_clone);
        return new Lotto(numbers_clone);
    }
}
