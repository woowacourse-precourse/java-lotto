package lotto.model;

import java.util.ArrayList;
import java.util.List;

class LottoNumbers {

    private final List<Lotto> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = new ArrayList<>();
    }

    void addLotto(int n) {
        while (n > 0) {
            Lotto lotto = new Lotto(RandomNumbersGenerator.creatSixDifferentNumbers());
            lottoNumbers.add(lotto);
            --n;
        }
    }

    public int getLottoQuantity() {
        return lottoNumbers.size();
    }
}
