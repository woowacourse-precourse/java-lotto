package lotto.domain.lotto;

import java.util.StringJoiner;

public class WinningNumber {
    Lotto lotto;
    int bonusNumber;

    public WinningNumber(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WinningNumber.class.getSimpleName() + "[", "]")
                .add("lotto=" + lotto)
                .add("bonusNumber=" + bonusNumber)
                .toString();
    }
}
