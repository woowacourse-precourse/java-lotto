package lotto.calculate;

import java.util.List;

public class CountMatchNumber {
    private int winNumberMatchCount;
    private int bonusNumberMatchCount;

    public CountMatchNumber() {
        this.winNumberMatchCount = 0;
        this.bonusNumberMatchCount = 0;
    }

    public int setWinningNumberMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (lottoNumbers.contains(winningNumber)) {
                winNumberMatchCount++;
            }
        }

        return winNumberMatchCount;
    }

    public int setBonusNumberMatchCount(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            bonusNumberMatchCount++;
        }

        return bonusNumberMatchCount;
    }
}
