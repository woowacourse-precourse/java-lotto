package lotto.output.calculation;

import lotto.data.Lotto;
import lotto.data.LottoNumber;
import lotto.data.LottoResult;
import lotto.data.PurchaseResult;

import java.util.List;

public class LottoResultEvaluator {
    private static final int LOTTO_UNIT_PRICE = 1000;
    private static final int PROFIT_RATE_PRECISION = 1;
    private static final int NUMBER_TO_EXPRESS_FIVE_AND_BONUS_WIN = 7;

    public LottoResult evaluateLottoResult(LottoNumber lottoNumber, PurchaseResult purchaseResult) {
        List<Lotto> purchasedLottos = purchaseResult.getPurchasedLottos();

        int[] winningResults = new int[purchaseResult.getPurchasedAmount()];

        for (int i = 0; i < winningResults.length; i++) {
            winningResults[i] = countMatchingNumbers(lottoNumber, purchasedLottos.get(i));
        }

        int[] countsByWinningResult = countLottosByWinningResult(winningResults);

        return new LottoResult(countsByWinningResult);
    }

    public int[] countLottosByWinningResult(int[] winningResults) {
        int[] countsByWinningResult = new int[8];

        for (int i = 0; i < winningResults.length; i++) {
            int numberMatched = winningResults[i];
            countsByWinningResult[numberMatched] += 1;
        }

        return countsByWinningResult;
    }

    public int countMatchingNumbers(LottoNumber lottoNumber, Lotto purchasedLotto) {
        List<Integer> winningNumbers = lottoNumber.getLotto().getNumbers();
        int bonusNumber = lottoNumber.getBonusNumber();
        List<Integer> numbers = purchasedLotto.getNumbers();

        int matchCount = (int) numbers.stream().filter(winningNumbers::contains).count();

        if (matchCount == 5 && numbers.contains(bonusNumber)) {
            matchCount = NUMBER_TO_EXPRESS_FIVE_AND_BONUS_WIN;
        }

        return matchCount;
    }

    public double calculateProfitRate(LottoResult lottoResult, PurchaseResult purchaseResult) {
        double totalPrice = purchaseResult.getPurchasedAmount() * LOTTO_UNIT_PRICE;
        double prize = lottoResult.getTotalPrizeAmount();

        return getRoundedProfitRate(prize / totalPrice * 100, PROFIT_RATE_PRECISION);
    }

    private double getRoundedProfitRate(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
