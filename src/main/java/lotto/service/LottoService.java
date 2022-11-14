package lotto.service;

import java.util.List;
import lotto.vo.Lotto;
import lotto.vo.LottoPurchaseInfo;
import lotto.vo.LottoScore;
import lotto.vo.LottoWinNumberInfo;

public interface LottoService {

    LottoPurchaseInfo getLottoPurchase();

    LottoWinNumberInfo getLottoWinNumbers();

    LottoWinNumberInfo getLottoBonusNumber();

    List<Lotto> createLottoNumbers(int lottoGameCount);

    LottoScore getLottoRank(List<Lotto> lottoNumbers, LottoWinNumberInfo lottoWinNumberInfo);
}
