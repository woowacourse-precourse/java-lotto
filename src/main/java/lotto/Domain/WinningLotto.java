package lotto.Domain;

import static lotto.Utils.Constant.*;

import java.util.ArrayList;
import java.util.List;
import lotto.Utils.Util;
import lotto.Utils.Validator.BonusValidator;
import lotto.Utils.Validator.WinningLottoValidator;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonus;

    public WinningLotto(String lotto, String bonus) {
        new WinningLottoValidator(lotto);
        List<Integer> WinningLotto = Util.getList(lotto);
        new BonusValidator(WinningLotto, bonus);

        this.winningNumbers = WinningLotto;
        this.bonus = Util.getInt(bonus);
    }

    public int matchNumberCount(Lotto lotto) {
        return Math.toIntExact(lotto.getNumbers().stream()
                .filter(this.winningNumbers::contains)
                .count());
    }

    public boolean isMatchBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonus);
    }

    public List<WinningRank> makeRankResult(Buyer buyer) {
        List<WinningRank> rankResult = new ArrayList<>();
        List<Lotto> LottoWallet = buyer.getLottoWallet();

        for (int i = ZERO; i < LottoWallet.size(); i++) {
            rankResult.add(WinningRank.valueOf(this.matchNumberCount(LottoWallet.get(i))
                    , this.isMatchBonusNumber(LottoWallet.get(i))));
        }

        return rankResult;
    }

}
