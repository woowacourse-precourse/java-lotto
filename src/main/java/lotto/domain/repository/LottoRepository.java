package lotto.domain.repository;

import lotto.domain.Lotto;

import java.util.List;

public class LottoRepository {

    public Lotto create(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }
}
