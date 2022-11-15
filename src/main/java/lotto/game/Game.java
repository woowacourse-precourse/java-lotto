package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.common.Constant;
import lotto.ui.Error;
import lotto.ui.Input;
import lotto.ui.Print;

public class Game {

    private int purchasedLottoPrice;
    private int purchasedLottoCount;
    private final List<Lotto> purchasedLottoNumbers = new ArrayList<>();
    private final List<Integer> winningLottoNumbers = new ArrayList<>();
    private int bonusNumber;
    private final Map<String, Integer> rankCounts = new HashMap<>();
    private long winningAmount;


    public Game() {
        try {
            purchaseLotto();
            setNewLottos();
            setRankCounts();
            setInitialWinningAmount();
            setWinningLottoNumbers();
            setBonusNumber();
            getGameResult();
        } catch (IllegalArgumentException exception) {
            Print.message(exception.getMessage());
        }
    }

    private void purchaseLotto() {
        Print.inputPrice();
        this.purchasedLottoPrice = Input.price();
        Print.newLine();
        this.purchasedLottoCount = purchasedLottoPrice / Constant.LOTTO_PRICE_UNIT;
        Print.buyLotto(this.purchasedLottoCount);
    }

    private void setNewLottos() {
        for (int i = 0; i < this.purchasedLottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    Constant.LOTTO_NUMBER_MIN, Constant.LOTTO_NUMBER_MAX, Constant.LOTTO_NUMBERS_INPUT_SIZE);
            Print.lottoNumbers(numbers);
            this.purchasedLottoNumbers.add(new Lotto(numbers));
        }
        Print.newLine();
    }

    private void setInitialWinningAmount() {
        this.winningAmount = Constant.INITIAL_AMOUNT;
    }

    private void setRankCounts() {
        rankCounts.put(LottoResult.FIRST.name(), Constant.INITIAL_COUNT);
        rankCounts.put(LottoResult.SECOND.name(), Constant.INITIAL_COUNT);
        rankCounts.put(LottoResult.THIRD.name(), Constant.INITIAL_COUNT);
        rankCounts.put(LottoResult.FOURTH.name(), Constant.INITIAL_COUNT);
        rankCounts.put(LottoResult.FIFTH.name(), Constant.INITIAL_COUNT);
    }

    private void setWinningLottoNumbers() {
        Print.inputLottoNumbers();
        List<Integer> winningLottoNumbers = Input.lottoNumbers();
        this.winningLottoNumbers.addAll(winningLottoNumbers);
        Print.newLine();
    }

    private void setBonusNumber() {
        Print.inputBonusNumber();
        int bonusNumber = Input.bonusNumber();
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
        Print.newLine();
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < Constant.LOTTO_NUMBER_MIN || bonusNumber > Constant.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(Error.lottoNumberException());
        }
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Error.nonDuplicatedBonusNumberException());
        }
    }

    private double calculateProfitRate(int purchasedLottoPrice, long winningAmount) {
        return (double) winningAmount / (double) purchasedLottoPrice * Constant.PERCENTAGE;
    }

    private void getGameResult() {
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
