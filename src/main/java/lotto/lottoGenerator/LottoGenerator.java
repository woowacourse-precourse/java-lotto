package lotto.lottoGenerator;

import lotto.Lotto;

import java.util.List;

public interface LottoGenerator {
    public List<Lotto> issueLottosByInputAmount(int numberOfLottos);
}
