package lotto.model.lotto;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);

        this.winningLotto = new Lotto(winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public int checkMatchCount(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        int matchCount = 0;
        for(int lottoNumber: lottoNumbers) {
            if(winningLotto.getNumbers().contains(lottoNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public boolean checkBonusMatch(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        boolean doesBonusMatch = false;
        for(int lottoNumber: lottoNumbers) {
            doesBonusMatch = (lottoNumber == bonusNumber);
            if(doesBonusMatch) {
                break;
            }
        }

        return doesBonusMatch;
    }

    private static void validate(Lotto lottoNumbers, int bonusNumber) {
        if(isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호는 " + Lotto.MINIMUM_NUMBER + "부터 " + Lotto.MAXIMUM_NUMBER + " 사이의 숫자여야 합니다.");
        }

        if(isSameNumberOnLotto(bonusNumber, lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호가 중복되어서는 안 됩니다.");
        }
    }

    private static boolean isOutOfRange(int number) {
        return number < Lotto.MINIMUM_NUMBER || number > Lotto.MAXIMUM_NUMBER;
    }

    private static boolean isSameNumberOnLotto(int number, Lotto lottoNumbers) {
        return lottoNumbers.getNumbers().contains(number);
    }
}
