package lotto.service;

import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.User;
import lotto.domain.WinningLotto;

public class LottoService {

    public static final Boolean BONUS_NUMBER_HIT = true;
    public static final Boolean BONUS_NUMBER_MISS = false;

    public void calculateLottoRanks(User user, WinningLotto winningLotto) {
        for (Lotto purchasedLotto : user.getLottos()) {
            LottoRank lottoRank = calculateLottoRank(purchasedLotto, winningLotto);
            user.getLottoRanks().add(lottoRank);
        }
    }

    private LottoRank calculateLottoRank(Lotto purchasedLotto, WinningLotto winningLotto) {
        List<Integer> purchasedLottoNumbers = purchasedLotto.getNumbers();
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        int matchCount = (int) purchasedLottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();

        Integer bonusNumber = winningLotto.getBonusNumber();
        if (purchasedLottoNumbers.contains(bonusNumber)) {
            return LottoRank.getLottoRank(matchCount, BONUS_NUMBER_HIT);
        }
        return LottoRank.getLottoRank(matchCount, BONUS_NUMBER_MISS);
    }

}
