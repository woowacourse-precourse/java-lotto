package lotto.domain;


import java.util.List;

public class WinChecker {
    private final List<Integer> winNumber;
    private final int bonusNumber;

    public WinChecker(List<Integer> winNumber, int bonusNumber) {
        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
    }

    public Rank checkLotto(Lotto lottoNumber) {
        int count = lottoNumber.compare(winNumber);

        return Rank.of(count, isBonus(lottoNumber));
    }

    private boolean isBonus(Lotto lottoNumber) {
        return lottoNumber.contains(bonusNumber);
    }
}
