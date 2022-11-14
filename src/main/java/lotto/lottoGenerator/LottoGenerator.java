package lotto.lottoGenerator;

import lotto.Lotto;

import java.util.List;

public interface LottoGenerator {
    public List<Lotto> issueLottosByInputAmount(int numberOfLottos);
    public List<Lotto> printLottos(List<Lotto> lottos);
}
