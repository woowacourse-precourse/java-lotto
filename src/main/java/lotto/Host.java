package lotto;

import java.util.ArrayList;
import java.util.List;

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

    public List<Winning> drawLotto(User user) {
        List<Winning> result = new ArrayList<>();

        for (Lotto userLotto : user.getLottos()) {
            int correctCount = compareNumbers(userLotto);
            boolean isBonusNumber = compareBonusNumber(userLotto);
            result.add(Winning.valueOf(correctCount, isBonusNumber));
        }
        return result;
    }

    private boolean compareBonusNumber(Lotto userLotto) {
        return userLotto.getNumbers().contains(winningBonusNumber);
    }

    private int compareNumbers(Lotto userLotto) {
        List<Integer> userLottoNumbers = userLotto.getNumbers();
        int correctCount = 0;

        for (int i = 0; i < Constants.LOTTO_LEN; i++) {
            if (winningLottoNumbers.contains(userLottoNumbers.get(i))) {
                correctCount += 1;
            }
        }
        return correctCount;
    }
}
