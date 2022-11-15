package lotto.service;

import java.util.List;
import lotto.vo.Lotto;
import lotto.vo.LottoPurchaseInfo;
import lotto.vo.LottoWinNumberInfo;

public interface LottoService {

    LottoPurchaseInfo getLottoPurchase();

    String getLottoWinNumbers();

    int getLottoBonusNumber();

    List<Lotto> createLottoNumbers(int lottoGameCount);

    List<String> getLottoRank(List<Lotto> lottoNumbers, LottoWinNumberInfo lottoWinNumberInfo);
}
