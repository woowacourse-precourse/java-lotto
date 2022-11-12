package lotto.domain;

import java.util.List;

public class WinningResult {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private int accordedNumbers;
    private boolean isHitBonus;

    public WinningResult(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers= winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void checkTheResult(List<Integer> lottoNumbers) {
        accordedNumbers = (int)winningNumbers.stream()
                .filter(num -> lottoNumbers.contains(num))
                .count();
        checkTheBonus(lottoNumbers);
    }

    private void checkTheBonus(List<Integer> lottoNumbers) {
        if (accordedNumbers != 5)
            return ;
        isHitBonus = lottoNumbers.contains(bonusNumber);
        if (isHitBonus)
            accordedNumbers += 1;
    }

    public int getAccordedNumbers() {
        return accordedNumbers;
    }
}
