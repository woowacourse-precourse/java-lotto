package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoProcess {

    public static List<Integer> putMatchNumber(final Lotto winningLotto, final List<Lotto> lottoContainer) {
        List<Integer> numberOfMatch = new ArrayList<>();

        for (Lotto lotto : lottoContainer) {
            numberOfMatch.add(countMatchNumber(lotto, winningLotto));
        }
        return numberOfMatch;
    }

    public static int countMatchNumber(final Lotto lotto, final Lotto winningLotto) {
        int count = 0;
        List<Integer> lottoNumbers = lotto.getLotto();
        List<Integer> winningNumbers = winningLotto.getLotto();

        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                ++count;
            }
        }
        return count;
    }

    public static List<Boolean> putAvailableBonus(final Bonus bonusNumber, final List<Lotto> lottoContainer) {
        List<Boolean> bonusInLotto = new ArrayList<>();

        for (Lotto lotto : lottoContainer) {
            bonusInLotto.add(isBonusInLotto(lotto, bonusNumber));
        }
        return bonusInLotto;
    }

    public static boolean isBonusInLotto(final Lotto lotto, final Bonus bonusNumber) {
        List<Integer> numbers = lotto.getLotto();
        return numbers.contains(bonusNumber.getBonusNumber().get(0));
    }

    public static double calculateRateOfProfit(List<Integer> countMatchNumber,
                                               List<Boolean> bonusInLotto,
                                               int price) {
        int prize = calculatePrize(countMatchNumber, bonusInLotto);

        return (double) prize / price * 100;
    }

    public static int calculatePrize(List<Integer> countMatchNumber,
                                     List<Boolean> bonusInLotto) {
        int prize = 0;

        for (int index = 0; index < countMatchNumber.size(); ++index) {
            int match = countMatchNumber.get(index);
            boolean bonus = bonusInLotto.get(index);
            prize += checkMapMatchPrize(match, bonus);
        }
        return prize;
    }

    private static int checkMapMatchPrize(final int match, final boolean bonus) {
        if (match == MapMatchPrize.FIVE.getNumberOfMatch() && !bonus) {
            return MapMatchPrize.FIVE.getPrize();
        }

        if (match == MapMatchPrize.FIVE_AND_BONUS.getNumberOfMatch() && bonus) {
            return MapMatchPrize.FIVE_AND_BONUS.getPrize();
        }

        return MapMatchPrize.find(match).getPrize();
    }
}
