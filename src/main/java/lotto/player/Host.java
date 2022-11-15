package lotto.player;

import java.util.ArrayList;
import java.util.List;
import lotto.console.Constants;
import lotto.ticket.Lotto;
import lotto.ticket.Winning;

public class Host {

    private Lotto winningLotto;
    private List<Integer> winningLottoNumbers;
    private int winningBonusNumber;

    public Host(Lotto winningLotto, int winningBonusNumber) {
        validate(winningLotto.getNumbers(), winningBonusNumber);
        this.winningLotto = winningLotto;
        this.winningLottoNumbers = winningLotto.getNumbers();
        this.winningBonusNumber = winningBonusNumber;
    }

    private void validate(List<Integer> lottoNumber, int bonusNumber) {
        if (lottoNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(Constants.LOTTO_NUMBERS_DUPLICATE_EXCEPTION);
        }

        if (bonusNumber < Constants.LOTTO_START_NUMBER
                || bonusNumber > Constants.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(Constants.LOTTO_NUMBERS_RANGE_EXCEPTION);
        }
    }

    public List<Winning> drawLotto(List<Lotto> userLottos) {
        List<Winning> result = new ArrayList<>();

        for (Lotto userLotto : userLottos) {
            List<Integer> userLottoNumbers = userLotto.getNumbers();
            int correctCount = compareNumbers(userLottoNumbers);
            boolean isBonusNumber = compareBonusNumber(userLottoNumbers);
            result.add(Winning.valueOf(correctCount, isBonusNumber));
        }
        return result;
    }

    private boolean compareBonusNumber(List<Integer> userLottoNumbers) {
        return userLottoNumbers.contains(winningBonusNumber);
    }

    private int compareNumbers(List<Integer> userLottoNumbers) {
        int correctCount = 0;

        for (int i = 0; i < Constants.LOTTO_LEN; i++) {
            if (winningLottoNumbers.contains(userLottoNumbers.get(i))) {
                correctCount += 1;
            }
        }
        return correctCount;
    }
}
