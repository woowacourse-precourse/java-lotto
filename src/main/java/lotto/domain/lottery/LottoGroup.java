package lotto.domain.lottery;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.generator.NumberGenerator;

public class LottoGroup {

    private final List<Lotto> lottoGroup = new ArrayList<>();

    public LottoGroup(int purchaseCount, NumberGenerator numberGenerator) {
        makeLottoGroup(purchaseCount, numberGenerator);
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }

    private void makeLottoGroup(int purchaseCount, NumberGenerator numberGenerator) {
        for (int count = 0; count < purchaseCount; count++) {
            lottoGroup.add(new Lotto(numberGenerator.generateNumbers()));
        }
    }
}
