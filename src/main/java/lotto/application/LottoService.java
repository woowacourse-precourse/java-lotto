package lotto.application;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.BonusNumber;
import lotto.domain.GeneralWinNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.Match;
import lotto.domain.WinNumber;
import lotto.infrastructure.LottoProvider;

public class LottoService {

    public static List<Lotto> getLottos(int purchaseAmount) {
        LottoAmount lottoAmount = new LottoAmount(purchaseAmount);
        return LottoProvider.createLottos(lottoAmount.getLottoCount());
    }

    public static WinNumber getWinNumber(GeneralWinNumber generalWinNumber, BonusNumber bonusNumber) {
        return new WinNumber(generalWinNumber, bonusNumber);
    }

    public static List<Match> match(List<Lotto> lottos, WinNumber winNumber) {
        return lottos.stream()
                .map(lotto -> lotto.match(winNumber))
                .collect(Collectors.toList());
    }

}
