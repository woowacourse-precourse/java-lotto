package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.common.Constant;
import lotto.ui.Print;

public class Game {

    private final int purchasedLottoPrice;
    private final List<Lotto> purchasedLottoNumbers = new ArrayList<>();
    private final List<Integer> winningLottoNumbers = new ArrayList<>();
    private int bonusNumber;
    private final Map<String, Integer> rankCounts = new HashMap<>();
    private long winningAmount;


    public Game(int purchasedLottoPrice) {
        this.purchasedLottoPrice = purchasedLottoPrice;
        int purchasedLottoCount = purchasedLottoPrice / Constant.LOTTO_PRICE_UNIT;
        Print.buyLotto(purchasedLottoCount);
        for (int i = 0; i < purchasedLottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    Constant.LOTTO_NUMBER_MIN, Constant.LOTTO_NUMBER_MAX, Constant.LOTTO_NUMBERS_INPUT_SIZE);
            Print.lottoNumbers(numbers);
            purchasedLottoNumbers.add(new Lotto(numbers));
        }
        setRankCounts();
        this.winningAmount = Constant.INITIAL_AMOUNT;
    }

    private void setRankCounts() {
        rankCounts.put(LottoResult.FIRST.name(), Constant.INITIAL_COUNT);
        rankCounts.put(LottoResult.SECOND.name(), Constant.INITIAL_COUNT);
        rankCounts.put(LottoResult.THIRD.name(), Constant.INITIAL_COUNT);
        rankCounts.put(LottoResult.FOURTH.name(), Constant.INITIAL_COUNT);
        rankCounts.put(LottoResult.FIFTH.name(), Constant.INITIAL_COUNT);
    }

    public void setWinningLottoNumbers(List<Integer> winningLottoNumbers) {
        this.winningLottoNumbers.addAll(winningLottoNumbers);
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < Constant.LOTTO_NUMBER_MIN || bonusNumber > Constant.LOTTO_NUMBER_MAX) {
            Print.lottoNumberException();
            throw new IllegalArgumentException();
        }
        if (winningLottoNumbers.contains(bonusNumber)) {
            Print.nonDuplicatedBonusNumberException();
            throw new IllegalArgumentException();
        }
    }

    private double calculateProfitRate(int purchasedLottoPrice, long winningAmount) {
        return (double) winningAmount / (double) purchasedLottoPrice * Constant.PERCENTAGE;
    }

    public void getGameResult() {
        for (Lotto purchasedLottoNumber : purchasedLottoNumbers) {
            setGameResult(purchasedLottoNumber.getLottoResult(this.winningLottoNumbers, this.bonusNumber));
        }
        Print.winningLotteryResult(
                rankCounts.get(LottoResult.FIFTH.name()), rankCounts.get(LottoResult.FOURTH.name()),
                rankCounts.get(LottoResult.THIRD.name()), rankCounts.get(LottoResult.SECOND.name()),
                rankCounts.get(LottoResult.FIRST.name()));
        Print.profitRate(calculateProfitRate(this.purchasedLottoPrice, this.winningAmount));
    }

    private void setGameResult(LottoResult lottoResult) {
        if (lottoResult != LottoResult.NOTHING) {
            rankCounts.put(lottoResult.name(), rankCounts.get(lottoResult.name()) + 1);
            winningAmount += lottoResult.getAmount();
        }
    }
}
