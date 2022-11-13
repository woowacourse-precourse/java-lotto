package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.enumtype.LottoNumberInclusive;
import lotto.constant.enumtype.LottoRule;
import lotto.domain.lotto.repository.Lotto;
import lotto.domain.lotto.repository.LottoBonus;

public class LottoBonusService {
    private LottoBonus lottoBonus;

    private LottoBonusService() {
    }

    private static class InnerLottoBonusService {
        private static final LottoBonusService instance = new LottoBonusService();
    }

    public static LottoBonusService getInstance(){
        return InnerLottoBonusService.instance;
    }

    public void setLottoBonusNumber(Integer bonusNumber, List<Integer> LottoNumber) throws IllegalArgumentException {
        lottoBonus = new LottoBonus(bonusNumber, LottoNumber);
    }

    public LottoBonus getLottoBonus() {
        return lottoBonus;
    }
}
