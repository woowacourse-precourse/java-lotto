package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private final LottoNumbersGenerator lottoNumbersGenerator;

    public Lottos() {
        this.lottos = new ArrayList<>();
        this.lottoNumbersGenerator = new LottoNumbersGenerator();
    }

    public void issueLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoNumbersGenerator.getLottoNumbers());
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
