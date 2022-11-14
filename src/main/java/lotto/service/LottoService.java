package lotto.service;

import lotto.vo.LottoPurchaseInfo;
import lotto.vo.LottoWinNumberInfo;

public interface LottoService {

    LottoPurchaseInfo getLottoPurchase();

    LottoWinNumberInfo getLottoWinNumbers();

    LottoWinNumberInfo getLottoBonusNumber();
}
