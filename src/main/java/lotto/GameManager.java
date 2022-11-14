package lotto;

import lotto.domain.*;
import lotto.constant.Constant;
import lotto.utils.Ranking;
import lotto.views.Input;
import lotto.views.Output;

import java.util.HashMap;
import java.util.List;

public class GameManager {

    private final Input input;
    private final Output output;
    private Money money;
    private Wallet wallet;
    private Lotto winningNumber;
    private BonusNumber bonusNumber;
    private Prize prize;

    public GameManager() {
        this.output = new Output();
        this.input = new Input();
    }

    public void run() {
        money = new Money(input.getUserMoney());
        purchaseLotto(money.getNumberOfPurchase());
        output.printWallet(wallet.getLottos(), money.getNumberOfPurchase());

        winningNumber = new Lotto(input.getWinningNumber());
        bonusNumber = new BonusNumber(input.getBonusNumber());
        winningNumber.validateDistinctInBonusNumber(bonusNumber.getBonusNumber());
        prize = new Prize(makePrize());

        output.printPrize(prize);
        output.printProfit(getProfit(money.getNumberOfPurchase() * Constant.LOTTO_PRICE));
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

    public double getProfit(int lottoPrice) {
        long result = 0;
        result += prize.getValue(Ranking.FIRST_PLACE) * Ranking.FIRST_PLACE.getMoney();
        result += prize.getValue(Ranking.SECOND_PLACE) * Ranking.SECOND_PLACE.getMoney();
        result += prize.getValue(Ranking.THIRD_PLACE) * Ranking.THIRD_PLACE.getMoney();
        result += prize.getValue(Ranking.FOURTH_PLACE) * Ranking.FOURTH_PLACE.getMoney();
        result += prize.getValue(Ranking.FIFTH_PLACE) * Ranking.FIFTH_PLACE.getMoney();

        return (double) result / (double) lottoPrice * 100.0;
    }
}
