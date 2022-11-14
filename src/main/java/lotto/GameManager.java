package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.Wallet;
import lotto.utils.Constant;
import lotto.utils.Ranking;
import lotto.views.Input;

import javax.print.attribute.standard.RequestingUserName;
import java.util.HashMap;
import java.util.List;

public class GameManager {

    private final Input input;
    private Wallet wallet;
    private Lotto winningNumber;
    private BonusNumber bonusNumber;
    private Prize prize;

    public GameManager(Input input) {
        this.input = input;
    }

    public void run() {
        int lottoPrice = input.getUserMoney();
        int numberOfPurchase = changeNumberOfLottoToBuy(lottoPrice);
        purchaseLotto(numberOfPurchase);
        wallet.printWallet();

        winningNumber = new Lotto(input.getWinningNumber());
        bonusNumber = new BonusNumber(input.getBonusNumber());
        winningNumber.validateDistinctInBonusNumber(bonusNumber.getBonusNumber());
        prize = new Prize(makePrize());

    }

    public int changeNumberOfLottoToBuy(int lottoPrice) {
        return lottoPrice / Constant.LOTTO_PRICE;
    }

    public void purchaseLotto(int numberOfPurchase) {
        wallet = new Wallet(numberOfPurchase);
    }

    public HashMap<Ranking, Integer> makePrize() {
        HashMap<Ranking, Integer> result = new HashMap<>();

        for (Lotto lotto : wallet.getLottos()) {
            Ranking ranking = compareWinningNumber(lotto.getNumbers());
            addRankingInResult(result, ranking);
        }

        return result;
    }

    public Ranking compareWinningNumber(List<Integer> lotto) {
        int count = 0;
        for (Integer number : lotto) {
            if (winningNumber.getNumbers().contains(number))
                count++;
        }

        count = checkSecondPrize(lotto, count);

        return Ranking.checkNumberCount(count);
    }

    public int checkSecondPrize(List<Integer> lotto, int count) {
        if (lotto.contains(bonusNumber.getBonusNumber()) && count == Ranking.THIRD_PLACE.getNumberCount())
            return Ranking.SECOND_PLACE.getNumberCount();
        return count;
    }

    public void addRankingInResult(HashMap<Ranking, Integer> result, Ranking ranking) {
        if (ranking == Ranking.NOTHING)
            return;

        if (!result.containsKey(ranking)) {
            result.put(ranking, 1);
            return;
        }
        result.put(ranking, ranking.getNumberCount() + 1);
    }

}
