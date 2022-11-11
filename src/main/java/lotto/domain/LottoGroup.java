package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {

    private final List<Lotto> lottoGroup;

    public LottoGroup(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    public List<List<Integer>> getLottoNumbers() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottoGroup) {
            lottoNumbers.add(lotto.getNumbers());
        }
        return lottoNumbers;
    }
}
