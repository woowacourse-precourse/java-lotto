package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.common.Constant;
import lotto.ui.Print;

public class Game {

    private final int purchasedLottoPrice;
    private final List<Lotto> purchasedLottoNumbers = new ArrayList<>();
    private final List<Integer> winningLottoNumbers = new ArrayList<>();
    private int bonusNumber;
    private int winningFifthCount;
    private int winningFourthCount;
    private int winningThirdCount;
    private int winningSecondCount;
    private int winningFirstCount;
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
        this.winningFifthCount = Constant.INITIAL_COUNT;
        this.winningFourthCount = Constant.INITIAL_COUNT;
        this.winningThirdCount = Constant.INITIAL_COUNT;
        this.winningSecondCount = Constant.INITIAL_COUNT;
        this.winningFirstCount = Constant.INITIAL_COUNT;
        this.winningAmount = Constant.INITIAL_AMOUNT;
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
}
