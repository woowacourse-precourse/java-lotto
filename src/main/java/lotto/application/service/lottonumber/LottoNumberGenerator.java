package lotto.application.service.lottonumber;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoNumberGenerator {
    List<Lotto> generateLottoNumber(int purchaseNumber);
}
