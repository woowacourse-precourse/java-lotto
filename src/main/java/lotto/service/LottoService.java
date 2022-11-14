package lotto.service;

import lotto.vo.LottoPurchaseInfo;
import lotto.vo.LottoWinNumberInfo;

public interface LottoService {

    LottoPurchaseInfo LottoPurchaseServcie();

    LottoWinNumberInfo lottoNumbersService();

    LottoWinNumberInfo lottoBonusNumberService();
}
