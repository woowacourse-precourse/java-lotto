package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private final LottoNumbersGenerator lottoNumbersGenerator;

    public Lottos() {
        this.lottos = new ArrayList<>();
        this.lottoNumbersGenerator  = new LottoNumbersGenerator();
    }

    public void issueLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = issueLotto();
            lottos.add(lotto);
        }
    }
    private Lotto issueLotto() {
        List<Integer> lottoNumbers = lottoNumbersGenerator.getLottoNumbers();
        return new Lotto(lottoNumbers);
    }
}
