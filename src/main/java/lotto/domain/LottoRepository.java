package lotto.domain;

import java.util.List;

public class LottoRepository {

    public Lotto create(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }
}
