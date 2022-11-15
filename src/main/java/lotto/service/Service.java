package lotto.service;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Rank;
import lotto.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Service {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;
    private static final int LOTTO_LEAST_AMOUNT = 1_000;
    private static final int COUNT_ZERO = 0;
    private static final int COUNT_ONE = 1;

    public void buyAllLotto(Buyer buyer) {
        int count = buyer.getPurchaseAmount() / LOTTO_LEAST_AMOUNT;
        for (; count > COUNT_ZERO; count--) {
            buyOneLotto(buyer);
        }
    }

    private void buyOneLotto(Buyer buyer) {
        Lotto lotto = generateLottoNumber();
        buyer.buyLotto(lotto);
    }

    private Lotto generateLottoNumber() {
        List<Integer> numbers = new ArrayList<>(
                Utils.randomUniqueNumberGenerate(LOTTO_START_NUMBER, LOTTO_LAST_NUMBER, LOTTO_LENGTH));
        return new Lotto(numbers);
    }

    public void checkBuyerLotteries(Buyer buyer, LottoGame lottoGame) {
        HashMap<Rank, Integer> result = buyer.getLottoResult();
        for (Lotto lotto : buyer.getPurchasedLotteries()) {
            Rank rank = determineLottoRank(lottoGame, lotto);
            result.put(rank, result.getOrDefault(rank, COUNT_ZERO) + COUNT_ONE);
        }
    }

    private int countCorrectLottoNumbers(LottoGame lottoGame, Lotto lotto) {
        return Utils.countSameElements(lottoGame.getWinningNumbers(), lotto.getNumbers());
    }

    private boolean containsBonusNumber(LottoGame lottoGame, Lotto lotto) {
        return lotto.getNumbers().contains(lottoGame.getBonusNumber());
    }

    private Rank determineLottoRank(LottoGame lottoGame, Lotto lotto) {
        int correctCount = countCorrectLottoNumbers(lottoGame, lotto);
        boolean correctBonusNumber = containsBonusNumber(lottoGame, lotto);
        Rank rank = Rank.values()[correctCount];
        if (rank == Rank.THIRD && correctBonusNumber) {
            return Rank.SECOND;
        }
        return rank;
    }
}
