package lotto.domain.model;

import lotto.domain.generator.LottoGenerator;
import lotto.domain.model.request.MoneyRequest;

public class LottoService {

    // 로또를 생성하고 로또들을 반환
    public Lottos getGeneratedLottoList(MoneyRequest moneyRequest) {
        LottoGenerator generator = new LottoGenerator(moneyRequest);
        return generator.getLottos();
    }

    // 로또 계산 결과
}
